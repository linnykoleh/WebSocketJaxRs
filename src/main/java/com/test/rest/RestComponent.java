package com.test.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import com.test.scanner.ConsoleScanner;

@Component
@Path("/jaxrs")
public class RestComponent {

	@GET
	public void sendMessages() {
		try {
			final ConsoleScanner consoleScanner =  new ConsoleScanner();
			consoleScanner.readConsoleAndSendMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
