package com.userapp;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UserServiceTest {
	Client client = Client.create();

	@Test
	public void getAllUsersTest() {
		WebResource webResource = client.resource("http://localhost:9090/rest/users");
		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
		Assert.assertEquals(200, response.getStatus());
		String output = response.getEntity(String.class);
		Assert.assertTrue(output.contains("userId"));
	}

	@Test
	public void createUpdateUserTest() {
		WebResource webResource = client.resource("http://localhost:9090/rest/users");
		String input = "{\"birthDate\":\"2001-02-01\",\"firstName\":\"Norman\",\"lastName\":\"May\",\"userId\":\"2\"}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		Assert.assertEquals(200, response.getStatus());
		String output = response.getEntity(String.class);
		Assert.assertTrue(output.contains("userId"));
		input = "{\"birthDate\":\"2001-02-01\",\"firstName\":\"Norman\",\"lastName\":\"Smith\",\"userId\":\"2\"}";
		response = webResource.type("application/json").put(ClientResponse.class, input);
		Assert.assertEquals(200, response.getStatus());
		output = response.getEntity(String.class);
		Assert.assertTrue(output.contains("userId"));
	}
}
