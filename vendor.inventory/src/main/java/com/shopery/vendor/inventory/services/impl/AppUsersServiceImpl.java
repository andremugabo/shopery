package com.shopery.vendor.inventory.services.impl;

import com.shopery.vendor.inventory.dto.AppUsersDto;
import com.shopery.vendor.inventory.models.AppUsers;
import com.shopery.vendor.inventory.models.UserType;
import com.shopery.vendor.inventory.repositories.AppUsersRepository;
import com.shopery.vendor.inventory.services.AppUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppUsersServiceImpl implements AppUsersService {

    @Autowired
    private AppUsersRepository appUsersRepository;
    @Override
    public AppUsersDto addUsers(AppUsersDto appUsersDto) {

        if(appUsersRepository.existsByEmail(appUsersDto.getEmail())){
            throw new IllegalArgumentException("User with this email already exists");
        }
        // Convert AppUsersDto to AppUsers JPA entity
        AppUsers appUsers = new AppUsers();

        appUsers.setUserType(UserType.valueOf(appUsersDto.getUserType()));
        appUsers.setName(appUsersDto.getName());
        appUsers.setEmail(appUsersDto.getEmail());
        appUsers.setPhoneNumber(appUsersDto.getPhoneNumber());
        appUsers.setAddress(appUsersDto.getAddress());
        appUsers.setStatus(appUsersDto.getStatus());
        appUsers.setLatitude(appUsersDto.getLatitude());
        appUsers.setLongitude(appUsersDto.getLongitude());
        appUsers.setIsTwoFactorEnabled(appUsersDto.getIsTwoFactorEnabled());
        appUsers.setIsTwoFactorVerified(appUsersDto.getIsTwoFactorVerified());
        appUsers.setPassword(appUsersDto.getPassword());

        // Save the entity to the repository
        AppUsers savedUser = appUsersRepository.save(appUsers);

        // Convert saved AppUsers entity back to AppUsersDto
        AppUsersDto savedUserDto = new AppUsersDto(
                savedUser.getUserId(),
                savedUser.getUserType().name(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getPhoneNumber(),
                savedUser.getAddress(),
                savedUser.getStatus(),
                savedUser.getLatitude(),
                savedUser.getLongitude(),
                savedUser.getIsTwoFactorEnabled(),
                savedUser.getIsTwoFactorVerified(),
                savedUser.getPassword()
        );

        return savedUserDto;
    }

    @Override
    public AppUsersDto login(String email, String password) {
        AppUsers user = appUsersRepository.findByEmail(email);


        if (!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return new AppUsersDto(
                user.getUserId(),
                user.getUserType().name(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getStatus(),
                user.getLatitude(),
                user.getLongitude(),
                user.getIsTwoFactorEnabled(),
                user.getIsTwoFactorVerified(),
                user.getPassword()
        );
    }

    @Override
    public AppUsersDto updateUser(UUID userId, AppUsersDto appUsersDto) {
        AppUsers existingUser = appUsersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Update fields as necessary
        existingUser.setName(appUsersDto.getName());
        existingUser.setPhoneNumber(appUsersDto.getPhoneNumber());
        existingUser.setAddress(appUsersDto.getAddress());
        existingUser.setStatus(appUsersDto.getStatus());
        existingUser.setLatitude(appUsersDto.getLatitude());
        existingUser.setLongitude(appUsersDto.getLongitude());
        existingUser.setIsTwoFactorEnabled(appUsersDto.getIsTwoFactorEnabled());
        existingUser.setIsTwoFactorVerified(appUsersDto.getIsTwoFactorVerified());

        // Save the updated user
        AppUsers updatedUser = appUsersRepository.save(existingUser);

        return new AppUsersDto(
                updatedUser.getUserId(),
                updatedUser.getUserType().name(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getPhoneNumber(),
                updatedUser.getAddress(),
                updatedUser.getStatus(),
                updatedUser.getLatitude(),
                updatedUser.getLongitude(),
                updatedUser.getIsTwoFactorEnabled(),
                updatedUser.getIsTwoFactorVerified(),
                updatedUser.getPassword()
        );
    }

    @Override
    public void softDeleteUser(UUID userId) {
        AppUsers user = appUsersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setStatus(true);
        appUsersRepository.save(user); // Mark as deleted
    }
    @Override
    public AppUsersDto getUserById(UUID userId) {
        AppUsers user = appUsersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new AppUsersDto(
                user.getUserId(),
                user.getUserType().name(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getStatus(),
                user.getLatitude(),
                user.getLongitude(),
                user.getIsTwoFactorEnabled(),
                user.getIsTwoFactorVerified(),
                user.getPassword()
        );
    }

    @Override
    public List<AppUsersDto> getAllUsers() {
        List<AppUsers> users = appUsersRepository.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private AppUsersDto convertToDto(AppUsers appUsers) {
        return new AppUsersDto(
                appUsers.getUserId(),
                appUsers.getUserType().name(),
                appUsers.getName(),
                appUsers.getEmail(),
                appUsers.getPhoneNumber(),
                appUsers.getAddress(),
                appUsers.getStatus(),
                appUsers.getLatitude(),
                appUsers.getLongitude(),
                appUsers.getIsTwoFactorEnabled(),
                appUsers.getIsTwoFactorVerified(),
                appUsers.getPassword()
        );
    }
}
