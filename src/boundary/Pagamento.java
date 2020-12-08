package boundary;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class Pagamento {
	private Pane pane = new Pane();

	private Label lblCPF = new Label("CPF HOSPEDE:");
	private Label lblCartao = new Label("CARTAO:");
	private Label lblCodSeguranca = new Label("COD. SEGURANCA:");
	private Label lblCedula = new Label("R$");
	private Label lblTipoPagamento = new Label("TIPO PAGAMENTO:");
	private Label lblPrecoTotal = new Label("TOTAL:");
	private Label lblPagamento = new Label("PAGAMENTO");
	private TextField txtCPF = new TextField();
	private TextField txtCartao = new TextField();
	private TextField txtCodSeguranca = new TextField();
	private TextField txtPrecoTotal = new TextField();
	private RadioButton rbDebito = new RadioButton("Debito");
	private RadioButton rbCredito = new RadioButton("Credito");
	private RadioButton rbDinheiro = new RadioButton("Dinheiro");
	private Button confirmarPagamento = new Button("Confirmar Pagamento");
	private Button pesquisarCpf = new Button("Pesquisar");
	private ToggleGroup groupTipoPagamento = new ToggleGroup();
	private Alert alert = new Alert(AlertType.WARNING);

	public Pagamento() {
		lblPagamento.setLayoutX(50);
		lblPagamento.setLayoutY(40);
		lblPagamento.setStyle("-fx-font-weight: bold");

		lblCPF.setLayoutX(50);
		lblCPF.setLayoutY(90);

		txtCPF.setLayoutX(50);
		txtCPF.setLayoutY(120);

		pesquisarCpf.setLayoutX(220);
		pesquisarCpf.setLayoutY(120);

		lblCartao.setLayoutX(50);
		lblCartao.setLayoutY(190);

		txtCartao.setLayoutX(50);
		txtCartao.setLayoutY(220);

		lblCodSeguranca.setLayoutX(50);
		lblCodSeguranca.setLayoutY(290);

		txtCodSeguranca.setLayoutX(50);
		txtCodSeguranca.setLayoutY(320);
		txtCodSeguranca.setPrefWidth(100);

		lblPrecoTotal.setLayoutX(50);
		lblPrecoTotal.setLayoutY(390);

		lblCedula.setLayoutX(50);
		lblCedula.setLayoutY(420);

		txtPrecoTotal.setLayoutX(70);
		txtPrecoTotal.setLayoutY(420);
		txtPrecoTotal.setEditable(false);
		txtPrecoTotal.setPrefWidth(125);

		lblTipoPagamento.setLayoutX(500);
		lblTipoPagamento.setLayoutY(90);

		rbDebito.setLayoutX(500);
		rbDebito.setLayoutY(140);
		rbDebito.setToggleGroup(groupTipoPagamento);
		rbDebito.setSelected(true);

		rbCredito.setLayoutX(500);
		rbCredito.setToggleGroup(groupTipoPagamento);
		rbCredito.setLayoutY(180);

		rbDinheiro.setLayoutX(500);
		rbDinheiro.setToggleGroup(groupTipoPagamento);
		rbDinheiro.setLayoutY(220);

		confirmarPagamento.setLayoutX(300);
		confirmarPagamento.setLayoutY(500);
		confirmarPagamento.setPrefWidth(170);

		alert.setTitle("Erro");

		pane.getChildren().addAll(lblPagamento, lblCPF, txtCPF, pesquisarCpf, lblCartao, txtCartao, lblCodSeguranca,
				txtCodSeguranca, lblPrecoTotal, lblCedula, txtPrecoTotal, lblTipoPagamento, rbDebito, rbCredito,
				rbDinheiro, confirmarPagamento);

		rbDinheiro.setOnAction((event) -> {
			txtCartao.clear();
			txtCartao.setEditable(false);
			txtCodSeguranca.clear();
			txtCodSeguranca.setEditable(false);
		});

		rbDebito.setOnAction((event) -> {
			txtCartao.setEditable(true);
			txtCodSeguranca.setEditable(true);
		});

		rbCredito.setOnAction((event) -> {
			txtCartao.setEditable(true);
			txtCodSeguranca.setEditable(true);
		});
		
		pesquisarCpf.setOnAction((event) -> {
			if(txtCPF.getText().isEmpty()) {
				alert.setHeaderText("O campo de CPF n�o foi preenchido");
				alert.setContentText("Preencha o campo de CPF para pesquisar");
				alert.showAndWait();
			}
		});

		confirmarPagamento.setOnAction((event) -> {
			if (txtCPF.getText().isEmpty()) {
				alert.setHeaderText("O campo de CPF n�o foi preenchido");
				alert.setContentText("Preencha o campo de CPF para prosseguir");
				alert.showAndWait();
			}
		});

	}

	public Pane getPane() {
		return pane;
	}

}
