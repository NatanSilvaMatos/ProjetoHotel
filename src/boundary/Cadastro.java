package boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Cadastro implements EventHandler<ActionEvent> {
	private TextField txtNome = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtEndereco = new TextField();
	private TextField txtNumeroResidencia = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtCPF= new TextField();
	private TextField txtSenha = new TextField();
	private Label lblCadastro = new Label("CADASTRO");
	private Label lblNome = new Label("NOME:");
	private Label lblEmail = new Label("EMAIL:");
	private Label lblEndereco = new Label("ENDERECO:");
	private Label lblNumeroResidencia = new Label("NUMERO DE RESIDENCIA:");
	private Label lblTelefone = new Label("TELEFONE:");
	private Label lblCPF = new Label("CPF:");
	private Label lblSenha = new Label("SENHA:");
	private Pane pane = new Pane();
	private Button cadastrar = new Button("Cadastrar");
	private Button gerarSenha = new Button("Gerar Senha");
	
	
	public Cadastro() {		
		lblCadastro.setLayoutX(30);
		lblCadastro.setLayoutY(30);
		lblCadastro.setStyle("-fx-font-weight: bold");
		
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
		
		lblCPF.setLayoutX(500);
		lblCPF.setLayoutY(70);
		
		txtCPF.setLayoutX(500);
		txtCPF.setLayoutY(100);
		
		lblSenha.setLayoutX(500);
		lblSenha.setLayoutY(170);
		
		txtSenha.setLayoutX(500);
		txtSenha.setLayoutY(200);
		txtSenha.setEditable(false);
		txtSenha.setPrefWidth(250);
		
		gerarSenha.setLayoutX(580);
		gerarSenha.setLayoutY(250);
		
		cadastrar.setLayoutX(350);
		cadastrar.setLayoutY(500);
		cadastrar.setPrefWidth(120);
		cadastrar.setOnAction(this);
										
		pane.setStyle("-fx-background-color: white;");
		pane.getChildren().addAll(lblCadastro, lblNome,txtNome, lblEmail, txtEmail, lblEndereco, txtEndereco,lblNumeroResidencia,txtNumeroResidencia,
		lblTelefone,txtTelefone,lblCPF, txtCPF, lblSenha, txtSenha,cadastrar,gerarSenha);
	}

	public Pane getPane() {
		return pane;
	}
	
	@Override
	public void handle(ActionEvent e) {
		if(e.getTarget() == cadastrar) {
			if(txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtNumeroResidencia.getText().isEmpty() ||
			txtTelefone.getText().isEmpty() || txtCPF.getText().isEmpty() || txtSenha.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Erro");
				alert.setHeaderText("Estão faltando campos a serem preenchidos");
				alert.setContentText("Preencha todos os campos");
				alert.showAndWait();
			}
			
		}
		
	}

}
