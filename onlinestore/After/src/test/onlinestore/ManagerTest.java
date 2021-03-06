package onlinestore;

import static org.junit.Assert.assertEquals;
import onlinestore.Employee;
import onlinestore.Manager;
import onlinestore.Salesman;

import org.junit.Test;

public class ManagerTest {

	@Test
	public void calculateTheNetSalaryWhenFixedSalaryIsUnderTheMinimumTax() {
		int fixedSalary = 3000;
		Employee manager = createManager(fixedSalary);

		assertEquals(2700, manager.netSalary(), 0);
	}

	@Test
	public void calculateTheNetSalaryWhenFixedSalaryIsOverTheMinimumTax() {
		int fixedSalary = 5000;
		Employee manager = createManager(fixedSalary);

		assertEquals(4250, manager.netSalary(), 0);
	}

	@Test
	public void CalculateTheNetSalaryWhenBenefits() {
		int fixedSalary = 3000;
		Manager manager = createManager(fixedSalary);
		manager.addSubordinate(createSubordinate());

		assertEquals(2720, manager.netSalary(), 0);
	}

	private Manager createManager(int fixedSalary) {
		return new Manager("Carlos", "Rodriguez", fixedSalary);
	}

	private Salesman createSubordinate() {
		return new Salesman("Miguel", "Gonzales", 2000, 2);
	}
}
