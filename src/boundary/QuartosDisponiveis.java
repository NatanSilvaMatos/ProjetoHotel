package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class QuartosDisponiveis extends Application {
	private Pane pane = new Pane();
	private Scene scene = new Scene(pane,800,600);
	private Button voltar = new Button("Voltar");
	private TableView<String> table = new TableView<String>();

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
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
		
		voltar.setLayoutX(350);
		voltar.setLayoutY(500);
		voltar.setPrefWidth(100);
				
		pane.getChildren().addAll(table, voltar);
		stage.setScene(scene);
		stage.show();		
	}
	
	public static void main(String[] args) {
		Application.launch(QuartosDisponiveis.class,args);
	}
}
