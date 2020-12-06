package control;

import entity.Hospede;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entity.Pagamento;

public class PagamentoControl {
	
	public void adicionar(Pagamento pagamento) {
	       
    }
	
	public ObservableList <Pagamento> getLista() {
        ObservableList <Pagamento> obsPagamentos = FXCollections.observableArrayList();
//        obsFuncionarios.addAll(funcDao.getAll());
        return obsPagamentos;
    }
}
