package com.apress.todo.controller;

import com.apress.todo.domain.ToDo;
import com.apress.todo.repository.ToDoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoRepository repository;

    @GetMapping("/todo/{id}")
    public Mono<ToDo> getToDo(@PathVariable String id) {
        return this.repository.findById(id);
    }

    @GetMapping("/todo")
    public Flux<ToDo> getToDos() {
        return this.repository.findAll();
    }
}
