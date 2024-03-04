package com.example.libraryManagementSystem.controller;
import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.entity.MemberEntity;
import com.example.libraryManagementSystem.service.LibraryService;
import com.example.libraryManagementSystem.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.data.domain.Page;
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
    public List<MemberEntity> getMember(){
        return memberService.getMembers();
    };

    @PostMapping("/addmembers")
    public MemberEntity addMember(@RequestBody MemberEntity memberEntity){
        System.out.println("course = "+memberEntity);
        return memberService.addMembers(memberEntity);
    };


}
