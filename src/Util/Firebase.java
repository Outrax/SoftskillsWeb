package Util;

import java.io.Reader;

import org.codehaus.jackson.map.ObjectMapper;

import Entities.User;

public class Firebase {

	public User getUser(String username){
		User user = null;
		DriverI driver = new FireBaseDriver();
        driver.setChannel("https://softskill-tools.firebaseio.com/");
        Reader reader = driver.read("Brugere/"+username);
        try{
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(reader, User.class);
            System.out.println(user.getName());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("END");
        return user;
	} 
}
