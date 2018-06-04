package se.anviken.integrationengine.mowerlogger.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.json.getmowers.LocationJSON;
import se.anviken.integrationengine.mowerlogger.json.getmowers.MowerJSON;
import se.anviken.integrationengine.mowerlogger.model.Location;
import se.anviken.integrationengine.mowerlogger.model.Mower;

public class LocationCalculator extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();

		@SuppressWarnings("unchecked")
		ArrayList<Location> fromDB = in.getBody(ArrayList.class);
		MowerJSON mowerJSON = (MowerJSON) in.getHeader(MOWER_STATUS_JSON);
		ArrayList<Location> toDB = getLocationList(mowerJSON.getStatus().getLastLocations());
		toDB.removeAll(fromDB);
		Mower mower = (Mower) in.getHeader(MOWER);
		int orderNo = 1;
		if (fromDB.size() != 0) {
			orderNo = fromDB.get(0).getOrderNo() + 1;
		}
		for (Location l : toDB) {
			l.setMower(mower);
			l.setOrderNo(orderNo);
			orderNo++;
			l.setLocationTimestamp(new Date());
		}
		in.setBody(toDB);
	}

	private ArrayList<Location> getLocationList(List<LocationJSON> lastLocations) {
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
