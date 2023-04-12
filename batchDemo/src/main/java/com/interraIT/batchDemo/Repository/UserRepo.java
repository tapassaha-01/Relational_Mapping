package com.interraIT.batchDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interraIT.batchDemo.Model.EmployeeEntity;

@Repository
public interface UserRepo extends JpaRepository<EmployeeEntity, Long> {

}
