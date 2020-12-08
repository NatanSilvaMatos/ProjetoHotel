package boundary;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class MenuPrincipal {
	public static BorderPane pane = new BorderPane();
	//private Scene scene = new Scene(pane, 800, 600); 
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
	private String tipoUsuario;
	private int cpf;
	
	public MenuPrincipal(String tipoUsuario, int cpf) {
		this.tipoUsuario = tipoUsuario;
		this.cpf = cpf;
	}
	
	public BorderPane chamaTela()  {
		if(tipoUsuario == "Hóspede") {
			menu.getItems().addAll(quartosDisponiveis,meusAlugueis,sair);
		}
		else {
			menu.getItems().addAll(quartosDisponiveis,novoAluguel,novoCadastro,todosOsAlugueis,pagamentos,sair);
		}
		pane.setTop(barraMenu);
		barraMenu.getMenus().addAll(menu);
		pane.setStyle("-fx-background-color: white;");
		
		pane.setCenter(telaQuartosDisponiveis.getPane());
		
		
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
		return pane;				
	}
}
