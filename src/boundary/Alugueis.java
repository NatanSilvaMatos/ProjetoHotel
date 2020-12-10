package boundary;

import java.time.LocalDate;
import java.util.List;

import control.PagamentoControl;
import entity.Aluguel;
import entity.AluguelQuarto;
import entity.Categoria;
import entity.Pagamento;
import entity.Quarto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
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
	private TableView<AluguelQuarto> table = new TableView<AluguelQuarto>();
	private PagamentoControl listaAluguel = new PagamentoControl();
	private Button botaoPesquisar = new Button("Pesquisar");
	private TextField txtPesquisar = new TextField();

	@SuppressWarnings("unchecked")
	public Alugueis() {
		TableColumn<AluguelQuarto, Integer> columnQuarto = new TableColumn<>("QUARTO");
		columnQuarto.setMinWidth(120);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("numQuarto"));

		TableColumn<AluguelQuarto, Integer> columnAndar = new TableColumn<>("ANDAR");
		columnAndar.setMinWidth(120);
		columnAndar.setCellValueFactory(new PropertyValueFactory<>("andarQuarto"));

		TableColumn<AluguelQuarto, Categoria> columnCategoria = new TableColumn<>("CATEGORIA");
		columnCategoria.setMinWidth(120);
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriaQuarto"));

		TableColumn<AluguelQuarto, String> columnData = new TableColumn<>("DATA DE ALUGUEL");
		columnData.setMinWidth(120);
		columnData.setCellValueFactory(new PropertyValueFactory<>("dataAluguel"));

		TableColumn<AluguelQuarto, Double> columnPrecoDiaria = new TableColumn<>("PRECO(DIARIA)");
		columnPrecoDiaria.setMinWidth(120);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("precoQuarto"));

		TableColumn<AluguelQuarto, Long> columnCPFHospede = new TableColumn<>("CPF HOSPEDE");
		columnCPFHospede.setMinWidth(120);
		columnCPFHospede.setCellValueFactory(new PropertyValueFactory<>("cpfHospede"));

		table.getColumns().addAll(columnQuarto, columnAndar, columnCategoria, columnData, columnPrecoDiaria,
				columnCPFHospede);
		table.setLayoutX(40);
		table.setLayoutY(70);
		
		table.setItems(listaAluguel.getListaListaAlugueis());
		/*
		 * for (String o : listaAluguel.getListaListaAlugueis()) {
		 * 
		 * table.getItems(); }
		 */
		// columnQuarto.setCellValueFactory(data -> new SimpleStringProperty(item));
		// columnAndar.setCellValueFactory(data -> new SimpleStringProperty(item));
		// columnCategoria.setCellValueFactory(data -> new SimpleStringProperty(item));
		// columnData.setCellValueFactory(data -> new SimpleStringProperty(item));
		// columnPrecoDiaria.setCellValueFactory(data -> new
		// SimpleStringProperty(item));
		// columnCPFHospede.setCellValueFactory(data -> new SimpleStringProperty(item));
		/*
		 * for (String item : listaAluguel.getListaListaAlugueis()) {
		 * 
		 * 
		 * System.out.println(item); }
		 */

		

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
		botaoPesquisar.setOnAction((event) -> {
			{
				int num = Integer.parseInt(txtPesquisar.getText());
				if (listaAluguel.getListaPagamentosCpf(num) != null) {
					System.out.println("certinho");
				} else {
					System.out.println("deu ruim");
				}
			}
		});

		pane.getChildren().addAll(table, lblAlugueis, txtPesquisar, botaoPesquisar);

	}

	public Pane getPane() {
		return pane;
	}

}
