package com.users.app.controller;

import com.users.app.entity.Users;
import com.users.app.service.UsersService;
import com.users.app.utils.constants.ApiConstants;
import com.users.app.utils.constants.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(ApiConstants.USERS)
public class UserController {

    @Autowired
    UsersService usersService;

    @GetMapping()
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @PostMapping()
    public ResponseEntity<ResponseData> saveUsers(@RequestBody final Users users) {
        final String returnMsg = usersService.saveUsers(users);
        ResponseData responseData = new ResponseData(returnMsg, true);
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(ApiConstants.PATH_VARIABLE_USERID)
    public ResponseEntity<ResponseData> deleteUsers(@PathVariable final String userId) {
        final String returnMsg = usersService.deleteUsers(userId);
        ResponseData responseData = new ResponseData(returnMsg, true);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping()
    public String updateUsers(@RequestBody final Users users) {
        return usersService.updateUsers(users);
    }

    @GetMapping(ApiConstants.PATH_VARIABLE_SEARCH)
    public ResponseEntity<List<Users>> searchUsers(@PathVariable final String searchString) {
        return ResponseEntity.ok(usersService.searchUsers(searchString));
    }
}