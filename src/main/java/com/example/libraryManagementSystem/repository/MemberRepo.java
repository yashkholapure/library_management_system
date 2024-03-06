package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepo extends JpaRepository<MemberEntity, Long> {
    // You can add custom query methods specific to MemberEntity if needed
}
