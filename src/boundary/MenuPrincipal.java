package boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	private MenuItem novoAluguel = new MenuItem("Novo Aluguel");
	private MenuItem novoCadastro = new MenuItem("Cadastro");
	private MenuItem todosOsAlugueis = new MenuItem("Alugueis");
	private MenuItem quartosDisponiveis = new MenuItem("Quartos Disponiveis");
	private MenuItem meusAlugueis = new MenuItem("Meus Alugueis");
	private MenuItem pagamentos = new MenuItem("Pagamentos");
	private MenuItem sair = new MenuItem("Sair");
	private QuartosDisponiveis telaQuartosDisponiveis = new QuartosDisponiveis();
	private Alugueis telaTodosAlugueis = new Alugueis();
	private Cadastro telaCadastro = new Cadastro();
	private NovoAluguel telaNovoAluguel = new NovoAluguel();
	private Pagamento telaPagamento = new Pagamento();
	private MeusAlugueis telaMinhasReservas = new MeusAlugueis();
	private Button b = new Button();
	
	@Override
	public void start(Stage stage) throws Exception {
		pane.setTop(barraMenu);
		barraMenu.getMenus().addAll(menu);
		pane.setStyle("-fx-background-color: white;");
		menu.getItems().addAll(novoAluguel,novoCadastro,todosOsAlugueis,quartosDisponiveis,meusAlugueis,pagamentos,sair);
		pane.setCenter(telaQuartosDisponiveis.getPane());
		stage.setScene(scene);
		
		todosOsAlugueis.setOnAction((event) -> {
			pane.setCenter(telaTodosAlugueis.getPane());
		});
		
		sair.setOnAction((event) -> {
			System.exit(0);
		});
		
		novoCadastro.setOnAction((event) -> {
			pane.setCenter(telaCadastro.getPane());
		});
		
		pagamentos.setOnAction((event) -> {
			pane.setCenter(telaPagamento.getPane());
		});
		
		quartosDisponiveis.setOnAction((event) -> {
			pane.setCenter(telaQuartosDisponiveis.getPane());
		});
		
		meusAlugueis.setOnAction((event) -> {
			pane.setCenter(telaMinhasReservas.getPane());
		});
		
		novoAluguel.setOnAction((event) -> {
			pane.setCenter(telaNovoAluguel.getPane());
		});
				
		stage.setResizable(false);
		stage.setTitle("Menu Principal");
		stage.show();
	}
	
	
	public static void main(String[] args) {
		Application.launch(MenuPrincipal.class, args);
	}
}
