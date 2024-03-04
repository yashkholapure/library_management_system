package com.example.libraryManagementSystem.service.serviceimpl;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.entity.MemberEntity;
import com.example.libraryManagementSystem.repository.MemberRepo;
import com.example.libraryManagementSystem.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Memberimpl implements MemberService {

    private final MemberRepo memberRepo_obj;
    public Memberimpl(MemberRepo memberRepo_obj) {
        this.memberRepo_obj = memberRepo_obj;
    }

    @Override
    public List<MemberEntity> getMembers(){
        return memberRepo_obj.findAll();
    }

    @Override
    public MemberEntity addMembers(MemberEntity memberEntity){
        return memberRepo_obj.save(memberEntity);
    }

}
