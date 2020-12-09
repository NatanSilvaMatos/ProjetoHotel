package control;

import dao.CartaoDebitoDao;
import entity.Cartao;
import entity.CartaoCredito;
import entity.CartaoDebito;
import entity.Hospede;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CartaoDebitoControl {

	CartaoDebitoDao debitoDao = new CartaoDebitoDao();

	public void adicionarDebito(Hospede hospede, CartaoDebito debito) {
		debitoDao.Insert(hospede, debito);
	}

	public void atualizarDebito(Hospede hospede, CartaoDebito debito) {
		debitoDao.Update(hospede, debito);
	}

	public void desativarDebito(int cod) {
		debitoDao.Delete(cod);
	}

	public ObservableList<Cartao> getListaDebito(Hospede hospede) {
		ObservableList<Cartao> obsCartoesDebito = FXCollections.observableArrayList();
		obsCartoesDebito.addAll(debitoDao.Pesquisa(hospede));
		return obsCartoesDebito;
	}

}
