package com.capg.pbms.transactionms;
import static org.junit.jupiter.api.Assertions.assertEquals;
  
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.pbms.transactionms.model.Customer;
import com.capg.pbms.transactionms.service.TransactionService;
import com.capg.pbms.transactionms.service.TransactionServiceImpl;
@SpringBootTest
class PbmsTransactionManagementApplicationTests {
     @Autowired     
    TransactionServiceImpl Service; 
         @Test
         public void testAccountId() {
             assertEquals(true, Service.isValidAccountId(123456789012L));
         } 
         @Test
         public void isvalidAccountId() {
             assertEquals(false, Service.isValidAccountId(1234567890121L));
         } 
         @Test
         public void isvalidAmount() {
             assertEquals(false, Service.isValidAmount(20.00));
         } 
         @Test
         public void testAmount() {
             assertEquals(true, Service.isValidAmount(20000.00));
         } 
 
         
         @Test
         void allTransactions() {
             assertEquals(true,true);
         }

         @Test
         void contextLoads() {
         }
 
}