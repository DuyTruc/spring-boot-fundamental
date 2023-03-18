package fpt.m2.kienpt16;

import fpt.m2.kienpt16.entity.UserEntity;
import fpt.m2.kienpt16.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Kienpt16ApplicationTests {

    @Value("${userrestapi.service.url}")
    String baseUrl;

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    void beforeAll() {
        // Clear data before test
        userRepository.deleteAll();
    }

    RestTemplate restTemplate = new RestTemplate();

    private UserEntity createUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(2);
        userEntity.setUserName("test_name");
        userEntity.setEmail("test@gmail.com");
        userEntity.setAddress("test");
        userEntity.setPhoneNumber("0387056256");
        return userEntity;
    }

    @Test
    @Order(1)
    void testCreateUserSuccess() {
        UserEntity userEntity = createUserEntity();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

        ResponseEntity<UserEntity> response =
                restTemplate.exchange(baseUrl + "/create", HttpMethod.POST, entity, UserEntity.class);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, HttpStatus.OK.value());
    }

    @Test
    @Order(2)
    void testCreateUserNegativeUsernameEmpty() {
        try {
            UserEntity userEntity = createUserEntity();
            userEntity.setUserName("");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

            restTemplate.exchange(baseUrl + "/create", HttpMethod.POST, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(3)
    void testCreateUserNegativeUsernameOversize() {
        try {
            UserEntity userEntity = createUserEntity();
            userEntity.setUserName(
                    "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest1");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

            restTemplate.exchange(baseUrl + "/create", HttpMethod.POST, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(4)
    void testCreateUserNegativeEmailEmpty() {
        try {
            UserEntity userEntity = createUserEntity();
            userEntity.setEmail("");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

            restTemplate.exchange(baseUrl + "/create", HttpMethod.POST, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(5)
    void testCreateUserNegativeEmailOversize() {
        try {
            UserEntity userEntity = createUserEntity();
            userEntity.setUserName(
                    "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttetesttesttesttestt@gmail.com");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

            restTemplate.exchange(baseUrl + "/create", HttpMethod.POST, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(6)
    void testCreateUserNegativeEmailInvalid() {
        try {
            UserEntity userEntity = createUserEntity();
            userEntity.setUserName("testtesttesttesttesttesttes");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

            restTemplate.exchange(baseUrl + "/create", HttpMethod.POST, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(7)
    void testCreateUserNegativeAddressEmpty() {
        try {
            UserEntity userEntity = createUserEntity();
            userEntity.setAddress("");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

            restTemplate.exchange(baseUrl + "/create", HttpMethod.POST, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(8)
    void testCreateUserNegativeAddressOversize() {
        try {
            UserEntity userEntity = createUserEntity();
            userEntity.setAddress(
                    "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest1");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

            restTemplate.exchange(baseUrl + "/create", HttpMethod.POST, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(9)
    void testGetUserSuccess() {
        System.out.println(createUserEntity().getId());
        ResponseEntity<UserEntity> response
                = restTemplate.getForEntity(baseUrl + "/getUserById/2", UserEntity.class);
        UserEntity userEntity = response.getBody();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(userEntity.getId(), createUserEntity().getId());
        Assertions.assertEquals(userEntity.getUserName(), "testtesttesttesttesttesttes");
        Assertions.assertEquals(userEntity.getEmail(), createUserEntity().getEmail());
        Assertions.assertEquals(userEntity.getAddress(), createUserEntity().getAddress());
        Assertions.assertEquals(userEntity.getPhoneNumber(), createUserEntity().getPhoneNumber());
    }

    @Test
    @Order(10)
    void testGetUserNegativeUserNotFound() {
        try {
            ResponseEntity<UserEntity> response
                    = restTemplate.getForEntity(baseUrl + "/getUserByName/9898989", UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    @Order(12)
    void testGetUserNegativeIdInvalidType() {
        try {
            ResponseEntity<UserEntity> response
                    = restTemplate.getForEntity(baseUrl + "/getUserByName/abc", UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(13)
    void testUpdateUserSuccess() {
        UserEntity userEntity = createUserEntity();
        userEntity.setPhoneNumber("987654321");
        userEntity.setEmail("update@gmail.com");
        userEntity.setAddress("home update");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);

        ResponseEntity<UserEntity> response =
                restTemplate.exchange(baseUrl + "/updateUser/999999",
                        HttpMethod.PUT, entity, UserEntity.class);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, HttpStatus.OK.value());
    }

    @Test
    @Order(14)
    void testUpdateUserNegativeUserNotFound() {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName("testsetsteststsetest");
            userEntity.setPhoneNumber("987654321");
            userEntity.setEmail("update@gmail.com");
            userEntity.setAddress("home update");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);
            restTemplate.exchange(baseUrl + "/update/9898989",
                    HttpMethod.PUT, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    @Order(15)
    void testUpdateUserNegativeIdInvalid() {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName("testsetsteststsetest");
            userEntity.setPhoneNumber("987654321");
            userEntity.setEmail("update@gmail.com");
            userEntity.setAddress("home update");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity, headers);
            restTemplate.exchange(baseUrl + "/update/abc",
                    HttpMethod.PUT, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @Test
    @Order(16)
    void testDeleteUserSuccess() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<UserEntity> entity = new HttpEntity<>(headers);

        ResponseEntity<UserEntity> response =
                restTemplate.exchange(baseUrl + "/delete/999999",
                        HttpMethod.DELETE, entity, UserEntity.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, HttpStatus.OK.value());
    }

    @Test
    @Order(17)
    void testDeleteUserNegativeUserNotFound() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<UserEntity> entity = new HttpEntity<>(headers);

            restTemplate.exchange(baseUrl + "/delete/9898989",
                    HttpMethod.DELETE, entity, UserEntity.class);
        } catch (HttpStatusCodeException exception) {
            Assertions.assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}
