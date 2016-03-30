package Algorithm;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Generator.Cluster;
import Generator.DataPoint;
//import Graphics.HelpFunctions;

public class Calculus {
	private int Num_Cluster;
	private int Dimension;
	private List<Cluster> AllCluster = new ArrayList<Cluster>();
	private List<DataPoint> Points = new ArrayList<DataPoint>();
	private List<DataPoint> LastCentroids = new ArrayList<DataPoint>();
	private int Runs = 0;
	private int xmax;

	public Calculus(List<DataPoint> _Points, int _Num_Cluster, int _xmax)
	{
		Points = _Points;
		Dimension = _Points.get(0).getData().length;
		Num_Cluster = _Num_Cluster;
		xmax = _xmax;
		for(int i = 0;i<Num_Cluster; i++)
		{
			LastCentroids.add(new DataPoint(Dimension));
			AllCluster.add(new Cluster(0)); // Amount of Points unknown
		}
	}
	
	private void Initial3() // Random distribution of Points to Clusters and Calc of initial Centroids
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
	
	private void Initial1()
	{
		Random RandomGenerator = new Random();
		for(int i=0;i<Num_Cluster;i++)
		{
			int rand_x = RandomGenerator.nextInt(xmax);
			int rand_y = 	RandomGenerator.nextInt(xmax);
			double[] temp_array = {(double) rand_x,(double) rand_y};
			AllCluster.get(i).set_Centroid(new DataPoint(temp_array));
		}
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
			if(temp_Cluster.getNum_DataPoints() == 0)
			{
				continue;
			}
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
		Calc_Centroid();
	}
	private void Update_Points2()
	{
		double temp_dist = 0;
		double tempd = 0;
		int destcluster = 0;
		List<DataPoint> Centroids = new ArrayList<DataPoint>();
		for(int i=0;i<Num_Cluster;i++)
		{
			Centroids.add(AllCluster.get(i).get_Centroid());
		}
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
			destcluster = 0;
			temp_dist = Distance(Points.get(i),Centroids.get(0));
			for(int j = 1;j<Num_Cluster;j++)
			{
				tempd = Distance(Points.get(i),Centroids.get(j));
				if(tempd<temp_dist)
				{
					temp_dist=tempd;
					destcluster=j;
				}
			}
			AllCluster.get(destcluster).add_Point(Points.get(i));
			for(int k=0;k<Num_Cluster;k++)
			{
				AllCluster.get(k).setNum_DataPoints(AllCluster.get(k).DataInCluster().size());
			}
			Calc_Centroid();
		}
	}
	
	private double Distance(DataPoint p1, DataPoint p2)
	{
		double temp = 0;
		double temp0 = 0;
		double temp1 = 0;
		for(int i=0;i<Dimension;i++)
		{
			temp0 = p1.getData()[i];
			temp1 = p2.getData()[i];
			temp+=Math.pow((temp0 - temp1),2.0);
		}
		temp = Math.sqrt(temp);
		return temp;
	}
	
	private boolean ClusterChangeCheck()
	{
		int count = 0;
		int adder = 0;
		if(LastCentroids.isEmpty())
		{
			return true;
		}
		if(AllCluster.get(0).get_Centroid() == null)
		{
			return true;
		}
		for(int i = 0; i < AllCluster.size(); i++)
		{
			for(int j=0;j<Dimension;j++)
			{
				if(Math.abs((LastCentroids.get(i).getData()[j] - 
						AllCluster.get(i).get_Centroid().getData()[j])) < 0.00000001)
				{
					adder++;
				}
			}
			if(adder == Dimension)
			{
				count++;
			}
			adder = 0;
		}
		if(count == AllCluster.size())
		{
			return false;
		}
		return true;
		
	}
	
	private void UpdateCentroids()
	{
		for(int i = 0; i < Num_Cluster; i++)
		{
			LastCentroids.get(i).setData(AllCluster.get(i).get_Centroid().getData());
		}
	}
	
	public List<Cluster> getAllCluster(){
		return AllCluster;
	}
	
	public List<Double> ChoseAlgorythm(int I, int U)
	{
		List<Double> temp = new ArrayList<Double>();
		if(I == 1)
		{
			Initial1();
			System.out.println("Initial 1: ");
		}
		else
		{
			Initial2();
			System.out.println("Initial 2: ");
		}
		if(U == 1)
		{
			while(ClusterChangeCheck() == true)
			{
				UpdateCentroids();
				Update_Points1();
				Runs++;
				temp.add(ObjectiveFunction());
				
				
			}
			System.out.println(Runs + "steps till covergence.");
		}
		else
		{
			while(ClusterChangeCheck() == true)
			{
				UpdateCentroids();
				Update_Points2();
				Runs++;
				temp.add(ObjectiveFunction());
				
			}
			System.out.println(Runs + "steps till covergence.");
		}
		
		Runs = 0;
		return temp;
	}
	
	
	private double ObjectiveFunction()
	{
		double temp = 0;
		for(int i = 0; i < Num_Cluster; i++)
		{
			for(int j = 0; j < AllCluster.get(i).getNum_DataPoints(); j++)
			{
				temp += Math.pow(Distance(AllCluster.get(i).DataInCluster().get(j), AllCluster.get(i).get_Centroid()), 2.0);
			}
		}
		return temp;
	}
}









