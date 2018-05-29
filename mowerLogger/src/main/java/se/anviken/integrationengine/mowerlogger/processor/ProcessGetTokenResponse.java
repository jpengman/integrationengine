package se.anviken.integrationengine.mowerlogger.processor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.json.gettoken.GetToken;

public class ProcessGetTokenResponse extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		GetToken response = exchange.getIn().getBody(GetToken.class);
		exchange.getIn().setHeader(TOKEN, response.getData().getId());
		LocalDateTime timePoint = LocalDateTime.now().plusSeconds(response.getData().getAttributes().getExpiresIn());
		exchange.getIn().setHeader(TOKEN_EXPIRES, timePoint.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		exchange.getIn().setBody(null);
	}
}
