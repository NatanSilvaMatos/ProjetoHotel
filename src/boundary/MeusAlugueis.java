package boundary;

import control.PagamentoControl;
import entity.AluguelQuarto;
import entity.Categoria;
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
	private TableView<AluguelQuarto> table = new TableView<AluguelQuarto>();
	private PagamentoControl listaAluguel = new PagamentoControl();
	private Button botaoPesquisar = new Button("Pesquisar");
	private TextField txtPesquisar = new TextField();
	private long cpf;

	@SuppressWarnings("unchecked")
	public MeusAlugueis(long cpf) {
		this.cpf = cpf;
		TableColumn<AluguelQuarto, Integer> columnQuarto = new TableColumn<>("QUARTO");
		columnQuarto.setMinWidth(60);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("numQuarto"));

		TableColumn<AluguelQuarto, Integer> columnAndar = new TableColumn<>("ANDAR");
		columnAndar.setMinWidth(60);
		columnAndar.setCellValueFactory(new PropertyValueFactory<>("andarQuarto"));

		TableColumn<AluguelQuarto, Categoria> columnCategoria = new TableColumn<>("CATEGORIA");
		columnCategoria.setMinWidth(100);
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriaQuarto"));

		TableColumn<AluguelQuarto, String> columnData = new TableColumn<>("DATA DE ALUGUEL");
		columnData.setMinWidth(120);
		columnData.setCellValueFactory(new PropertyValueFactory<>("dataAluguel"));

		TableColumn<AluguelQuarto, Double> columnPrecoDiaria = new TableColumn<>("PRECO(DIARIA)");
		columnPrecoDiaria.setMinWidth(80);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("precoQuarto"));

		TableColumn<AluguelQuarto, Long> columnCPFHospede = new TableColumn<>("CPF HOSPEDE");
		columnCPFHospede.setMinWidth(120);
		columnCPFHospede.setCellValueFactory(new PropertyValueFactory<>("cpfHospede"));

		TableColumn<AluguelQuarto, String> columnNomeHospede = new TableColumn<>("NOME HOSPEDE");
		columnNomeHospede.setMinWidth(130);
		columnNomeHospede.setCellValueFactory(new PropertyValueFactory<>("nomeHospede"));

		table.getColumns().addAll(columnQuarto, columnAndar, columnCategoria, columnData, columnPrecoDiaria,
				columnCPFHospede, columnNomeHospede);
		table.setLayoutX(40);
		table.setLayoutY(70);

		System.out.println(cpf);
		table.setItems(listaAluguel.getListaListaAlugueisCPF(cpf));

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

		pane.getChildren().addAll(table, lblAluguel, botaoPesquisar, txtPesquisar);

	}

	public Pane getPane() {
		return pane;
	}

}
