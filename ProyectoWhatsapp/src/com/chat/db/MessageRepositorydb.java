package com.chat.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import application.Mensaje;
import application.Usuario;
public class MessageRepositorydb {

	private UserRepositorydb usuarios = new UserRepositorydb();
	private List<Mensaje> resultado;
	private String url;
	private String user;
	private String clave;
		
	public MessageRepositorydb() {
		url = "jdbc:postgresql://localhost:5432/Mensajeria";
		user = "postgres";
		clave = "m123";
	}
		
	public List<Mensaje> conversaciones(int usuario1, int usuario2){
		resultado = new ArrayList<Mensaje>();
		int id;
		String contenido;
		LocalDateTime fecha;
		Usuario emisor;
		Usuario receptor;
		
		try {
			Connection connect = DriverManager.getConnection(url, user, clave);
			Statement stm = connect.createStatement();
			String query = "select * from mensajes where user1Id = " + usuario1 + " and user2Id = " + usuario2 + " or user1Id = " + usuario2 + " and user2Id = " + usuario1;
			ResultSet rs = stm.executeQuery(query);
				
			while(rs.next()) {
				id = rs.getInt(1);
				contenido = rs.getString(2);
				fecha = rs.getTimestamp(3).toLocalDateTime();
				emisor = usuarios.userId(rs.getInt(2));
				receptor = usuarios.userId(rs.getInt(3));
				Mensaje ms = new Mensaje(id, contenido, fecha, emisor, receptor);
				resultado.add(ms);
			}
				
			connect.close();
		}
		catch(SQLException e) {
				e.printStackTrace();
		}
		return resultado;
	}
		
	public Mensaje getUltimoMsj(int usuario1, int usuario2) {
		resultado = conversaciones(usuario1, usuario2);
		if(resultado.size() == 0)
			return null;
		return resultado.get(resultado.size()-1);
	}
		
	public void addMensajes(Mensaje mensaje) {
		try {			
			Connection connect = DriverManager.getConnection(url, user, clave);
			Statement stm = connect.createStatement();
			String query = "insert into mensajes (user1Id, user2Id, mensaje, fecha)\r\n"
						+ "values (" + mensaje.getEmisor().getId() + ", " + mensaje.getReceptor().getId() + ", '" + mensaje.getContenido() + "', '" + mensaje.getFecha() + "');";
			stm.execute(query);
			connect.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Mensaje[] getMensageRepository() {
		// TODO Auto-generated method stub
		return null;
	}
}