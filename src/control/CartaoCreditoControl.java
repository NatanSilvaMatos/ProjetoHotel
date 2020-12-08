package control;

import dao.CartaoCreditoDao;
import entity.Cartao;
import entity.CartaoCredito;
import entity.Hospede;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CartaoCreditoControl {
	CartaoCreditoDao creditoDao = new CartaoCreditoDao();

	public void adicionarCredito(Hospede hospede, CartaoCredito credito) {
		creditoDao.Insert(hospede, credito);
	}

	public void atualizarCredito(Hospede hospede, CartaoCredito credito) {
		creditoDao.Update(hospede, credito);
	}

	public void desativarCredito(int cod) {
		creditoDao.Delete(cod);
	}

	public ObservableList<Cartao> getListaCredito(Hospede hospede) {
		ObservableList<Cartao> obsCartoesCredito = FXCollections.observableArrayList();
		obsCartoesCredito.addAll(creditoDao.Pesquisa(hospede));
		return obsCartoesCredito;
	}

	public void ativarCredito(Hospede hospede, CartaoCredito credito) {
		creditoDao.Update(hospede, credito);
	}

	public void desativarCredito(Hospede hospede, CartaoCredito credito) {
		creditoDao.Update(hospede, credito);
	}

}
