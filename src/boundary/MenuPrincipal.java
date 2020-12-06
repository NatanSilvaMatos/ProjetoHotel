package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuPrincipal extends Application {
	private BorderPane pane = new BorderPane();
	private Scene scene = new Scene(pane, 800, 600); 
	private MenuBar barraMenu = new MenuBar();
	private Menu menu = new Menu("Menu");
	private MenuItem novaReserva = new MenuItem("Nova Reserva");
	private MenuItem novoHospede = new MenuItem("Novo Hospede");
	private MenuItem todasAsReservas = new MenuItem("Todas as Reservas");
	private MenuItem quartosDisponiveis = new MenuItem("Quartos Disponiveis");
	private MenuItem minhasReservas = new MenuItem("Minhas Reservas");
	private MenuItem pagamentos = new MenuItem("Pagamentos");
	private MenuItem sair = new MenuItem("Sair");
	
	@Override
	public void start(Stage stage) throws Exception {
		pane.setTop(barraMenu);
		barraMenu.getMenus().addAll(menu);
		menu.getItems().addAll(novaReserva,novoHospede,todasAsReservas,quartosDisponiveis,minhasReservas,pagamentos,sair);
		stage.setScene(scene);
		stage.setTitle("Menu Principal");
		stage.show();
	}
	
	
	public static void main(String[] args) {
		Application.launch(MenuPrincipal.class, args);
	}
}
