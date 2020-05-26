package smartbytes.aswini;

public class Customer {
	private String firstName;
	private String lastName;
	private double salary;
    private boolean isActive;
    
	public Customer() {

	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive= true;
	}

	public Customer(String firstName, String lastName, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.isActive=true;
	}

	
	public boolean isActive() {
		return isActive;
	}

	public double getSalary() {
		return salary;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
	}

	public void prettPrint() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\n");
		sb.append("firstname:" + firstName +",\n");
		sb.append("lastName:"+ lastName+",\n");
		sb.append("salary:"+ salary+"\n");
		sb.append("}");
		System.out.println(sb.toString());
	}
}
