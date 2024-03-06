package com.example.libraryManagementSystem.service.serviceimpl;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.entity.MemberEntity;
import com.example.libraryManagementSystem.repository.MemberRepo;
import com.example.libraryManagementSystem.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class Memberimpl implements MemberService {

    private final MemberRepo memberRepo_obj;
    public Memberimpl(MemberRepo memberRepo_obj) {
        this.memberRepo_obj = memberRepo_obj;
    }

    @Override
    public Page<MemberEntity> getMembers(Pageable pageable){
        return memberRepo_obj.findAll(pageable);
    }

    @Override
    public MemberEntity addMembers(MemberEntity memberEntity){
        return memberRepo_obj.save(memberEntity);
    }

}
