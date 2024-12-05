package com.example.services;

import com.example.beans.Person;
import com.example.beans.User;

public interface LoginServices {

	User validate(String username, String password);

	boolean InsertData(Person p, User u);

	boolean exists(User u);


}
