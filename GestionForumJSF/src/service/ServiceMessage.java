package service;

import java.util.List;

import model.Message;
public interface ServiceMessage {
	public void create(Message message,int id_user,int id_discussion);
	public void update(Message message);
	public void delete(Message message);
	public List<Message> getall(int id_discussion);
	public List<Message> afficher();
	public int afficheriduser(int id_message);
}
