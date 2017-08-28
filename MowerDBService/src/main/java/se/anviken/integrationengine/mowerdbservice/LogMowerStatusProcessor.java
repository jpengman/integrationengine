package se.anviken.integrationengine.mowerdbservice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.anviken.integrationengine.mowerdbservice.model.Mower;

public class LogMowerStatusProcessor implements Processor {

	@PersistenceContext(unitName = "MowerDBService-persistence-unit")
	private EntityManager em;

	@Override
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
}
