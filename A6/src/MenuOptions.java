
public enum MenuOptions {
	A("Create new Reservation with Room Type"),
	B("Display all Reservations"), 
	C("List the reservations for a specific city"),
	D("Add extra services to a reservation"),
	E("Calculate total cost for each service"),
	F("Display the total cost of every customer"),
	G("Exit");
	private String selection;

	MenuOptions(String selection) {
		this.selection = selection;

	}

	public String getSelection() {
		return selection;
	}

}