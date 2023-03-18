package com.fpt.m2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fpt.m2.dto.UserResponseDTO;
import com.fpt.m2.request.UserRequestBody;
import com.fpt.m2.services.UserService;
import com.fpt.m2.services.UserServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UserProjectApplicationTests {

	ModelMapper mapper = new ModelMapper();

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Test
	void getUserById() {
		int id = 1;
		UserRequestBody expectedUser = new UserRequestBody(id, "dungda", "dungda@gmail.com", "fptcomlex", 123);
		ResponseEntity<UserRequestBody> response = new ResponseEntity<>(expectedUser, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.GET),
				ArgumentMatchers.isNull(), ArgumentMatchers.<Class<UserRequestBody>>any(), ArgumentMatchers.eq(id)))
				.thenReturn(response);
		UserResponseDTO actualUser = userService.getUserById(id);
		Assert.assertEquals(expectedUser, actualUser);
	}

}
