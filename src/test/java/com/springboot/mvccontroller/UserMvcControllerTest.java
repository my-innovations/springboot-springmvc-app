package com.springboot.mvccontroller;

//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//import com.springboot.model.User;
import com.springboot.service.UserServiceImpl;

//Different ways:
//using MockMvc in standalone mode , only with springRunner.. - This will not start the internal embedded tomcat server. and loading the entire context.
//using @WebMvcTest together with springRunner.
//using @SpringBootTest together with springRunner.


//@RunWith(MockitoJUnitRunner.class) //OK
//@RunWith(SpringJUnit4ClassRunner.class) //OK
@RunWith(SpringRunner.class)//OK
public class UserMvcControllerTest {
	
	//@InjectMocks
	//private UserMvcController userMvcController; //OK
	
	@Mock //OK
	//@MockBean
	private UserServiceImpl userService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		//Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(new UserMvcController()).build();//OK
		//this.mockMvc = MockMvcBuilders.standaloneSetup(userMvcController).build();//OK
	}
	
	@Test
	public void testShowUserRegisterform() throws Exception{
		this.mockMvc.perform(get("/register"))
		.andExpect(status().isOk())
		.andExpect(view().name("userRegistrationForm"))
		.andDo(print());
	}
	
	
	/*@Test
	public void testEditUserForm() throws Exception{
		
	assertThat(this.userService).isNotNull();
	
	User user = new User(1L,"punyasmruti nayak",40,"punyasmruti@gmail.com");
	when(userService.getUserByUserId(1L)).thenReturn(user);
	
	 MvcResult response =mockMvc.perform(get("/edit/{id}",1))
			.andExpect(status().isOk())
			.andExpect(view().name("userEditForm"))
			.andReturn();
	
	//MockHttpServletResponse response = result.getResponse();
	//assertThat(response.getContentType()).isEqualTo("text/html;charset=UTF-8");
	
	//verify(userService,times(1)).getUserByUserId(1L);
	//verifyNoMoreInteractions(userService);
	
	}*/
	
    
    @Test
    public void testsaveUser() throws Exception {
     
        //when(userService.buy(any(User.class),6)).thenThrow(new InsufficientProductsException("For Testing"));
        /*this.mockMvc.perform(post("/user")
                .param("email", "mvcemail@test.com")
                .param("firstName", "mvcfirst")
                .param("lastName", "mvclastname"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
                .andExpect(model().attributeExists("page_error"));*/
    }
}
