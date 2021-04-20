package unoesc.edu.aulaJSP.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import unoesc.edu.aulaJSP.model.Cliente;

@Controller
public class ClienteController {

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String rootPage(Model model, HttpSession session) {

		LinkedList<Cliente> listaCliente;

		if (session.getAttribute("listClientes") == null) {
			listaCliente = new LinkedList();
			session.setAttribute("listClientes", listaCliente);
		} else
			listaCliente = (LinkedList) session.getAttribute("listClientes");

		model.addAttribute("listClientas", listaCliente);
		model.addAttribute("cliente", new Cliente());

		return "clienteCrud";
	}

	@RequestMapping(value = "/clienteSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("cliente") Cliente cliente, HttpSession session) {
		LinkedList<Cliente> clientes;
		clientes = (LinkedList<Cliente>) session.getAttribute("listClientes");

		if (cliente.getId() == 0) {
			clientes.add(cliente);
			cliente.setId(clientes.size());
		} else {
			Cliente c = clientes.get(cliente.getId() - 1);
			c.setNome(cliente.getNome());
			c.setSobrenome(cliente.getSobrenome());
		}
		System.out.println("Salvou: " + cliente.getNome());

		return "redirect:/clientes";
	}

	@RequestMapping(value = "/clienteEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		LinkedList<Cliente> clientes;
		clientes = (LinkedList<Cliente>) session.getAttribute("listClientes");

		Cliente c = clientes.get(id - 1);

		model.addAttribute("listaCliente", clientes);
		model.addAttribute("cliente", c);

		return "clienteCrud";
	}

}
