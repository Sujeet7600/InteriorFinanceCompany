package com.ffc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ffc.models.Loan;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
