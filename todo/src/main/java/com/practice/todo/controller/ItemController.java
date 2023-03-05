package com.practice.todo.controller;

import com.practice.todo.dto.ItemDTO;
import com.practice.todo.entity.Item;
import com.practice.todo.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/items/")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> completedItems = itemService.getAllItems();

        log.info("completed items :{}", completedItems);
        return new ResponseEntity<>(completedItems, HttpStatus.OK);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Item>> getAllCompletedItems() {
        List<Item> completedItems = itemService.getAllCompletedItems();
        log.info("completed items :{}", completedItems);
        return new ResponseEntity<>(completedItems, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> addNewItem(@RequestBody Item item) {
        itemService.saveItem(item);
        return new ResponseEntity<>("item added!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable int id) throws Exception {
        Item updatedItem = itemService.updateItem(item, id);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id) {
        itemService.deleteItem( id);
        return new ResponseEntity<>("item deleted!", HttpStatus.OK);
    }
}
