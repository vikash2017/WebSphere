package com.userapp;

import java.util.List;
public interface UserService {
List<User> getAllUsers();
User getById(long userId);
User createUser(User user);
User updateUser(User user);
void deleteUser(long userId);
}