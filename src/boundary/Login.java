package boundary;

import java.io.InputStream;

import dao.LoginDao;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {
	private Pane pane = new Pane();
	private Scene scn = new Scene(pane, 800, 600);
	private Label lblBemVindo = new Label("SEJA BEM VINDO AO HOTEL DO COLEVAT�O!");
	private Label lblLogin = new Label("LOGIN: (UTILIZE SEU CPF PARA ENTRAR)");
	private Label lblSenha = new Label("SENHA:");
	private Button btnEntrar = new Button("Entrar");
	private RadioButton rbHospede = new RadioButton("H�spede");
	private RadioButton rbFuncionario = new RadioButton("Funcion�rio");
	private TextField txtLogin = new TextField();
	private PasswordField txtSenha = new PasswordField();
	private ToggleGroup groupCategoriaUsuario = new ToggleGroup();
	private Alert alert = new Alert(AlertType.WARNING);
	private LoginDao login = new LoginDao();

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

		lblBemVindo.setLayoutX(90);
		lblBemVindo.setLayoutY(100);
		lblBemVindo.setStyle("-fx-font-weight: bold");
		lblBemVindo.setFont(new Font(25));
		lblBemVindo.setTextFill(Color.DODGERBLUE);

		lblLogin.setLayoutX(90);
		lblLogin.setLayoutY(210);

		lblSenha.setLayoutX(90);
		lblSenha.setLayoutY(290);

		txtLogin.setLayoutX(90);
		txtLogin.setLayoutY(240);
		txtLogin.setPrefWidth(250);

		txtSenha.setLayoutX(90);
		txtSenha.setLayoutY(320);
		txtSenha.setPrefWidth(250);

		rbHospede.setToggleGroup(groupCategoriaUsuario);
		rbHospede.setSelected(true);
		rbFuncionario.setToggleGroup(groupCategoriaUsuario);

		rbHospede.setLayoutX(250);
		rbHospede.setLayoutY(360);

		rbFuncionario.setLayoutX(250);
		rbFuncionario.setLayoutY(390);

		InputStream input = this.getClass().getResourceAsStream("/img/icon.png");
		Image icon = new Image(input);
		stage.getIcons().add(icon);

		pane.getChildren().addAll(lblBemVindo, lblLogin, lblSenha, btnEntrar, txtLogin, txtSenha, rbHospede,
				rbFuncionario, imageView);

		alert.setTitle("Erro");

		btnEntrar.setOnAction((event) -> {
			if (txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()) {
				alert.setHeaderText("Algum campo n�o foi preenchido");
				alert.setContentText("Preencha todos os campos para fazer Login!");
				alert.showAndWait();
			}
			if (rbFuncionario.isSelected()) {
				try {
					if (login.LoginFuncionario(Long.parseLong(txtLogin.getText()), txtSenha.getText().toString())) {
						MenuPrincipal menu = new MenuPrincipal(rbFuncionario.getText().toString(),
								Long.parseLong(txtLogin.getText()));
						Scene cena2 = new Scene(menu.chamaTela(), 800, 600);
						stage.setScene(cena2);
					} else {
						alert.setHeaderText("Login ou Senha incorretos");
						alert.setContentText("Preencha os dados corretamente pra fazer Login!");
						alert.showAndWait();
					}
				} catch (Exception e) {
					alert.setHeaderText("Login ou Senha incorretos");
					alert.setContentText("Preencha os dados corretamente pra fazer Login!");
					alert.showAndWait();
				}
			} else {
				try {
					if (login.LoginHospede(Long.parseLong(txtLogin.getText()), txtSenha.getText().toString())) {
						MenuPrincipal menu = new MenuPrincipal(rbHospede.getText().toString(),
								Long.parseLong(txtLogin.getText()));
						Scene cena2 = new Scene(menu.chamaTela(), 800, 600);
						stage.setScene(cena2);
					} else {
						alert.setHeaderText("Login ou Senha incorretos");
						alert.setContentText("Preencha os dados corretamente pra fazer Login!");
						alert.showAndWait();
					}
				} catch (Exception e) {
					alert.setHeaderText("Login ou Senha incorretos");
					alert.setContentText("Preencha os dados corretamente pra fazer Login!");
					alert.showAndWait();
				}
			}
		});

		stage.setScene(scn);
		stage.setResizable(false);
		stage.setTitle("HOTEL DO COLEVAT�O");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(Login.class, args);
	}

}
