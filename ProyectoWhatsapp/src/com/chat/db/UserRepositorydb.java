package com.chat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import application.Usuario;

public class UserRepositorydb {

	private application.Usuario usuario;
	private String url;
	private String user;
	private String clave;
		
	public UserRepositorydb() {
		url = "jdbc:postgresql://localhost:5432/BDWhatsApp";
		user = "postgres";
		clave = "2003";
	}
	
	public List<Usuario> getUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Connection connect = DriverManager.getConnection(url, user, clave);
			Statement stm = connect.createStatement();
			String query = "select * from usuarios";			
			ResultSet rs = stm.executeQuery(query);
				
			while(rs.next()) {
				usuarios.add(new application.Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			connect.close();			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario userId(int id) {	
		try {
			Connection connect = DriverManager.getConnection(url, user, clave);
			Statement stm = connect.createStatement();
			String query = "select * from usuarios where usuarioId = " + id;			
			ResultSet rs = stm.executeQuery(query);
				
			while(rs.next()) {
				usuario = new application.Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			connect.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return usuario;		
	}
		
	public Usuario userName(String username) {	
		try {
			Connection connect = DriverManager.getConnection(url, user, clave);
			Statement stm = connect.createStatement();
			String query = "select * from usuarios where username = '" + username + "'";
			ResultSet rs = stm.executeQuery(query);
				
			while(rs.next()) {
				usuario = new application.Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			connect.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
		
	public Usuario password(String username, String password) {	
		try {
			Connection connect = DriverManager.getConnection(url, user, clave);
			Statement stm = connect.createStatement();
			String query = "select * from usuarios where username = '" + username + "' and clave = '" + password + "'";
			ResultSet rs = stm.executeQuery(query);
				
			while(rs.next()) {
				usuario = new application.Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			connect.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		return usuario;
	}
}
