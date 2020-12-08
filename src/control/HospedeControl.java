package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dao.HospedeDao;
import entity.Hospede;

public class HospedeControl {

	HospedeDao hospDao = new HospedeDao();

	public void adicionar(Hospede hospede) {
		hospDao.Insert(hospede);
	}

	public void atualizar(Hospede hospede) {
		hospDao.update(hospede);
	}

	public void desativar(int cpf) {
		hospDao.delete(cpf);
	}

	public ObservableList<Hospede> getLista() {
		ObservableList<Hospede> obsHospedes = FXCollections.observableArrayList();
		obsHospedes.addAll(hospDao.Pesquisa());
		return obsHospedes;
	}

	public ObservableList<Hospede> getListaEspecifica(int cpf) {
		ObservableList<Hospede> obsHospedes = FXCollections.observableArrayList();
		obsHospedes.addAll(hospDao.PesquisaCpf(cpf));
		return obsHospedes;
	}

}
