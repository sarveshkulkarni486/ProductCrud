package com.example.services;

import com.example.beans.Person;
import com.example.beans.User;
import com.example.dao.LoginDao;
import com.example.dao.LoginDaoImpl;

public class LoginServicesImpl implements LoginServices {
	private LoginDao ldao;
	public LoginServicesImpl(){
		ldao = new LoginDaoImpl();
	}
	@Override
	public User validate(String username, String password) {
		User u = new User(username, password);
		return ldao.validateUser(u);
	}
	@Override
	public boolean InsertData(Person p, User u) {
		
		return ldao.saveData(p, u);
	}
	@Override
	public boolean exists(User u) {
		return ldao.exists(u);
	}
}
