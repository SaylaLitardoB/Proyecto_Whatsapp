package application;
	
import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
		VBox vbox1=new VBox();//contenedor vertical izquierdo
		vbox1.setPrefSize(50, 500);
		vbox1.setBackground(new Background(new BackgroundFill(Color.web("2B2B2B"), CornerRadii.EMPTY, Insets.EMPTY)));
		
		
        VBox vbox2=new VBox();//contenedor vertical medio
        vbox2.setPrefSize(250, 500);
        vbox2.setBackground(new Background(new BackgroundFill(Color.web("#212121"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        
        AnchorPane chatt= new AnchorPane();//contenedor derecho
        
        Label info=new Label("WhatsApp para Windows");
        info.setFont(new Font("",20));
        info.setTextFill(Color.WHITE);//color al texto
        
        Label infosecond=new Label("Envia y recibe mensajes sin mantener tu telefono conectado.");
        infosecond.setTextFill(Color.WHITE);//color al texto
        
        Label infothird=new Label("Usa WhatsApp en hasta 4 dispositivos vinculados y 1 telefono a la vez.");
        infothird.setTextFill(Color.WHITE);//color al texto
        
        Label infocifrado= new Label("Cifrado de extremo a extremo");
        infocifrado.setTextFill(Color.WHITE);//color al texto
        
        InputStream inputstream;//inserccion de imagen
        inputstream=getClass().getResourceAsStream("/Images/whatsapp icon.png");
        Image image=new Image(inputstream);//objeto con la imagen
        
        ImageView logoW=new ImageView(image);//para visualizar el objeto con la imagen
        logoW.setFitHeight(75);//alto de la imagen
        logoW.setFitWidth(75);//ancho de imagen
        
        AnchorPane.setTopAnchor(logoW,135.0);//posicion de la imagen
        AnchorPane.setLeftAnchor(logoW,200.0);
        
        AnchorPane.setTopAnchor(info,230.0);
        AnchorPane.setLeftAnchor(info,135.0);
        
        AnchorPane.setTopAnchor(infosecond,260.0);
        AnchorPane.setLeftAnchor(infosecond,90.0);
        
        AnchorPane.setTopAnchor(infothird,275.0);
        AnchorPane.setLeftAnchor(infothird,60.0);
        
        AnchorPane.setBottomAnchor(infocifrado, 10.0);
        AnchorPane.setRightAnchor(infocifrado, 175.0);
        
        chatt.setPrefSize(500,500);//dimension del archorpane
        chatt.getChildren().addAll(logoW,info, infosecond, infothird, infocifrado);
        chatt.setBackground(new Background(new BackgroundFill(Color.web("#2B2B2B"), CornerRadii.EMPTY, Insets.EMPTY)));//color de fondo
        
        
		HBox hbox1=new HBox();//contenedor horizontal
		hbox1.getChildren().addAll(vbox1,vbox2,chatt);
		HBox.setHgrow(vbox1, Priority.ALWAYS);//siempre se redimensione
		HBox.setHgrow(vbox2, Priority.ALWAYS);//siempre se redimensione
		HBox.setHgrow(chatt, Priority.ALWAYS);//siempre se redimensione
		
		
		Scene scene=new Scene(hbox1,800,500);
		primaryStage.setTitle("WhatsApp");	
		primaryStage.initStyle(StageStyle.DECORATED);//estilo de la escena
		primaryStage.setFullScreen(false);//true para que al abrir se abra en pantalla completa, false para que no suceda esto
		primaryStage.getIcons().add(new Image("/Images/WhatsApp color.png"));//icono de la app, la imagen esta en el package "images"
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
