package com.test.utils;

import com.test.models.LoginObject;
import com.test.models.UserObject;

public class GetObjects {

	public static UserObject getUser() {
		UserObject user = new UserObject();
		user.setAccountno("TA-7222221");
		user.setDepartmentno("7");
		user.setSalary("5555");
		user.setPincode("923465");
		return user;

	}

	public static LoginObject getLogin() {
		LoginObject login = new LoginObject();
		
		login.setUsername(Utils.getApplicationProperty("username"));
		login.setPassword(Utils.getApplicationProperty("password"));
		return login;
	}
}
