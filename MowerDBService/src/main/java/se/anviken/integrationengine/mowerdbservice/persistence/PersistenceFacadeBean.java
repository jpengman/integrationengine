package se.anviken.integrationengine.mowerdbservice.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import se.anviken.integrationengine.mowerdbservice.model.Mower;

@Default
@ApplicationScoped
public class PersistenceFacadeBean implements PersistenceFacade {

	@Inject
	PersistenceManager persistenceManager;

	@Override
	public Mower getMower(String mowerID) {

		return persistenceManager.doGetMower(mowerID);
	}
}
