package com.example.libraryManagementSystem.service;


import com.example.libraryManagementSystem.entity.MemberEntity;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface MemberService {
//    public List<MemberEntity> getMembers();
    Page<MemberEntity> getMembers(Pageable pageable);

    public MemberEntity addMembers(MemberEntity memberEntity);
}
