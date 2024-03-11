package com.my.project;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MyProjectTest {
	
	@Autowired
	private MockMvc mock; //MockMvc 객체를 사용하여 HTTP 요청을 보내고 응답을 검증
	
	@Test
	void mainConTest() throws Exception {
		mock.perform(get("/")) //get 요청을 "/"경로로 보내는 동작
			.andExpect(status().isOk()) //응답 상태 코드가 200(OK)인지 검증
			.andExpect(content().string("Hello")); //응답 본문이 "Hello"문자열과 일치하는지
	}
}
