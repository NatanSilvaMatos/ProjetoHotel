package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dao.PagamentoDao;
import dao.QuartoDao;
import entity.Quarto;

public class QuartoControl {

	QuartoDao quaDao = new QuartoDao();

	public void adicionar(Quarto quarto) {
		quaDao.Insert(quarto);
	}

	public ObservableList<Quarto> getListaDisponiveis() {
		ObservableList<Quarto> obsQuartos = FXCollections.observableArrayList();
		obsQuartos.addAll(quaDao.Pesquisa());
		return obsQuartos;
	}

	public ObservableList<Quarto> getLista() {
		ObservableList<Quarto> obsQuartos = FXCollections.observableArrayList();
		obsQuartos.addAll(quaDao.Pesquisa());
		return obsQuartos;
	}

	public ObservableList<Quarto> getListaEspecifico(int quarto) {
		ObservableList<Quarto> obsQuartos = FXCollections.observableArrayList();
		obsQuartos.addAll(quaDao.PesquisaNumQuarto(quarto));
		return obsQuartos;
	}

	public void ocupar(Quarto quarto) {
		quaDao.Update(quarto);
	}

	public void desocupar(Quarto quarto) {
		quaDao.Update(quarto);
	}
	
}
