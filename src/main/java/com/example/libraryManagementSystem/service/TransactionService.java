package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.entity.TransactionEntity;

import java.util.List;
import java.util.Map;

public interface  TransactionService {
    public TransactionEntity borrowBook(long memberId, long bookId);

    public TransactionEntity returnBook(long transactionId);

    public List<Map<String, Object>> memberHistory(long memberId);
}
