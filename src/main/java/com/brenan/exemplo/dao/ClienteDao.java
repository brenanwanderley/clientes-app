package com.brenan.exemplo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.brenan.exemplo.model.Cliente;

public class ClienteDao {

	private EntityManager entityManager;

	public ClienteDao() {
		try {
			entityManager = LocalEntityManagerFactory.getEntityManager();
		} catch (RuntimeException ex) {
			ex.printStackTrace(System.err);
			throw ex;
		}
	}

	public void close() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
	}

	public List<Cliente> listarTodos() {
		Query queryObj = entityManager.createQuery("SELECT c FROM Cliente c");
		return queryObj.getResultList();
	}

	public Cliente criar(Cliente cliente) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(cliente);
			transaction.commit();
			return cliente;
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}

	public void deletar(Long clienteId) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Cliente cliente = entityManager.find(Cliente.class, clienteId);
			if (cliente != null) {
				entityManager.remove(cliente);
			}
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}

	public void atualizar(Long clienteId, String updatedClienteName) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Cliente cliente = entityManager.find(Cliente.class, clienteId);
			if (cliente != null) {
				cliente.setNome(updatedClienteName);
				entityManager.merge(cliente);
			}
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}

	public Cliente existeEmail(String email) {
		
		try {
			Cliente cliente = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class)
					.setParameter("email", email).getSingleResult();

			return cliente;

		} catch (Exception e) {
			return null;
		}
	}

	public boolean isClienteIdPresent(Long clienteId) {
		Cliente cliente = entityManager.find(Cliente.class, clienteId);
		return cliente != null;
	}

	public Cliente buscarPorId(Long clienteId) {
		try {
			return entityManager.find(Cliente.class, clienteId);
		} catch (RuntimeException e) {
			return null;
		}
	}
}
