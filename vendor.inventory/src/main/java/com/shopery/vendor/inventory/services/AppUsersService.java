package com.shopery.vendor.inventory.services;

import com.shopery.vendor.inventory.dto.AppUsersDto;

import java.util.List;
import java.util.UUID;

public interface AppUsersService {

    AppUsersDto addUsers(AppUsersDto appUsersDto);
    AppUsersDto login(String email, String password);
    AppUsersDto updateUser(UUID userId, AppUsersDto appUsersDto);
    void softDeleteUser(UUID userId);
    AppUsersDto getUserById(UUID userId);
    List<AppUsersDto> getAllUsers();

}
