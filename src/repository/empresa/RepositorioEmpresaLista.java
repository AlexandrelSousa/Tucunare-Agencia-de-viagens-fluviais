package repository.empresa;

import java.util.ArrayList;
import java.util.List;
import model.empresa.Empresa;

public class RepositorioEmpresaLista implements RepositorioEmpresa {
	
	List <Empresa> empresas;

    RepositorioEmpresaLista(){
        empresas = new ArrayList<>();
    }

    public void inserirEmpresa(Empresa empresa) throws EmpresaJaCadastradaException{
        try{
            buscarEmpresa(empresa.getCnpj());
            throw new EmpresaJaCadastradaException();
        }catch (EmpresaNaoCadastradaException ex){
            empresas.add(empresa);
        }
    }

	@Override
	public void alterarEmpresa(Empresa empresa) throws EmpresaNaoCadastradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarEmpresa(Empresa empresa) throws EmpresaNaoCadastradaException {
        if (! empresas.remove(empresa)) {
            throw new EmpresaNaoCadastradaException();
        }
        
		
	}

	@Override
	public Empresa buscarEmpresa(String cnpj) throws EmpresaNaoCadastradaException {
		for(Empresa empresa : empresas){
            if(empresa.getCnpj() == cnpj){
                return empresa;
            }
        }
        throw new EmpresaNaoCadastradaException();
	}

	@Override
	public List<Empresa> getAll() {
		 return new ArrayList<>(empresas);
	}


}
