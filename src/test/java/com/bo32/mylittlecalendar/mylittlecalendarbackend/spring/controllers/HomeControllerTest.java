package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.beans.ApiMessage;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
//	@Autowired
//    private WebApplicationContext wac;
	
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//	}
	
	@Test
	public void testHome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/home"))
        		.andExpect(status().isOk())
        		.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
    			.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)))
    			.andExpect(jsonPath("$.message", is(ApiMessage.HOME)));
	}
	
	@Test
	public void testRoot() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)))
				.andExpect(jsonPath("$.message", is(ApiMessage.HOME)));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/"))
        		.andExpect(status().isOk())
        		.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
    			.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)))
    			.andExpect(jsonPath("$.message", is(ApiMessage.HOME)));
	}

}
