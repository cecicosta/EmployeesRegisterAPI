package com.register.api.access.data;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StreamFrameReceiver {

	@RequestMapping(value="/streamframe", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String streamReceiver(HttpServletRequest request, HttpServletResponse response) throws Exception {
		body = StreamUtils.copyToByteArray(request.getInputStream());
		

		return "return";
	}
	

   private static byte[] body = new byte[]{};
   public static byte[] GetCurrentFrameBytes() {
	   return body;
   }

}
