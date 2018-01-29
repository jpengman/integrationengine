package se.anviken.integrationengine.mowerdbservice.persistence;

import se.anviken.integrationengine.mowerdbservice.model.Mower;

public interface PersistenceManager {

	public Mower doGetMower(String mowerID);

}
