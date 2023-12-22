package com.example;

import com.example.model.Cat;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DatabaseResource {

	@PersistenceContext(name="patatas")
	private EntityManager entityManager;

	@Transactional
	public void addCat(String name) {
		Cat cat = new Cat();
		cat.setName(name);
		entityManager.persist(cat);
	}

	public List<Cat> getAllCats() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cat> cq = cb.createQuery(Cat.class);
		Root<Cat> rootEntry = cq.from(Cat.class);
		CriteriaQuery<Cat> all = cq.select(rootEntry);

		TypedQuery<Cat> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

}
