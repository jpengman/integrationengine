package se.anviken.integrationengine.mowerdbservice;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.camel.Exchange;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.anviken.integrationengine.mowerdbservice.model.Mower;

@Stateless
public class LogMowerStatusProcessor {

	@PersistenceContext(unitName = "MowerDBService-persistence-unit")
	private EntityManager em;

	public void process(Exchange exchange) throws Exception {
		String jsonString = (String) exchange.getIn().getBody();
		ObjectMapper mapper = new ObjectMapper();
		se.anviken.integrationengine.mower.json.MowerStatus jsonStatus = mapper.readValue(jsonString,
				se.anviken.integrationengine.mower.json.MowerStatus.class);

		TypedQuery<Mower> query = em.createNamedQuery("Mower.findAll", Mower.class);
		Mower mower = null;
		for (Mower queryMower : query.getResultList()) {
			if (queryMower.getRestServiceId().equals(jsonStatus.getId())) {
				mower = queryMower;
			}
		}
		if (mower == null) {
			mower = new Mower();
			mower.setModel(jsonStatus.getModel());
			mower.setMoverName(jsonStatus.getName());
			mower.setRestServiceId(jsonStatus.getId());
		}
		em.persist(mower);

		exchange.getOut().setBody(jsonStatus);
	}

	private EntityManager initializeEM() throws NamingException {
		Context iCtx = new InitialContext();
		String lookUpString = "java:/MowerDBManager";
		javax.persistence.EntityManager entityManager = (javax.persistence.EntityManager) iCtx.lookup(lookUpString);
		return entityManager;
	}

}
