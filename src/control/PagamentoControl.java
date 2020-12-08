package control;

import dao.PagamentoDao;
import entity.Hospede;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entity.Pagamento;

public class PagamentoControl {

	PagamentoDao pagDao = new PagamentoDao();

	public void adicionar(Pagamento pagamento) {
		pagDao.Insert(pagamento);

	}

	public ObservableList<Pagamento> getLista() {
		ObservableList<Pagamento> obsPagamentos = FXCollections.observableArrayList();
		obsPagamentos.addAll(pagDao.Pesquisa());
		return obsPagamentos;
	}

	public Hospede getHospede(String cpf) {
		return null;
	}
}
