package control;

import entity.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entity.Aluguel;

public class AluguelControl {
	public void adicionar(Aluguel aluguel) {

	}

	public ObservableList<Aluguel> getLista() {
		ObservableList<Aluguel> obsAluguel = FXCollections.observableArrayList();
//        obsFuncionarios.addAll(funcDao.getAll());
		return obsAluguel;
	}
}
