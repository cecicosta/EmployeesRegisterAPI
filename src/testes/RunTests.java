package testes;

import com.google.gson.Gson;
import com.register.api.entities.Employee;
import com.register.api.events.CommandBus;
import com.register.api.persistence.EventStorage;
import com.register.api.persistence.SnapshotRegister;
import com.register.api.queries.QueryEmployeeRegistersAccess;

public class RunTests {

	public static void main(String[] args) {
		SnapshotRegister ssr = new SnapshotRegister(System.currentTimeMillis(), 
				"commited", 0);
		//EventStorage.storeSnapshotRegister(ssr);
		//(new CommandBus()).start();

		Employee e = new Employee("00010", "julio", "123456");
		try {
			e = QueryEmployeeRegistersAccess.getEmployeeByCode("00007");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(e.toJson());
		
	}

}
