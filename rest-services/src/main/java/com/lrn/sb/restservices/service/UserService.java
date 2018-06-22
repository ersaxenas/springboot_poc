package com.lrn.sb.restservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lrn.sb.restservices.model.User;

@Component
public class UserService {

	List<User> userList = new ArrayList<>();
	public int userIdCount = 0;

	public UserService() {
		userList.add(new User(++userIdCount,"David", "Jan 01, 2018"));
		userList.add(new User(++userIdCount,"Sam", "Jan 20, 2018"));
		userList.add(new User(++userIdCount,"Suzy", "Feb 01, 2017"));
		userList.add(new User(++userIdCount,"Kamel", "Dec 04, 2018"));
		userList.add(new User(++userIdCount,"Dana", "Oct 01, 2018"));
	}

	public User getUser(final int id) {
		User user = null;
		for(User usr : userList) {
			if(usr.getId() == id) {
				user = usr;
				break;
			}
		}
		return user;
	}

	public List<User> getUsers() {
		return userList;
	}

	public boolean removeUser(final int id) {
		boolean result = false;
		for(int cnt=0; cnt<userList.size(); cnt++) {
			if(userList.get(cnt).getId() == id) {
				userList.remove(cnt);
				result = true;
				break;
			}
		}
		return result;
	}

	public User save(final User user) {
		user.setId(++userIdCount);
		if(!userList.isEmpty()) {
			userList.add(user);
		}
		else if(!userList.contains(user)){
			userList.add(user);
		}
		return user;
	}

}
