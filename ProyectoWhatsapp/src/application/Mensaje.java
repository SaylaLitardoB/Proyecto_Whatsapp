package application;

import java.time.LocalDateTime;

public class Mensaje {
	private int id;
	private String contenido;
	private LocalDateTime fecha;
	private Usuario emisor;
	private Usuario receptor;
	
	public Mensaje(int id, String contenido, LocalDateTime fecha, Usuario emisor, Usuario receptor) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.fecha = fecha;
		this.emisor = emisor;
		this.receptor = receptor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Usuario getEmisor() {
		return emisor;
	}
	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}
	public Usuario getReceptor() {
		return receptor;
	}
	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}
	public String toString() {
		return "{\"id\":" + id + ", \"from\":" + emisor + ", \"to\":" + receptor + ", \"date\": \"" + fecha + "\", \"content\" :\"" + contenido + "\"}";
	}
}
