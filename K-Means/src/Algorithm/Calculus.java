package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Generator.Cluster;
import Generator.DataPoint;

public class Calculus {
	private int Num_Cluster;
	private int Dimension;
	private List<Cluster> AllCluster = new ArrayList<Cluster>();
	private List<DataPoint> Points = new ArrayList<DataPoint>();

	public Calculus(List<DataPoint> _Points, int _Num_Cluster)
	{
		Points = _Points;
		Dimension = _Points.get(0).getData().length;
		Num_Cluster = _Num_Cluster;
		for(int i = 0;i<Num_Cluster; i++)
		{
			AllCluster.add(new Cluster(0)); // Amount of Points unknown
		}
	}
	
	private void Initial1() // Random distribution of Points to Clusters and Calc of initial Centroids
	{
		Random RandomGenerator = new Random();
		int index = 0;
		for(int i=0;i<Points.size();i++)
		{
			index = RandomGenerator.nextInt(Num_Cluster);
			AllCluster.get(index).add_Point(Points.get(i));
		}
		Cluster tempCluster = new Cluster(0);
		for(int i=0;i<Num_Cluster;i++)
		{
			tempCluster = AllCluster.get(i);
			tempCluster.setNum_DataPoints(tempCluster.DataInCluster().size());
		}
		
		Calc_Centroid();
	}
	
	private void Calc_Centroid()  // Calculates Centroids and stores them in Cluster
	{
		for(int i = 0;i<Num_Cluster; i++)
		{
			Cluster temp_Cluster = AllCluster.get(i);
			double[] centroid = new double[Dimension];
			List<DataPoint> temp_Points = temp_Cluster.DataInCluster();
			for(int j =0;j<temp_Cluster.getNum_DataPoints();j++)
			{
				double[] temp_d_array = temp_Points.get(j).getData();
				for(int k = 0;k<Dimension;k++)
				{
					centroid[k]+=temp_d_array[k];
				}
			}
			for(int k = 0;k<centroid.length;k++)
			{
				centroid[k]=centroid[k]/temp_Cluster.getNum_DataPoints();
			}
			AllCluster.get(i).set_Centroid(new DataPoint(centroid));
		}
	}
	
	public List<Cluster> getAllCluster()
	{
		Initial1();
		return AllCluster;
	}
}
