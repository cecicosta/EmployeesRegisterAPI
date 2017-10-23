package com.streamserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

import com.stream.encoder.movie.JpegImagesToMovie;
import com.streamreceiver.window.StreamReceiverWindow;

public class StreamServer {
	
	public static void main(String[] args) throws IOException {
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					StreamServer server = null;
					
						server = new StreamServer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
			
	}
	
	public StreamServer() throws IOException {
		//System.setProperty("java.awt.headless", "true");
		
		socket = new ServerSocket(10400);
		Socket client;
		client = socket.accept();
		
		StreamReceiverWindow receiver = StreamReceiverWindow.GetInstance();
		
		
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				InputStream reader = null;
				OutputStream writer = null;
				try {
					reader = client.getInputStream();
					writer = client.getOutputStream();
					System.out.println("SocketConnected: server");
				} catch (IOException e) {
					e.printStackTrace();
				}
				boolean firstFrame = true;
				while(true)
					try {	
						
						int bytesRead = 0;
						bytesRead = reader.read(body);
						int totalBytesToRead = Integer.parseInt(new String(body,0 , bytesRead));
						//System.out.println("Bytes to read: " + totalBytesToRead);
						
						String msg = "REQUEST_FILE: " + totalBytesToRead;
						writer.write(msg.getBytes());
						
						body = new byte[totalBytesToRead];
						//Read file data
						bytesRead = 0;
						int totalBytesRead = 0;
						while(totalBytesRead < totalBytesToRead && bytesRead > -1) {
							bytesRead = reader.read(body, totalBytesRead, totalBytesToRead - totalBytesRead);
							totalBytesRead += bytesRead < -1? 0 : bytesRead;
							//System.out.println("Read: " + totalBytesRead + " of " + totalBytesToRead);
						}
						
						if(totalBytesRead != totalBytesToRead) {							
							//System.out.println("read bytes mismatch: " + totalBytesRead + " read, expected: " + totalBytesToRead);
							msg = "BYTES_MISMATCH";
							writer.write(msg.getBytes());
							continue;
						}
						
						
						if(firstFrame) {
							receiver.Initiate(body);
							firstFrame = false;
						}else {
							receiver.SetNewFrame(body);
						}
						
						//System.out.println("All bytes received");
						msg = "ALL_BYTES_RECEIVED";
						writer.write(msg.getBytes());
						
						if(receiver.WasClosed()) {
							break;
						}
						
					} catch (Exception e) {
						try {
							JpegImagesToMovie.CreateVideoFile(LocalDateTime.now().toString());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						e.printStackTrace();
						break;
					}
				
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	private byte[] body = new byte[2048];
	private ServerSocket socket;
	
}


