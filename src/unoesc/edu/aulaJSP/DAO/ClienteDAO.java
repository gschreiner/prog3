package unoesc.edu.aulaJSP.DAO;

import java.util.List;

import unoesc.edu.aulaJSP.model.Cliente;

public interface ClienteDAO {

	Cliente getClienteById (int id);
	List<Cliente> getClientes();
	boolean deleteCliente(int id);
	boolean insertCliente(Cliente p);
	boolean updateCliente(Cliente p);
	
}
