package com.EventManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/organiser")
public class OrganiserController {
	@RequestMapping("/view")
	public String view() {
		return "attendee/viewDashboard";
	}
}
