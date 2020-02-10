package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method

		// Marshalling the input-message with RPCID
		byte[] request = RPCUtils.marshallString(RPCID, message);

		// Receiving the RPC reply message and unmarshalling
		byte[] response = rpcclient.call(request);
		RPCUtils.unmarshallVoid(response);

	}
}