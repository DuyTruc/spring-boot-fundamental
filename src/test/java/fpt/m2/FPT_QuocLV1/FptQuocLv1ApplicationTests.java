package fpt.m2.FPT_QuocLV1;
import fpt.m2.FPT_QuocLV1.dto.UserDto;
import fpt.m2.FPT_QuocLV1.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class FptQuocLv1ApplicationTests {
	private final String BASE_URL ="http://localhost:8082/user";

	@Test
	void createUser() {
		RestTemplate restTemplate = new RestTemplate();
		UserDto userDto = new UserDto(1,"QuocLV1","quoclv1@gmail.com","QuangNam",384937977);
		UserDto createdUser = restTemplate.postForObject(BASE_URL, userDto, UserDto.class);
		assertThat(createdUser).isNotNull();

	}
	@Test
	void getUserById(){
		RestTemplate restTemplate = new RestTemplate();
		UserDto userDto = new UserDto(1,"QuocLV1","quoclv1@gmail.com","QuangNam",384937977);
		UserDto createdUser = restTemplate.postForObject(BASE_URL, userDto, UserDto.class);
		UserDto retrievedUser = restTemplate.getForObject(BASE_URL + "/"+createdUser.getId(), UserDto.class);
		assertThat(retrievedUser).isEqualTo(createdUser);

	}
	@Test
	void updateUser(){
		RestTemplate restTemplate = new RestTemplate();
		UserEntity userDto = new UserEntity(1,"QuocLV1","quoclv1@gmail.com","QuangNam",384937977);
		UserEntity createdUser = restTemplate.postForObject(BASE_URL, userDto, UserEntity.class);
		createdUser.setEmail("quoclv1@fsoft.com");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserEntity> entity = new HttpEntity<>(createdUser, headers);
		ResponseEntity<UserEntity> response =
				restTemplate.exchange(BASE_URL + "/"+createdUser.getId(), HttpMethod.PUT, entity, UserEntity.class);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(200, HttpStatus.OK.value());



	}
	@Test
	void deleteUser(){
		RestTemplate restTemplate = new RestTemplate();
		UserEntity userDto = new UserEntity(1,"QuocLV1","quoclv1@gmail.com","QuangNam",384937977);
		UserEntity createdUser = restTemplate.postForObject(BASE_URL, userDto, UserEntity.class);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserEntity> entity = new HttpEntity<>(createdUser, headers);
		ResponseEntity<UserEntity> response =
				restTemplate.exchange(BASE_URL + "/"+createdUser.getId(),
						HttpMethod.DELETE, entity, UserEntity.class);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(200, HttpStatus.OK.value());

	}
}
