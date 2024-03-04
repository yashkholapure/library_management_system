package com.example.libraryManagementSystem.service;


import com.example.libraryManagementSystem.entity.MemberEntity;

import java.util.List;

public interface MemberService {
    public List<MemberEntity> getMembers();

    public MemberEntity addMembers(MemberEntity memberEntity);
}
