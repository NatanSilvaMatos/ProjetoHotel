package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MinhasReservas extends Application {
	private Pane pane = new Pane();
	private Scene scene = new Scene(pane,800,600);
	private Button voltar = new Button("Voltar");
	private TableView<String> table = new TableView<String>();

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
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
		
		voltar.setLayoutX(350);
		voltar.setLayoutY(500);
		voltar.setPrefWidth(100);
				
		pane.getChildren().addAll(table, voltar);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(MinhasReservas.class,args);
	}
	

	

}
