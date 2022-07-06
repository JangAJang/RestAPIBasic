package com.example.demo.Controller;

import com.example.demo.Mapper.UserProfileMapper;
import com.example.demo.Model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private UserProfileMapper userProfileMapper;
    public UserProfileController(UserProfileMapper userProfileMapper){
        this.userProfileMapper = userProfileMapper;
    }

    private Map<String, UserProfile> map;

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id){
        return userProfileMapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList(){
        return userProfileMapper.getUserProfileList();
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                               @RequestParam("phone") String phone, @RequestParam("address") String address){
        userProfileMapper.insertUserProfile(id, name, phone, address);
    }

    @PostMapping("/user/{id}")
    public void modifyUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                                  @RequestParam("phone") String phone, @RequestParam("address") String address){
        userProfileMapper.updateUserProfile(id, name, phone, address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id){
        userProfileMapper.deleteUserProfile(id);
    }

}
