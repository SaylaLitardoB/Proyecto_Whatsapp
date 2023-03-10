module ProyectoWhatsapp {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.base;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
