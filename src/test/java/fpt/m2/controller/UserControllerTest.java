package fpt.m2.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import fpt.m2.entity.UserEntity;
import fpt.m2.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setUserName("user1");
        user.setEmail("user1@test.com");
        user.setAddress("123 Main St, City, Country");
        user.setPhoneNumber("1234567890");

        when(userService.createUser(any(UserEntity.class))).thenReturn(user);

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userName", is(user.getUserName())))
                .andExpect(jsonPath("$.email", is(user.getEmail())))
                .andExpect(jsonPath("$.address", is(user.getAddress())))
                .andExpect(jsonPath("$.phoneNumber", is(user.getPhoneNumber())));

        verify(userService, times(1)).createUser(any(UserEntity.class));
    }

    @Test
    public void testGetUserByName() throws Exception {
        String userName = "user1";
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setEmail("user1@test.com");
        user.setAddress("123 Main St, City, Country");
        user.setPhoneNumber("1234567890");

        when(userService.getUserByName(userName)).thenReturn(user);

        mockMvc.perform(get("/api/users/{userName}", userName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName", is(user.getUserName())))
                .andExpect(jsonPath("$.email", is(user.getEmail())))
                .andExpect(jsonPath("$.address", is(user.getAddress())))
                .andExpect(jsonPath("$.phoneNumber", is(user.getPhoneNumber())));

        verify(userService, times(1)).getUserByName(userName);
    }

    @Test
    public void testUpdateUser() throws Exception {
        Long userId = 1L;
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setUserName("user1");
        user.setEmail("user1@test.com");
        user.setAddress("123 Main St, City, Country");
        user.setPhoneNumber("1234567890");

        when(userService.updateUser(any(UserEntity.class))).thenReturn(user);

        mockMvc.perform(put("/api/users/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(user.getId().intValue())))
                .andExpect(jsonPath("$.userName", is(user.getUserName())))
                .andExpect(jsonPath("$.email", is(user.getEmail())))
                .andExpect(jsonPath("$.address", is(user.getAddress())))
                .andExpect(jsonPath("$.phoneNumber", is(user.getPhoneNumber())));

        verify(userService, times(1)).updateUser(any(UserEntity.class));
    }

    @Test
    public void testDeleteUser() throws Exception {
        Long userId = 1L;

        mockMvc.perform(delete("/api/users/{id}", userId))
                .andExpect(status().isNoContent());

        verify(userService, times(1)).deleteUser(userId);
    }
}
