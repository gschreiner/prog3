package unoesc.edu.aulaJSP.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import unoesc.edu.aulaJSP.model.Cliente;



@Repository
public class ClienteDAOImpl implements ClienteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Cliente getClienteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente p = (Cliente) session.get(Cliente.class, id);
		
		return p;
	}

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		
		return this.sessionFactory.getCurrentSession().createQuery("from Cliente").list();
	}

	@Override
	@Transactional
	public boolean deleteCliente(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente p = (Cliente) session.load(Cliente.class, id);
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertCliente(Cliente p) {
		
		this.sessionFactory.getCurrentSession().save(p);
		
		return false;
	}

	@Override
	@Transactional
	public boolean updateCliente(Cliente p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		return true;
	}

}
