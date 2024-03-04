package com.example.libraryManagementSystem.service.serviceimpl;

import com.example.libraryManagementSystem.entity.LibraryEntity;
import com.example.libraryManagementSystem.entity.TransactionEntity;
import com.example.libraryManagementSystem.repository.LibraryRepo;
import com.example.libraryManagementSystem.repository.MemberRepo;
import com.example.libraryManagementSystem.repository.TransactionRepo;
import com.example.libraryManagementSystem.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Transactionimpl implements TransactionService {
    private final TransactionRepo transaction_obj;
    private LibraryRepo library_obj;
    public Transactionimpl(TransactionRepo transaction_obj, LibraryRepo library_obj) {

        this.transaction_obj = transaction_obj;
        this.library_obj = library_obj;
    }

    @Override
    public TransactionEntity borrowBook(long memberId, long bookId){

        TransactionEntity transaction = new TransactionEntity();

        Optional<LibraryEntity> bookData = library_obj.findById(bookId);

        if(bookData.isPresent()){
            LibraryEntity libraryEntity = bookData.get();
            if(libraryEntity.getAvailable() > 0){
                libraryEntity.setAvailable(libraryEntity.getAvailable() - 1);
                transaction.setMember_id(memberId);
                transaction.setBook_id(bookId);

                transaction.setBorrow_date(new Date());

                // Set expected return date to 15 days after borrow date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(transaction.getBorrow_date());
                calendar.add(Calendar.DAY_OF_MONTH, 15);
                transaction.setExpected_return(calendar.getTime());
                transaction.setBook_title(libraryEntity.getBook_title());
                transaction.setIsbn(libraryEntity.getIsbn());

                transaction.setActual_return(null);
                library_obj.save(libraryEntity);

                return transaction_obj.save(transaction);
            }
            else{
                throw new RuntimeException("No available copies for the book with ID: " + bookId);
            }

        }
        else{
            throw new RuntimeException("Book not found with ID: " + bookId);
        }
    }





    @Override
    public TransactionEntity returnBook(long transactionId){
//        TransactionEntity transaction = new TransactionEntity();   dont create new object for update
        Optional<TransactionEntity> transactionData = transaction_obj.findById(transactionId);

        if(transactionData.isPresent()){
            TransactionEntity transactionEntity = transactionData.get();

            if(transactionEntity.getActual_return() == null){
                transactionEntity.setActual_return(new Date());
                long id = transactionEntity.getBook_id();
                Optional<LibraryEntity> bookData = library_obj.findById(id);
                LibraryEntity libraryEntity = bookData.get();
                libraryEntity.setAvailable(libraryEntity.getAvailable() + 1);
                library_obj.save(libraryEntity);
                return transaction_obj.save(transactionEntity);
            }
            else{
                throw new RuntimeException("book with transaction ID already return: " + transactionId);
            }
        }
        else{
            throw new RuntimeException("transaction not found with ID: " + transactionId);
        }

    }




    @Override
    public List<Map<String, Object>> memberHistory(long memberId){
        List<TransactionEntity> transactionData = transaction_obj.findByMember_id(memberId);
        List<Map<String, Object>> memberHistoryList = new ArrayList<>();
        for (TransactionEntity transactionEntity : transactionData) {
            Map<String, Object> transactionMap = new HashMap<>();
            transactionMap.put("memberId", transactionEntity.getMember_id());
            transactionMap.put("bookTitle", transactionEntity.getBook_title());
            transactionMap.put("bookId", transactionEntity.getBook_id());
            transactionMap.put("actualReturn", transactionEntity.getActual_return());
            transactionMap.put("expectedReturn", transactionEntity.getExpected_return());
            memberHistoryList.add(transactionMap);
        }

        if(!memberHistoryList.isEmpty()){
            return memberHistoryList;
        }
        else{
            throw new RuntimeException("member with member ID not present: " + memberId);
        }
    }
}
