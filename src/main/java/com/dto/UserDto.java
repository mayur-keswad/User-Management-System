package com.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class UserDto {

	private String uname;

	private String uaddress;

	public UserDto(String uname, String uaddress) {
		this.uname = uname;
		this.uaddress = uaddress;
	}

	@Override
	public String toString() {
		return "{uname='" + uname + "', uaddress='" + uaddress + "'}";
	}

}
