package fpt.m2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fpt.m2.controller.UserController;
import fpt.m2.entity.UserEntity;
import fpt.m2.service.UserService;

@SpringBootTest(classes = FptNhungNt40Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FptNhungNt40ApplicationTests {

	private static final String API_ENDPOINT = "http://localhost:8080/api/users/";

	RestTemplate restTemplate = new RestTemplate();

	@MockBean
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Test
	public void createUserTest() {
		UserEntity user = new UserEntity();
		user.setUserName("Nhung Nhung");
		user.setEmail("nhungnhung@gmail.com");
		user.setAddress("Nghe An");
		user.setPhoneNumber(1234567);

		Mockito.when(userService.createUser(ArgumentMatchers.any(UserEntity.class))).thenReturn(user);

		ResponseEntity<UserEntity> responseEntity = restTemplate.postForEntity(API_ENDPOINT, user, UserEntity.class);

		assertNotNull(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		assertEquals(responseEntity.getBody().getUserName(), "Nhung Nhung");
		assertEquals(responseEntity.getBody().getEmail(), "nhungnhung@gmail.com");
		assertEquals(responseEntity.getBody().getAddress(), "Nghe An");
		assertEquals(responseEntity.getBody().getPhoneNumber(), 1234567);

		Mockito.verify(userService, Mockito.times(1)).createUser(ArgumentMatchers.any(UserEntity.class));
	}

	@Test
	public void getUserByIdTest() {
		int id = 1;
		UserEntity user = new UserEntity();
		user.setId(id);
		user.setUserName("Nhung Nhung");
		user.setEmail("nhungnhung@gmail.com");
		user.setAddress("Nghe An");
		user.setPhoneNumber(1234567);

		Mockito.when(userService.getUserById(ArgumentMatchers.anyInt())).thenReturn(user);

		ResponseEntity<UserEntity> responseEntity = restTemplate.getForEntity(API_ENDPOINT + "user/1",
				UserEntity.class);

		assertNotNull(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		assertEquals(responseEntity.getBody().getId(), id);
		assertEquals(responseEntity.getBody().getUserName(), "Nhung Nhung");
		assertEquals(responseEntity.getBody().getEmail(), "nhungnhung@gmail.com");
		assertEquals(responseEntity.getBody().getAddress(), "Nghe An");
		assertEquals(responseEntity.getBody().getPhoneNumber(), 1234567);

		Mockito.verify(userService, Mockito.times(1)).getUserById(ArgumentMatchers.anyInt());
	}

	@Test
	public void updateUserTest() {
		int id = 1;
		UserEntity user = new UserEntity();
		user.setId(id);
		user.setUserName("Tình Tuyết Nhung");
		user.setEmail("nhungnhung@gmail.com");
		user.setAddress("Nghe An");
		user.setPhoneNumber(1234567);

		Mockito.when(userService.getUserById(ArgumentMatchers.anyInt())).thenReturn(user);
		ResponseEntity<UserEntity> response = restTemplate.getForEntity(API_ENDPOINT + "user/1", UserEntity.class);
		Mockito.verify(userService, Mockito.times(1)).getUserById(ArgumentMatchers.anyInt());

		Mockito.when(userService.createUser(ArgumentMatchers.any(UserEntity.class))).thenReturn(user);
		Mockito.when(userService.updateUser(ArgumentMatchers.anyInt(), ArgumentMatchers.any(UserEntity.class)))
				.thenReturn(user);

		HttpEntity<UserEntity> requestEntity = new HttpEntity<>(user);
		ResponseEntity<UserEntity> responseEntity = restTemplate.exchange(API_ENDPOINT + "update/1", HttpMethod.PUT,
				requestEntity, UserEntity.class);

		assertNotNull(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		assertEquals(responseEntity.getBody().getId(), id);
		assertEquals(responseEntity.getBody().getUserName(), "Tình Tuyết Nhung");
		assertEquals(responseEntity.getBody().getEmail(), "nhungnhung@gmail.com");
		assertEquals(responseEntity.getBody().getAddress(), "Nghe An");
		assertEquals(responseEntity.getBody().getPhoneNumber(), 1234567);

		Mockito.verify(userService, Mockito.times(1)).updateUser(ArgumentMatchers.anyInt(),
				ArgumentMatchers.any(UserEntity.class));
	}

	@Test
	public void testDeleteUser() {
		int id = 1;
		UserEntity user = new UserEntity();
		user.setId(id);
		user.setUserName("Tình Tuyết");
		user.setEmail("nhungnhung@gmail.com");
		user.setAddress("Nghe An");
		user.setPhoneNumber(1234567);
		Mockito.when(userService.getUserById(ArgumentMatchers.anyInt())).thenReturn(user);
		ResponseEntity<UserEntity> response = restTemplate.getForEntity(API_ENDPOINT + "user/1", UserEntity.class);
		Mockito.verify(userService, Mockito.times(1)).getUserById(ArgumentMatchers.anyInt());

		ResponseEntity<Void> responseEntity = restTemplate.exchange(API_ENDPOINT + "delete/1", HttpMethod.DELETE, null,
				Void.class);

		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

		Mockito.verify(userService, Mockito.times(1)).deleteUser(ArgumentMatchers.anyInt());
	}

}
