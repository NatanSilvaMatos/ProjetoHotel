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

public class QuartosDisponiveis {
	private Pane pane = new Pane();
	//private Scene scene = new Scene(pane,800,600);
	private Label lblQuartos = new Label("QUARTOS DISPONIVEIS");
	private TableView<String> table = new TableView<String>();

	@SuppressWarnings("unchecked")
	//@Override
	public QuartosDisponiveis() {
		TableColumn<String,String> columnQuarto = new TableColumn<>("N.QUARTO");
		columnQuarto.setMinWidth(150);
		columnQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		TableColumn<String,String> columnAndar = new TableColumn<>("ANDAR");
		columnAndar.setMinWidth(150);
		columnAndar.setCellValueFactory(new PropertyValueFactory<>("andar"));
		
		TableColumn<String,String> columnCategoria = new TableColumn<>("CATEGORIA");
		columnCategoria.setMinWidth(150);
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		
		TableColumn<String,String> columnPrecoDiaria = new TableColumn<>("PRECO");
		columnPrecoDiaria.setMinWidth(150);
		columnPrecoDiaria.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		table.getColumns().addAll(columnQuarto,columnAndar,columnCategoria,columnPrecoDiaria);
		table.setLayoutX(90);
		table.setLayoutY(70);	
		
		lblQuartos.setLayoutX(90);
		lblQuartos.setLayoutY(30);
		lblQuartos.setStyle("-fx-font-weight: bold");
				
		pane.getChildren().addAll(table, lblQuartos);
		//stage.setScene(scene);
		//stage.show();		
	}

	public Pane getPane() {
		return pane;
	}

	//public static void main(String[] args) {
		//Application.launch(QuartosDisponiveis.class,args);
	//}
}
