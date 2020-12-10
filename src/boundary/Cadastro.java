package boundary;

import java.sql.SQLDataException;

import control.HospedeControl;
import dao.HospedeDao;
import entity.Hospede;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Cadastro {
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
	private ToggleGroup groupTipoPagamento = new ToggleGroup();
	private Button cadastrar = new Button("Cadastrar");
	private Button gerarSenha = new Button("Gerar Senha");
	private HospedeControl hospedeControl = new HospedeControl();
	private HospedeDao hospedeDao = new HospedeDao();
	private RadioButton rbHospede = new RadioButton("Hóspede");
	private RadioButton rbFuncionario = new RadioButton("Funcionário");
	private Alert alert = new Alert(AlertType.WARNING);


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

		rbHospede.setLayoutX(500);
		rbHospede.setToggleGroup(groupTipoPagamento);
		rbHospede.setSelected(true);
		rbHospede.setLayoutY(340);

		rbFuncionario.setLayoutX(500);
		rbFuncionario.setToggleGroup(groupTipoPagamento);
		rbFuncionario.setLayoutY(300);

		gerarSenha.setLayoutX(580);
		gerarSenha.setLayoutY(250);

		cadastrar.setLayoutX(350);
		cadastrar.setLayoutY(500);
		cadastrar.setPrefWidth(120);

		cadastrar.setOnAction((event) -> {
			if(txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtNumeroResidencia.getText().isEmpty() ||
					txtTelefone.getText().isEmpty() || txtCPF.getText().isEmpty() || txtSenha.getText().isEmpty()) {
				alert.setTitle("Erro");
				alert.setHeaderText("Estão faltando campos a serem preenchidos");
				alert.setContentText("Preencha todos os campos");
				alert.showAndWait();
			}
			else {
				int cpf = Integer.parseInt(txtCPF.getText());
				alert.setTitle("Erro");
				alert.setHeaderText("Esse cpf já existe em nossa base, cadastre com outro CPF");
				int telefone = Integer.parseInt(txtTelefone.getText()); 
				Hospede hospede = new Hospede(cpf, txtEmail.getText(),txtNome.getText(),txtEndereco.getText(),telefone,txtSenha.getText(),1);
				if(hospedeDao.PesquisaCpf(cpf) != null) {
					alert.setTitle("Erro");
					alert.setHeaderText("Esse CPF ja existe, cadastre os outros");
					alert.showAndWait();
					System.out.println(hospedeDao.PesquisaCpf(cpf));
				}
				else {
					System.out.println("Pode cadastrar");
				}
			}
		});
		//else {
		//hospedeControl.adicionar(hospede);
		//alert.setTitle("Sucesso");
		//alert.setHeaderText("O cadastro foi efetuado com sucesso!");

		gerarSenha.setOnAction((event) -> {
			txtSenha.setText(gerarNovaSenha(10));
		});

		pane.setStyle("-fx-background-color: white;");
		pane.getChildren().addAll(lblCadastro, lblNome,txtNome, lblEmail, txtEmail, lblEndereco, txtEndereco,lblNumeroResidencia,txtNumeroResidencia,
				lblTelefone,txtTelefone,lblCPF, txtCPF, lblSenha, txtSenha,cadastrar,gerarSenha,rbHospede,rbFuncionario);
	}

	public Pane getPane() {
		return pane;
	}

	public String gerarNovaSenha(int qtdeMaximaCaracteres){

		String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
				"9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
				"x", "y", "z"};

		StringBuilder senha = new StringBuilder();

		for (int i = 0; i < qtdeMaximaCaracteres; i++) {
			int posicao = (int) (Math.random() * caracteres.length);
			senha.append(caracteres[posicao]);
		}
		return senha.toString();
	}

}
