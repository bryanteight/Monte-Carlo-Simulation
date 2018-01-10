
public class Portfolio {
	private double mean;
	private double sd;
	private double investment;
	private String type;
	
	private double medianInvestment;
	private double best10Investment;
	private double worst10Investment;
	
	public Portfolio(double mean, double sd, double investment, String type) {
		this.mean = mean;
		this.sd = sd;
		this.investment = investment;
		this.type = type;
	}
	
	@Override
	public String toString() {
		
		return "Portfolio type: " + type + ", initial investment: " + investment + ", return: " + (mean * 100.0) + "%"
				+ " , Risk: " + sd + "\n" + "After simulation: " + "median: " + medianInvestment + 
				", 10% best case: " + best10Investment + ", 10% worse case: " + worst10Investment;
	}
	
	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}
	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public double getSd() {
		return sd;
	}

	public void setSd(double sd) {
		this.sd = sd;
	}
	
	public double getBest10Investment() {
		return best10Investment;
	}

	public void setBest10Investment(double best10Investment) {
		this.best10Investment = best10Investment;
	}

	public double getWorst10Investment() {
		return worst10Investment;
	}

	public void setWorst10Investment(double worst10Investment) {
		this.worst10Investment = worst10Investment;
	}

	public double getMedianInvestment() {
		return medianInvestment;
	}

	public void setMedianInvestment(double medianInvestment) {
		this.medianInvestment = medianInvestment;
	}
}
