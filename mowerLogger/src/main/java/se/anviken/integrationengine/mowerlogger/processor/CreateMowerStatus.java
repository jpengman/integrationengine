package se.anviken.integrationengine.mowerlogger.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.model.Mower;
import se.anviken.integrationengine.mowerlogger.model.MowerStatus;
import se.anviken.integrationengine.mowerlogger.utils.MappingUtil;

public class CreateMowerStatus extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();

		Mower mower = in.getBody(Mower.class);
		se.anviken.integrationengine.mowerlogger.json.getmowers.Mower mowerJSON = (se.anviken.integrationengine.mowerlogger.json.getmowers.Mower) in
				.getHeader("MowerStatusJSON");
		MowerStatus mowerStatus = MappingUtil.getMowerStatus(mower, mowerJSON);
		in.setBody(mowerStatus);
	}
}
