package com.brenan.exemplo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.validation.constraints.Email;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "O nome é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
	private String nome;

	@NotNull(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
	@Column(unique = true)
	private String email;

	@NotNull
	@Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres.")
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;

	public Cliente() {

	}

	public Cliente(Long id, String nome, String email, String telefone, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	/*
	 * public Cliente(Long id, String nome, String email, String telefone, String
	 * cep, String endereco, String bairro, String cidade, String estado) { super();
	 * this.id = id; this.nome = nome; this.email = email; this.telefone = telefone;
	 * this.cep = cep; this.endereco = endereco; this.bairro = bairro; this.cidade =
	 * cidade; this.estado = estado; }
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}