package com.example.mongodbrelationship.controller;

import com.example.mongodbrelationship.entity.User;
import com.example.mongodbrelationship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController{

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/placeorder")
	public String placeOrder(@RequestBody User user){
		userRepository.save(user);
		return "order placed";
	}


	@GetMapping("/getuserbyname/{name}")
	public List<User> getUserbyname(@PathVariable String name){

		return userRepository.findByName(name);
	}
	
	@GetMapping("/getuserbyaddr/{city}")
	public List<User> getUserbycity(@PathVariable String city){
		return userRepository.findByCity(city);
	}
}