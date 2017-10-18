package se.anviken.integrationengine.engineheatertrigger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ZWaySessionProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String setCookie = (String) exchange.getIn().getHeader("Set-Cookie");
		// exchange.getIn().setHeader("command",
		// exchange.getIn().getHeader("command"));
		exchange.getIn().setHeader("ZWAYSession",
				setCookie.replace("ZWAYSession=", "").replace("; Path=/; HttpOnly", ""));
	}
}
