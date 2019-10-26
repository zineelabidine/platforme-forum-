package service;

import java.util.ArrayList;
import java.util.List;


import model.User;

public interface ServiceUser {
	public void create(User user);
	public void update(User user);
	public void delete(User user);
	public List<User> getall();
	public User logine(User user);
	public String affichernomuser(int id);
	public void ajoutertimein(int id);
	public void ajoutertimeout(int id);
	public ArrayList<Integer> utilisateur_login();
	
	
}
