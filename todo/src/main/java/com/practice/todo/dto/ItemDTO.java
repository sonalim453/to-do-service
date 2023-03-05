package com.practice.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practice.todo.enums.CompletionStatus;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;


@Builder
public class ItemDTO {
    private int id;
    private String title;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfCompletion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfCreation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime timeOfCompletion;
    private Set<String> listTags;
    private CompletionStatus status;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(LocalDate dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalTime getTimeOfCompletion() {
        return timeOfCompletion;
    }

    public void setTimeOfCompletion(LocalTime timeOfCompletion) {
        this.timeOfCompletion = timeOfCompletion;
    }

    public Set<String> getListTags() {
        return listTags;
    }

    public void setListTags(Set<String> listTags) {
        this.listTags = listTags;
    }

    public CompletionStatus getStatus() {
        return status;
    }

    public void setStatus(CompletionStatus status) {
        this.status = status;
    }

}
