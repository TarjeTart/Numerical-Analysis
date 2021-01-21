public class ModifiedFalsePosition {
	public static void main(String[] args) {
		
		//get intervals
		double[] arr = signSwitch(0,1);
		//run bisection and print results
		for(int i = 0; i < 5;i++) {
			System.out.println("iteration " + i + " = " + FalsePos(arr[0],arr[1],i));
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
	private static double FalsePos(double lower,double upper,int iterations) {
		//Initialize variables
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
				mid = mid(mid,right/2);
			}else if(f(left)*f(mid) < 0) {
				right = mid;
				mid = mid(left/2,mid);
			}else{
				return mid;
			}
		}
		//return result
		return mid;
	}
	
	//get equation of line connecting the two points and return when f(x)=0
	private static double mid(double left,double right) {
		//get slope
		double m = (f(right)-f(left))/(right-left);
		//get y-intercept
		double b = f(right)-m*right;
		//return x for when y=0
		return (-b)/m;
	}
	
}
