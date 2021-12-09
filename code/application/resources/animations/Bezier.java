package application.resources.animations;

import application.resources.Utils;

/**
 * Quadratic bezier curve (ease in)
 */
public class Bezier {
	
	public class BezierInfo {
		public double currNorm, curr; // curr is normal result, currNorm is curr -> [0,1]
		
		public BezierInfo(double curr, double c) {
			this.curr = curr;
			this.currNorm = curr / c;
		}
	}
	
	private int length;
	private double a, b, c;
	private double timeDelta = 4; // time between points on bezier curve
	private double maxInterval;
	
	public Bezier(int length, double a, double b, double c) {
		this.length = length;
		this.a = a;
		this.b = b;
		this.c = c;
		this.maxInterval = length / timeDelta;
	}

	public BezierInfo calc(int interval_num) {
		
	    double t = interval_num * (timeDelta / length);

	    double p0 = Math.pow(1 - t, 2) * a;
	    double p1 = 2 * (1 - t) * t * b;
	    double p2 = t * t * c;

//	    return p0 + p1 + p2;
	    return new BezierInfo(p0 + p1 + p2, c);
	    
	    
	}
	
	public double getMaxInterval() {
		return maxInterval;
	}
	
	public double getTimeDelta() {
		return timeDelta;
	}
	
	public double getEnd() {
		return c;
	}
	
	/**
	 * 
	 * Generate an ease in bezier curve for sliding page from left to right
	 * 
	 * @param per
	 * @param width
	 * @return
	 */
	public static Bezier genEaseIn(double size) {
		
		return new Bezier(Utils.slideAnimLength, (double) 0, -size, -size);
		
	}
	
}
