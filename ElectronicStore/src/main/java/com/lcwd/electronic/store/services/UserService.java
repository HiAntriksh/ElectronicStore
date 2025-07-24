package com.lcwd.electronic.store.services;

import com.lcwd.electronic.store.dtos.PageableResponse;
import com.lcwd.electronic.store.dtos.UserDto;

import java.io.IOException;
import java.util.List;

public interface UserService {


    // create
    UserDto createUser(UserDto userDto);


    // update
    UserDto updateUser(UserDto userDto, String userId);

    //delete

    void deleteUser(String UserId) throws IOException;

    // get all users
    PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir);


    // get single user by id

    UserDto getUser(String userId);

    // get single user by email

    UserDto getUserByEmail(String email);

    // search user

    List<UserDto> searchUser(String keyword);

    UserDto getUserById(String userId);

    //other user specific features
}
