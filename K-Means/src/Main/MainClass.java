package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Generator.*;

public class MainClass {

	public static void main(String[] args) throws IOException
	{
<<<<<<< HEAD
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.print("Number of Cluster: ");
	    String eingabe = br.readLine();
	    int numCluster = Integer.parseInt(eingabe);
	    
	    System.out.print("Number of Data Points: ");
	    String eingabe2 = br.readLine();
	    int numData = Integer.parseInt(eingabe2);
	    
	    System.out.print("Enter X max: ");
	    String eingabe3 = br.readLine();
	    int Xmax = Integer.parseInt(eingabe3);
	    
	    
		DataGenerator.getInstance().Init(numCluster, numData, Xmax);
		
		int temp = DataGenerator.getInstance().getDataPoints().size();
		System.out.print(temp);
	}
	
}

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
