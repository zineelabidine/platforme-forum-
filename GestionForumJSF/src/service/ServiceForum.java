package service;

import java.util.List;


import model.Forum;

public interface ServiceForum {
	public void create(Forum forum);
	public void update(Forum forum);
	public void delete(Forum forum);
	public List<Forum> getall();
	public List<Forum> getlistebycategorie(int id_categorie);
}
