package serviceImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Message;
import model.User;
import service.ServiceMessage;

public class ImplServiceMessage implements ServiceMessage {
	Connection conx;
	public ImplServiceMessage () 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionforum","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void create(Message message,int id_user,int id_discussion) {
		try {
			System.out.println(id_user);
			Statement ste=conx.createStatement();
			String requte ="INSERT INTO message (object_message, message,id_user,id_discussion) VALUES ('"+message.getObject()+"','"+message.getMessage()+"',"+id_user+","+id_discussion+")";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Message message) {
		try {
			Statement ste=conx.createStatement();
			String requte ="UPDATE message SET object_message='"+message.getObject()+"',message='"+message.getMessage()+"' WHERE id="+message.getId()+";";
			ste.execute(requte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		// TODO Auto-generated method stub
		
	}
		
	}
	@Override
	public void delete(Message message) {
		try {
			Statement ste=conx.createStatement();
			String requte ="DELETE FROM message WHERE id="+message.getId()+";";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Message> getall(int id_discussion) {
		try {
			ArrayList<Message> messages=new ArrayList<Message>();
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM message where  	id_discussion="+id_discussion+";");
			while(result.next()){
				Message m=new Message();
				m.setId(result.getInt("id"));
				m.setObject(result.getString("object_message"));
				m.setMessage(result.getString("message"));
				messages.add(m);}
			return messages;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public List<Message> afficher() {
		try {
			ArrayList<Message> messages=new ArrayList<Message>();
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM message ;");
			while(result.next()){
				Message m=new Message();
				m.setId(result.getInt("id"));
				m.setObject(result.getString("object_message"));
				m.setMessage(result.getString("message"));
				messages.add(m);}
			return messages;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public int afficheriduser(int id_message) {
		try {
			int iduser = 0;
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM message where id="+id_message+" ;");
			while(result.next()){
		
				iduser=result.getInt("id_user");

		}
			return iduser;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return 0;
	}
	
	
	
}
