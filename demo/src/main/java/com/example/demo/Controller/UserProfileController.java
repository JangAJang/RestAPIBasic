package com.example.demo.Controller;

import com.example.demo.Model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private Map<String, UserProfile> map;

    @PostConstruct
    public void init(){
        map = new HashMap<String, UserProfile>();
        map.put("1", new UserProfile("1", "Peter", "111-1111", "YonginCity"));
        map.put("2", new UserProfile("2", "John", "222-2222", "SuwonCity"));
        map.put("3", new UserProfile("3", "Paul", "333-3333", "GangnamCity"));
        map.put("4", new UserProfile("4", "Uda", "444-4444", "BusanCity"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id){
        return map.get(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList(){
        return new ArrayList<UserProfile>(map.values());
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                               @RequestParam("phone") String phone, @RequestParam("address") String address){
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        map.put(id, userProfile);
    }

    @PostMapping("/user/{id}")
    public void modifyUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                                  @RequestParam("phone") String phone, @RequestParam("address") String address){
        UserProfile userProfile = map.get(id);
        userProfile.setName(name);
        userProfile.setPhone(phone);
        userProfile.setAddress(address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id){
        map.remove(id);
    }

}
