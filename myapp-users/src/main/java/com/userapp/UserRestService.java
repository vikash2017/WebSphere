package com.userapp;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Path("/users")
public class UserRestService {
@Autowired
UserService userService;
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<User> getAllUsers() {
return userService.getAllUsers();
}
@GET
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public User getUserById(@PathParam("id") long id) {
return userService.getById(id);
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public User create(User user) {
return userService.createUser(user);
}
@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public User update(User user) {
return userService.updateUser(user);
}
@DELETE
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public void remove(@PathParam("id") long id) {
userService.deleteUser(id);
}
}