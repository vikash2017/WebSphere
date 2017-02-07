package com.userapp;

import java.util.List;
public interface UserDao {
User createUser(User user);
User updateUser(User user);
void deleteUser(long userId);
User findUser(long userId);
List<User> findAllUsers();
}
