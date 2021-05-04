package unoesc.edu.aulaJSP.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.websocket.Session;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(path = "/cliente", method = RequestMethod.GET)
	public String acessoCliente(Model model, HttpSession session) {
		System.out.println("CHamou CLiente!");
		
		List<Cliente> listaCliente = clienteDao.getClientes();
		
		model.addAttribute("listaCliente", listaCliente);
		Cliente c = new Cliente();
		model.addAttribute("cliente", c);
	  	
		
		
		return "clienteCrud";
	}
	
	@RequestMapping(path = "clienteSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("cliente") Cliente cli, HttpSession session) {
		
		if (cli.getId() == 0) {
			clienteDao.insertCliente(cli);
		}else {
			Cliente c = (Cliente) clienteDao.getClienteById(cli.getId());
			c.setNome(cli.getNome());
			c.setSobrenome(cli.getSobrenome());
			clienteDao.updateCliente(c);
		}
		
		return "redirect:/cliente";
	}
	
	@RequestMapping(path = "clienteEdit/{id}", method = RequestMethod.GET )
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		

	  	List<Cliente> listaCliente = clienteDao.getClientes();
		model.addAttribute("listaCliente", listaCliente);
		
		Cliente c = clienteDao.getClienteById(id);
		model.addAttribute("cliente", c);
		
		return "clienteCrud";
	}

}
