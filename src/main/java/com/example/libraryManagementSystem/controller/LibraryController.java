package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService=libraryService;
    }

    @GetMapping("/home")
    public String home(){
        return "this home page";
    }
    @GetMapping("/allbooks")
    public List<LibraryEntity> getBooks(){
        return libraryService.getBooks();
    };

    @PostMapping("/addbooks")
    public LibraryEntity addBook(@RequestBody LibraryEntity libraryEntity){
        System.out.println("course = "+libraryEntity);
        return libraryService.addBooks(libraryEntity);
    };


}
