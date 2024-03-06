package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
public class LibraryController {


    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService=libraryService;
    }

    @GetMapping("/home")
    public String home(){
        return "this home page";
    }

    private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
    @GetMapping("/allbooks")
    public Page<LibraryEntity> getBooks(@RequestParam(defaultValue = "0") int page) {
        log.info("allbooks_controller");
        return libraryService.getBooks(PageRequest.of(page, 2));

    }

    @PostMapping("/addbooks")
    public LibraryEntity addBook(@RequestBody LibraryEntity libraryEntity){
        System.out.println("course = "+libraryEntity);
        return libraryService.addBooks(libraryEntity);
    };


}
