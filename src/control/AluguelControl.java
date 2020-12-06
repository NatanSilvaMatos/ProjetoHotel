package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import entity.Aluguel;
import entity.Hospede;
import entity.Quarto;

public class AluguelControl {

	public void adicionar(Aluguel aluguel) {

	}

	public ObservableList<Aluguel> getLista() {
		ObservableList<Aluguel> obsAluguel = FXCollections.observableArrayList();
//        obsFuncionarios.addAll(funcDao.getAll());
		return obsAluguel;
	}

	public Hospede getHospede(String cpf) {
		return null;
	}

	public List<Quarto> getAllQuartos() {
		return null;
	}
}
