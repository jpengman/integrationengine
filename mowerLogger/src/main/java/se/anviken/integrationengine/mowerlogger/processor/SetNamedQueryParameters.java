package se.anviken.integrationengine.mowerlogger.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;

public class SetNamedQueryParameters extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Message in = exchange.getIn();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(REST_SERVICE_ID, in.getHeader(REST_SERVICE_ID));
		in.setHeader(PARAMETERS, parameters);
	}
}
