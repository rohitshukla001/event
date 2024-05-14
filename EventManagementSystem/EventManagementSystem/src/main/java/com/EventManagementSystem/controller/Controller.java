package com.EventManagementSystem.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.EventManagementSystem.entity.DbEntity;
import com.EventManagementSystem.library.Library;
import com.EventManagementSystem.library.Library.MyEnum;
import com.EventManagementSystem.manager.Manager;
import com.EventManagementSystem.service.Service;
import com.EventManagementSystem.validation.Validation;

import jakarta.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Service service;

	DbEntity preUpdateData;

	public Controller() {
		super();
	}

	@GetMapping("/")
	public String homePage(Model model) {
		try {
			DbEntity dbobj = new DbEntity();
			model.addAttribute("signUpData", dbobj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		try {
			DbEntity dbobj = new DbEntity();
			model.addAttribute("signUpData", dbobj);
			model.addAttribute("sizeEnum", MyEnum.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "signup";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/showGridData")
	public String getAndshowDataList(Model model) {
		try {
			model.addAttribute("showdatalist", service.getDataList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "gridData";
	}

	// save data
	@PostMapping("/getSignUpData")
	public String getSignUpData(@Valid @ModelAttribute("getEditData") DbEntity dbobj, BindingResult result,
			Model model) {
		try {
			System.out.println("Hello india");
			System.out.println(dbobj.getUsertype());
			new Validation().formValidation(dbobj);
			dbobj.setUsertype((int)dbobj.getUsertype());
			
			if (result.hasErrors()) {
				model.addAttribute("signUpData", dbobj);
				model.addAttribute("message", result.getFieldError().getDefaultMessage());
				return "signup";
			} else {
				System.out.println("for date time1");
				dbobj.setPrepareddt(new Timestamp(System.currentTimeMillis()));
				System.out.println("for date time");
				service.saveData(dbobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("editRecordData", dbobj);
			model.addAttribute("message", e.getMessage());
			return "edit";
		}
		return "redirect:/showGridData";
	}

	@GetMapping("/delete/{id}")
	public String deleteRecord(@PathVariable int id) {
		try {
			service.deleteRecordById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/showGridData";
	}

	// procedding to update records
	@GetMapping("/edit/{id}")
	public String editRecords(@PathVariable int id, Model model) {
		try {
			preUpdateData = service.getRecordsById(id);
			model.addAttribute("editRecordData", service.getRecordsById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "edit";
	}

	// update data
	@PostMapping("/getEditData/{id}")
	public String getEditData(@Valid @ModelAttribute("editRecordData") DbEntity dbobj, BindingResult result,
			Model model) {
		try {
			new Validation().formValidation(dbobj);
			System.out.println("prepareddtt is : " + dbobj.getPrepareddt());

			if (result.hasErrors()) {
				model.addAttribute("editRecordData", dbobj);
				model.addAttribute("message", result.getFieldError().getDefaultMessage());
				return "edit";
			} else {
				dbobj.setPrepareddt(preUpdateData.getPrepareddt());
				dbobj.setUpdatedt(new Timestamp(System.currentTimeMillis()));
				service.saveData(dbobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("editRecordData", dbobj);
			model.addAttribute("message", e.getMessage());
			return "edit";
		}
		return "redirect:/showGridData";
	}

}
