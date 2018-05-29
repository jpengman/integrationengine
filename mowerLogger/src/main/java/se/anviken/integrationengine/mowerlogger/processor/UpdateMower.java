package se.anviken.integrationengine.mowerlogger.processor;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.model.Mower;

public class UpdateMower extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();

		@SuppressWarnings("unchecked")
		ArrayList<Mower> mowerList = in.getBody(ArrayList.class);
		se.anviken.integrationengine.mowerlogger.json.getmowers.Mower mowerJSON = (se.anviken.integrationengine.mowerlogger.json.getmowers.Mower) in
				.getHeader("MowerStatusJSON");
		Mower mower = null;
		if (mowerList.size() == 0) {
			mower = new Mower();
			mower.setModel(mowerJSON.getModel());
			mower.setMoverName(mowerJSON.getName());
			mower.setRestServiceId(mowerJSON.getId());
		} else {
			mower = mowerList.get(0);
			mower.setModel(mowerJSON.getModel());
			mower.setMoverName(mowerJSON.getName());
		}
		in.setBody(mower);
	}
}
