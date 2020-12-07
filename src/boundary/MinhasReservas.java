package boundary;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MinhasReservas {
	private Pane pane = new Pane();
	private Label lblReserva = new Label("MINHAS RESERVAS");
	private TableView<String> table = new TableView<String>();
	

	@SuppressWarnings("unchecked")
	public MinhasReservas() {
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
		
		lblReserva.setLayoutX(50);
		lblReserva.setLayoutY(30);
		lblReserva.setStyle("-fx-font-weight: bold");
		
			
				
		pane.getChildren().addAll(table,lblReserva);
		
	}
	
	public Pane getPane() {
		return pane;
	}

}
