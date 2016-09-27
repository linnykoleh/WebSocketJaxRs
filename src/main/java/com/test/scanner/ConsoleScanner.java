package com.test.scanner;

import java.io.IOException;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.websocket.EncodeException;

import org.springframework.stereotype.Service;

import com.test.websockets.WebSocket;

@Service
public class ConsoleScanner {

	public void readConsoleAndSendMessage() throws IOException, EncodeException {
		final Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if("exit".equals(line)){
				return;
			}
			WebSocket.sendMessage(line);
		}
	}
}
