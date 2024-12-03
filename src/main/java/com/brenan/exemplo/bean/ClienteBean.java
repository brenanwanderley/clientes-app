package com.brenan.exemplo.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.brenan.exemplo.model.Cliente;
import com.brenan.exemplo.model.Endereco;
import com.brenan.exemplo.service.ClienteService;
import com.brenan.exemplo.service.ViaCepService;

@ManagedBean
@SessionScoped
public class ClienteBean {

	private Cliente cliente;
	private Endereco endereco;
	private List<Cliente> clientes;

	private final ClienteService clienteService;
	private final ViaCepService viaCepService;

	public ClienteBean() {
		this.clienteService = new ClienteService();
		this.viaCepService = new ViaCepService();
	}

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		endereco = new Endereco();
	}

	// Getters e Setters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Cliente> listarTodos() {
		clientes = clienteService.listarTodos();
		return clientes;
	}

	public String saveOrUpdate() {

		cliente.setEndereco(endereco);
		clienteService.criarCliente(cliente);
		cliente = new Cliente();
		endereco = new Endereco();
		return "listarClientes.xhtml?faces-redirect=true";

	}

	public String editCliente(Long clienteId) {
		cliente = clienteService.buscarPorId(clienteId);
		endereco = cliente.getEndereco();
		return "cadastroCliente.xhtml";
	}

	public String deleteCliente(Long clienteId) {
		clienteService.deletarCliente(clienteId);
		return "listarClientes.xhtml?faces-redirect=true";
	}

	public void buscarEnderecoPorCep() {
		//System.out.print("entrou consulta cep");
		if (endereco.getCep() != null && endereco.getCep().length() > 0) {
			try {
				endereco = viaCepService.consultarEnderecoPorCep(endereco.getCep());
			} catch (Exception e) {
				endereco = new Endereco();
			}
		}

	}
}
