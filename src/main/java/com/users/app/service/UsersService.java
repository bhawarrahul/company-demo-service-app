package com.users.app.service;

import com.users.app.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    String saveUsers(final Users users);

    String deleteUsers(final String userId);

    String updateUsers(final Users users);

    List<Users> searchUsers(final String searchString);
}
