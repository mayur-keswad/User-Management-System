package com.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.DaoLayer;
import com.Entity.User;
import com.dto.UserDto;
import com.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceIMPL implements userService {
	
	 @Autowired
	    private UserRepository repo; 

	@Autowired
	private DaoLayer ud;

	@Override
	public void getuserInservice(User user) {
		System.out.println("USer in service layer :- " + user);

		ud.getuserinDAO(user);

	}

	@Override
	public UserDto getuserByidinservice(int uid) {

		log.info("user in service :-" + uid);
		User user = ud.getuserByIdinDAo(uid);

		if (user != null) {
			log.info("user exists :- " + user);

			// manual way
			// userDto urd = new userDto();
			// urd.setUname(user.getUname());
			// urd.setUaddress(user.getUaddress());

			ModelMapper mp = new ModelMapper();
			UserDto urd = mp.map(user, UserDto.class);

			return urd;

		} else {
			log.warn("Invalid data");

		}

		return null;

	}
	
	// READ all
    public List<UserDto> getAllUsers() {
        return repo.findAll()
                   .stream()
                   .map(u -> new UserDto(u.getUname(), u.getUaddress()))
                   .collect(Collectors.toList());
    }

    // UPDATE
    public UserDto updateUser(int id, User user) {
        Optional<User> u = repo.findById(id);
        if (u.isPresent()) {
            User existing = u.get();
            existing.setUname(user.getUname());
            existing.setUaddress(user.getUaddress());
            User updated = repo.save(existing);
            return new UserDto(updated.getUname(), updated.getUaddress());
        }
        return null;
    }

    // DELETE
    public boolean deleteUser(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
