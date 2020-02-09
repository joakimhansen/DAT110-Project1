package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.nio.ByteBuffer;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return
	// values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the
	// RPC message syntax [rpcid,parameter/return value]

	public static byte[] marshallString(byte rpcid, String str) {

		// TODO: marshall RPC identifier and string into byte array

		// Convert the string to byte-array
		byte[] strByteArray = str.getBytes();

		// Creating the encoded array with input-string length + rpcid
		byte[] encoded = new byte[str.length() + 1];
		// Sets the first byte to rpcid(length of the payload)
		encoded[0] = rpcid;

		// Copy the input-string to encoded array
		System.arraycopy(strByteArray, 0, encoded, 1, strByteArray.length);
		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		// TODO: unmarshall String contained in data into decoded
		// Create a string of the input-data
		String decoded = new String(data);

		// Create a byte-array with the length of the payload
		byte[] dataArray = new byte[data.length - 1];

		// Copy the data from input-data to the byte-array
		System.arraycopy(data, 1, dataArray, 0, dataArray.length);

		return new String(dataArray);
	}

	public static byte[] marshallVoid(byte rpcid) {

		// TODO: marshall RPC identifier in case of void type
		// Create a 1byte byte-array containing the rpcid
		byte[] encoded = new byte[1];
		encoded[0] = rpcid;
		return encoded;
	}

	public static void unmarshallVoid(byte[] data) {
		// TODO: unmarshall void type
		// Nothing to do
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		// Create a byte-array with length of 5 (rpcid + integer=4bytes)
		encoded = new byte[5];
		// Set first byte to rpcid
		encoded[0] = rpcid;
		// Convert the input-integer to a byte-array using ByteBuffer
		byte[] intToByteArray = ByteBuffer.allocate(4).putInt(x).array();
		// Copy the data from byte-array to the encoded-array
		System.arraycopy(intToByteArray, 0, encoded, 1, intToByteArray.length);
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data
		// Create a byte-array from the input-data containing length of the payload
		byte[] byteToIntArray = new byte[data.length - 1];
		// Copy the data from input-data to the decoded byte-array
		System.arraycopy(data, 1, byteToIntArray, 0, byteToIntArray.length);
		// returns the converted byte-array using
		return ByteBuffer.wrap(byteToIntArray).getInt();
	}

}
