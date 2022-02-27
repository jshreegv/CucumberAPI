package com.test.helpers;

import java.util.List;

import com.test.models.UserObject;
import com.test.utils.GetObjects;

public class ReusableMethods {

	public static UserObject getUserFromResponse() {
		  UserObject user= GetObjects.getUser();
		  List<UserObject> listUser = UserServiceHelper.getAllUserData();
			for (UserObject usr : listUser) {
				if (usr.getAccountno().equalsIgnoreCase(user.getAccountno())) {
					user=usr;
				}
			}
		  return user;
	  }
}
