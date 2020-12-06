package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Cadastro extends Application {
	private TextField txtNome = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtEndereco = new TextField();
	private TextField txtNumeroResidencia = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtCPF= new TextField();
	private TextField txtSenha = new TextField();
	private Label lblNome = new Label("NOME:");
	private Label lblEmail = new Label("EMAIL:");
	private Label lblEndereco = new Label("ENDERECO:");
	private Label lblNumeroResidencia = new Label("NUMERO DE RESIDENCIA:");
	private Label lblTelefone = new Label("TELEFONE:");
	private Label lblCPF = new Label("CPF:");
	private Label lblSenha = new Label("SENHA:");
	private Pane pane = new Pane();
	private Scene scene = new Scene(pane,800,600);
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		lblNome.setLayoutX(30);
		lblNome.setLayoutY(70);
		
		txtNome.setLayoutX(30);
		txtNome.setLayoutY(100);
		txtNome.setPrefWidth(250);
		
		lblEmail.setLayoutX(30);
		lblEmail.setLayoutY(170);
				
		txtEmail.setLayoutX(30);
		txtEmail.setLayoutY(200);
		txtEmail.setPrefWidth(250);
		
		lblEndereco.setLayoutX(30);
		lblEndereco.setLayoutY(270);
		
		txtEndereco.setLayoutX(30);
		txtEndereco.setLayoutY(300);
		txtEndereco.setPrefWidth(250);
		
		lblNumeroResidencia.setLayoutX(30);
		lblNumeroResidencia.setLayoutY(370);
		
		txtNumeroResidencia.setLayoutX(30);
		txtNumeroResidencia.setLayoutY(400);
		
		lblTelefone.setLayoutX(30);
		lblTelefone.setLayoutY(470);
		
		txtTelefone.setLayoutX(30);
		txtTelefone.setLayoutY(500);
		txtTelefone.setPrefWidth(250);
		
					
		pane.setStyle("-fx-background-color: white;");
		pane.getChildren().addAll(lblNome,txtNome, lblEmail, txtEmail, lblEndereco, txtEndereco,lblNumeroResidencia,txtNumeroResidencia,
		lblTelefone,txtTelefone);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		Application.launch(Cadastro.class,args);
	}
	
	
	
}
