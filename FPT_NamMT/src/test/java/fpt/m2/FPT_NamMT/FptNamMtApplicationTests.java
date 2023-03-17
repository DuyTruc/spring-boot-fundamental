package fpt.m2.FPT_NamMT;

import fpt.m2.FPT_NamMT.model.UserEntity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class FptNamMtApplicationTests {
  @Value("${resttemplate.api.url}")
  private String baseUrlRestTemplate;

  @Autowired
  RestTemplate restTemplate;

  @Test
  void test_1_CreateUser() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    Map<String, Object> body = new HashMap<>();
    body.put("userName", "NamMT");
    body.put("email", "NamMT@fsoft.com");
    body.put("address", "Rừng xà nu");
    body.put("phoneNumber", 123456);
    HttpEntity request = new HttpEntity(body, headers);
    ResponseEntity<Void> response = restTemplate.exchange(
        baseUrlRestTemplate + "createUser",
        HttpMethod.POST,
        request,
        Void.class);

    assertTrue(response.getStatusCode().is2xxSuccessful());
  }

  @Test
  void test_2_GetAllUser() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity request = new HttpEntity(null, headers);
    ResponseEntity<UserEntity[]> response = restTemplate.exchange(
        baseUrlRestTemplate + "getAll",
        HttpMethod.GET,
        request,
        UserEntity[].class);
    List<UserEntity> userList = Arrays.stream(
        Objects.requireNonNull(response.getBody())).toList();

    assertNotNull(userList);
    assertTrue(response.getStatusCode().is2xxSuccessful());
  }

  @Test
  void test_3_GetUserByName() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity request = new HttpEntity(null, headers);
    ResponseEntity<UserEntity[]> responseGetAllUser = restTemplate.exchange(
        baseUrlRestTemplate + "getAll",
        HttpMethod.GET,
        request,
        UserEntity[].class);
    List<UserEntity> userList = Arrays.stream(
        Objects.requireNonNull(responseGetAllUser.getBody())).toList();

    String userNameFirstIndex = userList.get(0).getUserName();

    String urlGetUserByName = baseUrlRestTemplate + "getUserByName/" + userNameFirstIndex;

    ResponseEntity<UserEntity[]> responseGetUserByName = restTemplate.exchange(
        urlGetUserByName,
        HttpMethod.GET,
        request,
        UserEntity[].class);

    UserEntity[] userEntity = responseGetUserByName.getBody();

    assertNotNull(responseGetUserByName.getBody());
    assertTrue(responseGetUserByName.getStatusCode().is2xxSuccessful());
  }

  @Test
  void test_4_GetUserById() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity request = new HttpEntity(null, headers);
    ResponseEntity<UserEntity[]> responseGetAllUser = restTemplate.exchange(
        baseUrlRestTemplate + "getAll",
        HttpMethod.GET,
        request,
        UserEntity[].class);
    List<UserEntity> userList = Arrays.stream(
        Objects.requireNonNull(responseGetAllUser.getBody())).toList();

    String idFirstIndex = userList.get(0).getId();

    String urlGetUserByName = baseUrlRestTemplate + "getUser/" + idFirstIndex;

    ResponseEntity<UserEntity> responseGetUserById = restTemplate.exchange(
        urlGetUserByName,
        HttpMethod.GET,
        request,
        UserEntity.class);

    UserEntity userEntity = responseGetUserById.getBody();

    assertNotNull(responseGetUserById.getBody());
    assertTrue(responseGetUserById.getStatusCode().is2xxSuccessful());
  }

  @Test
  void test_5_UpdateUser() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity requestGetAllUser = new HttpEntity(null, headers);
    ResponseEntity<UserEntity[]> responseGetAllUser = restTemplate.exchange(
        baseUrlRestTemplate + "getAll",
        HttpMethod.GET,
        requestGetAllUser,
        UserEntity[].class);
    List<UserEntity> userList = Arrays.stream(
        Objects.requireNonNull(responseGetAllUser.getBody())).toList();

    String idFirstIndex = userList.get(0).getId();

    String urlUpdateUserByName = baseUrlRestTemplate + "updateUser/" + idFirstIndex;

    Map<String, Object> body = new HashMap<>();
    body.put("userName", "HeHeHe");
    body.put("email", "HeHeHe@gmail.com");
    body.put("address", "Rừng rú");
    body.put("phoneNumber", 654321);

    HttpEntity requestUpdateUser = new HttpEntity(body, headers);

    ResponseEntity<Void> responseUpdateUser = restTemplate.exchange(
        urlUpdateUserByName,
        HttpMethod.PUT,
        requestUpdateUser,
        Void.class);

    assertTrue(responseUpdateUser.getStatusCode().is2xxSuccessful());
  }

  @Test
  void test_6_DeleteUserById() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity request = new HttpEntity(null, headers);
    ResponseEntity<UserEntity[]> responseGetAllUser = restTemplate.exchange(
        baseUrlRestTemplate + "getAll",
        HttpMethod.GET,
        request,
        UserEntity[].class);
    List<UserEntity> userList = Arrays.stream(
        Objects.requireNonNull(responseGetAllUser.getBody())).toList();

    String idFirstIndex = userList.get(0).getId();

    String urlDeleteUserByName = baseUrlRestTemplate + "deleteUser/" + idFirstIndex;

    ResponseEntity<Void> responseGetUserByName = restTemplate.exchange(
        urlDeleteUserByName,
        HttpMethod.DELETE,
        request,
        Void.class);

    assertTrue(responseGetUserByName.getStatusCode().is2xxSuccessful());
  }
}
