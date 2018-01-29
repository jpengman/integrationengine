package se.anviken.integrationengine.mowerdbservice.persistence;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import se.anviken.integrationengine.mowerdbservice.model.Mower;

@RequestScoped
public class PersistenceManagerBean implements PersistenceManager {

	@PersistenceContext(unitName = "MowerDBService-persistence-unit")
	private EntityManager em;

	@Override
	public Mower doGetMower(String mowerID) {
		TypedQuery<Mower> query = em.createNamedQuery("Mower.findAll", Mower.class);
		return query.getSingleResult();
	}
}
