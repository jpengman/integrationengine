package se.anviken.integrationengine.mowerlogger.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import se.anviken.integrationengine.mowerlogger.constants.Headers;
import se.anviken.integrationengine.mowerlogger.json.gettoken.Attributes;
import se.anviken.integrationengine.mowerlogger.json.gettoken.Data;
import se.anviken.integrationengine.mowerlogger.json.gettoken.GetToken;

public class CreateGetTokenRequest extends Headers implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// {"data":{"attributes":{"password":
		// "${header.password}","username":"${header.username}"},"type":"token"}}
		Message in = exchange.getIn();
		GetToken request = new GetToken();
		Data data = new Data();
		data.setType(TOKEN);
		Attributes attributes = new Attributes();
		attributes.setUsername((String) in.getHeader(USERNAME));
		attributes.setPassword((String) in.getHeader(PASSWORD));
		data.setAttributes(attributes);
		request.setData(data);
		in.setBody(request);
	}
}
