package model;

public class Message {
	int id ;
	public String object;
	public String message;
	public Message() {
		super();
	}
	public Message(int id, String object, String message) {
		super();
		this.id = id;
		this.object = object;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", object=" + object + ", message=" + message + "]";
	}
	

}
