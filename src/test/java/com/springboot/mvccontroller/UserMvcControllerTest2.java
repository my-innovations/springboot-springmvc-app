package com.springboot.mvccontroller;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//import com.springboot.model.User;
import com.springboot.service.UserService;

//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class) //OK
//@WebMvcTest(UserMvcController.class)//OK
@WebMvcTest(controllers = UserMvcController.class) // This will not start the embedded Tomcat server. But we are loading loading the application context.but TestRestTemplate is not avialable to autowire for restcall.
public class UserMvcControllerTest2 {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private UserService userService;
	
	@Before
	public void setUp(){
		// if we are using @AutoConfigureMockMvc 
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
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
	
	
	/*@Test
	public void testEditUserForm() throws Exception{
		
	assertThat(this.userService).isNotNull();
	
	User user = new User(1L,"punyasmruti nayak",40,"punyasmruti@gmail.com");
		
	when(userService.getUserByUserId(1L)).thenReturn(user);
	
	MvcResult result = mockMvc.perform(get("/edit/{id}",1))
			.andExpect(status().isOk())
			.andExpect(view().name("userEditForm"))
			.andReturn();
	
	//MockHttpServletResponse response = result.getResponse();
	//assertThat(response.getContentType()).isEqualTo("text/html;charset=UTF-8");
	
	verify(userService,times(1)).getUserByUserId(1L);
	verifyNoMoreInteractions(userService);
	
	}*/
	
	
	@Test
	public void testViewUsers() throws Exception{
		assertThat(this.userService).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
		.andExpect(status().isOk())
		.andExpect(view().name("viewUsers"))
		.andExpect(MockMvcResultMatchers.view().name("viewUsers"))
		.andDo(print());
	}
}
