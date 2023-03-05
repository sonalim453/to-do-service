package com.practice.todo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practice.todo.enums.CompletionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dateOfCompletion;
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dateOfCreation;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
    private LocalTime timeOfCompletion;
    private Set<String> listTags;
    private String status=CompletionStatus.NOT_STARTED.name();





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateOfCompletion=" + dateOfCompletion +
                ", dateOfCreation=" + dateOfCreation +
                ", timeOfCompletion=" + timeOfCompletion +
                ", listTags='" + listTags + '\'' +
                ", status=" + status +
                '}';
    }
}
