package testes;

import com.google.gson.Gson;
import com.register.api.persistence.DataAccessHelper;

public class RunTests {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		try {
			String json = gson.toJson(DataAccessHelper.getRegister(8));
			System.out.println(json.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
