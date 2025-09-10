package com.test.java.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
	//클래스 멤버변수 이름 작성시 주의사항
	// - 되도록이면 전부 소문자로 작성한다.
	//이런 스타일 ㄴㄴ..
	// - String pName	
	// - String p_name
	
	private String id;
	private String pw;
	private String name;
	private String grade;
}
