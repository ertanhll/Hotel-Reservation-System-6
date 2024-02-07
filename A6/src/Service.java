public abstract class Service {

	private int customerID;

	public Service(int customerID) {
		this.customerID = customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public abstract String getServicetype();

	public abstract double calculateService();

	public int getCustomerID() {
		return customerID;
	}

}
