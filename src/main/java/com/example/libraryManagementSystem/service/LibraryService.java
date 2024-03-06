package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibraryService {
//    public List<LibraryEntity> getBooks();

    Page<LibraryEntity> getBooks(Pageable pageable);

    public LibraryEntity addBooks(LibraryEntity libraryEntity);
}
