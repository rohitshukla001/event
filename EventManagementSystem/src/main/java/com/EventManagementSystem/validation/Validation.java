package com.EventManagementSystem.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.EventManagementSystem.entity.DbEntity;
import com.EventManagementSystem.manager.Manager;
import com.EventManagementSystem.repository.Repository;
import com.EventManagementSystem.service.Service;

public class Validation {
	@Autowired
	Repository repo;
	@Autowired
	Service service;

	public String formValidation(DbEntity dbEntity) throws Exception {
		String output = "";
		try {
			String userInputDate = dbEntity.getDob();
			String currentDate = getCurrentDate();
			if (!userInputDate.equalsIgnoreCase("")) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				LocalDate date1 = LocalDate.parse(userInputDate, formatter);
				LocalDate date2 = LocalDate.parse(currentDate, formatter);

				if (date1.isAfter(date2)) {
					throw new Exception("You cann't enter future date.");
				}
			} else {
				System.out.println("userInputDate is null at validation class.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return output;
	}

	public String getCurrentDate() {
		String output = "";
		try {
			LocalDate currentDate = LocalDate.now();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			output = currentDate.format(formatter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	public String getuniqueName(String UserType, int id) {
		String uniqueName = "";
		try {
			String newUserType = UserType.substring(0, 3);
			String udidId = String.valueOf(UUID.randomUUID().hashCode()).replace("-", "").substring(0, 3);
			uniqueName = (newUserType + id + "_" + udidId).toString();
//			
//			boolean isUnique = service.isUsernameUnique(uniqueName);
//			if (isUnique) {
//				System.out.println("Found duplicate userName.");
//				getuniqueName(UserType, id)	;
//			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uniqueName;
	}

}
