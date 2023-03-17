package fpt.m2.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "User controller")
public class UserController {
	
//	@Autowired
//	private UserRepository repository;
//	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
//	
//	@RequestMapping(value = "/products/", method = RequestMethod.GET)
//	public List<UserEntity> getProducts() {
//		return repository.findAll();
//	}
//	
//	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
//	@Transactional(readOnly = true)
//	@Cacheable("product-cache")
//	public UserEntity getProduct(@PathVariable("id") int id) {
//		LOGGER.info("Find product by Id" + id);
//		return repository.findById(id).get();
//	}
//	
//	@RequestMapping(value = "/products/", method = RequestMethod.POST)
//	public UserEntity createProduct(@RequestBody UserEntity product) {
//		return repository.save(product);
//	}
//	
//	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
//	public UserEntity updateProduct(@RequestBody UserEntity product) {
//		return repository.save(product);
//	}
//	
//	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
//	@CacheEvict("product-cache")
//	public void deleteProduct(@PathVariable("id") int id) {
//		repository.deleteById(id);
//	}
}
