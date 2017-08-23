package com.lbh360.platform;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@WebAppConfiguration("src/main/resources")
public class SpringbootApplicationTests {

	private MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void hello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}

	@Test
	public void allparams() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/allparams").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void aspect() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/aspect").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("请查看控制台的输出。")));
	}
}
