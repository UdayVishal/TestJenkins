package com.example.demo;

import com.example.demo.controller.TestController;
import com.example.demo.model.Employee;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@WebMvcTest(TestController.class)
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DemoService demoService;

	@Test
	void testHelloEndpoint() throws Exception {
		mockMvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"));
	}

	@Test
	void testHello2Endpoint() throws Exception {
		mockMvc.perform(get("/hello2").param("name", "Vishal"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello Vishal"));
	}

	@Test
	void testListEmpEndpoint() throws Exception {
		List<Employee> mockEmployees = Arrays.asList(
				new Employee("John", "12345"),
				new Employee("Alice", "67890")
		);

		when(demoService.listEmp()).thenReturn(mockEmployees);

		mockMvc.perform(get("/allemp"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.size()").value(2))
				.andExpect(jsonPath("$[0].empName").value("John"))
				.andExpect(jsonPath("$[1].address").value("67890"));
	}


}
