package com.ffc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ffc.models.Remark;

@Repository
public interface RemarkRepository extends JpaRepository<Remark, Long>{

}
