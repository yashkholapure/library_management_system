package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.entity.TransactionEntity;
import com.example.libraryManagementSystem.service.MemberService;
import com.example.libraryManagementSystem.service.TransactionService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction/borrow/{memberId}/{bookId}")
    public TransactionEntity borrowBook(@PathVariable("memberId") Long memberId, @PathVariable("bookId") Long bookId){
        return transactionService.borrowBook(memberId,bookId);
    }

    @PutMapping("/transaction/return/{transactionId}")
    public TransactionEntity returnBook(@PathVariable("transactionId") Long transactionId){
        return transactionService.returnBook(transactionId);
    }

    @GetMapping("/transaction/history/{memberId}")
    public List<Map<String, Object>> memberHistory(@PathVariable("memberId") Long memberId){
        return transactionService.memberHistory(memberId);
    }
}
