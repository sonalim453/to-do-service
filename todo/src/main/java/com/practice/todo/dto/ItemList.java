package com.practice.todo.dto;

import com.practice.todo.entity.Item;

import java.util.List;

public class ItemList {

    private String listId;
    private String listName;
    private List<Item> items;

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "listId='" + listId + '\'' +
                ", listName='" + listName + '\'' +
                ", items=" + items +
                '}';
    }
}
