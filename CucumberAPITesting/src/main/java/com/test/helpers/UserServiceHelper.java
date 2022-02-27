package com.test.helpers;

import java.util.List;
import com.test.constants.EndPoints;
import com.test.models.LoginObject;
import com.test.models.UserObject;
import com.test.utils.GetObjects;
import com.test.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserServiceHelper {

	protected static Response res;
	protected static String token;
	protected static UserObject user;

	public static String getBaseURI() {
		return Utils.getApplicationProperty("baseURI");
	}

	protected static Response LoginToApplication() {
		LoginObject login = GetObjects.getLogin();
		res = RestAssured.given().contentType(ContentType.JSON).body(login).post(EndPoints.LOGIN_URI);
		token = res.jsonPath().get("[0].token");
		return res;
	}

	protected static String getToken() {
		if (token == null)
			LoginToApplication();
		return token;
	}

	protected static List<UserObject> getAllUserData() {
		res = getUsers();
		List<UserObject> listUser = res.jsonPath().getList("$", UserObject.class);
		return listUser;
	}

	protected static Response getUsers() {
		Header header = new Header("token", getToken());
		res = RestAssured.given().header(header).contentType(ContentType.JSON).get(EndPoints.GET_URI);
		return res;
	}

	protected static Response addUser() {
		Header header = new Header("token", getToken());
		user = GetObjects.getUser();
		res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user).post(EndPoints.ADD_URI);
		return res;
	}

	protected static Response deleteUser() {
		Header header = new Header("token", getToken());
		res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user).delete(EndPoints.DELETE_URI);
		return res;
	}

	protected static Response updateUser() {
		Header header = new Header("token", getToken());
		user.setSalary("5555");
		res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user).put(EndPoints.UPDATE_URI);
		return res;
	}

	protected UserObject getUser() {
		getUsers();
		UserObject[] listuser = res.as(UserObject[].class);
		for (UserObject usr : listuser) {
			if (usr.getUserid().equalsIgnoreCase("isfELhvM0RXfHcsLJDul")) {
				user = usr;
			}
		}
		return user;
	}
}