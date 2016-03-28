package Generator;

import java.util.Random;

public class DataPoint {

	private double[] Data;

	
	public DataPoint(double[] dev,double[] var, int dim)
	{
		Data = new double[dim];
		Init(dev, var, dim);
	}
	
	public DataPoint(double[] _Data)
	{
		Data = _Data;
	}
	
	public DataPoint(int dim)
	{
		Data = new double[dim];
		for(int i = 0; i < dim; i++)
		{
			Data[i] = 0.0;
		}
	}
	
	private void Init(double[] dev, double[] variation,  int Dim)
	{
		Random r = new Random();
		
		for(int i = 0; i < Dim; i++)
		{
			Data[i] = dev[i] +(r.nextGaussian() * variation[i]);
			//System.out.println(Data[i]);
		}

	}
	
	public double[] getData() {
		return Data;
	}
	public void setData(double[] toSet){
		Data = toSet;
	}
}
