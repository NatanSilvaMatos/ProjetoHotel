package control;

import dao.PagamentoDao;
import entity.AluguelQuarto;
import entity.Hospede;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entity.Pagamento;

public class PagamentoControl {

	PagamentoDao pagDao = new PagamentoDao();

	public void adicionar(Pagamento pagamento) {
		pagDao.Insert(pagamento);

	}

	public ObservableList<Pagamento> getListaPagamentos() {
		ObservableList<Pagamento> obsPagamentos = FXCollections.observableArrayList();
		obsPagamentos.addAll(pagDao.Pesquisa());
		return obsPagamentos;
	}

	public ObservableList<Pagamento> getListaPagamentosCpf(long cpf) {
		ObservableList<Pagamento> obsPagamentos = FXCollections.observableArrayList();
		obsPagamentos.addAll(pagDao.PesquisaporCpf(cpf));
		return obsPagamentos;
	}
	
	public ObservableList<AluguelQuarto> getListaListaAlugueis() {
		ObservableList<AluguelQuarto> obsPagamentos = FXCollections.observableArrayList();
		obsPagamentos.addAll(pagDao.pesquisaAlugueis());
		return obsPagamentos;
	}
	
	public ObservableList<AluguelQuarto> getListaListaAlugueisCPF(long cpf) {
		ObservableList<AluguelQuarto> obsPagamentos = FXCollections.observableArrayList();
		obsPagamentos.addAll(pagDao.pesquisaAlugueisCPF(cpf));
		return obsPagamentos;
	}
	

	public Hospede getHospede(long cpf) {
		return null;
	}
}
