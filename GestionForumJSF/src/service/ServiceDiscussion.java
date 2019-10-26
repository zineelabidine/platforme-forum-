package service;

import java.util.List;


import model.Discussion;

public interface ServiceDiscussion {
	public void create(Discussion discussion,int id_forum,int id);
	public void update(Discussion discussion);
	public void delete(Discussion discussion);
	public List<Discussion> getall(int id_forum);
	public List<Discussion> afficher();
	
}
