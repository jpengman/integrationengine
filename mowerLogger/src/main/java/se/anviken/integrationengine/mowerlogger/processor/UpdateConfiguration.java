package se.anviken.integrationengine.mowerlogger.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.model.Configuration;

public class UpdateConfiguration extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		Configuration c = in.getBody(Configuration.class);
		if (c.getParameter().equals(TOKEN)) {
			c.setValue((String) in.getHeader(TOKEN));
		}
		if (c.getParameter().equals(TOKEN_EXPIRES)) {
			c.setValue((String) in.getHeader(TOKEN_EXPIRES));
		}
		in.setBody(c);
	}
}
