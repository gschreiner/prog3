package unoesc.edu.aulaJSP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {
	
	@Id
	@GeneratedValue(generator = "seq_pk_clientes", strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name="sobre_nome")
	private String sobrenome;
	
	
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
