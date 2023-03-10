package com.chat.db;

import java.util.ArrayList;
import application.Mensaje; 
import java.util.List;
import application.Chat;
import application.Usuario;
public class ChatRepositorydb {

	private UserRepositorydb usuario;
	private MessageRepositorydb mensaje;
		
	public ChatRepositorydb() {
		usuario = new UserRepositorydb();
		mensaje = new MessageRepositorydb();
	}

	public UserRepositorydb getUsuario() {
		return usuario;
	}

	public void setUsuario(UserRepositorydb usuario) {
		this.usuario = usuario;
	}

	public MessageRepositorydb getMensaje() {
		return mensaje;
	}

	public void setMensaje(MessageRepositorydb mensaje) {
		this.mensaje = mensaje;
	}
		
	public List<Chat> getChat(int Id){
		List<Chat> contactMsj = new ArrayList<Chat>();
		List<Usuario> contactos = usuario.getUsuarios();
			
		for(Usuario l: contactos) {
			if(l.getId() == Id)
				continue;
				
			Mensaje ultimoMsj = mensaje.getUltimoMsj(Id, l.getId());
				
			if(ultimoMsj == null)
				continue;
				
			Usuario contacto = usuario.userId(l.getId());
				
			contactMsj.add(new Chat(contacto, ultimoMsj));
				
		}		
			
		return contactMsj;
			
	}

}
