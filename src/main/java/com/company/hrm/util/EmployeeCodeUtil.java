package com.company.hrm.util;

public class EmployeeCodeUtil {

	public static String generateEmpCode( long count) {
		
		return "EMP"+ ( 1000 + count +1);
	}
}
