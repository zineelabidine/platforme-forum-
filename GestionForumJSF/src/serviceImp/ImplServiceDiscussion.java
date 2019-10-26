package serviceImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Discussion;
import service.ServiceDiscussion;

public class ImplServiceDiscussion implements ServiceDiscussion {
	Connection conx;
	public ImplServiceDiscussion () 
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
	public void create(Discussion discussion,int id_forum,int id) {
		try {
			Statement ste=conx.createStatement();
			String requte ="INSERT INTO discussion (titre_discussion,description_discussion,id_user,id_forum) VALUES ('"+discussion.getNom()+"','"+discussion.getDescription()+"',"+id+","+id_forum+")";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Discussion discussion) {
		try {
			Statement ste=conx.createStatement();
			String requte ="UPDATE discussion SET titre_discussion='"+discussion.getNom()+"',description_discussion ='"+discussion.getDescription()+"' WHERE id="+discussion.getId()+";";
			ste.execute(requte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		// TODO Auto-generated method stub
		
	}		
	}
	@Override
	public void delete(Discussion discussion) {
		try {
			Statement ste=conx.createStatement();
			String requte ="DELETE FROM message WHERE message.id_discussion="+discussion.getId()+";";
			ste.execute(requte);
			requte ="DELETE FROM discussion WHERE discussion.id="+discussion.getId()+";";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Discussion> getall(int id_forum) {
		try {
			System.out.println("imher");
			ArrayList<Discussion> discussions=new ArrayList<Discussion>();
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM discussion where id_forum="+id_forum+";");
			while(result.next()){
				Discussion d=new Discussion();
				d.setId(result.getInt("id"));
				d.setNom(result.getString("titre_discussion"));
				d.setDescription(result.getString("description_discussion"));
				
				discussions.add(d);}
			return discussions;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public List<Discussion> afficher() {
		try {
		
			ArrayList<Discussion> discussions=new ArrayList<Discussion>();
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM discussion;");
			while(result.next()){
				Discussion d=new Discussion();
				d.setId(result.getInt("id"));
				d.setNom(result.getString("titre_discussion"));
				d.setDescription(result.getString("description_discussion"));
				discussions.add(d);}
			return discussions;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	
	}