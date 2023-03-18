package fpt.m2.ThienNLNT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import fpt.m2.ThienNLNT.entities.UserEntity;

@SpringBootTest
class FptThienNlntApplicationTests {


	@Test
	public void testGetUserByid() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity userEntity = restTemplate.getForObject("http://localhost:8080/users/2", UserEntity.class);
		assertNotNull(userEntity);
		assertEquals("thiennlnt", userEntity.getUserName());
	}
	
	@Test
	public void testCreateUser() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("thiennlnt");
		userEntity.setEmail("thiennlnt@gmail.com");
		userEntity.setAddress("abc");
		userEntity.setPhoneNumber(123456789);
		UserEntity newUserEntity = restTemplate.postForObject("http://localhost:8080/users/", userEntity , UserEntity.class);
		assertNotNull(newUserEntity);
		assertNotNull(newUserEntity.getUserId());
		assertEquals("thiennlnt", newUserEntity.getUserName());
	}
	
	@Test
	public void testUpdateUser() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity userEntity = restTemplate.getForObject("http://localhost:8080/users/2", UserEntity.class);
		userEntity.setEmail("tamthiennlnt@gmail.com");
		restTemplate.put("http://localhost:8080/users/", userEntity);
	}


}
