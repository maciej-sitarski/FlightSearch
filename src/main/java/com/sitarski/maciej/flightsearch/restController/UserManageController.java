package com.sitarski.maciej.flightsearch.restController;

import com.sitarski.maciej.flightsearch.dao.UserRepository;
import com.sitarski.maciej.flightsearch.entity.User;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userManage")
public class UserManageController {

  private final UserRepository userRepository;

  @Autowired
  public UserManageController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping(value = "/", consumes = "application/json")
  public @ResponseBody void saveUserInDataBase(@RequestBody User user) {
    if(userRepository.findByEmail(user.getEmail()).isEmpty()){
      User userToSave = new User();
      userToSave.setUserId(user.getId());
      userToSave.setEmail(user.getEmail());
      userRepository.save(userToSave);
    }
  }
}
