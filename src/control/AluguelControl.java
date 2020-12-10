package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

import dao.AluguelDao;
import dao.FuncionarioDao;
import entity.Aluguel;
import entity.Hospede;
import entity.Quarto;

public class AluguelControl {
	
	AluguelDao aluDao = new AluguelDao();
	
	public void adicionar(Aluguel aluguel) {
		aluDao.Insert(aluguel);
	}
	
	public void atualizar(Aluguel aluguel) {
		aluDao.Update(aluguel);
	}
	
	public ObservableList<Aluguel> getLista() {
		ObservableList<Aluguel> obsAluguel = FXCollections.observableArrayList();
		obsAluguel.addAll(aluDao.Pesquisa());
		return obsAluguel;
	}

	public Hospede getHospede(int cpf) {
		return null;
	}

	public List<Quarto> getAllQuartos(int cpf) {
		return null;
	}
}
