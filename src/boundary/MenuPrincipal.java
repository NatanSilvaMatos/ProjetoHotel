package boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuPrincipal extends Application implements EventHandler<ActionEvent> {
	private BorderPane pane = new BorderPane();
	private Scene scene = new Scene(pane, 800, 600); 
	private MenuBar barraMenu = new MenuBar();
	private Menu menu = new Menu("Menu");
	private MenuItem novaReserva = new MenuItem("Nova Reserva");
	private MenuItem novoCadastro = new MenuItem("Cadastro");
	private MenuItem todasAsReservas = new MenuItem("Todas as Reservas");
	private MenuItem quartosDisponiveis = new MenuItem("Quartos Disponiveis");
	private MenuItem minhasReservas = new MenuItem("Minhas Reservas");
	private MenuItem pagamentos = new MenuItem("Pagamentos");
	private MenuItem sair = new MenuItem("Sair");
	private QuartosDisponiveis telaQuartosDisponiveis = new QuartosDisponiveis();
	private TodasReservas telaTodasReservas = new TodasReservas();
	private Cadastro telaCadastro = new Cadastro();
	private NovaReserva telaNovaReserva = new NovaReserva();
	private Pagamento telaPagamento = new Pagamento();
	private MinhasReservas telaMinhasReservas = new MinhasReservas();
	
	@Override
	public void start(Stage stage) throws Exception {
		pane.setTop(barraMenu);
		barraMenu.getMenus().addAll(menu);
		menu.setOnAction(this);
		pane.setStyle("-fx-background-color: white;");
		menu.getItems().addAll(novaReserva,novoCadastro,todasAsReservas,quartosDisponiveis,minhasReservas,pagamentos,sair);
		pane.setCenter(telaQuartosDisponiveis.getPane());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Menu Principal");
		stage.show();
	}

	@Override
	public void handle(ActionEvent e) {
		if(e.getTarget() == todasAsReservas) {
			pane.setCenter(telaTodasReservas.getPane());
		}
		if(e.getTarget() == sair) {
			System.exit(0);
		}
		if(e.getTarget() == novoCadastro) {
			pane.setCenter(telaCadastro.getPane());
		}
		if(e.getTarget() == pagamentos) {
			pane.setCenter(telaPagamento.getPane());
		}
		if(e.getTarget() == quartosDisponiveis) {
			pane.setCenter(telaQuartosDisponiveis.getPane());
		}
		if(e.getTarget() == minhasReservas) {
			pane.setCenter(telaMinhasReservas.getPane());
		}
		if(e.getTarget() == novaReserva) {
			pane.setCenter(telaNovaReserva.getPane());
		}
	}
	
	
	public static void main(String[] args) {
		Application.launch(MenuPrincipal.class, args);
	}
}
