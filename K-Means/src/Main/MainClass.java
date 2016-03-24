package Main;

import java.util.ArrayList;
import java.util.List;

import Generator.*;

public class MainClass {

	public static void main(String[] args)
	{
		/*
		int count = 0;
		List<DataPoint> DataPoints = new ArrayList<DataPoint>();
		for(int i = 0; i < 1000000; i++)
		{
			DataPoints.add(new DataPoint());
			
		}
		double x,y;
		for(int i = 0; i < 1000000; i++)
		{
			
			x = DataPoints.get(i).getX();
			y = DataPoints.get(i).getY();
			if(x >= 5 )
			{
				System.out.println(x);
				count++;
			}
			if(y >= 5 )
			{
				count++;
				System.out.println(y);
			}
		}
		System.out.println(count);
		*/
		int numCluster = 10;
		int numDataPoints = 1009;
		int xmax = 100;
		DataGenerator.getInstance().Init(numCluster, numDataPoints, xmax);
		
		int temp = DataGenerator.getInstance().getDataPoints().size();
		System.out.print(temp);
	}
	
}
