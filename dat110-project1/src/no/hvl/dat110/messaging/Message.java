package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length < MessageConfig.SEGMENTSIZE)
			this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = null;

		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format

		// Sets the size of the encoded array to 128bits
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		// Sets the first bit to the size of the payload(data message)
		encoded[0] = (byte) payload.length;
		// Copy the content of the payload into the encoded array
		System.arraycopy(payload, 0, encoded, 1, payload.length);
		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it
		// in the payload of this message

		// Updating size of payload to the size of the received-array
		payload = new byte[received[0]];
		// Copy the content of the payload into the encoded array
		System.arraycopy(received, 1, payload, 0, payload.length);

	}
}