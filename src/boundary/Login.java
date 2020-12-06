package boundary;

import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login extends Application {
	private Pane pane = new Pane();
	private Scene scn = new Scene(pane, 800, 600);
	private Label lblLogin = new Label("LOGIN:");
	private Label lblSenha = new Label("SENHA:");
	private Button btnEntrar = new Button("Entrar");
	private RadioButton rbHospede = new RadioButton("Hóspede");
	private RadioButton rbFuncionario = new RadioButton("Funcionário");
	private TextField txtLogin = new TextField();
	private PasswordField txtSenha = new PasswordField();

	@Override
	public void start(Stage stage) throws Exception {
		InputStream is = getClass().getResourceAsStream("/img/logo.png");
		Image imagem = new Image(is);
		ImageView imageView = new ImageView(imagem);
		imageView.setFitHeight(300);
		imageView.setFitWidth(300);
		imageView.setLayoutX(400);
		imageView.setLayoutY(150);
		btnEntrar.setLayoutX(250);
		btnEntrar.setLayoutY(430);
		btnEntrar.setPrefWidth(75);
		btnEntrar.prefHeight(50);
		pane.setStyle("-fx-background-color: white;");

		lblLogin.setLayoutX(90);
		lblLogin.setLayoutY(220);

		lblSenha.setLayoutX(90);
		lblSenha.setLayoutY(300);

		txtLogin.setLayoutX(90);
		txtLogin.setLayoutY(240);
		txtLogin.setPrefWidth(250);

		txtSenha.setLayoutX(90);
		txtSenha.setLayoutY(320);
		txtSenha.setPrefWidth(250);

		ToggleGroup groupCategoriaUsuario = new ToggleGroup();
		rbHospede.setToggleGroup(groupCategoriaUsuario);
		rbHospede.setSelected(true);
		rbFuncionario.setToggleGroup(groupCategoriaUsuario);

		rbHospede.setLayoutX(250);
		rbHospede.setLayoutY(360);

		rbFuncionario.setLayoutX(250);
		rbFuncionario.setLayoutY(390);

		pane.getChildren().add(lblLogin);
		pane.getChildren().add(lblSenha);
		pane.getChildren().add(btnEntrar);
		pane.getChildren().add(txtLogin);
		pane.getChildren().add(txtSenha);
		pane.getChildren().add(rbHospede);
		pane.getChildren().add(rbFuncionario);
		pane.getChildren().add(imageView);

		stage.setScene(scn);
		stage.setResizable(false);
		stage.setTitle("BEM-VINDO AO HOTEL DO COLEVATÃO");
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(Login.class, args);
	}

}
