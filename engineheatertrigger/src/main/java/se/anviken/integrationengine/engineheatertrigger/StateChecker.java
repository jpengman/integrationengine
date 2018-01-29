package se.anviken.integrationengine.engineheatertrigger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import se.anviken.integrationengine.engineheatertrigger.json.ZwaveObject;

public class StateChecker implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		ZwaveObject body = (ZwaveObject) exchange.getIn().getBody();
		exchange.getIn().setHeader("state", body.getData().getMetrics().getLevel());
		exchange.getIn().setHeader("failed", body.getData().getMetrics().getIsFailed());
	}
}
