public class ModifiedFalsePosition {
	public static void main(String[] args) {
		
		//get intervals
		double[] arr = signSwitch(0,1);
		//run bisection and print results
		for(int i = 1; i < 6;i++) {
			System.out.println("iteration " + i + " = " + ModFalsePos(arr[0],arr[1],i-1));
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
	private static double ModFalsePos(double lower,double upper,int iterations) {
		//Initialize variables
		double left,right;
		left = lower;
		right = upper;
		//get initial mid point
		double mid = mid(left,f(left),right,f(right));
		//run for iteration amount of times
		for(int i = 0; i < iterations;i++) {
			//initial if statements check for how to change points, final else checks if root has already been found
			if(f(left)*f(mid) > 0) {
				left = mid;
				mid = mid(mid,f(mid),right,f(right)/2);
			}else if(f(left)*f(mid) < 0) {
				right = mid;
				mid = mid(left,f(left)/2,mid,f(mid));
			}else{
				return mid;
			}
		}
		//return result
		return mid;
	}
	
	//get equation of line connecting the two points and return when f(x)=0
	private static double mid(double left,double fleft,double right, double fright) {
		//get slope
		double m = (fright-fleft)/(right-left);
		//get y-intercept
		double b = fleft-m*left;
		//return x for when y=0
		return (-b)/m;
	}
	
}
