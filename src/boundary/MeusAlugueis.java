package boundary;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class MeusAlugueis {
	private Pane pane = new Pane();
	private Label lblAluguel = new Label("MEUS ALUGUEIS");
	private TableView<String> table = new TableView<String>();
	private Button botaoPesquisar = new Button("Pesquisar");
	private TextField txtPesquisar = new TextField();
	

	@SuppressWarnings("unchecked")
	public MeusAlugueis() {
		TableColumn<String,String> columnQuarto = new TableColumn<>("N.QUARTO");
		columnQuarto.setMinWidth(120);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		TableColumn<String,String> columnAndar = new TableColumn<>("ANDAR");
		columnAndar.setMinWidth(120);
		columnAndar.setCellValueFactory(new PropertyValueFactory<>("andar"));
		
		TableColumn<String,String> columnCategoria = new TableColumn<>("CATEGORIA");
		columnCategoria.setMinWidth(120);
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		
		TableColumn<String,String> columnDataEstadia = new TableColumn<>("DATA ESTADIA");
		columnDataEstadia.setMinWidth(120);
		columnDataEstadia.setCellValueFactory(new PropertyValueFactory<>("dataEstadia"));
		
		TableColumn<String,String> columnPrecoDiaria = new TableColumn<>("PRECO(DIARIA)");
		columnPrecoDiaria.setMinWidth(120);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		TableColumn<String,String> columnPago = new TableColumn<>("PAGO");
		columnPago.setMinWidth(100);
		columnPago.setCellValueFactory(new PropertyValueFactory<>("pago"));
		
		table.getColumns().addAll(columnQuarto,columnAndar,columnCategoria,columnDataEstadia,columnPrecoDiaria,columnPago);
		table.setLayoutX(50);
		table.setLayoutY(70);
		
		lblAluguel.setLayoutX(50);
		lblAluguel.setLayoutY(30);
		lblAluguel.setStyle("-fx-font-weight: bold");
		
		txtPesquisar.setLayoutX(50);
		txtPesquisar.setLayoutY(500);
		txtPesquisar.setPrefWidth(150);
		txtPesquisar.setPromptText("Pesquisa");
		
		botaoPesquisar.setLayoutX(220);
		botaoPesquisar.setLayoutY(500);
		botaoPesquisar.setPrefWidth(100);
				
						
		pane.getChildren().addAll(table,lblAluguel,botaoPesquisar,txtPesquisar);
		
	}
	
	public Pane getPane() {
		return pane;
	}

}
