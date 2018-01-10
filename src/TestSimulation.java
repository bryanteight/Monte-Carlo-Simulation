import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestSimulation {

	@Test
	public void testSimulation() {
		Portfolio p1 = new Portfolio(0.094324, 0.15675, 100000, "aggressive");
		Portfolio p2 = new Portfolio(0.06189, 0.063438, 100000, "very conservative");
		
		List<Portfolio> portfolios = new ArrayList<>();
		portfolios.add(p1);
		portfolios.add(p2);
		
		Simulator simulator = new Simulator(portfolios);
		simulator.simulate();
		
		System.out.println(p1.toString());
		System.out.println("");
		System.out.println(p2.toString());	
	}	
}
