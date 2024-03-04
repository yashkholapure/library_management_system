package com.example.libraryManagementSystem.service.serviceimpl;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.repository.LibraryRepo;
import com.example.libraryManagementSystem.service.LibraryService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class Libraryimpl implements LibraryService {

    private final LibraryRepo libraryRepo_obj;

    public Libraryimpl(LibraryRepo libraryRepo_obj){
        this.libraryRepo_obj = libraryRepo_obj;
    }

    @Override
    public List<LibraryEntity> getBooks(){
        return libraryRepo_obj.findAll();
    }

    @Override
    public LibraryEntity addBooks(LibraryEntity libraryEntity){
        return libraryRepo_obj.save(libraryEntity);
    }
}
