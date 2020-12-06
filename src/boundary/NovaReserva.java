package boundary;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NovaReserva extends Application{
	private Pane pane = new Pane();
	private Scene scene = new Scene(pane,800,600);
	private Label lblCPF = new Label("CPF HOSPEDE:");
	private Label lblNumQuarto = new Label("NUMERO DO QUARTO:");
	private Label lblPrecoDiaria = new Label("PRECO(DIARIA)");
	private Label lblAndar = new Label("ANDAR");
	private Label lblCategoria = new Label("CATEGORIA");
	private Label lblDisponibilidade = new Label("DISPONIBILIDADE");
	private Label lblCedula = new Label("R$");
	private TextField txtCPF = new TextField();
	private TextField txtNumQuarto = new TextField();
	private TextField txtPrecoDiaria = new TextField();
	private TextField txtAndar = new TextField();
	private TextField txtDisponibilidade = new TextField();
	private ComboBox<String> cbCategoria = new ComboBox<String>(); 
	private Button confirmarReserva = new Button("Confirmar Reserva");
	private String[] categorias = {"Premium","Presidencial","Comum"};

	@Override
	public void start(Stage stage) throws Exception {		
		lblCPF.setLayoutX(50);
		lblCPF.setLayoutY(90);
		
		txtCPF.setLayoutX(50);
		txtCPF.setLayoutY(120);
		
		lblNumQuarto.setLayoutX(50);
		lblNumQuarto.setLayoutY(190);
				
		txtNumQuarto.setLayoutX(50);
		txtNumQuarto.setLayoutY(220);
		
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
		
		lblCategoria.setLayoutX(500);
		lblCategoria.setLayoutY(190);
		
		cbCategoria.setLayoutX(500);
		cbCategoria.setLayoutY(220);
		cbCategoria.setItems(FXCollections.observableArrayList(categorias));
		cbCategoria.getSelectionModel().select(categorias[0]);
		cbCategoria.setPrefWidth(150);		
		
		lblDisponibilidade.setLayoutX(500);
		lblDisponibilidade.setLayoutY(290);
		
		txtDisponibilidade.setLayoutX(500);
		txtDisponibilidade.setLayoutY(320);
		
		confirmarReserva.setLayoutX(300);
		confirmarReserva.setLayoutY(500);
		confirmarReserva.setPrefWidth(170);
				
		pane.getChildren().addAll(lblCPF,txtCPF,lblNumQuarto,txtNumQuarto,lblPrecoDiaria,lblCedula,txtPrecoDiaria,lblAndar,txtAndar,lblCategoria,cbCategoria,
		lblDisponibilidade, txtDisponibilidade, confirmarReserva);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	
	public static void main(String[] args) {
		Application.launch(NovaReserva.class,args);
	}
}
