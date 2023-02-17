package repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import application.Mensaje;
import application.Usuario;

	public class MensajeRepository {
		private ArrayList<Mensaje> mensajes = new ArrayList<>();
		
		public MensajeRepository() {
			Usuario Bryan = new Usuario(1, "Bryan", "Zumba", "Bryan", "123");
			Usuario Sayla= new Usuario(2, "Sayla", "Litardo", "Sayla", "123");
			Usuario Sebastian = new Usuario(3, "Sebastian", "Garcia", "Sebastian", "123");
			Usuario Saul = new Usuario(4, "Saul", "Litardo", "Saul", "123");
			
			Mensaje m1 = new Mensaje(1, "Hola papucho!", LocalDateTime.now(), Sayla, Bryan);
			Mensaje m2 = new Mensaje(2, "Hola amorcito", LocalDateTime.now(), Bryan, Sayla);
			Mensaje m3 = new Mensaje(3, "Mis ganas de ti no se quitan, se acumulan.", LocalDateTime.now(), Sayla, Bryan);
			Mensaje m4 = new Mensaje(4, "Pero ya andate a dormir", LocalDateTime.now(), Sayla, Bryan);


			Mensaje m5 = new Mensaje(5, "Hola Sebastian!!", LocalDateTime.now(), Bryan, Sebastian);
			Mensaje m6 = new Mensaje(6, "Confirma, vas a hacer esa vuelta?", LocalDateTime.now(), Sebastian, Bryan);
			Mensaje m7 = new Mensaje(7, "Sí, mañana salgo a las 6:00 am de casa", LocalDateTime.now(), Bryan, Sebastian);
			
			Mensaje m8 = new Mensaje(8, "Hola Saul!!", LocalDateTime.now(), Bryan, Saul);
			Mensaje m9 = new Mensaje(9, "Oe ñaño mi hermana pregunto por ti", LocalDateTime.now(), Saul, Bryan);
			Mensaje m10 = new Mensaje(10, "Dale mis saludos, mañana la voy a ver", LocalDateTime.now(), Bryan, Saul);
			
			
			mensajes.add(m1);
			mensajes.add(m2);
			mensajes.add(m3);
			mensajes.add(m4);
			mensajes.add(m5);
			mensajes.add(m6);
			mensajes.add(m7);
			mensajes.add(m8);
			mensajes.add(m9);
			mensajes.add(m10);
			
		}
		
		public List<Mensaje> getMensajes(Usuario login, Usuario selected){
			ArrayList<Mensaje> temps = new ArrayList<>();
			
			for(Mensaje mensaje: mensajes) {
				if((mensaje.getEmisor().getId() == login.getId() &&
						mensaje.getReceptor().getId() == selected.getId()) ||
						(mensaje.getEmisor().getId() == selected.getId() &&
								mensaje.getReceptor().getId() == login.getId())) {
					
					temps.add(mensaje);
					
				}
			}
			
			return temps;
		}
}