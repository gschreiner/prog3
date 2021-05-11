package unoesc.edu.aulaJSP.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import unoesc.edu.aulaJSP.DAO.ClienteDAO;
import unoesc.edu.aulaJSP.model.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDao;
	

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String rootPage(Model model, HttpSession session) {

		List<Cliente> listaCliente = this.clienteDao.getAllClientes();
		System.out.println(listaCliente);

		model.addAttribute("listClientas", listaCliente);
		model.addAttribute("cliente", new Cliente());

		return "clienteCrud";
	}

	@RequestMapping(value = "/clienteSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("cliente") Cliente cliente, HttpSession session) {
		

		if (cliente.getId() == 0) {
			this.clienteDao.insertCliente(cliente);
		} else {
			//Cliente c = this.clienteDao.getClienteById(cliente.getId());
			//c.setNome(cliente.getNome());
			//c.setSobrenome(cliente.getSobrenome());
			this.clienteDao.updateCliente(cliente);
		}
		System.out.println("Salvou: " + cliente.getNome());

		return "redirect:/clientes";
	}

	@RequestMapping(value = "/clienteEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		List<Cliente> clientes = this.clienteDao.getAllClientes();

		Cliente c = this.clienteDao.getClienteById(id);

		model.addAttribute("listClientas", clientes);
		model.addAttribute("cliente", c);

		return "clienteCrud";
	}
	
	@RequestMapping(value = "/clienteDel/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model) {
		

		Cliente c = this.clienteDao.getClienteById(id);

		this.clienteDao.deleteCliente(c);

		return "redirect:/clientes";
	}

	public ClienteDAO getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	

}
