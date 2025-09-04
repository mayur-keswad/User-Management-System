package com.Dao;

import com.Entity.User;

public interface DaoLayer {



	void getuserinDAO(User user);

	User getuserByIdinDAo(int uid);

}
