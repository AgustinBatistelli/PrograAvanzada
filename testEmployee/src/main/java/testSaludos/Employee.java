package testSaludos;

public abstract class Employee {
	protected abstract double getSalesAmount();
	
	public double getComission() {
		return getSalesAmount() * 0.15;
	}
	
	
	public class Sales extends Employee{
//		@Override
//		protected double getSalesAmount() {
//			// TODO Auto-generated method stub
//			return 0;
//		}
		
		public Sales() {
			super();
		}
		
		@Override
		protected double getSalesAmount() {
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
//		Employee e = new Employee();
//		Sales s = new Sales();
	}
}
