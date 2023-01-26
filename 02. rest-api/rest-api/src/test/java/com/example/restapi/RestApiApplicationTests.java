package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		//var user = new UserRequest("홍길동",10,"hong@gmail.com",true);
		//System.out.println(user);
		//user.setUserName("홍길동");
		//user.setUserAge(10);
		//user.setEmail("hong@gmail.com");
		//user.setIsKorean(true);


		var json = "{\"user_names\":\"홍길동\",\"user_age\":10,\"email\":\"hong@gmail.com\",\"is_korean\":true}";
		System.out.println(json);

		var dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println(dto);
	}

}
