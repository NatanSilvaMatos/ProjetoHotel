package boundary;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NovoAluguel {
	private Pane pane = new Pane();
	private Label lblCPF = new Label("CPF HOSPEDE:");
	private Label lblNumQuarto = new Label("NUMERO DO QUARTO:");
	private Label lblPrecoDiaria = new Label("PRECO(DIARIA)");
	private Label lblAndar = new Label("ANDAR");
	private Label lblCategoria = new Label("CATEGORIA");
	private Label lblDisponibilidade = new Label("DISPONIBILIDADE");
	private Label lblCedula = new Label("R$");
	private Label lblNovoAluguel = new Label("NOVO ALUGUEL");
	private TextField txtCPF = new TextField();
	private TextField txtNumQuarto = new TextField();
	private TextField txtPrecoDiaria = new TextField();
	private TextField txtAndar = new TextField();
	private ComboBox<String> cbCategoria = new ComboBox<String>(); 
	private ComboBox<String> cbDisponibilidade = new ComboBox<String>();
	private Button confirmarAluguel = new Button("Confirmar Aluguel");
	private Button pesquisarCpf = new Button("Pesquisar");
	private Button pesquisarNumQuarto = new Button("Pesquisar Quarto");
	private String[] categorias = {"Premium","Presidencial","Comum"};
	private String[] disponibilidade = {"Locado","Disponivel"};
	private Alert alert = new Alert(AlertType.WARNING);

	//@Override
	public NovoAluguel() {		
		lblNovoAluguel.setLayoutX(50);
		lblNovoAluguel.setLayoutY(30);
		lblNovoAluguel.setStyle("-fx-font-weight: bold");

		lblCPF.setLayoutX(50);
		lblCPF.setLayoutY(90);

		txtCPF.setLayoutX(50);
		txtCPF.setLayoutY(120);

		pesquisarCpf.setLayoutX(220);
		pesquisarCpf.setLayoutY(120);

		lblNumQuarto.setLayoutX(50);
		lblNumQuarto.setLayoutY(190);

		txtNumQuarto.setLayoutX(50);
		txtNumQuarto.setLayoutY(220);

		pesquisarNumQuarto.setLayoutX(220);
		pesquisarNumQuarto.setLayoutY(220);

		lblPrecoDiaria.setLayoutX(50);
		lblPrecoDiaria.setLayoutY(290);

		lblCedula.setLayoutX(50);
		lblCedula.setLayoutY(320);

		txtPrecoDiaria.setLayoutX(70);
		txtPrecoDiaria.setLayoutY(320);
		txtPrecoDiaria.setEditable(false);
		txtPrecoDiaria.setPrefWidth(125);

		lblAndar.setLayoutX(500);
		lblAndar.setLayoutY(90);

		txtAndar.setLayoutX(500);
		txtAndar.setLayoutY(120);
		txtAndar.setEditable(false);

		lblCategoria.setLayoutX(500);
		lblCategoria.setLayoutY(190);

		cbCategoria.setLayoutX(500);
		cbCategoria.setLayoutY(220);
		cbCategoria.setItems(FXCollections.observableArrayList(categorias));
		cbCategoria.getSelectionModel().select(categorias[0]);
		cbCategoria.setPrefWidth(150);	

		lblDisponibilidade.setLayoutX(500);
		lblDisponibilidade.setLayoutY(290);

		cbDisponibilidade.setLayoutX(500);
		cbDisponibilidade.setLayoutY(320);
		cbDisponibilidade.setItems(FXCollections.observableArrayList(disponibilidade));
		cbDisponibilidade.getSelectionModel().select(disponibilidade[0]);
		cbDisponibilidade.setPrefWidth(150);

		confirmarAluguel.setLayoutX(300);
		confirmarAluguel.setLayoutY(500);
		confirmarAluguel.setPrefWidth(170);

		pesquisarNumQuarto.setOnAction((event) -> {
			if(txtNumQuarto.getText().isEmpty()) {			
				alert.setHeaderText("Estão faltando campos a serem preenchidos");
				alert.setContentText("Preencha o campo de Numero do Quarto para pesquisar!");
				alert.showAndWait();
			}
		});

		pesquisarCpf.setOnAction((event) -> {
			if(txtCPF.getText().isEmpty()) {			
				alert.setHeaderText("Estão faltando campos a serem preenchidos");
				alert.setContentText("Preencha o campo do CPF para pesquisar!");
				alert.showAndWait();
			}
		});

		confirmarAluguel.setOnAction((event) -> {
			if(txtCPF.getText().isEmpty() || txtNumQuarto.getText().isEmpty() ) {			
				alert.setHeaderText("Estão faltando campos a serem preenchidos");
				alert.setContentText("Preencha todos os campos para confirmar a Aluguel!");
				alert.showAndWait();
			}
		});


		alert.setTitle("Erro");

		pane.getChildren().addAll(lblCPF,txtCPF,lblNumQuarto,txtNumQuarto,lblPrecoDiaria,lblCedula,txtPrecoDiaria,lblAndar,txtAndar,lblCategoria,cbCategoria,
				lblDisponibilidade, cbDisponibilidade, confirmarAluguel, lblNovoAluguel, pesquisarCpf,pesquisarNumQuarto);
	}

	public Pane getPane() {
		return pane;
	}


}

