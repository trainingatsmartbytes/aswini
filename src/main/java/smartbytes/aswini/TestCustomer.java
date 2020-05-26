package smartbytes.aswini;

public class TestCustomer {

	public static void main(String[] args) {
		Customer c1 = new Customer("Aswini","Ramachandran",100000);
		
		c1.prettPrint();
		
		Customer c2 = new Customer();
		c2.setFirstName("Akash");
		c2.setLastName("Seth");
		c2.setSalary(15000);
	
        c2.prettPrint();
		
	}
}
