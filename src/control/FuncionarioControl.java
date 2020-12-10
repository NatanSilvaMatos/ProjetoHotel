package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dao.FuncionarioDao;
import entity.Funcionario;

public class FuncionarioControl {

	FuncionarioDao funcDao = new FuncionarioDao();

	public void adicionar(Funcionario funcionario) {
		funcDao.Insert(funcionario);
	}
	
	public void atualizar(Funcionario funcionario) {
		funcDao.Update(funcionario);
	}
	
	public void desativar(long cpf) {
		funcDao.Delete(cpf);
	}

	public ObservableList<Funcionario> getListaAtivos() {
		ObservableList<Funcionario> obsFuncionarios = FXCollections.observableArrayList();
		obsFuncionarios.addAll(funcDao.Pesquisa());
		return obsFuncionarios;
	}

	public ObservableList<Funcionario> getLista() {
		ObservableList<Funcionario> obsFuncionarios = FXCollections.observableArrayList();
		obsFuncionarios.addAll(funcDao.Pesquisa());
		return obsFuncionarios;
	}

	public ObservableList<Funcionario> getListaEspecifica(long cpf) {
		ObservableList<Funcionario> obsFuncionarios = FXCollections.observableArrayList();
		obsFuncionarios.addAll(funcDao.PesquisaCpf(cpf));
		return obsFuncionarios;
	}

}
