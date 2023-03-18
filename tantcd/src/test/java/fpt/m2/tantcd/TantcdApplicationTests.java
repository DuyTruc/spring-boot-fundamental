package fpt.m2.tantcd;

import fpt.m2.tantcd.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TantcdApplicationTests {
    private static final String BASE_URL = "http://127.0.0.1:8080/user";
    @Test
    @Order(1)
    void testCreateUser() {
        RestTemplate restTemplate = new RestTemplate();

        User userCreate = new User();
        userCreate.setUserName("congtan97");
        userCreate.setEmail("congtan98@gmail.com");
        userCreate.setAddress("Danang");
        userCreate.setPhoneNumber(12345);

        HttpEntity<User> request = new HttpEntity<>(userCreate);
        ResponseEntity<User> response = restTemplate.exchange(BASE_URL, HttpMethod.POST,request, User.class);
        Assertions.assertEquals(response.getStatusCode().value(), 200);
    }

    @Test
    @Order(2)
    void testGetUser() {
        RestTemplate restTemplate = new RestTemplate();

        int id = 1;
        User user = restTemplate
                .getForObject(BASE_URL + "/" + id, User.class);
        Assertions.assertNotNull(user.getUserName());
        Assertions.assertEquals(user.getEmail(), "congtan98@gmail.com");
    }

    @Test
    @Order(3)
    void testUpdateUser() {
        RestTemplate restTemplate = new RestTemplate();

        User user = new User();
        user.setId(1);
        user.setUserName("congtan97");
        user.setEmail("congtan98@gmail.com");
        user.setAddress("Danang");
        user.setPhoneNumber(98765);

        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<User> response = restTemplate.exchange(BASE_URL, HttpMethod.PUT,request, User.class);
        Assertions.assertEquals(response.getStatusCode().value(), 200);
    }

    @Test
    @Order(4)
    void testDeleteUser() {
        RestTemplate restTemplate = new RestTemplate();

        int id = 1;

        restTemplate.delete(BASE_URL + "/" + 1);
    }
}
