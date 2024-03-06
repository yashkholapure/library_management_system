package com.example.libraryManagementSystem.service.serviceimpl;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.entity.MemberEntity;
import com.example.libraryManagementSystem.repository.LibraryRepo;
import com.example.libraryManagementSystem.service.LibraryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Libraryimpl implements LibraryService {

    private final LibraryRepo libraryRepo_obj;

    public Libraryimpl(LibraryRepo libraryRepo_obj){
        this.libraryRepo_obj = libraryRepo_obj;
    }



    @Override
    public Page<LibraryEntity> getBooks(Pageable pageable) {
        Page<LibraryEntity> page = libraryRepo_obj.findAll(pageable);
        List<LibraryEntity> sortedContent = page.getContent()
                .stream()
                .sorted(Comparator.comparing(LibraryEntity::getGenre))
                .collect(Collectors.toList());
        return new PageImpl<>(sortedContent, pageable, page.getTotalElements());
    }

    @Override
    public LibraryEntity addBooks(LibraryEntity libraryEntity){
        return libraryRepo_obj.save(libraryEntity);
    }
}
