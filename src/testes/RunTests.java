package testes;

import com.google.gson.Gson;
import com.register.api.events.CommandBus;
import com.register.api.persistence.EventStorage;
import com.register.api.persistence.SnapshotRegister;
import com.register.api.queries.QueryEmployeeRegistersAccess;

public class RunTests {

	public static void main(String[] args) {
		SnapshotRegister ssr = new SnapshotRegister(System.currentTimeMillis(), 
				"commited", 0);
		//EventStorage.storeSnapshotRegister(ssr);
		(new CommandBus()).start();

	}

}
