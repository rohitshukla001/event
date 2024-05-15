package com.EventManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EventManagementSystem.entity.DbEntity;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<DbEntity, Integer>{
	@Query(value="select * from regdb where username = ?1", nativeQuery=true)
    public boolean findByUsername(String username);
}
