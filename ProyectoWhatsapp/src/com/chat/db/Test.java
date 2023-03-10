package com.chat.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import application.Mensaje;
import application.Usuario;

public class Test {
	
	public static void main(String[] args) {
		
		UserRepositorydb  users = new UserRepositorydb();
		MessageRepositorydb messages = new MessageRepositorydb();

		try {
			Connection conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDWhatsApp", "postgres", "2003");
			Statement stm = conect.createStatement();
			String queryInsert;
			String queryCreate;
			String queryDrop;
		
			
			
			queryCreate = "create table usuarios (\r\n"
					+ "	usuarioId serial not null,\r\n"
					+ "	nombre character varying not null,\r\n"
					+ "	apellido character varying not null,\r\n"
					+ "	username character varying not null,\r\n"
					+ "	imagen character varying not null,\r\n"
					+ "	clave character varying not null,\r\n"
					+ "	estado character varying not null,\r\n"
					+ "	constraint pk_userId primary key (usuarioId)\r\n"
					+ ");\r\n"
					+ "\r\n"
					+ "create table mensajes (\r\n"
					+ "	mensajeId serial not null,\r\n"
					+ "	user1Id integer not null,\r\n"
					+ "	user2Id integer not null,\r\n"
					+ "	mensaje character varying not null,\r\n"
					+ "	fecha timestamp not null,\r\n"
					+ "	constraint pk_mensajeId primary key (mensajeId),\r\n"
					+ "	constraint fk_user1Id foreign key (user1Id) references usuarios (usuarioId),\r\n"
					+ "	constraint fk_user2Id foreign key (user2Id) references usuarios (usuarioId)\r\n"
					+ ");";
			
			stm.execute(queryCreate);
			

			for(Usuario user: users.getUsuarios()) {
	
				queryInsert = "INSERT INTO public.users (nombre, apellido, username, password)"
						+ "VALUES ('"+user.getNombre()+"', '"+user.getApellido()+"', '"+user.getUsername()+"', '"+user.getPassword()+"');";
							
				stm.execute(queryInsert);
	
			}
			
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd MMM, YYYY  HH:mm");
			
			for(Mensaje msj: messages.getMensageRepository()) {
				
				queryInsert = "INSERT INTO public.mensajes (user1Id, user2Id, mensaje, fecha)"
						+ "VALUES ("+msj.getContenido()+"', '"+dt.format(msj.getFecha())+"','"+msj.getEmisor().getId()+"', '"+msj.getReceptor().getId()+"')";
				
				stm.execute(queryInsert);
						 
			}
		
			System.out.println("Conexion exitosa");
			
		}
		
		catch (SQLException e) {
			
			System.out.println("Conexion erronea");
			e.printStackTrace();
		}	
			
		
	}

}