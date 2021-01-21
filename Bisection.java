public class Bisection {

	public static void main(String[] args) {
		
		//get intervals
		double[] arr = signSwitch(0,1);
		//run bisection and print results
		System.out.println(bisection(arr[0],arr[1]));

	}
	
	//function of interest
	private static double f(double x) {
		return Math.pow(x, 2)-2;
	}
	
	//finds the sign switch
	private static double[] signSwitch(double start, double stepSize) {
		double tmp = start;
		while(f(start)*f(tmp) > 0) {
			tmp += stepSize;
		}
		if(f(tmp) == 0) {
			return null;
		}
		double[] toReturn = {tmp,tmp-stepSize};
		return toReturn;
	}
	
	//bisection algorithm
	private static double bisection(double lower,double upper){
		//initialize variables
		double left,right;
		left = lower;
		right = upper;
		//sets mid point
		double mid = (left+right)/2;
		//checks for precision
		while(Math.abs(right-left) > 0.00001) {
			if(f(left)*f(mid) > 0) {
				left = mid;
				mid = (left+right)/2;
			}else if(f(left)*f(mid) < 0) {
				right = mid;
				mid = (left+right)/2;
			}else{
				return mid;
			}
		}
		return mid;
	}

}
