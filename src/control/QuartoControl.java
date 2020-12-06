package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entity.Quarto;

public class QuartoControl {
	public void adicionar(Quarto quarto) {

	}

	public ObservableList<Quarto> getListaDisponiveis() {
		ObservableList<Quarto> obsQuartos = FXCollections.observableArrayList();
//        obsFuncionarios.addAll(funcDao.getAll());
		return obsQuartos;
	}

	public ObservableList<Quarto> getLista() {
		ObservableList<Quarto> obsQuartos = FXCollections.observableArrayList();
//        obsFuncionarios.addAll(funcDao.getAll());
		return obsQuartos;
	}

	public void ocupar(Quarto quarto) {

	}

	public void desocupar(Quarto quarto) {
	}
}
