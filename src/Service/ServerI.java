package Service;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(name="ServerI")
public interface ServerI {

	
	@WebMethod boolean login(String bruger, String adgangskode) ;
	@WebMethod String CheckConnection() ;
	@WebMethod String getSafeSize() ;
	//@WebMethod void createGroup(String name, ArrayList<User> users, int size) ;
	//@WebMethod Group getGroup(String name) ;
	@WebMethod boolean deleteGroup(String name) ;
	//@WebMethod ArrayList<User> getAllUsers() ;
	//@WebMethod void addProductToUser(AbstractItem item, User user, int qty) ;
	//@WebMethod void addToResults(User user,AbstractItem item) ;
	@WebMethod void setName(String newName, String newSurName) ;
	@WebMethod String getName() ;
	@WebMethod String getSurName() ;
	@WebMethod void setEmail(String newEmail) ;
	@WebMethod String getEmail() ;
	@WebMethod void setRetning(String newRetning) ;
	@WebMethod String getRetning() ;
	//@WebMethod List<AbstractItem> retrieveSafeObjects();
	//@WebMethod Safe getSafe() ;
	//@WebMethod void setSafe(Safe safe) ;
	@WebMethod void setfullName() ;
	//@WebMethod List<AbstractItem> hentResults() ;
	@WebMethod String getFullName() ;
	//@WebMethod void addToSafe(AbstractItem item, int qty) ;
	@WebMethod void setFirstRun(Boolean firstRun) ;
	@WebMethod boolean getFirstRun() ;
	@WebMethod boolean getAdministrativ() ;
	@WebMethod boolean getNotifikationer() ;
	@WebMethod boolean getInverter() ;
	@WebMethod void setAdministrativ(boolean administrativ) ;
	@WebMethod void setNotifikationer(boolean notifikationer) ;
	@WebMethod void setInverter(boolean inverter) ;
	@WebMethod boolean write(Map<String, String> map);
	@WebMethod Reader read(String uri) ;
	@WebMethod boolean delete(String uri) ;
	@WebMethod void setChannel(String channel);
	@WebMethod void setKey(String key) ;

	
}
