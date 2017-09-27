package com.register.api.access.data;

import java.awt.Image;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
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
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamFrameUpdate {
	@RequestMapping(value="/streamframeupdate", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String frameUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//StreamReceiverWindow.GetInstance().Initiate(request.getInputStream());

		byte[] fileByte =  StreamFrameReceiver.GetCurrentFrameBytes().clone();
		OutputStream writer = null;
		try {
			writer = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] pngBytes = ConvertRawToPng(fileByte);
		
		response.setContentLength(pngBytes.length);
		response.setContentType("image/jpg");
		
		
		try {
			writer.write(pngBytes, 0, pngBytes.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.flush();
		response.flushBuffer();
		
		return "";
	}

	
	public byte[] ConvertRawToPng(byte[] data) {
		// You need to know width/height of the image
		int width = 1280;
		int height = 720;

		int samplesPerPixel = 3;
		int[] bandOffsets = {0, 1, 2}; // BGRA order

		DataBuffer buffer = new DataBufferByte(data, data.length);
		WritableRaster raster = Raster.createInterleavedRaster(buffer, width, height, samplesPerPixel * width, samplesPerPixel, bandOffsets, null);

		ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);

		BufferedImage image = new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);

		//System.out.println("image: " + image); // Should print: image: BufferedImage@<hash>: type = 0 ...

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "JPG", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return output.toByteArray();
		
	}
}
