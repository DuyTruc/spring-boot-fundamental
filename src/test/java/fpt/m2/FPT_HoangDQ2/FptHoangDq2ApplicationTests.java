package fpt.m2.FPT_HoangDQ2;

import fpt.m2.FPT_HoangDQ2.controller.UserController;
import fpt.m2.FPT_HoangDQ2.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FptHoangDq2ApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	public void testCreateUser(){
		RestTemplate restTemplate = new RestTemplate();
		UserDTO userDTO = createUserDTO();
		UserDTO newUser = userController.createUser(userDTO);
		int id = newUser.getId();
		List<Map<?,?>> results = restTemplate.getForObject("http://localhost:8080/user/" + id, List.class);
		assertEquals(results.get(0).get("id"), id);
	}

	public void testUpdateUser(){
		RestTemplate restTemplate = new RestTemplate();
		UserDTO userDTO = createUserDTO();
		UserDTO newUser = userController.createUser(userDTO);
		int id = newUser.getId();

		userDTO.setId(id);
		userDTO.setUserName("testUpdate");

		restTemplate.postForObject("http://localhost:8080/user/", userDTO, Object.class);

		List<Map<?,?>> results = restTemplate.getForObject("http://localhost:8080/user/" + id, List.class);
		assertEquals(results.get(0).get("userName"),"testUpdate");
	}

	public void testDeleteUser(){
		RestTemplate restTemplate = new RestTemplate();
		UserDTO userDTO = createUserDTO();
		UserDTO newUser = userController.createUser(userDTO);
		int id = newUser.getId();
		restTemplate.delete("http://localhost:8080/user/" + id);
		List<Map<?,?>> results = restTemplate.getForObject("http://localhost:8080/user/" + id, List.class);
		assertEquals(results.size(),0);
	}

	private static UserDTO createUserDTO() {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("Hoang");
		userDTO.setEmail("hoangdq2@fsoft.com.vn");
		userDTO.setPhoneNumber(Integer.parseInt("0778506650"));
		userDTO.setAddress("danang");
		return userDTO;
	}

}
