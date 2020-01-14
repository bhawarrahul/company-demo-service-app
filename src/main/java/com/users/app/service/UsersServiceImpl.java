package com.users.app.service;

import com.users.app.entity.Users;
import com.users.app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private final static String USERS_EXISTS = "User Already Exists!";
    private final static String USERS_NOT_EXISTS = "User Not Exists!";
    private final static String USERS_NO_RESULTS = "No search results!";
    private final static String USERS_ADDED = "User Added successfully";
    private final static String USERS_DELETED = "User deleted successfully!";
    private final static String USERS_UPDATED = "User updated successfully!";

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public String saveUsers(final Users users) {
        String saveUsersMsg = USERS_EXISTS;
        if (!usersRepository.existsByUserId(users.getUserId())) {
            usersRepository.save(users);
            saveUsersMsg = USERS_ADDED;
        }
        return saveUsersMsg;
    }

    @Override
    @Transactional()
    public String deleteUsers(final String userId) {
        String usersDeleteMsg = USERS_NOT_EXISTS;
        if (usersRepository.existsByUserId(userId)) {
            usersRepository.deleteByUserId(userId);
            usersDeleteMsg = USERS_DELETED;
        }
        return usersDeleteMsg;
    }

    @Override
    public String updateUsers(final Users usersUpdate) {
        String usersUpdateMsg = USERS_NOT_EXISTS;
        if (usersRepository.existsByUserId(usersUpdate.getName())) {
            Users users = usersRepository.findByUserId(usersUpdate.getName());
            users.setAddress(usersUpdate.getAddress());
            usersRepository.save(users);
            usersUpdateMsg = USERS_UPDATED;
        }
        return usersUpdateMsg;
    }

    @Override
    public List<Users> searchUsers(final String searchString) {
        return usersRepository.findByNameContainingOrAddressContaining(searchString, searchString);
    }
}