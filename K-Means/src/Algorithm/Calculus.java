package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Generator.Cluster;
import Generator.DataPoint;

public class Calculus {
	private int Num_Cluster;
	private List<Cluster> AllCluster = new ArrayList<Cluster>();
	private List<DataPoint> Points = new ArrayList<DataPoint>();

	Calculus(List<DataPoint> _Points, int _Num_Cluster)
	{
		Points = _Points;
		Num_Cluster = _Num_Cluster;
		for(int i=0;i<Num_Cluster;i++)
		{
			AllCluster
		}
	}
	
	private void Initial1()
	{
		Random RandomGenerator = new Random();
		int index = 0;
		for(int i=0;i<Points.size();i++)
		{
			index = RandomGenerator.nextInt(Num_Cluster)+1;
			AllCluster.get(index).add_Point(Points.get(i));
		}
	}
}
