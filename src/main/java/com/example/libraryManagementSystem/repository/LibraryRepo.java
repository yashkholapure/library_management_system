package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository <LibraryEntity, Long> {

}

//public class LibraryRepo {
//}



