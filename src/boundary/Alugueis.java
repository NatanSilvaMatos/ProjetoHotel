package boundary;

import java.time.LocalDate;

import control.AluguelControl;
import control.PagamentoControl;
import entity.Aluguel;
import entity.Categoria;
import entity.Pagamento;
import entity.Quarto;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class Alugueis {
	private Pane pane = new Pane();
	private Label lblAlugueis = new Label("ALUGUEIS");
	private TableView<Pagamento> table = new TableView<Pagamento>();
	private PagamentoControl listaAluguel = new PagamentoControl();
	private Button botaoPesquisar = new Button("Pesquisar");
	private TextField txtPesquisar = new TextField();
	
	
	@SuppressWarnings("unchecked")
	public Alugueis() {
		TableColumn<Pagamento,Quarto> columnQuarto = new TableColumn<>("QUARTO");
		columnQuarto.setMinWidth(120);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("quarto"));
		
		TableColumn<Pagamento,Integer> columnCodigo = new TableColumn<>("CODIGO");
		columnCodigo.setMinWidth(120);
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		
		TableColumn<Pagamento,Integer> columnNumDias = new TableColumn<>("NUM. DIAS");
		columnNumDias.setMinWidth(120);
		columnNumDias.setCellValueFactory(new PropertyValueFactory<>("numDias"));
		
		TableColumn<Pagamento,LocalDate> columnData = new TableColumn<>("DATA");
		columnData.setMinWidth(120);
		columnData.setCellValueFactory(new PropertyValueFactory<>("disponibilidade"));
		
		TableColumn<Pagamento,Double> columnPrecoDiaria = new TableColumn<>("PRECO(DIARIA)");
		columnPrecoDiaria.setMinWidth(120);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		TableColumn<Pagamento,Integer> columnCPFHospede = new TableColumn<>("CPF HOSPEDE");
		columnCPFHospede.setMinWidth(120);
		columnCPFHospede.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		
		table.getColumns().addAll(columnQuarto,columnCodigo,columnNumDias);
		table.setLayoutX(40);
		table.setLayoutY(70);
		table.setItems(listaAluguel.getLista());
		
		
		
		lblAlugueis.setLayoutX(40);
		lblAlugueis.setLayoutY(30);
		lblAlugueis.setStyle("-fx-font-weight: bold");
		
		txtPesquisar.setLayoutX(40);
		txtPesquisar.setLayoutY(500);
		txtPesquisar.setPrefWidth(150);
		txtPesquisar.setPromptText("Pesquisa");
		
		botaoPesquisar.setLayoutX(210);
		botaoPesquisar.setLayoutY(500);
		botaoPesquisar.setPrefWidth(100);
		
		pane.getChildren().addAll(table,lblAlugueis,txtPesquisar,botaoPesquisar);
		
	}
	public Pane getPane() {
		return pane;
	}
	
	
	
}
