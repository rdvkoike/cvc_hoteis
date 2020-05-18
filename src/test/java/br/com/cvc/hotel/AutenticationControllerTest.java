package br.com.cvc.hotel;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.cvc.hotel.controller.AuthenticationController;
import br.com.cvc.hotel.entity.HotelFind;
import br.com.cvc.hotel.entity.User;

@SpringBootTest
public class AutenticationControllerTest extends ApplicationTests{
 
//	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private AuthenticationController authController;
	
	public void setUp() {
	}    
    
	@Test
	public void testPOST_getToken() throws Exception {
		
		User user = new User();
		user.setUsername("usertest1");
		user.setPassword("12345");
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
		this.mockMvc.perform(MockMvcRequestBuilders.post("/signin")
				.param("username", user.getUsername())
				.param("password", user.getPassword()))
				.andExpect(MockMvcResultMatchers.status().isOk());		
	}
}
