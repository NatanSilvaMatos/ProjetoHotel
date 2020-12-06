package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entity.Hospede;

public class HospedeControl {

	public void adicionar(Hospede hospede) {

	}

	public ObservableList<Hospede> getLista() {
		ObservableList<Hospede> obsHospedes = FXCollections.observableArrayList();
//        obsFuncionarios.addAll(funcDao.getAll());
		return obsHospedes;
	}

}
