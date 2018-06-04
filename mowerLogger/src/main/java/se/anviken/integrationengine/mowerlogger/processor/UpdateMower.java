package se.anviken.integrationengine.mowerlogger.processor;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.json.getmowers.MowerJSON;
import se.anviken.integrationengine.mowerlogger.model.Mower;

public class UpdateMower extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();

		@SuppressWarnings("unchecked")
		ArrayList<Mower> mowerList = in.getBody(ArrayList.class);
		MowerJSON mowerJSON = (MowerJSON) in.getHeader(MOWER_STATUS_JSON);
		Mower mower = null;
		boolean updateNeeded = true;
		if (mowerList.size() == 0) {
			mower = new Mower();
			mower.setModel(mowerJSON.getModel());
			mower.setMowerName(mowerJSON.getName());
			mower.setRestServiceId(mowerJSON.getId());
		} else {
			mower = mowerList.get(0);
			if (mower.getModel().equals(mowerJSON.getModel()) || mower.getMowerName().equals(mowerJSON.getName())) {
				mower.setModel(mowerJSON.getModel());
				mower.setMowerName(mowerJSON.getName());
			} else {
				updateNeeded = false;
			}
		}
		in.setHeader(MOWER_UPDATE_NEEDED, updateNeeded);
		in.setBody(mower);
	}
}
