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
import unoesc.edu.aulaJSP.DAO.PedidoDAO;
import unoesc.edu.aulaJSP.DAO.ProdutoDAO;
import unoesc.edu.aulaJSP.model.ItemPedido;
import unoesc.edu.aulaJSP.model.Pedido;

@Controller
public class PedidosController {
	
	@Autowired
	private PedidoDAO pedidoDao;
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private ClienteDAO clienteDao;
	

	@RequestMapping(value = "/pedidos", method = RequestMethod.GET)
	public String rootPage(Model model, HttpSession session) {

		List<Pedido> listaPedido = this.pedidoDao.getAllPedidos();
		System.out.println(listaPedido);

		model.addAttribute("listPedidos", listaPedido);
		model.addAttribute("listClientes", this.clienteDao.getAllClientes());
		model.addAttribute("listProdutos", this.produtoDao.getAllProdutos());
		model.addAttribute("pedido", new Pedido());


		return "pedidoCrud";
	}

	@RequestMapping(value = "/pedidoSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("pedido") Pedido pedido, HttpSession session) {
		

		if (pedido.getId() == 0) {
			this.pedidoDao.insertPedido(pedido);
		} else {
			//Pedido c = this.pedidoDao.getPedidoById(pedido.getId());
			//c.setNome(pedido.getNome());
			//c.setSobrenome(pedido.getSobrenome());
			this.pedidoDao.updatePedido(pedido);
		}

		return "redirect:/pedidos";
	}
	
	
	@RequestMapping(value = "/addPedido", method = RequestMethod.POST)
	public String addPedido(@ModelAttribute("itemPedido") ItemPedido item, @ModelAttribute("pedido") Pedido pedido,Model model, HttpSession session) {
		item.setPedido(pedido);
		pedido.getItems().add(item);
		
		
		pedidoDao.insertItensPedido(pedido);
		
		model.addAttribute("listPedidos", this.pedidoDao.getAllPedidos());
		model.addAttribute("listClientes", this.clienteDao.getAllClientes());
		model.addAttribute("listProdutos", this.produtoDao.getAllProdutos());
		model.addAttribute("pedido", pedido);
		model.addAttribute("itemPedido", new ItemPedido());

		return "redirect:/pedidoEditItens/"+pedido.getId();
	}
	
	

	@RequestMapping(value = "/pedidoEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		List<Pedido> pedidos = this.pedidoDao.getAllPedidos();

		Pedido c = this.pedidoDao.getPedidoById(id);

		model.addAttribute("listPedidos", pedidos);
		model.addAttribute("listClientes", this.clienteDao.getAllClientes());
		model.addAttribute("listProdutos", this.produtoDao.getAllProdutos());
		model.addAttribute("pedido", c);
		//model.addAttribute("itemPedido", new ItemPedido());

		return "pedidoCrud";
	}
	
	@RequestMapping(value = "/pedidoEditItens/{id}", method = RequestMethod.GET)
	public String editItens(@PathVariable int id, Model model, HttpSession session) {
		List<Pedido> pedidos = this.pedidoDao.getAllPedidos();

		Pedido c = this.pedidoDao.getPedidoById(id);

		model.addAttribute("listProdutos", this.produtoDao.getAllProdutos());
		model.addAttribute("listClientes", this.clienteDao.getAllClientes());
		model.addAttribute("pedido", c);
		model.addAttribute("itemPedido", new ItemPedido());

		return "pedidoItensCrud";
	}
	
	@RequestMapping(value = "/pedidoDel/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model) {
		

		Pedido c = this.pedidoDao.getPedidoById(id);

		this.pedidoDao.deletePedido(c);

		return "redirect:/pedidos";
	}

	public PedidoDAO getPedidoDao() {
		return pedidoDao;
	}

	public void setPedidoDao(PedidoDAO pedidoDao) {
		this.pedidoDao = pedidoDao;
	}
	
	

}
