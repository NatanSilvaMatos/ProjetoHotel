package boundary;


import control.QuartoControl;
import entity.Disponibilidade;
import entity.Quarto;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;


public class QuartosDisponiveis {
	private Pane pane = new Pane();
	private Label lblQuartos = new Label("QUARTOS DISPONIVEIS");
	private TableView<Quarto> table = new TableView<Quarto>();
	private QuartoControl quartosDisponiveis = new QuartoControl();
	private Button botaoPesquisar = new Button("Pesquisar");
	private TextField txtPesquisar = new TextField();

	@SuppressWarnings("unchecked")
	public QuartosDisponiveis() {
		TableColumn<Quarto, Integer>  columnQuarto = new TableColumn<Quarto, Integer>("N.QUARTO");
		columnQuarto.setMinWidth(150);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		TableColumn<Quarto, Integer> columnAndar = new TableColumn<Quarto, Integer>("ANDAR");
		columnAndar.setMinWidth(150);
		columnAndar.setCellValueFactory(new PropertyValueFactory<>("andar"));
		
		TableColumn<Quarto,Disponibilidade> columnCategoria = new TableColumn<Quarto,Disponibilidade>("CATEGORIA");
		columnCategoria.setMinWidth(150);
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		
		TableColumn<Quarto,Double> columnPrecoDiaria = new TableColumn<Quarto,Double>("PRECO");
		columnPrecoDiaria.setMinWidth(150);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		table.getColumns().addAll(columnQuarto, columnAndar, columnCategoria, columnPrecoDiaria);
		table.setLayoutX(90);
		table.setLayoutY(70);	
		
		table.setItems(quartosDisponiveis.getListaDisponiveis());
		
		lblQuartos.setLayoutX(90);
		lblQuartos.setLayoutY(30);
		lblQuartos.setStyle("-fx-font-weight: bold");
		
		
		
		txtPesquisar.setLayoutX(90);
		txtPesquisar.setLayoutY(500);
		txtPesquisar.setPrefWidth(100);
		
		botaoPesquisar.setLayoutX(210);
		botaoPesquisar.setLayoutY(500);
		botaoPesquisar.setPrefWidth(100);
				
		pane.getChildren().addAll(table, lblQuartos, txtPesquisar, botaoPesquisar);
		
	}

	public Pane getPane() {
		return pane;
	}

}
