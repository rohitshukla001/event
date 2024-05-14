package com.EventManagementSystem.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.EventManagementSystem.entity.DbEntity;

public class Validation {

	public String formValidation(DbEntity dbEntity) throws Exception {
		String output = "";
		try {
			String userInputDate = dbEntity.getDob();
			String currentDate = getCurrentDate();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate date1 = LocalDate.parse(userInputDate, formatter);
			LocalDate date2 = LocalDate.parse(currentDate, formatter);
			
			if (date1.isAfter(date2)) {
				throw new Exception("You cann't enter future date.");				
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

}
