package boundary;


import java.io.InputStream;
import javafx.application.Application;
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
		RadioButton rbHospede = new RadioButton("H�spede");
		RadioButton rbFuncionario = new RadioButton("Funcion�rio");
		Label lbllbl = new Label();
		
		TextField txtLogin = new TextField();
		PasswordField txtSenha = new PasswordField();

		InputStream is = getClass().getResourceAsStream("/img/logo.png");
		Image imagem = new Image(is);
		ImageView imageView = new ImageView(imagem);
		imageView.setFitHeight(300);
		imageView.setFitWidth(300);
		imageView.setLayoutX(20);
		imageView.setLayoutY(3);
		
		btnEntrar.setLayoutX(347);
		btnEntrar.setLayoutY(450);
		btnEntrar.setPrefWidth(100);
		btnEntrar.prefHeight(15);
		
		lblLogin.setLayoutX(380);
		lblLogin.setLayoutY(220);
		
		lblLogin.setLayoutX(380);
		lblLogin.setLayoutY(220);
		
		lblSenha.setLayoutX(380);
		lblSenha.setLayoutY(320);
		
		txtLogin.setLayoutX(270);
		txtLogin.setLayoutY(250);
		txtLogin.setPrefWidth(250);
		
		txtSenha.setLayoutX(270);
		txtSenha.setLayoutY(350);
		txtSenha.setPrefWidth(250);
		
		rbHospede.setLayoutX(600);
		rbHospede.setLayoutY(290);
		
		rbFuncionario.setLayoutX(600);
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


