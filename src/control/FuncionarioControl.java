package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entity.Funcionario;

public class FuncionarioControl {

	public void adicionar(Funcionario funcionario) {

	}

	public ObservableList<Funcionario> getListaAtivos() {
		ObservableList<Funcionario> obsFuncionarios = FXCollections.observableArrayList();
//        obsFuncionarios.addAll(funcDao.getAll());
		return obsFuncionarios;
	}

	public ObservableList<Funcionario> getLista() {
		ObservableList<Funcionario> obsFuncionarios = FXCollections.observableArrayList();
//        obsFuncionarios.addAll(funcDao.getAll());
		return obsFuncionarios;
	}
}
