package com.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Entity.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class resttestController {

	@PostMapping("/signup")
	public ResponseEntity signup(@RequestBody User user) {
		
		//it haas nothing of its own : each line below logger is of 2nd APi

		log.info("i am in STS-1 UserManage Pro " + user);

		String url = "localhost:2020/register";
		
		//enttities in both must be same 
		HttpEntity<User> entity = new HttpEntity<User>(user);

		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<User> result = rt.exchange(url, HttpMethod.POST, entity, User.class);
		
		return new ResponseEntity ( result.getBody(), result.getStatusCode());
		

	}

}
