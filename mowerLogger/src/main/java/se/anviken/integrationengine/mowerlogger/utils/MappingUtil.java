package se.anviken.integrationengine.mowerlogger.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import se.anviken.integrationengine.mowerlogger.json.getmowers.LocationJSON;
import se.anviken.integrationengine.mowerlogger.json.getmowers.Status;
import se.anviken.integrationengine.mowerlogger.model.Location;
import se.anviken.integrationengine.mowerlogger.model.Mower;
import se.anviken.integrationengine.mowerlogger.model.MowerStatus;
import se.anviken.integrationengine.mowerlogger.model.RefStatus;

public class MappingUtil {

	public static MowerStatus getMowerStatus(Mower mower, RefStatus refStatus,
			se.anviken.integrationengine.mowerlogger.json.getmowers.MowerJSON mj) {
		MowerStatus ms = new MowerStatus();
		ms.setMower(mower);
		Status s = mj.getStatus();
		ms.setBatteryPerrcent(s.getBatteryPercent());
		ms.setCached_Settings_UUID(s.getCachedSettingsUUID());
		ms.setConnected(s.getConnected());
		ms.setNextStartTimestamp(new Date(s.getNextStartTimestamp()));
		// TODO ms.setOperatingModeId(operatingModeId);
		// TODO ms.setRefStartSource(refStartSource);
		ms.setStatus(refStatus);
		ms.setStoredTimestamp(new Date());
		ms.setValueFound(s.getValueFound());
		return ms;
	}

	public static Location getLocation(LocationJSON json, Mower mower, int orderNo) {
		Location location = new Location();
		location.setLatitude(json.getLatitude());
		location.setLongitude(json.getLongitude());
		location.setMower(mower);
		location.setOrderNo(orderNo);
		// TODO location.setRefStatus(refStatus);
		location.setLocationTimestamp(new Date());
		return location;
	}

	public static ArrayList<Location> getLocationList(List<LocationJSON> lastLocations) {
		ArrayList<Location> list = new ArrayList<Location>();
		for (LocationJSON l : lastLocations) {
			Location location = new Location();
			location.setLatitude(l.getLatitude());
			location.setLongitude(l.getLongitude());
			list.add(location);
		}
		return list;
	}
}
