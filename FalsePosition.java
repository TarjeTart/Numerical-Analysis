public class FalsePosition {
	public static void main(String[] args) {
		
		//get intervals
		double[] arr = signSwitch(0,1);
		//run bisection and print results
		for(int i = 0; i < 5;i++) {
			System.out.println("iteration " + i + " = " + FalsePosition(arr[0],arr[1],i));
		}
		
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
	
	//false position algo
	private static double FalsePosition(double lower,double upper,int iterations) {
		//initializze variables
		double left,right;
		left = lower;
		right = upper;
		//get initial mid point
		double mid = mid(left,right);
		//run for iteration amount of times
		for(int i = 0; i < iterations;i++) {
			//initial if statements check for how to change points, final else checks if root has already been found
			if(f(left)*f(mid) > 0) {
				left = mid;
				mid = mid(mid,right);
			}else if(f(left)*f(mid) < 0) {
				right = mid;
				mid = mid(left,mid);
			}else{
				return mid;
			}
		}
		//return result
		return mid;
	}
	
	//get equation of line connecting the two points and return when y=0
	private static double mid(double x,double y) {
		//get slop
		double m = (f(y)-f(x))/(y-x);
		//get y-intercept
		double b = f(x)-m*x;
		//return x for when y=0
		return (-b)/m;
	}
	
}
