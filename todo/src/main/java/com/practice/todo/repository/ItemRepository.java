package com.practice.todo.repository;

import com.practice.todo.entity.Item;
import com.practice.todo.enums.CompletionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByStatus(String status);
}
