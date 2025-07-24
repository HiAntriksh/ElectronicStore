package com.lcwd.electroinc.store.ElectronicStore.services;

import com.lcwd.electroinc.store.ElectronicStore.dtos.UserDto;
import com.lcwd.electroinc.store.ElectronicStore.entities.User;

import java.util.List;

public interface UserService {


    // create
    UserDto createUser(UserDto userDto);


    // update
    UserDto updateUser(UserDto userDto, String userId);

    //delete

    void deleteUser(String UserId);

    // get all users
    List<UserDto> getAllUser();

    // get single user by id

    UserDto getUser(String userId);

    // get single user by email

    UserDto getUserByEmail(String email);

    // search user

    List<UserDto> searchUser(String keyword);

    //other user specific features

}
