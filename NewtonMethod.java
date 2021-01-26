public class NewtonMethod {

	public static void main(String[] args) {

		System.out.println(NewtMeth(1,3));

	}

	//function of interest
	public static double f(double x) {
		return x*x-2;
	}
	
	//derivative of function
	public static double df(double x) {
		return 2*x;
	}
	
	//newtons method
	public static double NewtMeth(double start, int iterations) {
		//apply algorithm iterations amount of times
		for(int i = 0; i < iterations; i++) {
			start = -f(start)/df(start)+start;
		}
		return start;
	}
	
}
