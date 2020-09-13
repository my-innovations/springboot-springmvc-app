package com.springboot.mvccontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMvcControllerIntegrationTest {

	// Here we are not mocking the service layer.

	// @Autowired
	MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext context;

	@Autowired
	UserMvcController userMvcController;

	@Before
	public void setUp() {
		this.mockMvc = standaloneSetup(this.userMvcController).build();
		//OR
		// this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testShowUserRegisterform() throws Exception {
		this.mockMvc.perform(get("/register"))
		.andExpect(status().isOk())
		.andExpect(view().name("userRegistrationForm"))
		.andDo(print());
	}

}
