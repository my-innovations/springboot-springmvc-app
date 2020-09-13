package com.springboot.mvccontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springboot.model.User;
import com.springboot.service.UserService;

//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class) //OK
@AutoConfigureMockMvc(secure=false) // added this
//@WebMvcTest(UserMvcController.class)//OK
@WebMvcTest(controllers = UserMvcController.class) // This will not start the embedded Tomcat server. But we are loading loading the application context.but TestRestTemplate is not avialable to autowire for restcall.
public class UserMvcControllerTest3 {
	
	@Autowired // added @Autowired here., becoz we are using @AutoConfigureMockMvc.
	private MockMvc mockMvc;
	
	//@Autowired
	//private WebApplicationContext webApplicationContext;
	
	//@Moc
	@MockBean
	private UserService userService;
	
	User user;
	
	
	@Before
	public void setUp(){
		//This is not required here, becoz we are using @AutoConfigureMockMvc
		//this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		user = new User(1L,"punyasmruti nayak",40,"punyasmruti@gmail.com");
	}
	
	@Test
	public void testShowUserRegisterform() throws Exception{
		assertThat(this.userService).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/register"))
		.andExpect(status().isOk())
		.andExpect(view().name("userRegistrationForm"))
		.andExpect(MockMvcResultMatchers.view().name("userRegistrationForm"))
		.andDo(print());
	}

}
