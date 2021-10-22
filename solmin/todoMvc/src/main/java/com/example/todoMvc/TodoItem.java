package com.example.todoMvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    private boolean comleted;

    public TodoItem(String title, boolean comleted) {
        this.title = title;
        this.comleted = comleted;
    }

    public TodoItem() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComleted() {
        return comleted;
    }

    public void setComleted(boolean comleted) {
        this.comleted = comleted;
    }
}
