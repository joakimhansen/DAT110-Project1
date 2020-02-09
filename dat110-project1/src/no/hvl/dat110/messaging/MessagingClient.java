package no.hvl.dat110.messaging;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() {

		Socket clientSocket = null;
		Connection connection = null;

		// create TCP socket for client and connection
		// create connection object
		try {
			server = MessageConfig.MESSAGINGHOST;
			port = MessageConfig.MESSAGINGPORT;
			clientSocket = new Socket(server, port);
		} catch (UnknownHostException ex) {
			System.out.println("Unknown host: " + ex.getMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Connect: " + ex.getMessage());
			ex.printStackTrace();
		}

		connection = new Connection(clientSocket);
		return connection;
	}
}
