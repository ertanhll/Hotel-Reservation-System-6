public class Spa extends Service {

	private int duration;

	public Spa() {
		super(0);
	}

	@Override
	public String getServicetype() {
		return "Spa";
	}

	@Override
	public double calculateService() {

		double cost = 0;
		cost = duration * 100;
		return cost;
	}

	@Override
	public void setCustomerID(int customerID) {
		super.setCustomerID(customerID);
	}

	@Override
	public int getCustomerID() {
		return super.getCustomerID();
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
