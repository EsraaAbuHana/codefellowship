package com.example.codefellowship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHome() throws Exception {
		this.mockMvc.perform(get("/")).
				andDo(print()).andExpect(status().isOk());
	}
	@Test
	public void testLogin() throws Exception {
		this.mockMvc.perform(get("/login")).
				andDo(print()).andExpect(status().isOk());
	}
	@Test
	public void testSignup() throws Exception {
		this.mockMvc.perform(get("/signup")).andDo(print())
				.andExpect(status().isOk());
	}

//	@Test
//	void contextLoads() {
//	}


}
