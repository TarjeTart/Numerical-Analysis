public class FalsePosition {
	public static void main(String[] args) {
		
		//get intervals
		double[] arr = signSwitch(0,1);
		//run bisection and print results
		System.out.println(FalsePosition(arr[0],arr[1],10));
		
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
		double left,right;
		left = lower;
		right = upper;
		double mid = mid(left,right);
		for(int i = 0; i < iterations;i++) {
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
		return mid;
	}
	
	private static double mid(double x,double y) {
		double m = (f(y)-f(x))/(y-x);
		double b = f(x)-m*x;
		return (-b)/m;
	}
	
}
