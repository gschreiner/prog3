package unoesc.edu.aulaJSP.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class Cliente  implements Serializable {
	private int id;
	private String nome;
	private String sobrenome;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNasc;
	
	
	
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Cliente() {
		this.id = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
