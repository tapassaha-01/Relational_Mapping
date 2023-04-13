package com.interrait.Spring_Batch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interrait.Spring_Batch.Model.EmployeeEntity;

public interface UserRepo extends JpaRepository<EmployeeEntity, Long> {

}
