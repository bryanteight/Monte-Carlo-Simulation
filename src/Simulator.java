import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class Simulator {
	private List<Portfolio> portfolios;
	private Map<Portfolio, State> map; // create a portfolio - state mapping
	
	private final static int years = 20;
	private final static int simulations = 10000;
	private final static double inflation = 0.035;
	
	public Simulator(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
		map = new HashMap<>();
		for (Portfolio p : this.portfolios) {
			if (!map.containsKey(p)) {
				map.put(p, new State(p.getMean(), p.getSd()));
			}
		}
	}
	
	// store the simulate state for each portfolio
	private class State {
		private NormalDistribution normalDistribution;
		private DescriptiveStatistics stats; // Maintains a dataset of values
		
		public State(double mean, double sd) {
			this.normalDistribution = new NormalDistribution(mean, sd);
			this.stats = new DescriptiveStatistics();
	
		}
		
		// Adds the value to the dataset
		public void addValue(double v) {
			this.stats.addValue(v);
		}
		
		public double getPercentile(double v) {
			return this.stats.getPercentile(v);
		}
	}
	
	// start to run 10,000 simulations of projecting 20 year
	public void simulate() {
		for (Portfolio p : portfolios) {
			for (int i = 0; i < simulations; i++) {
				double curAsset = p.getInvestment();
				for (int j = 0; j < years; j++) {
					double nextRandomVal = map.get(p).normalDistribution.sample();
					curAsset = (1 + nextRandomVal) * curAsset;
					curAsset = (1 - inflation) * curAsset;
				}
				// add this simulation to the portfolio-state
				map.get(p).addValue(curAsset);
			}
			
			// update the portfolio after finishing simulations
			State state = map.get(p);
			p.setBest10Investment(state.getPercentile(90));
			p.setWorst10Investment(state.getPercentile(10));
			p.setMedianInvestment(state.getPercentile(50));
		}
	}
}
