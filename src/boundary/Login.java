package boundary;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login extends Application {
	
	

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Scene scn = new Scene(pane,800,600);
		Label lblLogin = new Label("Login");
		Label lblSenha = new Label("Senha");
		Button btnEntrar = new Button("Entrar");
		RadioButton rbHospede = new RadioButton("Hóspede");
		RadioButton rbFuncionario = new RadioButton("Funcionário");
		
		TextField txtLogin = new TextField();
		PasswordField txtSenha = new PasswordField();
		
		FileInputStream fis = new FileInputStream("E:\\JavaWorkspace\\Hotel\\images\\Logo.png");
		Image imagem = new Image(fis);
		ImageView imageView = new ImageView(imagem);
		imageView.setFitHeight(300);
		imageView.setFitWidth(300);
		imageView.setLayoutX(20);
		imageView.setLayoutY(3);
		
		
		btnEntrar.setLayoutX(370);
		btnEntrar.setLayoutY(420);
		btnEntrar.setAlignment(Pos.CENTER_RIGHT);
		
		lblLogin.setLayoutX(380);
		lblLogin.setLayoutY(220);
		
		lblLogin.setLayoutX(380);
		lblLogin.setLayoutY(220);
		
		lblSenha.setLayoutX(380);
		lblSenha.setLayoutY(320);
		
		txtLogin.setLayoutX(320);
		txtLogin.setLayoutY(250);
		
		txtSenha.setLayoutX(320);
		txtSenha.setLayoutY(350);
		
		rbHospede.setLayoutX(550);
		rbHospede.setLayoutY(290);
		
		rbFuncionario.setLayoutX(550);
		rbFuncionario.setLayoutY(330);
			
		pane.getChildren().add(lblLogin);
		pane.getChildren().add(lblSenha);
		pane.getChildren().add(btnEntrar);
		pane.getChildren().add(txtLogin);
		pane.getChildren().add(txtSenha);
		pane.getChildren().add(rbHospede);
		pane.getChildren().add(rbFuncionario);
		pane.getChildren().add(imageView);
	
	
		
		
		
		
		stage.setScene(scn);
		
		stage.setTitle("Login");
		stage.show();
		
		
	}
	
	
	
	public static void main(String[] args) {
		Application.launch(Login.class, args);
	}
}


