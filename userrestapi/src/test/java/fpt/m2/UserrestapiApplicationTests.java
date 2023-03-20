package fpt.m2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;

import fpt.m2.entities.User;

@SpringBootTest
class UserrestapiApplicationTests {

	@Test
	public void testGetUser() {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://localhost:8080/users/1", User.class);
		assertNotNull(user);
		assertEquals("hoanganh", user.getUserName());
	}
	
	@Test
	public void testCreateUser() {
		RestTemplate restTemplate = new RestTemplate();
		User user = new User();
		user.setUserName("tuan anh");
		user.setEmail("tuananh@gmail.com");
		user.setAddress("321 tnv");
		user.setPhoneNumber(012345);
		User newUser = restTemplate.postForObject("http://localhost:8080/users/", user, User.class);
		
		assertNotNull(newUser);
		assertNotNull(newUser.getId());
		assertEquals("tuan anh",newUser.getUserName());
		
	}
	
	@Test
	public void testUpdateUser() {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://localhost:8080/users/1", User.class);
		
		user.setAddress("999 nht");
		restTemplate.put("http://localhost:8080/users/", user);
	}

}
