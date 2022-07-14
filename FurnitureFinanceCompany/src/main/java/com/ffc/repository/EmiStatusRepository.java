package com.ffc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ffc.models.EmiStatus;



@Repository
public interface EmiStatusRepository extends JpaRepository<EmiStatus, Long>{

}
