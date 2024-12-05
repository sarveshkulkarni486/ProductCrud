package com.example.dao;

import com.example.beans.Person;
import com.example.beans.User;

public interface LoginDao {

	User validateUser(User u);

	boolean saveData(Person p, User u);


	boolean exists(User u);
}
