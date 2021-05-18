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

import unoesc.edu.aulaJSP.DAO.ProdutoDAO;
import unoesc.edu.aulaJSP.model.Produto;

//@Controller
public class ProdutosController {
	
	//@Autowired
	private ProdutoDAO produtoDao;
	

	//@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public String rootPage(Model model, HttpSession session) {

		List<Produto> listaProduto = this.produtoDao.getAllProdutos();
		System.out.println(listaProduto);

		model.addAttribute("listClientas", listaProduto);
		model.addAttribute("produto", new Produto());

		return "produtoCrud";
	}

	//@RequestMapping(value = "/produtoSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("produto") Produto produto, HttpSession session) {
		

		if (produto.getId() == 0) {
			this.produtoDao.insertProduto(produto);
		} else {
			//Produto c = this.produtoDao.getProdutoById(produto.getId());
			//c.setNome(produto.getNome());
			//c.setSobrenome(produto.getSobrenome());
			this.produtoDao.updateProduto(produto);
		}
		System.out.println("Salvou: " + produto.getName());

		return "redirect:/produtos";
	}

	@RequestMapping(value = "/produtoEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		List<Produto> produtos = this.produtoDao.getAllProdutos();

		Produto c = this.produtoDao.getProdutoById(id);

		model.addAttribute("listClientas", produtos);
		model.addAttribute("produto", c);

		return "produtoCrud";
	}
	
	//@RequestMapping(value = "/produtoDel/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model) {
		

		Produto c = this.produtoDao.getProdutoById(id);

		this.produtoDao.deleteProduto(c);

		return "redirect:/produtos";
	}

	public ProdutoDAO getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDAO produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	

}
