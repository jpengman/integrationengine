package se.anviken.integrationengine.mowerlogger.utils;

import java.util.Date;

import se.anviken.integrationengine.mowerlogger.json.getmowers.Status;
import se.anviken.integrationengine.mowerlogger.model.Mower;
import se.anviken.integrationengine.mowerlogger.model.MowerStatus;

public class MappingUtil {

	public static MowerStatus getMowerStatus(Mower mower,
			se.anviken.integrationengine.mowerlogger.json.getmowers.Mower mj) {
		MowerStatus ms = new MowerStatus();
		ms.setMower(mower);
		Status s = mj.getStatus();
		ms.setBatteryPerrcent(s.getBatteryPercent());
		ms.setCached_Settings_UUID(s.getCachedSettingsUUID());
		ms.setConnected(s.getConnected());
		ms.setNextStartTimestamp(new Date(s.getNextStartTimestamp()));
		// TODO ms.setOperatingModeId(operatingModeId);
		// TODO ms.setRefStartSource(refStartSource);
		// TODO ms.setRefStatus(refStatus);
		ms.setStoredTimestamp(new Date());
		ms.setValueFound(s.getValueFound());
		return ms;
	}
}
