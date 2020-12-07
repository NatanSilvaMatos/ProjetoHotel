package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TodasReservas  {
	private Pane pane = new Pane();
	//private Scene scene = new Scene(pane,800,600);
	private Label lblTodasAsReservas = new Label("TODAS AS RESERVAS");
	private TableView<String> table = new TableView<String>();
	
	
	@SuppressWarnings("unchecked")
	//@Override
	public TodasReservas() {
		TableColumn<String,String> columnQuarto = new TableColumn<>("N.QUARTO");
		columnQuarto.setMinWidth(120);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		TableColumn<String,String> columnAndar = new TableColumn<>("ANDAR");
		columnAndar.setMinWidth(120);
		columnAndar.setCellValueFactory(new PropertyValueFactory<>("andar"));
		
		TableColumn<String,String> columnCategoria = new TableColumn<>("CATEGORIA");
		columnCategoria.setMinWidth(120);
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		
		TableColumn<String,String> columnDisponibilidade = new TableColumn<>("DISPONIBILIDADE");
		columnDisponibilidade.setMinWidth(120);
		columnDisponibilidade.setCellValueFactory(new PropertyValueFactory<>("disponibilidade"));
		
		TableColumn<String,String> columnPrecoDiaria = new TableColumn<>("PRECO(DIARIA)");
		columnPrecoDiaria.setMinWidth(120);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		TableColumn<String,String> columnCPFHospede = new TableColumn<>("CPF HOSPEDE");
		columnCPFHospede.setMinWidth(120);
		columnCPFHospede.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		
		table.getColumns().addAll(columnQuarto,columnAndar,columnCategoria,columnDisponibilidade,columnPrecoDiaria,columnCPFHospede);
		table.setLayoutX(40);
		table.setLayoutY(70);
		
		lblTodasAsReservas.setLayoutX(40);
		lblTodasAsReservas.setLayoutY(30);
		
		pane.getChildren().addAll(table,lblTodasAsReservas);
		//stage.setScene(scene);
		//stage.show();
		
	}

	public Pane getPane() {
		return pane;
	}
	
	
	//public static void main(String[] args) {
		//Application.launch(TodasReservas.class,args);
	//}

}
