 package application;
	
import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Main extends Application {
	int x=0;
	
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
		//bt1.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		bt1.setCursor(Cursor.HAND);
	
		Image imgstatus=new Image("/Images/registrollamadas.png");
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
		
		AnchorPane contendedor_photoperfil=new AnchorPane();
		Image imguser=new Image("/Images/user.jpg");
		ImageView viewuser=new ImageView(imguser);
		viewuser.setFitHeight(30);
		viewuser.setFitWidth(30);
		Button bt5=new Button();
		bt5.setPrefSize(10.0, 10.0);
		bt5.setGraphic(viewuser);
		//bt5.setShape(new Circle(1));
		bt5.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		bt5.setCursor(Cursor.HAND);		
		
		Image imgperfil=new Image("/Images/user.jpg");
		ImageView viewphotoperfil=new ImageView(imgperfil);
		viewphotoperfil.setFitHeight(200);
		viewphotoperfil.setFitWidth(200);
		contendedor_photoperfil.getChildren().addAll(viewphotoperfil);
		contendedor_photoperfil.setPrefSize(200, 200);
		contendedor_photoperfil.setLayoutX(-600.0);
		contendedor_photoperfil.setLayoutY(400.0);
		contendedor_photoperfil.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
		
		Popup popup_Perfil= new Popup();
		popup_Perfil.getContent().add(contendedor_photoperfil);
		bt5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 if (!popup_Perfil.isShowing()) {
					 popup_Perfil.show(primaryStage);
                     
                 } else {
                	 popup_Perfil.hide();                    

                 }			
	    		
			}
			
		});
	   
		
		AnchorPane.setTopAnchor(bt1, 20.0);
		
		AnchorPane.setTopAnchor(bt2,70.0);
		
		AnchorPane.setTopAnchor(bt3,120.0);
		
		AnchorPane.setBottomAnchor(bt4,75.0);
		
		AnchorPane.setBottomAnchor(bt5,25.0);
		
		opciones.getChildren().addAll(bt1,bt2, bt3,bt4,bt5);
		opciones.setPrefSize(50, 500);
		opciones.setMinSize(50, 0);//minimo de la vbox
		opciones.setMaxSize(50, Double.MAX_VALUE);//maximo de vbox
		opciones.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), CornerRadii.EMPTY, Insets.EMPTY)));
		
		
		VBox vbox2=new VBox();//contenedor vertical medio
		
		Label chattTittle=new Label("Chatt	     		");
		chattTittle.setFont(new Font("",20));
		chattTittle.setTextFill(Color.BLACK);//color al texto
		
		Image imgNewChatt=new Image("/Images/newchatt.png");
		ImageView viewNewChatt=new ImageView(imgNewChatt);
		viewNewChatt.setFitHeight(30);
		viewNewChatt.setFitWidth(30);
		Button btNewChatt=new Button();
		btNewChatt.setPrefSize(10.0, 10.0);
		btNewChatt.setGraphic(viewNewChatt);
		//btNewGroup.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		btNewChatt.setCursor(Cursor.HAND);

		Image imgMoreOptions=new Image("/Images/options.png");
		ImageView viewOptions=new ImageView(imgMoreOptions);
		viewOptions.setFitHeight(30);
		viewOptions.setFitWidth(30);
		Button btOptions=new Button();
		btOptions.setPrefSize(10.0, 10.0);
		btOptions.setGraphic(viewOptions);
		btOptions.setCursor(Cursor.HAND);

		TextField busqueda=new TextField();
		busqueda.setPromptText("Busca un chatt o inicia uno nuevo 🔎");
		
		HBox hboxchatt=new HBox();
		hboxchatt.getChildren().addAll(chattTittle,btNewChatt,btOptions);
		hboxchatt.setBackground(new Background(new BackgroundFill(Color.web("#FDFEFE"), null, null)));
		
		
		
		
		
		
		//SCRALLPANE / CHATTS
		
		
		ScrollPane scrollchatt=new ScrollPane();
					
		Image img_user1=new Image("/Images/mona_lisa.jpg");
		ImageView view_User1=new ImageView(img_user1);
		view_User1.setFitHeight(30);
		view_User1.setFitWidth(30);
		Button fotochatt1=new Button();
		fotochatt1.setPrefSize(10.0, 10.0);
		fotochatt1.setGraphic(view_User1);
		//fotochatt1.setShape(new Circle(1));
		//fotochatt1.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		fotochatt1.setCursor(Cursor.HAND);
		
		AnchorPane contendedor_photo=new AnchorPane();
		Image imgMonaLisa=new Image("/Images/mona_lisa.jpg");
		ImageView viewMonaLisa=new ImageView(imgMonaLisa);
		viewMonaLisa.setFitHeight(200);
		viewMonaLisa.setFitWidth(200);
		contendedor_photo.getChildren().addAll(viewMonaLisa);
		contendedor_photo.setPrefSize(200, 200);
		contendedor_photo.setLayoutX(-300.0);
		contendedor_photo.setLayoutY(-50.0);
		contendedor_photo.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
		
		Popup popup3= new Popup();
		popup3.getContent().add(contendedor_photo);
		fotochatt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 if (!popup3.isShowing()) {
                     popup3.show(primaryStage);
                     
                 } else {
                     popup3.hide();                    

                 }			
	    		
			}
			
		});
	   
				
		Button user =new Button("Sayla Litardo");
		user.setCursor(Cursor.HAND);
		user.setPrefSize(295,40);
		user.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREENYELLOW));//Darle efectos a los botones
		user.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
		
		//CHATT 1 - SAYLA
		AnchorPane conversacion1=new AnchorPane();
		
		//ENCABEZADO 1
		AnchorPane encabezado1=new AnchorPane();
		
		//FOTO DE PERFIL DEL ENCABEZADO
		Circle circle_perfil = new Circle(150,150,30);
		circle_perfil.setStroke(Color.SEAGREEN);
        Image fotoperfil = new Image("/Images/mona_lisa.jpg");
        circle_perfil.setFill(new ImagePattern(fotoperfil));
        circle_perfil.setEffect(new DropShadow(+25d, 0d, +2d, Color.WHITE));
        
        //NOMBRE DE USUARIO
		Label nombreusuario1=new Label("Sayla Litardo");
		nombreusuario1.setFont(new Font("Cambria",20));
		
		//ESTADO DE USUARIO
		Label estado_user1=new Label("En linea");
		estado_user1.setFont(new Font("Cambria",15));
		
		//BOTON VIDEOLLAMADA
		Image videocall_chatt1=new Image("/Images/videollamada.png");
		ImageView view_videocallchatt1=new ImageView(videocall_chatt1);
		view_videocallchatt1.setFitHeight(30);
		view_videocallchatt1.setFitWidth(30);
		Button videollamada=new Button();
		videollamada.setPrefSize(10.0, 10.0);
		videollamada.setGraphic(view_videocallchatt1);	
		videollamada.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		videollamada.setCursor(Cursor.HAND);
		
		//BOTON LLAMADA
		Image call_chatt1=new Image("/Images/llamada.png");
		ImageView view_callchatt1=new ImageView(call_chatt1);
		view_callchatt1.setFitHeight(30);
		view_callchatt1.setFitWidth(30);
		Button llamada=new Button();
		llamada.setPrefSize(10.0, 10.0);
		llamada.setGraphic(view_callchatt1);
		llamada.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		llamada.setCursor(Cursor.HAND);
		
		//BOTON BUSQUEDA
		Image search_chatt1=new Image("/Images/lupa.png");
		ImageView view_searchchatt1=new ImageView(search_chatt1);
		view_searchchatt1.setFitHeight(30);
		view_searchchatt1.setFitWidth(30);
		Button search=new Button();
		search.setPrefSize(10.0, 10.0);
		search.setGraphic(view_searchchatt1);
		search.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		search.setCursor(Cursor.HAND);
		
		AnchorPane.setTopAnchor(circle_perfil, 10.0);
		AnchorPane.setLeftAnchor(circle_perfil, 10.0);
		AnchorPane.setTopAnchor(nombreusuario1, 10.0);
		AnchorPane.setLeftAnchor(nombreusuario1, 100.0);
		AnchorPane.setTopAnchor(estado_user1, 40.0);
		AnchorPane.setLeftAnchor(estado_user1, 100.0);
		AnchorPane.setTopAnchor(videollamada, 20.0);
		AnchorPane.setRightAnchor(videollamada, 125.0);
		AnchorPane.setTopAnchor(llamada, 20.0);
		AnchorPane.setRightAnchor(llamada, 75.0);
		AnchorPane.setTopAnchor(search, 20.0);
		AnchorPane.setRightAnchor(search, 10.0);
		
		encabezado1.getChildren().addAll(circle_perfil,nombreusuario1,estado_user1,videollamada,llamada,search);
		encabezado1.setPrefSize(980, 50);
		encabezado1.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
		
	
		//MENSAJES ENVIADOS Y RECIBIDOS
		ScrollPane mensajeschatt1=new ScrollPane();
		
		
		//MENSAJE 1
		Label sms1=new Label("Hola, don Pichulon");
		sms1.setFont(new Font("Cambria",18));
		AnchorPane smsrecibido1=new AnchorPane();
		//smsrecibido1.setBackground(new Background(new BackgroundFill(Color.SALMON, null, null)));
		smsrecibido1.setPrefSize(Double.MIN_VALUE, Double.MIN_VALUE);
		smsrecibido1.getChildren().addAll(sms1);
						
		//LISTA SMS
		VBox mensajes=new VBox(20);
		mensajes.setPrefSize(975, 595);
		mensajes.getChildren().addAll(smsrecibido1);
		mensajes.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
				
		mensajeschatt1.setPrefSize(980, 600);
		mensajeschatt1.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
		mensajeschatt1.setContent(mensajes);
		mensajeschatt1.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		
		//AREA DE ESCRIBIR Y BOTON
		List<Label>sms=new ArrayList<>();
		TextArea mensaje_enviar=new TextArea();
		mensaje_enviar.setPrefSize(870, 50);
		mensaje_enviar.setFont(new Font("Cambria",15));
		
		Button send=new Button("Enviar");
		send.setPrefSize(100, 50);
		send.setOnAction(evt->{
			
			sms.add(new Label(mensaje_enviar.getText()));
			mensaje_enviar.clear();
			
			if(x %2== 0){
            	sms.get(x).setAlignment(Pos.TOP_RIGHT);
            	
            }else{
            	sms.get(x).setAlignment(Pos.CENTER_LEFT);
            	
            }
			sms.get(x).setFont(new Font("Cambria",15));
			sms.get(x).setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
			mensajes.getChildren().add(sms.get(x));
			x++;
			
		});
		
		mensajeschatt1.setContent(mensajes);
		
		mensajes.setAlignment(Pos.TOP_RIGHT);
		
		//POSICIONAMIENTO
		AnchorPane.setTopAnchor(encabezado1, 10.0);
		AnchorPane.setLeftAnchor(encabezado1, 10.0);	
		AnchorPane.setTopAnchor(mensajeschatt1, 85.0);
		AnchorPane.setLeftAnchor(mensajeschatt1, 10.0);
		AnchorPane.setBottomAnchor(mensaje_enviar, 10.0);
		AnchorPane.setLeftAnchor(mensaje_enviar, 10.0);
		AnchorPane.setBottomAnchor(send, 10.0);
		AnchorPane.setRightAnchor(send, 20.0);
		
	    conversacion1.getChildren().addAll(encabezado1,mensajeschatt1,mensaje_enviar,send);
	    conversacion1.setPrefSize(1010, 750);
	    conversacion1.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
	    conversacion1.setLayoutX(335.0);
	    conversacion1.setLayoutY(25.0);	    	    
	    Popup popupConversacion1= new Popup();
	    popupConversacion1.getContent().add(conversacion1);
		user.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 if (!popupConversacion1.isShowing()) {
					 popupConversacion1.show(primaryStage);
                     
                 } else {
                	 popupConversacion1.hide();                    

                 }			
	    		
			}
			
		});
		
		
		HBox chatt1=new HBox();
	    chatt1.getChildren().addAll(fotochatt1,user);	  
	    chatt1.setPrefSize(295, 30);
	    	    
	    
	    
	   
	   	Image img_user2=new Image("/Images/rana.jpg");
		ImageView view_User2=new ImageView(img_user2);
		view_User2.setFitHeight(30);
		view_User2.setFitWidth(30);
		Button fotochatt2=new Button();
		fotochatt2.setPrefSize(10.0, 10.0);
		fotochatt2.setGraphic(view_User2);
		//btNewGroup.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		fotochatt2.setCursor(Cursor.HAND);
		
		Button user2 =new Button("Sebastian");
		user2.setPrefSize(275, 40);	
		//user2.setBackground(new Background(new BackgroundFill(Color.web("#EAF2F8"), null, null)));
		
		HBox chatt2=new HBox();
	    chatt2.getChildren().addAll(fotochatt2,user2);	   
	    chatt2.setPrefSize(295, 30);
	    
	   
		
		VBox listachatt= new VBox(10);
		listachatt.getChildren().addAll(chatt1,chatt2);
		listachatt.setPrefWidth(285);
		
		scrollchatt.setHbarPolicy(ScrollBarPolicy.NEVER);//agregar barra de desplazamiento cuando se necesite
		scrollchatt.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);//agregar barra de desplazamiento cuando se necesite
		scrollchatt.setPrefHeight(900);
		scrollchatt.setPrefWidth(285);
		scrollchatt.setContent(listachatt);
	
		
		
		
        vbox2.setPrefSize(350, 500);
        vbox2.setMinSize(265, 0);
        vbox2.setMaxSize(285, Double.MAX_VALUE);
        vbox2.setBackground(new Background(new BackgroundFill(Color.web("#FDFEFE"), CornerRadii.EMPTY, Insets.EMPTY)));
        vbox2.getChildren().addAll(hboxchatt,busqueda,scrollchatt);
        
        
        
        
        
        
        AnchorPane chatt= new AnchorPane();//contenedor derecho
        
        Label info=new Label("WhatsApp para Windows");
        info.setFont(new Font("",20));
        info.setTextFill(Color.BLACK);//color al texto
        
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
        chatt.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), CornerRadii.EMPTY, Insets.EMPTY)));//color de fondo
             

       
		
		HBox hbox1=new HBox();//contenedor horizontal
		
		hbox1.getChildren().addAll(opciones,vbox2,chatt);
		HBox.setHgrow(vbox1, Priority.ALWAYS);//siempre se redimensione
		HBox.setHgrow(vbox2, Priority.ALWAYS);//siempre se redimensione
		HBox.setHgrow(chatt, Priority.ALWAYS);//siempre se redimensione
		
		
		Scene scene= new Scene(hbox1,1000,650);
		primaryStage.setTitle("WhatsApp");	
		primaryStage.setMinHeight(500);//minimo de altura al minimizar
		primaryStage.setMinWidth(520);//minimo de anchura al minimizar
		//primaryStage.setX(20);
		//primaryStage.setY(10);
		primaryStage.initStyle(StageStyle.DECORATED);//estilo de la escena
		primaryStage.setFullScreen(true);//true para que al abrir se abra en pantalla completa, false para que no suceda esto
		primaryStage.getIcons().add(new Image("/Images/WhatsApp color.png"));//icono de la app, la imagen esta en el package "images"
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

