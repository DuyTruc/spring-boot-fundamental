package fpt.m2.FPT_AnhLD42;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import fpt.m2.FPT_AnhLD42.Entity.UserEntity;
import fpt.m2.FPT_AnhLD42.Reponsitory.UserRepository;

@SpringBootTest
class FptAnhLd42ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
    private UserRepository userRepository;

    private UserEntity buildUser() {
		UserEntity user = new UserEntity();
		user.setId(1);
		user.setUserName("anhLD123");
		user.setEmail("ducanh@gmail.com");
		user.setAddress("hue");
		user.setPhoneNumber("0348758432");
		return user;
	}
    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false)
    public void createUserTest(){

        UserEntity user = buildUser();
        
        userRepository.createUser(user);
        
        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }
    
    @Test
    @Order(2)
    public void getUserTest(){

    	UserEntity user = userRepository.getUserById(1);

        Assertions.assertThat(user.getId()).isEqualTo(1);
    }
    
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){

    	UserEntity user = userRepository.getUserById(1);

    	user.setEmail("leducanhtest@gmail.com");

    	UserEntity userUpdated =  userRepository.updateUser(user);

        Assertions.assertThat(userUpdated.getEmail()).isEqualTo("leducanhtest@gmail.com");

    }
//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteUserTest(){
//
//    	userRepository.deleteUser(1);
//
//    }
}
