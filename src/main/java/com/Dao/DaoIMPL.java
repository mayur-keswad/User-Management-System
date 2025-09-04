package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.User;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class DaoIMPL implements DaoLayer {

	@Autowired
	private SessionFactory sf;

	@Override
	public void getuserinDAO(User user) {

		System.out.println("user in DAO " + user);
		Session s = sf.openSession();
		s.save(user);
		s.beginTransaction().commit();

		System.out.println("user added");

	}

	@Override
	public User getuserByIdinDAo(int uid) {

		log.info("user in dao :-" + uid);
		Session s = sf.openSession();
		User user = s.get(User.class, uid);
		
		return user;

	}

}
