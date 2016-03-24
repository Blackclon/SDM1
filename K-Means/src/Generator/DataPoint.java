package Generator;

import java.util.Random;

public class DataPoint {

	private double X;
	private double Y;
	
	public DataPoint(double devX, double devY)
	{
		Init(devX, devY);
	}
	private void Init(double devationX, double devationY)
	{
		Random r = new Random();
		X = devationX + (r.nextGaussian());
		Y = devationY + (r.nextGaussian());
		System.out.println(X);
		System.out.println(Y);
	}
	
	public double getY() {
		return Y;
	}

	public double getX() {
		return X;
	}
}
