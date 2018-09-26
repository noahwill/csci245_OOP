package calc;

public class Total {
	private String total;
	
	public Total(String total) {
		this.setTotal(total);
	}
	
	public String getTotal() {
		return total;
	}
	
	public String setTotal(String someString) {
		this.total = someString;
		return someString;
	}
}
