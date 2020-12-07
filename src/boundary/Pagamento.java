package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Pagamento{
	private Pane pane = new Pane();
	private Scene scene = new Scene(pane,800,600);
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
	private ToggleGroup groupTipoPagamento = new ToggleGroup();
		
	//@Override
	public Pagamento() {	
		lblPagamento.setLayoutX(50);
		lblPagamento.setLayoutY(40);
		
		lblCPF.setLayoutX(50);
		lblCPF.setLayoutY(90);
		
		txtCPF.setLayoutX(50);
		txtCPF.setLayoutY(120);
		
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
		
		pane.getChildren().addAll(lblPagamento,lblCPF,txtCPF,lblCartao,txtCartao,lblCodSeguranca,txtCodSeguranca, lblPrecoTotal,lblCedula,txtPrecoTotal,lblTipoPagamento,
		rbDebito,rbCredito,rbDinheiro, confirmarPagamento);
		//stage.setScene(scene);
		//stage.show();
		
		
		
	}
	//public static void main(String[] args) {
		//Application.launch(Pagamento.class,args);
	//}

	public Pane getPane() {
		return pane;
	}
}
