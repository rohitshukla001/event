package com.EventManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EventManagementSystem.entity.DbEntity;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<DbEntity, Integer>{

}
