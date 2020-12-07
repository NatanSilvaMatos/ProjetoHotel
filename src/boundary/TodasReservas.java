package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TodasReservas extends Application {
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
		
		voltar.setLayoutX(350);
		voltar.setLayoutY(500);
		voltar.setPrefWidth(100);
		
		
		pane.getChildren().addAll(table, voltar);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(TodasReservas.class,args);
	}

}
