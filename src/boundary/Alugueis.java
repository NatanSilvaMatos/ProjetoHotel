package boundary;

import entity.Aluguel;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class Alugueis {
	private Pane pane = new Pane();
	private Label lblAlugueis = new Label("ALUGUEIS");
	private TableView<Aluguel> table = new TableView<Aluguel>();
	
	
	@SuppressWarnings("unchecked")
	public Alugueis() {
		TableColumn<Aluguel,String> columnQuarto = new TableColumn<>("N.QUARTO");
		columnQuarto.setMinWidth(120);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		TableColumn<Aluguel,String> columnAndar = new TableColumn<>("ANDAR");
		columnAndar.setMinWidth(120);
		columnAndar.setCellValueFactory(new PropertyValueFactory<>("andar"));
		
		TableColumn<Aluguel,String> columnCategoria = new TableColumn<>("CATEGORIA");
		columnCategoria.setMinWidth(120);
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		
		TableColumn<Aluguel,String> columnDisponibilidade = new TableColumn<>("DISPONIBILIDADE");
		columnDisponibilidade.setMinWidth(120);
		columnDisponibilidade.setCellValueFactory(new PropertyValueFactory<>("disponibilidade"));
		
		TableColumn<Aluguel,String> columnPrecoDiaria = new TableColumn<>("PRECO(DIARIA)");
		columnPrecoDiaria.setMinWidth(120);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		TableColumn<Aluguel,String> columnCPFHospede = new TableColumn<>("CPF HOSPEDE");
		columnCPFHospede.setMinWidth(120);
		columnCPFHospede.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		
		table.getColumns().addAll(columnQuarto,columnAndar,columnCategoria,columnDisponibilidade,columnPrecoDiaria,columnCPFHospede);
		table.setLayoutX(40);
		table.setLayoutY(70);
		
		lblAlugueis.setLayoutX(40);
		lblAlugueis.setLayoutY(30);
		lblAlugueis.setStyle("-fx-font-weight: bold");
		
		pane.getChildren().addAll(table,lblAlugueis);
		
	}
	public Pane getPane() {
		return pane;
	}
	
}
