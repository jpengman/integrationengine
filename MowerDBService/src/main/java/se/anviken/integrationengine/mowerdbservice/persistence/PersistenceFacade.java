/**
 *
 */
package se.anviken.integrationengine.mowerdbservice.persistence;

import se.anviken.integrationengine.mowerdbservice.model.Mower;

public interface PersistenceFacade {
	public Mower getMower(String mowerID);
}
