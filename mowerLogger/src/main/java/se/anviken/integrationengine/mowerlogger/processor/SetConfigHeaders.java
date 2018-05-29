package se.anviken.integrationengine.mowerlogger.processor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.model.Configuration;

public class SetConfigHeaders extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		@SuppressWarnings("unchecked")
		ArrayList<Configuration> configurations = exchange.getIn().getBody(ArrayList.class);
		for (Configuration c : configurations) {
			if (c.getParameter().equals(PASSWORD)) {
				exchange.getIn().setHeader(PASSWORD, c.getValue());
			}
			if (c.getParameter().equals(USERNAME)) {
				exchange.getIn().setHeader(USERNAME, c.getValue());
			}
			if (c.getParameter().equals(TOKEN)) {
				exchange.getIn().setHeader(TOKEN, c.getValue());
			}
			if (c.getParameter().equals(TOKEN_EXPIRES)) {
				exchange.getIn().setHeader(TOKEN_EXPIRES, c.getValue());
				exchange.getIn().setHeader(TOKEN_IS_INVALID, LocalDateTime
						.parse(c.getValue(), DateTimeFormatter.ISO_LOCAL_DATE_TIME).isBefore(LocalDateTime.now()));
			}
		}

	}
}
