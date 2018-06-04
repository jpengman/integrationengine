package se.anviken.integrationengine.mowerlogger.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.json.getmowers.MowerJSON;
import se.anviken.integrationengine.mowerlogger.model.Mower;
import se.anviken.integrationengine.mowerlogger.model.MowerStatus;
import se.anviken.integrationengine.mowerlogger.model.RefStatus;
import se.anviken.integrationengine.mowerlogger.utils.MappingUtil;

public class ObjectFactory extends Headers {
	public void createRefStatus(Exchange exchange) throws Exception {
		MowerJSON json = (MowerJSON) exchange.getIn().getHeader(MOWER_STATUS_JSON);
		exchange.getIn().setBody(new RefStatus(json.getStatus().getMowerStatus()));
	}

	public void createMowerStatus(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		Mower mower = (Mower) in.getHeader(MOWER);
		MowerJSON mowerJSON = (MowerJSON) in.getHeader("MowerStatusJSON");
		RefStatus refStatus = (RefStatus) in.getHeader(REF_STATUS);
		MowerStatus mowerStatus = MappingUtil.getMowerStatus(mower, refStatus, mowerJSON);
		in.setBody(mowerStatus);
	}
}
