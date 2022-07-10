package com.skilldistillery.skillguild;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.skilldistillery.skillguild.controllers.AuthController;

@SpringBootTest
@AutoConfigureMockMvc
class SmokeTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AuthController controller;

	@Test
	void test_AuthController_Exists() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void test_shouldGetIndexEndpoint() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}

}
