package com.EventManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/attendee")
public class AttendeeController {
	@RequestMapping("/view")
	public String view() {
		return "attendee/viewDashboard";
	}
}
