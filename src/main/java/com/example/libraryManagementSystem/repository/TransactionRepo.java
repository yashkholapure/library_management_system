package com.example.libraryManagementSystem.repository;
import java.util.List;
import java.util.Map;

import com.example.libraryManagementSystem.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository <TransactionEntity, Long>{
    @Query("SELECT t FROM TransactionEntity t WHERE t.member_id = :memberId")
    List<TransactionEntity> findByMember_id(@Param("memberId") long memberId);
//    List<Map<String, Object>> findByMemberId(@Param("memberId") long memberId);
}
