package repository.empresa;

import java.util.List;

import model.empresa.Empresa;

public interface RepositorioEmpresa {
	
	Empresa inserirEmpresa (Empresa empresa) throws EmpresaJaCadastradaException;
	
	void alterarEmpresa (Empresa empresa) throws EmpresaNaoCadastradaException;
	
	void deletarEmpresa (Empresa empresa) throws EmpresaNaoCadastradaException;
	
	Empresa buscarEmpresa(String cnpj) throws EmpresaNaoCadastradaException;
	
	List<Empresa> getAll();
    
}
