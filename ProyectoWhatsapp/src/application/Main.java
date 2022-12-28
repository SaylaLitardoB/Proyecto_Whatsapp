package application;
	
import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
		VBox vbox1=new VBox();//contenedor vertical izquierdo
		
		
		
		AnchorPane opciones=new AnchorPane();
		
		Image imgchatt=new Image("/Images/chatt.png");
		ImageView viewchatt=new ImageView(imgchatt);
		viewchatt.setFitHeight(30);
		viewchatt.setFitWidth(30);
		Button bt1=new Button();
		bt1.setPrefSize(10.0, 10.0);
		bt1.setGraphic(viewchatt);
		//bt1.setShape(new Circle(1));
		bt1.setCursor(Cursor.HAND);
	
		Image imgstatus=new Image("/Images/call.png");
		ImageView viewstatus=new ImageView(imgstatus);
		viewstatus.setFitHeight(30);
		viewstatus.setFitWidth(30);
		Button bt2=new Button();
		bt2.setPrefSize(10.0, 10.0);
		bt2.setGraphic(viewstatus);
		//bt2.setShape(new Circle(1));
		bt2.setCursor(Cursor.HAND);
		
		Image imgcall=new Image("/Images/status.png");
		ImageView viewcall=new ImageView(imgcall);
		viewcall.setFitHeight(30);
		viewcall.setFitWidth(30);
		Button bt3=new Button();
		bt3.setPrefSize(10.0, 10.0);
		bt3.setGraphic(viewcall);
		//bt3.setShape(new Circle(1));
		bt3.setCursor(Cursor.HAND);
		
		Image imgconfg=new Image("/Images/configuration.png");
		ImageView viewconfg=new ImageView(imgconfg);
		viewconfg.setFitHeight(30);
		viewconfg.setFitWidth(30);
		Button bt4=new Button();
		bt4.setPrefSize(10.0, 10.0);
		bt4.setGraphic(viewconfg);
		//bt4.setShape(new Circle(1));
		bt4.setCursor(Cursor.HAND);
		
		Image imguser=new Image("/Images/user.jpg");
		ImageView viewuser=new ImageView(imguser);
		viewuser.setFitHeight(30);
		viewuser.setFitWidth(30);
		Button bt5=new Button();
		bt5.setPrefSize(10.0, 10.0);
		bt5.setGraphic(viewuser);
		bt5.setShape(new Circle(1));
		bt5.setCursor(Cursor.HAND);
		
		AnchorPane.setTopAnchor(bt1, 20.0);
		
		AnchorPane.setTopAnchor(bt2,70.0);
		
		AnchorPane.setTopAnchor(bt3,120.0);
		
		AnchorPane.setBottomAnchor(bt4,75.0);
		
		AnchorPane.setBottomAnchor(bt5,25.0);
		
		opciones.getChildren().addAll(bt1,bt2, bt3,bt4,bt5);
		opciones.setPrefSize(50, 500);
		opciones.setMinSize(50, 0);//minimo de la vbox
		opciones.setMaxSize(50, Double.MAX_VALUE);//maximo de vbox
		opciones.setBackground(new Background(new BackgroundFill(Color.web("2B2B2B"), CornerRadii.EMPTY, Insets.EMPTY)));
		
		VBox vbox2=new VBox();//contenedor vertical medio
        vbox2.setPrefSize(350, 500);
        vbox2.setMinSize(265, 0);
        vbox2.setMaxSize(380, Double.MAX_VALUE);
        vbox2.setBackground(new Background(new BackgroundFill(Color.web("#212121"), CornerRadii.EMPTY, Insets.EMPTY)));
                
        
        
        AnchorPane chatt= new AnchorPane();//contenedor derecho
        
        Label info=new Label("WhatsApp para Windows");
        info.setFont(new Font("",20));
        info.setTextFill(Color.WHITE);//color al texto
        
        Label infosecond=new Label("Envia y recibe mensajes sin mantener tu telefono conectado.");
        infosecond.setTextFill(Color.GRAY);//color al texto
        
        Label infothird=new Label("Usa WhatsApp en hasta 4 dispositivos vinculados y 1 telefono a la vez.");
        infothird.setTextFill(Color.GRAY);//color al texto
        
        Label infocifrado= new Label("🔒 Cifrado de extremo a extremo");
        infocifrado.setTextFill(Color.GRAY);//color al texto
        
        InputStream inputstream;//inserccion de imagen
        inputstream=getClass().getResourceAsStream("/Images/whatsapp icon.png");
        Image image=new Image(inputstream);//objeto con la imagen
        
        ImageView logoW=new ImageView(image);//para visualizar el objeto con la imagen
        logoW.setFitHeight(75);//alto de la imagen
        logoW.setFitWidth(75);//ancho de imagen
        
        StackPane imgPane=new StackPane();
        imgPane.getChildren().add(logoW);
        StackPane.setAlignment(logoW, Pos.CENTER);
        
        AnchorPane.setTopAnchor(imgPane,200.0);
        AnchorPane.setLeftAnchor(imgPane,0.0);
        AnchorPane.setRightAnchor(imgPane,0.0);
        imgPane.setAlignment(Pos.CENTER);
        
        AnchorPane.setTopAnchor(info,295.0);
        AnchorPane.setLeftAnchor(info,0.0);
        AnchorPane.setRightAnchor(info,0.0);
        info.setAlignment(Pos.CENTER);
        
        AnchorPane.setTopAnchor(infosecond,330.0);
        AnchorPane.setLeftAnchor(infosecond,0.0);
        AnchorPane.setRightAnchor(infosecond,0.0);
        infosecond.setAlignment(Pos.CENTER);
        
        AnchorPane.setTopAnchor(infothird,348.0);
        AnchorPane.setLeftAnchor(infothird,0.0);
        AnchorPane.setRightAnchor(infothird,0.0);
        infothird.setAlignment(Pos.CENTER);
        
        AnchorPane.setBottomAnchor(infocifrado, 10.0);
        AnchorPane.setRightAnchor(infocifrado, 0.0);
        AnchorPane.setLeftAnchor(infocifrado,0.0);
        infocifrado.setAlignment(Pos.CENTER);
        
        chatt.setPrefSize(500,500);//dimension del archorpane
        chatt.getChildren().addAll(imgPane,info, infosecond, infothird, infocifrado);
        chatt.setBackground(new Background(new BackgroundFill(Color.web("#2B2B2B"), CornerRadii.EMPTY, Insets.EMPTY)));//color de fondo
             
		HBox hbox1=new HBox();//contenedor horizontal
		hbox1.getChildren().addAll(opciones,vbox2,chatt);
		HBox.setHgrow(vbox1, Priority.ALWAYS);//siempre se redimensione
		HBox.setHgrow(vbox2, Priority.ALWAYS);//siempre se redimensione
		HBox.setHgrow(chatt, Priority.ALWAYS);//siempre se redimensione
		
		Scene scene=new Scene(hbox1,800,500);
		primaryStage.setTitle("WhatsApp");	
		primaryStage.setMinHeight(500);//minimo de altura al minimizar
		primaryStage.setMinWidth(520);//minimo de anchura al minimizar
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
