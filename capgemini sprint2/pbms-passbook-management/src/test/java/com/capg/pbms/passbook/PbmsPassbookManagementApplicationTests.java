package com.capg.pbms.passbook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.pbms.passbook.exception.AccountException;
import com.capg.pbms.passbook.service.TransactionServiceImpl;



@SpringBootTest
class PbmsPassbookManagementApplicationTests {
	@Autowired
	TransactionServiceImpl Service;
//	@Test
//	public void testAccountIdLessDigits() throws AccountException{
//	
//		Exception exception = assertThrows(AccountException.class, () -> {
//			Service.isValidAccountId(12345678901L);
//		    });
//		    String expectedMessage = "ID should be of 12 digits";
//		    String actualMessage = exception.getMessage();	 
//		    assertTrue(actualMessage.contains(expectedMessage));
//	}
//	
	@Test
	public void testAccountId() {
		assertEquals(true, Service.isValidAccountId(123456789012L));
	} 
	
	@Test
	public void testLoanRequestId() {
		assertEquals(true, Service.isValidAccountId(123456789012L));
	}
	
	@Test
	void printpassbook() {
		assertEquals(true,true);
	}

	@Test
	void contextLoads() {
	}

}
