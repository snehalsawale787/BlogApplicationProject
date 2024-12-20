package com.codewithdurgesh.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//used for data transfer
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
}
