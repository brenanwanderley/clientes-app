package com.brenan.exemplo.service;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.brenan.exemplo.dao.ClienteDao;
import com.brenan.exemplo.model.Cliente;

public class ClienteService {

    private ClienteDao clienteDao;

    public ClienteService() {
        this.clienteDao = new ClienteDao();
    }

    public List<Cliente> listarTodos() {
        return clienteDao.listarTodos();
    }

    public String criarCliente(Cliente cliente) {
        try {
            clienteDao.criar(cliente);
            return "listarClientes.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error creating client", e.getMessage()));
            return null;
        }
    }

    public String deletarCliente(Long clienteId) {
        try {
            if (clienteDao.isClienteIdPresent(clienteId)) {
                clienteDao.deletar(clienteId);
                return "clientesList.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Client not found", "ID: " + clienteId));
                return null;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting client", e.getMessage()));
            return null;
        }
    }

    public String atualizarCliente(Long clienteId, String updatedClienteName) {
        try {
            if (clienteDao.isClienteIdPresent(clienteId)) {
                clienteDao.atualizar(clienteId, updatedClienteName);
                FacesContext.getCurrentInstance().addMessage("editClienteForm:clienteId", new FacesMessage("Cliente Record #" + clienteId + " Is Successfully Updated In Db"));
                return "clienteEdicao.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Client not found", "ID: " + clienteId));
                return null;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating client", e.getMessage()));
            return null;
        }
    }

    public Cliente buscarPorId(Long clienteId) {
        try {
            Cliente cliente = clienteDao.buscarPorId(clienteId);
            if (cliente != null) {
                return cliente;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Client not found", "ID: " + clienteId));
                return null;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error fetching client", e.getMessage()));
            return null;
        }
    }
    
    public Cliente existeEmail(String email) {
    	return clienteDao.existeEmail(email);
    }
}
