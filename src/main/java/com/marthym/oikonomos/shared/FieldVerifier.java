package com.marthym.oikonomos.shared;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.NumberFormat;

public class FieldVerifier {
	public static final String EMAIL_REGEXP = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$";

	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
	
	public static boolean isValidMail(String mail) {
		if(mail == null) return false;
        
        String emailPattern = "EMAIL_REGEXP";
        return mail.matches(emailPattern);
	}
	
	public static boolean isValidPassword(String password) {
		if (password == null) return false;
		
		return password.length() > 7;
	}
	
	public static boolean isValidDate(String date, PredefinedFormat format) {
		DateTimeFormat formatter = DateTimeFormat.getFormat(format);
		try {
			formatter.parse(date);
			return true;
		} catch (NumberFormatException e) {}
		return false;
	}
	
	public static boolean isValidNumeric(String numeric) {
		NumberFormat formatter = NumberFormat.getDecimalFormat();
		try {
			formatter.parse(numeric);
			return true;
		} catch (IllegalArgumentException e) {}
		return false;
	}
}
