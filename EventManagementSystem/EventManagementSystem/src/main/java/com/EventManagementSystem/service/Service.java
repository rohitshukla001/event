package com.EventManagementSystem.service;

import java.util.List;

import com.EventManagementSystem.entity.DbEntity;

import jakarta.persistence.EntityManager;

public interface Service {

	public List<DbEntity> getDataList();

	public DbEntity saveData(DbEntity dbEntity);	

	public DbEntity getRecordsById(int id);

	public void deleteRecordById(int id);

}
