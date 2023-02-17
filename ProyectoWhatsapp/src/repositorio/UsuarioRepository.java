package repositorio;

import java.util.ArrayList;
import java.util.List;

import application.Usuario;

public class UsuarioRepository {
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	public UsuarioRepository() {
		Usuario Bryan = new Usuario(1, "Bryan", "Zumba", "Bryan", "123");
		Usuario Sayla= new Usuario(2, "Sayla", "Litardo", "Sayla", "123");
		Usuario Sebastian = new Usuario(3, "Sebastian", "Garcia", "Sebastian", "123");
		Usuario Saul = new Usuario(4, "Saul", "Litardo", "Saul", "123");
		
		usuarios.add(Bryan);
		usuarios.add(Sayla);
		usuarios.add(Sebastian);
		usuarios.add(Saul);
	}
	
	public Usuario getUsuario(int id) {
		for(Usuario usuario: usuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}

}