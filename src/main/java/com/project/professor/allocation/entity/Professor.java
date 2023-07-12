package com.project.professor.allocation.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Professor")
public class Professor {

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;

	@Column(name = "id")
	private Long id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
