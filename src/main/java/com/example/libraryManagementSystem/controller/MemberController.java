package com.example.libraryManagementSystem.controller;
import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.entity.MemberEntity;
import com.example.libraryManagementSystem.service.LibraryService;
import com.example.libraryManagementSystem.service.MemberService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@RestController
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/home/member")
    public String home(){
        return "this home page of member";
    }


    @GetMapping("/allmembers")
    public Page<MemberEntity> getMember(@RequestParam(defaultValue = "0") int page) {
//        return memberService.getMembers(PageRequest.of(page, 2)); // Set the page size to 2
        return memberService.getMembers(PageRequest.of(page, 2, Sort.by("name")));
    }


    @PostMapping("/addmembers")
    public MemberEntity addMember(@RequestBody MemberEntity memberEntity){
        System.out.println("course = "+memberEntity);
        return memberService.addMembers(memberEntity);
    };


}
