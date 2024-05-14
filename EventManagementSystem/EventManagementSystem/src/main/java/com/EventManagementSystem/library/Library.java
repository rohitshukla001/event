package com.EventManagementSystem.library;

public class Library {

	public enum MyEnum {
		ORGANISER(0, "Organiser"), ATTENDEE(1, "Attendee");
		
		private final int code;
		private final String description;

		MyEnum(int code, String description) {
			this.code = code;
			this.description = description;
		}

		public int getCode() {
			return code;
		}

		public String getDescription() {
			return description;
		}
	}
}
