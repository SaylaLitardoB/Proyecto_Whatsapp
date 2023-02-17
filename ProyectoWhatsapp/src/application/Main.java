package application;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import repositorio.MensajeRepository;
import repositorio.UsuarioRepository;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class Main extends Application {
	int x=0;
	int y=0;
	int z=0;
	public static Usuario login;
	public static Usuario selected;
	@Override
	public void start(Stage primaryStage) {
		
		VBox izquierdaVbox = new VBox();//creamos un Vbox para poner todo dentro de un Hbox
	      
        Label lbTitle=new Label("Iniciar Sesion");
        lbTitle.setFont(new Font("Times New Roman", 35));//darle fuente y tamaño
        
        VBox formularioVBox=new VBox();//creamos un contenedor para mejor organizacion del formulario

        Label lbUsuario=new Label("Usuario");
        lbUsuario.setFont(new Font("Times New Roman", 20));
        Label lbContra=new Label("Contraseña");
        lbContra.setFont(new Font("Times New Roman", 20));
        Label lbGracias=new Label("Gracias por preferinos!");

        TextField textUser=new TextField();
        textUser.setFont(new Font(15));
        textUser.setPromptText("Ingrese su usuario:");
        textUser.setPrefWidth(341);//para un tamaño fijo para cuando se maximize, ancho
        textUser.setPrefHeight(44);
       
        PasswordField textContra=new PasswordField();
        textContra.setFont(new Font(15));
        textContra.setPromptText("Ingrese su contraseña:");
        textContra.setPrefWidth(341);//para un tamaño fijo para cuando se maximize, ancho
        textContra.setPrefHeight(44);

        Button b1login= new Button("Login");
        b1login.setMaxWidth(Double.MAX_VALUE);
        b1login.setFont(new Font("Times New Roman",20));
        b1login.setCursor(Cursor.HAND);//configurar el mouse cuando pase por el boton presente
        b1login.setPrefWidth(370);//para un tamaño fijo para cuando se maximize, ancho
        b1login.setPrefHeight(44);
        
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
		
		//PENDIENTE
		bt4.setOnAction(e ->{
			regresarLogin(e);
		});
		
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
		opciones.setMinSize(50, 0);//minimo de Archorpane
		opciones.setMaxSize(50, Double.MAX_VALUE);//maximo de Archorpane
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
		hboxchatt.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), null, null)));
		
		
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
		
		Popup popup= new Popup();
		popup.getContent().add(contendedor_photo);
		fotochatt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 if (!popup.isShowing()) {
                     popup.show(primaryStage);
                     
                 } else {
                     popup.hide();                    

                 }			
	    		
			}
			
		});
	   
				
		Button user =new Button("Sayla Litardo");
		user.setCursor(Cursor.HAND);
		user.setPrefSize(295,40);
		///user.setEffect(new DropShadow(+25d, 0d, +2d, Color.web("#C6E1F1")));//Darle efectos a los botones
		user.setBackground(new Background(new BackgroundFill(Color.web("#B5C5D7"), null, null)));
		
		
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
		encabezado1.setBackground(new Background(new BackgroundFill(Color.web("#77DD77"), null, null)));
		
	
		//MENSAJES ENVIADOS Y RECIBIDOS
		ScrollPane mensajeschatt1=new ScrollPane();
		
		
		//MENSAJE 1
		Label sms1=new Label("Hola, Cómo estas?");
		sms1.setFont(new Font("Cambria",18));
		AnchorPane smsrecibido1=new AnchorPane();
		//smsrecibido1.setBackground(new Background(new BackgroundFill(Color.SALMON, null, null)));
		smsrecibido1.setPrefSize(Double.MIN_VALUE, Double.MIN_VALUE);
		smsrecibido1.getChildren().addAll(sms1);
						
		//LISTA SMS
		VBox mensajes=new VBox(20);
		mensajes.setPrefSize(975, 595);
		mensajes.getChildren().addAll(smsrecibido1);
		mensajes.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), null, null)));
				
		mensajeschatt1.setPrefSize(980, 600);
		mensajeschatt1.setBackground(new Background(new BackgroundFill(Color.web("#77DD77"), null, null)));
		mensajeschatt1.setContent(mensajes);
		mensajeschatt1.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		mensajeschatt1.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		//AREA DE ESCRIBIR Y BOTON
		List<Label>sms=new ArrayList<>();
		TextArea mensaje_enviar=new TextArea();
		mensaje_enviar.setPrefSize(870, 50);
		mensaje_enviar.setFont(new Font("Cambria",15));
		
		Button send=new Button("Enviar");
		send.setPrefSize(100, 50);
		send.setBackground(new Background(new BackgroundFill(Color.web("#B5C5D7"), null, null)));

		send.setOnAction(evt->{
			
			sms.add(new Label(mensaje_enviar.getText()));
			mensaje_enviar.clear();
			
			if(x %2== 0){
            	sms.get(x).setAlignment(Pos.TOP_RIGHT);
            	
            }else{
            	sms.get(x).setAlignment(Pos.CENTER_LEFT);
            	
            }
			sms.get(x).setFont(new Font("Cambria",18));
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
	    conversacion1.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), null, null)));
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
	    	    
	    
	    
	    
	    
	    //Sebastian
	   	Image img_user2=new Image("/Images/rana.jpg");
		ImageView view_User2=new ImageView(img_user2);
		view_User2.setFitHeight(30);
		view_User2.setFitWidth(30);
		Button fotochatt2=new Button();
		fotochatt2.setPrefSize(10.0, 10.0);
		fotochatt2.setGraphic(view_User2);
		//btNewGroup.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		fotochatt2.setCursor(Cursor.HAND);
		
		AnchorPane contendedor_photo2=new AnchorPane();
		Image imgRana=new Image("/Images/rana.jpg");
		ImageView viewRana=new ImageView(imgRana);
		viewRana.setFitHeight(200);
		viewRana.setFitWidth(200);
		contendedor_photo2.getChildren().addAll(viewRana);
		contendedor_photo2.setPrefSize(200, 200);
		contendedor_photo2.setLayoutX(-300.0);
		contendedor_photo2.setLayoutY(-50.0);
		contendedor_photo2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
		
		Popup popup2= new Popup();
		popup2.getContent().add(contendedor_photo2);
		fotochatt2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 if (!popup2.isShowing()) {
                     popup2.show(primaryStage);
                     
                 } else {
                     popup2.hide();                    

                 }			
	    		
			}
			
		});
		
		
		Button user2 =new Button("Sebastian Garcia");
		user2.setPrefSize(275, 40);	
		user2.setCursor(Cursor.HAND);
		user2.setBackground(new Background(new BackgroundFill(Color.web("#B5C5D7"), null, null)));
		
		
		//CHATT 1 - Sebastian
		AnchorPane conversacion2=new AnchorPane();
		
		//ENCABEZADO 1
		AnchorPane encabezado2=new AnchorPane();
		
		//FOTO DE PERFIL DEL ENCABEZADO
		Circle circle_perfil2 = new Circle(150,150,30);
		circle_perfil2.setStroke(Color.SEAGREEN);
        Image fotoperfil2 = new Image("/Images/rana.jpg");
        circle_perfil2.setFill(new ImagePattern(fotoperfil2));
        circle_perfil2.setEffect(new DropShadow(+25d, 0d, +2d, Color.WHITE));
        
        //NOMBRE DE USUARIO
		Label nombreusuario2=new Label("Sebastian Garcia");
		nombreusuario2.setFont(new Font("Cambria",20));
		
		//ESTADO DE USUARIO
		Label estado_user2=new Label("En linea");
		estado_user2.setFont(new Font("Cambria",15));
		
		//BOTON VIDEOLLAMADA
		Image videocall_chatt2=new Image("/Images/videollamada.png");
		ImageView view_videocallchatt2=new ImageView(videocall_chatt2);
		view_videocallchatt2.setFitHeight(30);
		view_videocallchatt2.setFitWidth(30);
		Button videollamada2=new Button();
		videollamada2.setPrefSize(10.0, 10.0);
		videollamada2.setGraphic(view_videocallchatt2);	
		videollamada2.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		videollamada2.setCursor(Cursor.HAND);
		
		//BOTON LLAMADA
		Image call_chatt2=new Image("/Images/llamada.png");
		ImageView view_callchatt2=new ImageView(call_chatt2);
		view_callchatt2.setFitHeight(30);
		view_callchatt2.setFitWidth(30);
		Button llamada2=new Button();
		llamada2.setPrefSize(10.0, 10.0);
		llamada2.setGraphic(view_callchatt2);
		llamada2.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		llamada2.setCursor(Cursor.HAND);
		
		//BOTON BUSQUEDA
		Image search_chatt2=new Image("/Images/lupa.png");
		ImageView view_searchchatt2=new ImageView(search_chatt2);
		view_searchchatt2.setFitHeight(30);
		view_searchchatt2.setFitWidth(30);
		Button search2=new Button();
		search2.setPrefSize(10.0, 10.0);
		search2.setGraphic(view_searchchatt2);
		search2.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		search2.setCursor(Cursor.HAND);
		
		AnchorPane.setTopAnchor(circle_perfil2, 10.0);
		AnchorPane.setLeftAnchor(circle_perfil2, 10.0);
		AnchorPane.setTopAnchor(nombreusuario2, 10.0);
		AnchorPane.setLeftAnchor(nombreusuario2, 100.0);
		AnchorPane.setTopAnchor(estado_user2, 40.0);
		AnchorPane.setLeftAnchor(estado_user2, 100.0);
		AnchorPane.setTopAnchor(videollamada2, 20.0);
		AnchorPane.setRightAnchor(videollamada2, 125.0);
		AnchorPane.setTopAnchor(llamada2, 20.0);
		AnchorPane.setRightAnchor(llamada2, 75.0);
		AnchorPane.setTopAnchor(search2, 20.0);
		AnchorPane.setRightAnchor(search2, 10.0);
		
		encabezado2.getChildren().addAll(circle_perfil2,nombreusuario2,estado_user2,videollamada2,llamada2,search2);
		encabezado2.setPrefSize(980, 50);
		encabezado2.setBackground(new Background(new BackgroundFill(Color.web("#77DD77"), null, null)));
		
	
		//MENSAJES ENVIADOS Y RECIBIDOS
		ScrollPane mensajeschatt2=new ScrollPane();
		
		
		//MENSAJE 1
		Label sms2do=new Label("Hola, Cómo estas?");
		sms2do.setFont(new Font("Cambria",18));
		AnchorPane smsrecibido2=new AnchorPane();
		//smsrecibido1.setBackground(new Background(new BackgroundFill(Color.SALMON, null, null)));
		smsrecibido2.setPrefSize(Double.MIN_VALUE, Double.MIN_VALUE);
		smsrecibido2.getChildren().addAll(sms2do);
						
		//LISTA SMS
		VBox mensajes2=new VBox(20);
		mensajes2.setPrefSize(975, 595);
		mensajes2.getChildren().addAll(smsrecibido2);
		mensajes2.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), null, null)));
				
		mensajeschatt2.setPrefSize(980, 600);
		mensajeschatt2.setBackground(new Background(new BackgroundFill(Color.web("#77DD77"), null, null)));
		mensajeschatt2.setContent(mensajes2);
		mensajeschatt2.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		mensajeschatt2.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		//AREA DE ESCRIBIR Y BOTON
		List<Label>sms2 =new ArrayList<>();
		TextArea mensaje_enviar2=new TextArea();
		mensaje_enviar2.setPrefSize(870, 50);
		mensaje_enviar2.setFont(new Font("Cambria",15));
		
		Button send2=new Button("Enviar");
		send2.setPrefSize(100, 50);
		send2.setBackground(new Background(new BackgroundFill(Color.web("#B5C5D7"), null, null)));

		send2.setOnAction(evt->{
			
			sms2.add(new Label(mensaje_enviar2.getText()));
			mensaje_enviar2.clear();
			
			if(y %2== 0){
            	sms2.get(y).setAlignment(Pos.TOP_RIGHT);
            	
            }else{
            	sms2.get(y).setAlignment(Pos.CENTER_LEFT);
            	
            }
			sms2.get(y).setFont(new Font("Cambria",18));
			mensajes2.getChildren().add(sms2.get(y));
			y++;
			
		});
		
		mensajeschatt2.setContent(mensajes2);
		
		mensajes2.setAlignment(Pos.TOP_RIGHT);
		
		//POSICIONAMIENTO
		AnchorPane.setTopAnchor(encabezado2, 10.0);
		AnchorPane.setLeftAnchor(encabezado2, 10.0);	
		AnchorPane.setTopAnchor(mensajeschatt2, 85.0);
		AnchorPane.setLeftAnchor(mensajeschatt2, 10.0);
		AnchorPane.setBottomAnchor(mensaje_enviar2, 10.0);
		AnchorPane.setLeftAnchor(mensaje_enviar2, 10.0);
		AnchorPane.setBottomAnchor(send2, 10.0);
		AnchorPane.setRightAnchor(send2, 20.0);
		
	    conversacion2.getChildren().addAll(encabezado2,mensajeschatt2,mensaje_enviar2,send2);
	    conversacion2.setPrefSize(1010, 750);
	    conversacion2.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), null, null)));
	    conversacion2.setLayoutX(335.0);
	    conversacion2.setLayoutY(25.0);	    	    
	    Popup popupConversacion2= new Popup();
	    popupConversacion2.getContent().add(conversacion2);
		user2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 if (!popupConversacion2.isShowing()) {
					 popupConversacion2.show(primaryStage);
                     
                 } else {
                	 popupConversacion2.hide();                    

                 }			
	    		
			}
			
		});
		
		HBox chatt2=new HBox();
	    chatt2.getChildren().addAll(fotochatt2,user2);	   
	    chatt2.setPrefSize(295, 30);
	    
	   
	    
	    
	    
	    
	    
	    /*
	    Chatt Saul*/
	    Image img_user3=new Image("/Images/gumball.jpg");
		ImageView view_User3=new ImageView(img_user3);
		view_User3.setFitHeight(30);
		view_User3.setFitWidth(30);
		Button fotochatt3=new Button();
		fotochatt3.setPrefSize(10.0, 10.0);
		fotochatt3.setGraphic(view_User3);
		//fotochatt1.setShape(new Circle(1));
		//fotochatt1.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		fotochatt3.setCursor(Cursor.HAND);
		
		AnchorPane contendedor_photo3=new AnchorPane();
		Image imgGumball=new Image("/Images/gumball.jpg");
		ImageView viewGumball=new ImageView(imgGumball);
		viewGumball.setFitHeight(200);
		viewGumball.setFitWidth(200);
		contendedor_photo3.getChildren().addAll(viewGumball);
		contendedor_photo3.setPrefSize(200, 200);
		contendedor_photo3.setLayoutX(-300.0);
		contendedor_photo3.setLayoutY(-50.0);
		contendedor_photo3.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
		
		Popup popup3= new Popup();
		popup3.getContent().add(contendedor_photo3);
		fotochatt3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 if (!popup3.isShowing()) {
                     popup3.show(primaryStage);
                     
                 } else {
                     popup3.hide();                    

                 }			
	    		
			}
			
		});
	   
				
		Button user3 =new Button("Saul Litardo");
		user3.setCursor(Cursor.HAND);
		user3.setPrefSize(295,40);
		///user.setEffect(new DropShadow(+25d, 0d, +2d, Color.web("#C6E1F1")));//Darle efectos a los botones
		user3.setBackground(new Background(new BackgroundFill(Color.web("#B5C5D7"), null, null)));
		
		
		MensajeRepository mensajeRepository = new MensajeRepository();
		
		//CHATT 1 - SAUL
		AnchorPane conversacion3=new AnchorPane();
		
		//ENCABEZADO 1
		AnchorPane encabezado3=new AnchorPane();
		
		//FOTO DE PERFIL DEL ENCABEZADO
		Circle circle_perfil3 = new Circle(150,150,30);
		circle_perfil3.setStroke(Color.SEAGREEN);
        Image fotoperfil3 = new Image("/Images/gumball.jpg");
        circle_perfil3.setFill(new ImagePattern(fotoperfil3));
        circle_perfil3.setEffect(new DropShadow(+25d, 0d, +2d, Color.WHITE));
        
        //NOMBRE DE USUARIO
		Label nombreusuario3=new Label("Saul Litardo");
		nombreusuario3.setFont(new Font("Cambria",20));
		
		//ESTADO DE USUARIO
		Label estado_user3=new Label("En linea");
		estado_user3.setFont(new Font("Cambria",15));
		
		//BOTON VIDEOLLAMADA
		Image videocall_chatt3=new Image("/Images/videollamada.png");
		ImageView view_videocallchatt3=new ImageView(videocall_chatt3);
		view_videocallchatt3.setFitHeight(30);
		view_videocallchatt3.setFitWidth(30);
		Button videollamada3=new Button();
		videollamada3.setPrefSize(10.0, 10.0);
		videollamada3.setGraphic(view_videocallchatt3);	
		videollamada3.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		videollamada3.setCursor(Cursor.HAND);
		
		//BOTON LLAMADA
		Image call_chatt3=new Image("/Images/llamada.png");
		ImageView view_callchatt3=new ImageView(call_chatt3);
		view_callchatt3.setFitHeight(30);
		view_callchatt3.setFitWidth(30);
		Button llamada3=new Button();
		llamada3.setPrefSize(10.0, 10.0);
		llamada3.setGraphic(view_callchatt3);
		llamada3.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		llamada3.setCursor(Cursor.HAND);
		
		//BOTON BUSQUEDA
		Image search_chatt3=new Image("/Images/lupa.png");
		ImageView view_searchchatt3=new ImageView(search_chatt3);
		view_searchchatt3.setFitHeight(30);
		view_searchchatt3.setFitWidth(30);
		Button search3=new Button();
		search3.setPrefSize(10.0, 10.0);
		search3.setGraphic(view_searchchatt3);
		search3.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		search3.setCursor(Cursor.HAND);
		
		AnchorPane.setTopAnchor(circle_perfil3, 10.0);
		AnchorPane.setLeftAnchor(circle_perfil3, 10.0);
		AnchorPane.setTopAnchor(nombreusuario3, 10.0);
		AnchorPane.setLeftAnchor(nombreusuario3, 100.0);
		AnchorPane.setTopAnchor(estado_user3, 40.0);
		AnchorPane.setLeftAnchor(estado_user3, 100.0);
		AnchorPane.setTopAnchor(videollamada3, 20.0);
		AnchorPane.setRightAnchor(videollamada3, 125.0);
		AnchorPane.setTopAnchor(llamada3, 20.0);
		AnchorPane.setRightAnchor(llamada3, 75.0);
		AnchorPane.setTopAnchor(search3, 20.0);
		AnchorPane.setRightAnchor(search3, 10.0);
		
		encabezado3.getChildren().addAll(circle_perfil3,nombreusuario3,estado_user3,videollamada3,llamada3,search3);
		encabezado3.setPrefSize(980, 50);
		encabezado3.setBackground(new Background(new BackgroundFill(Color.web("#77DD77"), null, null)));
		
	
		//MENSAJES ENVIADOS Y RECIBIDOS
		ScrollPane mensajeschatt3=new ScrollPane();
		
		//AREA DE ESCRIBIR Y BOTON
		VBox mensajes3 =new VBox();
		mensajes3.setPrefSize(975, 595);
		mensajes3.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), null, null)));
		
		mensajeschatt3.setPrefSize(980, 600);
		mensajeschatt3.setContent(mensajes3);
		mensajeschatt3.setBackground(new Background(new BackgroundFill(Color.web("#77DD77"), null, null)));
		mensajeschatt3.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		mensajeschatt3.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		
		
		List<Label>sms3 =new ArrayList<>();
		TextArea mensaje_enviar3=new TextArea();
		mensaje_enviar3.setPrefSize(870, 50);
		mensaje_enviar3.setFont(new Font("Cambria",15));
		Button send3=new Button("Enviar");
		send3.setPrefSize(100, 50);
		send3.setBackground(new Background(new BackgroundFill(Color.web("#B5C5D7"), null, null)));

		send3.setOnAction(evt->{
			
			sms3.add(new Label(mensaje_enviar3.getText()));
			mensaje_enviar3.clear();
			
			if(z %2== 0){
            	sms3.get(z).setAlignment(Pos.TOP_RIGHT);
            	
            }else{
            	sms3.get(z).setAlignment(Pos.CENTER_LEFT);
            	
            }
			Label lbluser = new Label("Bryan  ");
			
			HBox mensajedueno= new HBox();
			mensajedueno.getChildren().addAll(lbluser,sms3.get(z));
			mensajes3.getChildren().addAll(mensajedueno);
			
			z++;
			
		});
		
		
		
		//POSICIONAMIENTO

	
		AnchorPane.setTopAnchor(encabezado3, 10.0);
		AnchorPane.setLeftAnchor(encabezado3, 10.0);	
		AnchorPane.setTopAnchor(mensajeschatt3, 85.0);
		AnchorPane.setLeftAnchor(mensajeschatt3, 10.0);
		AnchorPane.setBottomAnchor(mensaje_enviar3, 10.0);
		AnchorPane.setLeftAnchor(mensaje_enviar3, 10.0);
		AnchorPane.setBottomAnchor(send3, 10.0);
		AnchorPane.setRightAnchor(send3, 20.0);
		
		//conversacion3.getChildren().add(flowPane);
	    conversacion3.getChildren().addAll(encabezado3, mensajeschatt3,mensaje_enviar3,send3);
	    conversacion3.setPrefSize(1010, 750);
	    conversacion3.setBackground(new Background(new BackgroundFill(Color.web("#F5EEF8"), null, null)));
	    conversacion3.setLayoutX(335.0);
	    conversacion3.setLayoutY(25.0);	  
	    
		
		List<Mensaje> mensajess = mensajeRepository.getMensajes(login, selected);
		
		for(Mensaje mensaje: mensajess) {
			var fMessage = getBurbuja(mensaje);
			mensajes3.getChildren().add(fMessage);
		}
		
		Popup popupConversacion3= new Popup();
	    popupConversacion3.getContent().add(conversacion3);
		user3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 if (!popupConversacion3.isShowing()) {
					 popupConversacion3.show(primaryStage);
                     
                 } else {
                	 popupConversacion3.hide();                    

                 }			
	    		
			}
			
		});
		
		HBox chatt3=new HBox();
	    chatt3.getChildren().addAll(fotochatt3,user3 );	  
	    chatt3.setPrefSize(295, 30);
	    
	    
	    
	    
	    
	    
	    //TODOS LOS CHATT EN LISTA
	    
		VBox listachatt= new VBox(10);
		listachatt.getChildren().addAll(chatt1,chatt2,chatt3);
		listachatt.setPrefWidth(285);
		
		scrollchatt.setHbarPolicy(ScrollBarPolicy.NEVER);//agregar barra de desplazamiento cuando se necesite
		scrollchatt.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);//agregar barra de desplazamiento cuando se necesite
		scrollchatt.setPrefHeight(900);
		scrollchatt.setPrefWidth(285);
		scrollchatt.setContent(listachatt);
	
		
        vbox2.setPrefSize(350, 500);
        vbox2.setMinSize(265, 0);
        vbox2.setMaxSize(285, Double.MAX_VALUE);
        vbox2.setBackground(new Background(new BackgroundFill(Color.web("#FDFEF8"), CornerRadii.EMPTY, Insets.EMPTY)));
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
        Image imag=new Image(inputstream);//objeto con la imagen
        
        ImageView logoW=new ImageView(imag);//para visualizar el objeto con la imagen
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
		HBox.setHgrow(opciones, Priority.ALWAYS);//siempre se redimensione
		HBox.setHgrow(vbox2, Priority.ALWAYS);//siempre se redimensione
		HBox.setHgrow(chatt, Priority.ALWAYS);//siempre se redimensione
        
		b1login.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {			
				 Scene sceneprincipal=new Scene(hbox1,1370,750);
				 primaryStage.setScene(sceneprincipal);
				 primaryStage.setX(70);
				 primaryStage.setY(15);
				 
			}
			
		});
		
		
		
		//LOGIN
        formularioVBox.getChildren().addAll(lbUsuario,textUser,lbContra,textContra,b1login,lbGracias);//agregamos los labels al container secundario de formulario
        formularioVBox.setAlignment(Pos.TOP_LEFT);//poosicion
        
        VBox.setMargin(lbUsuario, new Insets(10,0,0,0));//margen arriba
        VBox.setMargin(textUser, new Insets(0,0,0,0));
        VBox.setMargin(lbContra, new Insets(10,0,0,0));
        VBox.setMargin(b1login, new Insets(20,0,0,0));
        VBox.setMargin(lbGracias, new Insets(0,0,0,0));

        izquierdaVbox.getChildren().addAll(lbTitle,formularioVBox);//agregamos todo al contenedor izquierdo
        izquierdaVbox.setPrefWidth(422);
        izquierdaVbox.setAlignment(Pos.CENTER);
        VBox.setMargin(formularioVBox,new Insets(0,30,0,30));//margen del contendor que esta con los layouts adentro
        izquierdaVbox.setBackground(new Background(new BackgroundFill(Color.web("#25D366"), CornerRadii.EMPTY, Insets.EMPTY)));//poner colores de fondo al contenedor

        VBox derechoVbox = new VBox();//Vbox para la derecha

        InputStream inputStream;//aqui contendra nuestra imagen
        inputStream=getClass().getResourceAsStream("/Images/Wh.png");//guardando la foto en ..
        Image image=new Image(inputStream);//guardando la inserccion en "image"

        ImageView imagenLogo;//creamos un view
        imagenLogo= new ImageView(image);//guardamos esta imagen en el view
        derechoVbox.getChildren().add(imagenLogo);

        derechoVbox.setPrefWidth(422);
        derechoVbox.setAlignment(Pos.CENTER);
        derechoVbox.setBackground(new Background(new BackgroundFill(Color.web("#25D366"), CornerRadii.EMPTY, Insets.EMPTY)));//poner colores de fondo al contenedor

        HBox root=new HBox();
        root.getChildren().addAll(izquierdaVbox,derechoVbox);//agregar todo al contendor principal
        
        HBox.setHgrow(izquierdaVbox, Priority.ALWAYS);//setHgrow, define que va a pasar con los nodos cuando se redimensione la pantalla
        HBox.setHgrow(derechoVbox, Priority.ALWAYS);
		
		
		Scene scene= new Scene(root,900,560);
		primaryStage.setTitle("WhatsApp");	
		primaryStage.setMinWidth(800);//minimo de anchura al minimizar
		primaryStage.setMinHeight(540);//minimo de altura al minimizar
		//primaryStage.setX(20);
		//primaryStage.setY(10);
		primaryStage.initStyle(StageStyle.DECORATED);//estilo de la escena
		primaryStage.setFullScreen(false);//true para que al abrir se abra en pantalla completa, false para que no suceda esto
		primaryStage.getIcons().add(new Image("/Images/WhatsApp color.png"));//icono de la app, la imagen esta en el package "images"
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void regresarLogin(ActionEvent e) {
		Node source = (Node) e.getSource();     //Me devuelve el elemento al que hice click
		Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
		stage.close();
		}
	
	public FlowPane getBurbuja(Mensaje mensaje) {
		FlowPane fMessage = new FlowPane(10,10);
		Label lbluser = new Label(mensaje.getEmisor().getUsername());
		Label lblMessage = new Label(mensaje.getContenido());
		fMessage.getChildren().addAll(lbluser, lblMessage);
		return fMessage; 
	}
	public static void main(String[] args) {
		UsuarioRepository usuarioRepository = new UsuarioRepository();
		Main.login = usuarioRepository.getUsuario(1);
		Main.selected = usuarioRepository.getUsuario(4);
		launch(args);
		
	}
}