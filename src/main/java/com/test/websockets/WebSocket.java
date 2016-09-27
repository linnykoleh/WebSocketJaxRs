package com.test.websockets;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocket {

	/** https://github.com/dearshor/websockets-demo */

	private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

	@OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {

		System.out.println("The message from UI is " + message);
		session.getBasicRemote().sendText("This is the first server message");
		
		int sentMessages = 0;
		while(sentMessages < 3){
			Thread.sleep(5000);
			session.getBasicRemote().sendText("This is an intermediate server message. Count: " + sentMessages);
			sentMessages++;
		}
		
		session.getBasicRemote().sendText("This is the last server message");
    }
	
	@OnOpen
    public void onOpen (final Session session) {
        System.out.println("Client connected");
		sessions.add(session);
    }

    @OnClose
    public void onClose (final Session session) {
    	System.out.println("Connection closed");
		sessions.remove(session);
    }

    public static void sendMessage(final String message) throws IOException, EncodeException {
		for(Session session : sessions){
			session.getBasicRemote().sendText(message);
		}
	}
}
