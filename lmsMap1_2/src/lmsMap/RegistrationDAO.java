package lmsMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RegistrationDAO {
	
	private Map<Integer, Registration> regDb;
	
	private static RegistrationDAO instance = new RegistrationDAO();
	
	private RegistrationDAO() {
		this.regDb = new HashMap<>();
	}
	
	public static RegistrationDAO getInstance() {
		return instance;
	}
	
	public int ranCode() {
		Set<Integer> keys = this.regDb.keySet();
		while(true) {
			int code = Lms.ran.nextInt(8999) + 1000;
			if(!keys.contains(code))
				return code;
		}
	}
	
	public void addReg(Registration reg) {
		int regCode = ranCode();
		
		Registration newRegistration = new Registration(regCode, reg.getStudent(), reg.getSubject());
		this.regDb.put(regCode, newRegistration);
		newRegistration.getStudent().addSubs(newRegistration);
	}

}
