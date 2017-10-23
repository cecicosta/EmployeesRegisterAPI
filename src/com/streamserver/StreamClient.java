package com.streamserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StreamClient{
	private ServerSocket socket;

	public StreamClient() throws IOException {
		socket = new ServerSocket(11400);
		while(true) {
//			Socket client = socket.accept();
//			OutputStream writer = client.getOutputStream();
//			System.out.println("SocketConnected: client");
//			try {
//				StreamServer.semaphore.acquire();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			writer.write(StreamServer.GetCurrentFrameBytes());
//			StreamServer.semaphore.release();
		}
	}
}