package boundary;

import java.time.LocalDate;

import control.AluguelControl;
import entity.Aluguel;
import entity.Categoria;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class Alugueis {
	private Pane pane = new Pane();
	private Label lblAlugueis = new Label("ALUGUEIS");
	private TableView<Aluguel> table = new TableView<Aluguel>();
	private AluguelControl listaAluguel = new AluguelControl();
	
	
	@SuppressWarnings("unchecked")
	public Alugueis() {
		TableColumn<Aluguel,Integer> columnQuarto = new TableColumn<>("N.QUARTO");
		columnQuarto.setMinWidth(120);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		TableColumn<Aluguel,Integer> columnAndar = new TableColumn<>("ANDAR");
		columnAndar.setMinWidth(120);
		columnAndar.setCellValueFactory(new PropertyValueFactory<>("andar"));
		
		TableColumn<Aluguel,Categoria> columnCategoria = new TableColumn<>("CATEGORIA");
		columnCategoria.setMinWidth(120);
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		
		TableColumn<Aluguel,LocalDate> columnData = new TableColumn<>("DATA");
		columnData.setMinWidth(120);
		columnData.setCellValueFactory(new PropertyValueFactory<>("disponibilidade"));
		
		TableColumn<Aluguel,Double> columnPrecoDiaria = new TableColumn<>("PRECO(DIARIA)");
		columnPrecoDiaria.setMinWidth(120);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		TableColumn<Aluguel,Integer> columnCPFHospede = new TableColumn<>("CPF HOSPEDE");
		columnCPFHospede.setMinWidth(120);
		columnCPFHospede.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		
		table.getColumns().addAll(columnData);
		table.setLayoutX(40);
		table.setLayoutY(70);
		table.setItems(listaAluguel.getLista());
		
		lblAlugueis.setLayoutX(40);
		lblAlugueis.setLayoutY(30);
		lblAlugueis.setStyle("-fx-font-weight: bold");
		
		pane.getChildren().addAll(table,lblAlugueis);
		
	}
	public Pane getPane() {
		return pane;
	}
	
}
