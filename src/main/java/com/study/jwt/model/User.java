package com.study.jwt.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data // getter setter toString 등 자동생성.
@Entity // DB 테이블에 대응하는 하나의 클래스라고 생각하면 된다.
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // mysql : AUTO_INCREMENT 자동증가 
	private long id;
	private String username;
	private String password;
	private String roles; // USER, ADMIN 콤마를사용하여 만들 것이다.
	
	// 하나의 유저당 role이 여러개있을 경우를 대비하여 만듬.
	public List<String> getRoleList(){
		if(this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(",")); // 콤마 구분자로 하여 리턴한다.
		}
		return new ArrayList<>();  //null이 발생하지 않게 하기위함.
	}
	
	
}
