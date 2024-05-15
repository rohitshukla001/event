package com.EventManagementSystem.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.EventManagementSystem.entity.DbEntity;

public interface Service {

	public List<DbEntity> getDataList();

	public DbEntity saveData(DbEntity dbEntity);

	public DbEntity getRecordsById(int id);

	public void deleteRecordById(int id);

	public boolean isUsernameUnique(@PathVariable String username);

}
