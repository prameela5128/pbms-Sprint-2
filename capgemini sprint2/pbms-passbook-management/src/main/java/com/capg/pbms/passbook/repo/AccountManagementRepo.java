package com.capg.pbms.passbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.passbook.model.AccountManagement;

public interface AccountManagementRepo extends JpaRepository<AccountManagement,Long>{

}
