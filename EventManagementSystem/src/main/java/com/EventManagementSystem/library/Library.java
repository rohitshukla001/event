package com.EventManagementSystem.library;

import java.io.Serializable;

public class Library {

	public enum MyEnum implements Serializable {
		ORGANISER(1, "Organiser"), ATTENDEE(2, "Attendee");

		private final int code;
		private final String name;

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		MyEnum(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public static MyEnum getViaCode(int code) {
			for (MyEnum value : MyEnum.values()) {
				if (code == value.getCode()) {
					return value;
				}
			}
			return null;
		}

		public static MyEnum getViaName(String name) {
			for (MyEnum value : MyEnum.values()) {
				if (name.trim().equalsIgnoreCase(value.getName())) {
					return value;
				}
			}
			return null;
		}
	}

	public enum MyOccupationEnum implements Serializable {
		UN_EMPLOYEED(1, "Un Employeed"), SALES_REPRESENTATIVE(2, "Sales Representative"),
		CUSTOMER_SERVICE_REPRESENTATIVE(3, "Customer Service Representative"), MANAGER(4, "Manager"),
		MARKETING_SPECIALIST(5, "Marketing Specialist"), ACCOUNTANT(6, "Accountant"), TEACHER(7, "Teacher"),
		NURSE(8, "Nurse"), DOCTOR(9, "Doctor"), ENGINEER(10, "Engineer"), STUDENT(11, "Student"), LAWYER(12, "Lawyer"),
		BUSINESS_ANALYST(13, "Business Analyst"), SOFTWARE_DEVELOPER(14, "Software Developer"), 
		PRIVATE_JOB(15, "Private Job"), GOVERNMENT_JOB(16, "Government Job"), SELF_EMPLOYEED(17, "Self Employeed"), 
		OTHERS(17, "Business Analyst");

		private final int code;
		private final String name;

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		MyOccupationEnum(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public static MyOccupationEnum getViaCode(int code) {
			for (MyOccupationEnum value : MyOccupationEnum.values()) {
				if (code == value.getCode()) {
					return value;
				}
			}
			return null;
		}

		public static MyOccupationEnum getViaName(String name) {
			for (MyOccupationEnum value : MyOccupationEnum.values()) {
				if (name.trim().equalsIgnoreCase(value.getName())) {
					return value;
				}
			}
			return null;
		}
	}
}
