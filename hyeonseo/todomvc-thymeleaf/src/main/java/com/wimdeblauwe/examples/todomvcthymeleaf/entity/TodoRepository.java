package com.wimdeblauwe.examples.todomvcthymeleaf.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
    int countAllByCompleted(boolean completed);
}
