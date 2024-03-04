package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.entity.LibraryEntity;

import java.util.List;

public interface LibraryService {
    public List<LibraryEntity> getBooks();

    public LibraryEntity addBooks(LibraryEntity libraryEntity);
}
