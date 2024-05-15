package com.EventManagementSystem.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.EventManagementSystem.entity.DbEntity;
import com.EventManagementSystem.repository.Repository;
import com.EventManagementSystem.service.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

@org.springframework.stereotype.Service
public class Manager implements Service {

	@Autowired
	Repository repo;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<DbEntity> getDataList() {
		return repo.findAll();
	}

	@Override
	public DbEntity saveData(DbEntity dbEntity) {
		return repo.save(dbEntity);
	}
	

	@Override
	public DbEntity getRecordsById(int id) {
		DbEntity entity = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

		return entity;
	}

	@Override
	public void deleteRecordById(int id) {
		repo.deleteById(id);
	}

	@Override
	public boolean isUsernameUnique(@PathVariable String username) {		
        return repo.findByUsername(username);
    }
}
