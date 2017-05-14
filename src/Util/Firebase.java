package Util;

import java.io.Reader;

import org.codehaus.jackson.map.ObjectMapper;

import Entities.User;

public class Firebase {

	public User getUser(String username){
	 DriverI driver = new FireBaseDriver();
	  driver.setChannel("https://softskill-tools.firebaseio.com/");
	  Reader reader = driver.read("Brugere/"+username);
	  try{
		  ObjectMapper mapper = new ObjectMapper();
		  User user = mapper.readValue(reader,User.class);
		  System.out.println(user.getName());
		  return user;
	  }
	  catch(Exception e){
		  System.out.println("Der skete en fejl under henting af bruger");
	  }
	  return null; 
	}
	  
}
