package fpt.m2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import fpt.m2.common.constants.MessageConstant;
import fpt.m2.entities.UserEntity;

@SpringBootTest
class FptThaoDv4ApplicationTests {
	
	private static final String BASE_URL = "http://localhost:8080/users";
	
	@Test
	void testCreateUser_success() {
			RestTemplate restTemplate = new RestTemplate();
			UserEntity user = new UserEntity();
			user.setAddress("Quang Nam");
			user.setUserName("Thao1");
			user.setPhoneNumber("090123123");
			user.setEmail("1231322@gmail.com");
			
			Map<String, String> result = restTemplate.postForObject(BASE_URL, user, Map.class);
			
			assertEquals(result.get("message"), MessageConstant.M1);
			restTemplate.delete(BASE_URL + "/" + user.getEmail());
	}
	
	@Test
	void testCreateUser_require() {
			assertThrows(HttpClientErrorException.class, () -> {

				RestTemplate restTemplate = new RestTemplate();
				UserEntity user = new UserEntity();
				user.setUserName("Thao1");
				user.setPhoneNumber("090123123");
				user.setEmail("12312@gmail.com");
				
				
				List<Map<?,?>> results = new ArrayList<>();
				Map<String, String> resultEqual = new HashMap<>();
				resultEqual.put("field", "userName");
				resultEqual.put("message", MessageConstant.V1);
				results.add(resultEqual);
				results.add(resultEqual);
				Object resultEnd = restTemplate.postForObject(BASE_URL, user, Object.class);
				
			});
			
	}
	
	@Test
	void testUpdateUser_success() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity user = new UserEntity();
		user.setAddress("Quang Nam");
		user.setUserName("Thao1123123123");
		user.setPhoneNumber("090123123");
		user.setEmail("122131233a@gmail.com");
		
		restTemplate.postForObject(BASE_URL, user, Object.class);
		user.setAddress("Da Nang");
		restTemplate.put(BASE_URL, user);
		List<Map<?,?>> results = restTemplate.getForObject(BASE_URL + "/" + user.getUserName(), List.class);
		assertEquals(results.get(0).get("address"), "Da Nang");
		restTemplate.delete(BASE_URL + "/" + user.getEmail());
	}
	
	@Test
	void testDelete_success() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity user = new UserEntity();
		user.setAddress("Quang Nam");
		user.setUserName("Thao112fasdfsdfsdfadf323");
		user.setPhoneNumber("090123123");
		user.setEmail("123fasfsdfdfasdfsdfa@gmail.com");
		
		restTemplate.postForObject(BASE_URL, user, Object.class);
		restTemplate.delete(BASE_URL + "/" + user.getEmail());
		List<Map<?,?>> results = restTemplate.getForObject(BASE_URL + "/" + user.getUserName(), List.class);
		assertEquals(results.size(), 0);
		
	}
	
	@Test
	void testFindUserByName_success() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity user = new UserEntity();
		user.setAddress("Quang Nam");
		user.setUserName("Thao112323");
		user.setPhoneNumber("090123123");
		user.setEmail("123fasfsdfdfa@gmail.com");
		
		restTemplate.postForObject(BASE_URL, user, Object.class);
		List<Map<?,?>> results = restTemplate.getForObject(BASE_URL + "/" + user.getUserName(), List.class);
		assertEquals(results.size()  > 0, true);
		restTemplate.delete(BASE_URL + "/" + user.getEmail());
		
	}

}
