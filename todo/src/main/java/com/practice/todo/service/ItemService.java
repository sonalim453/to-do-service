package com.practice.todo.service;

import com.practice.todo.dto.ItemDTO;
import com.practice.todo.entity.Item;
import com.practice.todo.enums.CompletionStatus;
import com.practice.todo.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public  List<Item> getAllItems() {
        List<Item> allItems = itemRepository.findAll();

        return allItems;

    }

    public List<Item> getAllCompletedItems() {
        List<Item> completedItems = itemRepository.findByStatus(CompletionStatus.COMPLETED.name());

        return completedItems;
    }

    public void saveItem(Item item) {


            item.setDateOfCreation( item.getDateOfCreation()!=null?item.getDateOfCreation():LocalDate.now());
            item.setStatus(item.getStatus()!=null && !item.getStatus().isEmpty()? item.getStatus() : CompletionStatus.NOT_STARTED.name());
            item.setListTags(item.getListTags()!=null &&!item.getListTags().isEmpty()?item.getListTags():new HashSet<>(Arrays.asList("tasks")));

        itemRepository.save(item);

    }

    public Item updateItem(Item item, int id) throws Exception {

        Optional<Item> oldItem = itemRepository.findById(id);
        if (oldItem.isPresent() && oldItem.get().getId()== item.getId()) {

            Item updatedItem = itemRepository.save(item);
            log.info("item after modification: {}", updatedItem);
//            ItemDTO updatedItemDto = entityToItemDtoMapper(updatedItem);
            return updatedItem;
        } else {
            throw new Exception("no such item exists!");
        }

    }

    public void deleteItem(int id){
        itemRepository.deleteById(id);

    }




    private Item itemDtoToEntityMapper(ItemDTO itemDTO) {
        Item item = Item.builder()
                .id(itemDTO.getId())
                .title(itemDTO.getTitle())
                .description(itemDTO.getDescription())
                .dateOfCreation(itemDTO.getDateOfCreation() != null ? itemDTO.getDateOfCreation() : LocalDate.now())
                .dateOfCompletion(itemDTO.getDateOfCompletion())
                .timeOfCompletion(itemDTO.getTimeOfCompletion())
                .listTags(!itemDTO.getListTags().isEmpty() ? itemDTO.getListTags() : new HashSet<>(Arrays.asList("tasks")))
                .status(itemDTO.getStatus().name())
                .build();
        return item;
    }

    private ItemDTO entityToItemDtoMapper(Item item) {
        ItemDTO itemDto = ItemDTO.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .dateOfCreation(item.getDateOfCreation())
                .dateOfCompletion(item.getDateOfCompletion())
                .timeOfCompletion(item.getTimeOfCompletion())
                .listTags(item.getListTags())
                .status(CompletionStatus.valueOf(item.getStatus()))
                .build();
        return itemDto;
    }
}
