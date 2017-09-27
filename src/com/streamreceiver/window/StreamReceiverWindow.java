package com.streamreceiver.window;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StreamReceiverWindow  extends Frame implements WindowListener, ActionListener, Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static StreamReceiverWindow streamReceiverWindow;
	
	private Image image;

	private MenuBar menu;

	private Menu ajuda;

	private MenuItem sobre;

	private Thread thread;
	
	private JLabel jlabel;
	
	private StreamReceiverWindow() {

    
//		
//		super("Stream Receiver");
//		
//		addWindowListener(this);
//		addNotify();
//		
//		menu = new MenuBar();
//		ajuda = new Menu("Ajuda");
//		sobre = new MenuItem("Sobre");
//		sobre.addActionListener(this);
//
//		ajuda.add(sobre);
//		menu.add(ajuda);
//
//		setMenuBar(menu);
//		sobre.addActionListener(this);
//		
//		addWindowListener(this);
//		setResizable(false);
	}
	
	public void Initiate(byte[] data) {
//		try {
//			image = ImageIO.read(new ByteArrayInputStream(data));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		ConvertRawToPng(data);
		
		JFrame frame = new JFrame();
		jlabel = new JLabel(new ImageIcon(image));
		frame.getContentPane().add(jlabel);
		frame.pack();
		frame.setVisible(true);  

//		SetNewFrame(data);
//        int width = (int) (image.getWidth(this));
//        int height = (int) (image.getHeight(this));
//		setSize(width, height);
//		
//		thread = new Thread(this);
//		thread.start();
	}
	
	public void SetNewFrame(byte[] data) {
		ConvertRawToPng(data);
//		try {
//			image = ImageIO.read(new ByteArrayInputStream(data));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		jlabel.setIcon(new ImageIcon(image));
	}

	
	public void ConvertRawToPng(byte[] data) {
		// You need to know width/height of the image
		int width = 1280;
		int height = 720;

		int samplesPerPixel = 3;
		int[] bandOffsets = {2, 1, 0}; // BGRA order

		DataBuffer buffer = new DataBufferByte(data, data.length);
		WritableRaster raster = Raster.createInterleavedRaster(buffer, width, height, samplesPerPixel * width, samplesPerPixel, bandOffsets, null);

		ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);

		BufferedImage image = new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);

		//System.out.println("image: " + image); // Should print: image: BufferedImage@<hash>: type = 0 ...

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "PNG", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.image = ImageIO.read(new ByteArrayInputStream(output.toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static StreamReceiverWindow GetInstance() {
		if(streamReceiverWindow == null)
			streamReceiverWindow = new StreamReceiverWindow();
		return streamReceiverWindow;
	}
	
	@Override
	public void update(Graphics g){
		g.drawImage(image, 0, 0, this);
	}
	
	@Override
	public void run() {
		while (true) {	
			try { Thread.sleep(45); } 
			catch (InterruptedException e) {
				return;
			}
	
			update(this.getGraphics());
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
