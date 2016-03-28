package Algorithm;

import java.io.IOException;
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
			AllCluster.set(i, tempCluster);
		}
		
		Calc_Centroid();
	}
	
	private void Initial2()
	{
		Random RandomGenerator = new Random();
		for(int i = 0; i < Num_Cluster; i++)
		{
			int rand = RandomGenerator.nextInt(Points.size());
			AllCluster.get(i).set_Centroid(Points.get(rand));
		}
		
	}
	
	private void Calc_Centroid()  // Calculates Centroids and stores them in Cluster
	{
		for(int i = 0;i<Num_Cluster; i++)
		{
			Cluster temp_Cluster = AllCluster.get(i);
			double[] centroid = new double[Dimension];
			List<DataPoint> temp_Points = temp_Cluster.DataInCluster();
			/*if(temp_Cluster.getNum_DataPoints() == 0)
			{
				continue;
			}*/
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
	
	private void Update_Points1()
	{
		double temp_dist = 0;
		double tempd = 0;
		int newcluster = 0;
		List<DataPoint> Centroids = new ArrayList<DataPoint>();
		for(int i=0;i<Num_Cluster;i++)
		{
			Centroids.add(AllCluster.get(i).get_Centroid());
		}
		//reset Clusters
		AllCluster.clear();	
		for(int i = 0;i<Num_Cluster; i++)
		{
			AllCluster.add(new Cluster(0)); // Amount of Points unknown
			
		}
		for(int i = 0;i<Num_Cluster; i++)
		{
			AllCluster.get(i).set_Centroid(Centroids.get(i));
		}
		for(int i=0;i<Points.size();i++)
		{
			newcluster = 0;
			temp_dist = Distance(Points.get(i),Centroids.get(0));
			for(int j = 1;j<Num_Cluster;j++)
			{
				tempd = Distance(Points.get(i),Centroids.get(j));
				//System.out.println(Distance(Points.get(i),Centroids.get(j)));
				if(tempd<temp_dist)
				{
					temp_dist=tempd;
					newcluster=j;
				}
			}
			AllCluster.get(newcluster).add_Point(Points.get(i));
		}

		for(int i=0;i<Num_Cluster;i++)
		{
			AllCluster.get(i).setNum_DataPoints(AllCluster.get(i).DataInCluster().size());
		}
	}
	
	private double Distance(DataPoint p1, DataPoint p2)
	{
		double temp = 0;
		for(int i=0;i<Dimension;i++)
		{
			double temp0 = p1.getData()[i];
			double temp1 = p2.getData()[i];
			temp+=Math.pow((temp0 - temp1),2.0);
		}
		//temp = Math.pow(temp, 1.0/2.0);
		if(temp == Double.NaN){System.out.println("NAN!!!!!!!!!!!!!!!!!!!!!");}
		return temp;
	}
	
	public List<Cluster> getAllCluster()
	{
		Initial2();
		//Calc_Centroid();
		for(int i = 0; i<20;i++)
		{
			Update_Points1();
			Calc_Centroid();
		}
		return AllCluster;
	}
	
	public void TEST()
	{
		for(int i = 0; i < AllCluster.size(); i++)
		{
			System.out.println(AllCluster.get(i).getNum_DataPoints());
		}
	}
}








