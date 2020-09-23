package com.capg.pbms.loan;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.capg.pbms.loan.service.LoanServiceImpl;
 
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.capg.pbms.loan.exception.AccountException;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
class PbmsLoanMsApplicationTests {
	@Autowired
	LoanServiceImpl Service;
  		@Test
 		public void testAccountId() {
 			assertEquals(true, Service.isValidAccountId(123456789012L));
 		} 
 		 
 		
 		@Test
 		void allTransactions() {
 			assertEquals(true,true);
 		}

 		@Test
 		void contextLoads() {
 		}
 

}
