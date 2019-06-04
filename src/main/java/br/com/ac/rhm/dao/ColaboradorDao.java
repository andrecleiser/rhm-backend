package br.com.ac.rhm.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.ac.rhm.entidades.Colaborador;

public class ColaboradorDao {

	@Inject
	private EntityManager em;

	public List<Colaborador> listar() {

		CriteriaQuery<Colaborador> query = em.getCriteriaBuilder().createQuery(Colaborador.class);
		query.select(query.from(Colaborador.class));

		List<Colaborador> lista = em.createQuery(query).getResultList();

		return lista;
	}

	public Colaborador incluir(Colaborador colaborador) {
		this.em.getTransaction().begin();
		this.em.persist(colaborador);
		this.em.getTransaction().commit();
		
		return colaborador;
	}

	public void atualizar(Long idColaborador, Colaborador colaborador) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(colaborador);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			this.em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public Colaborador buscarPorId(Long id) {
		return this.em.find(Colaborador.class, id);
	}

	public void excluir(Long idColaborador) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(this.buscarPorId(idColaborador));
			this.em.getTransaction().commit();

		} catch (Exception e) {
			this.em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
}
