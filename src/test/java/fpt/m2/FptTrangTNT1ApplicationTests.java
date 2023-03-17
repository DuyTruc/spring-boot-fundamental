package fpt.m2;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fpt.m2.entity.UserEntity;
import fpt.m2.repository.UserRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest
class FptTrangTNT1ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRepository userRepository;

	@Test
	void testGetUser() throws Exception {
		UserEntity UserEntity = new UserEntity();
		UserEntity.setUserName("Trang");
		UserEntity.setEmail("trang@gmail.com");
		UserEntity.setAddress("abc");
		UserEntity.setPhoneNumber(00000001);
		when(userRepository.findById((long) 3).get()).thenReturn(UserEntity);

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		mockMvc.perform(get("/getUser/3").content(objectWriter.writeValueAsString(UserEntity)))
				.andExpect(status().isOk());
	}

	@Test
	void testCreateUser() throws Exception {
		UserEntity UserEntity = new UserEntity();
		UserEntity.setUserName("Thuy Trang");
		UserEntity.setEmail("thuytrang104@gmail.com");
		UserEntity.setAddress("abc");
		UserEntity.setPhoneNumber(123456789);
		when(userRepository.save(any())).thenReturn(UserEntity);

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		mockMvc.perform(post("/createUser").contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(UserEntity))).andExpect(status().isOk());
	}

	@Test
	void testUpdateUser() throws Exception {
		UserEntity UserEntity = new UserEntity();
		UserEntity.setUserName("TrangTNT1");
		UserEntity.setEmail("trangtnt1@gmail.com");
		UserEntity.setAddress("defgh");
		UserEntity.setPhoneNumber(123456729);
		when(userRepository.save(any())).thenReturn(UserEntity);

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		mockMvc.perform(put("/updateUser").contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(UserEntity))).andExpect(status().isOk());
	}

	@Test
	void testDeleteUser() throws Exception {
		doNothing().when(userRepository).deleteById((long) 1);
		mockMvc.perform(get("/deleteUser/1")).andExpect(status().isOk());
	}

}
