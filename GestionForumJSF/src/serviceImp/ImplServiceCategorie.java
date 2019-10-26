package serviceImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categorie;
import model.Forum;
import service.ServiceCategorie;

public class ImplServiceCategorie implements ServiceCategorie {
	Connection conx;
	public ImplServiceCategorie () 
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
	public void create(Categorie categorie) {
		try {
			System.out.println(categorie);
			Statement ste=conx.createStatement();
			String requte ="INSERT INTO categorie (titre, description) VALUES ('"+categorie.getNom()+"','"+categorie.getDescription()+"')";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Categorie categorie) {
		try {
			System.out.println(categorie);
			Statement ste=conx.createStatement();
			String requte ="UPDATE categorie SET titre='"+categorie.getNom()+"',description='"+categorie.getDescription()+"' WHERE id="+categorie.getId()+";";
			ste.execute(requte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		// TODO Auto-generated method stub
		
	}
		
		
	}
	@Override
	public void delete(Categorie categorie) {
		try {
			Statement ste=conx.createStatement();
			String requte ="DELETE FROM message WHERE id_discussion IN (SELECT id FROM discussion WHERE id_forum IN (SELECT id from forum WHERE id_categorie="+categorie.getId()+"));;";
			ste.execute(requte);
			requte ="DELETE FROM discussion WHERE id_forum IN (SELECT id FROM forum WHERE id_categorie="+categorie.getId()+");";
			ste.execute(requte);
			requte ="DELETE FROM forum WHERE forum.id_categorie="+categorie.getId()+";";
			ste.execute(requte);
			requte ="DELETE FROM categorie WHERE id="+categorie.getId()+"; ";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Categorie> getall() {
		try {
			ArrayList<Categorie> categories=new ArrayList<Categorie>();
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM categorie;");
			while(result.next()){
				Categorie g=new Categorie();
				g.setId(result.getInt("id"));
				g.setNom(result.getString("titre"));
				g.setDescription(result.getString("description"));
				categories.add(g);}
			return categories;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public String getNamebyid(int id) {
		try {
			String nom;
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM categorie where id='"+id+"';");
			while(result.next()){
				nom=result.getString("titre");
			return nom;

		} 
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public int getidbyname(String nom) {
		try {
			int  id;
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM categorie where titre='"+nom+"';");
			while(result.next()){
				id=result.getInt("id");
			return id;

		} 
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return 0;
	}
	
	
	}
	


