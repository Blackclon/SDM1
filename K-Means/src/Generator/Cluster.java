package Generator;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
	
	private int Num_DataPoints;
	private List<DataPoint> DataInCluster = new ArrayList<DataPoint>();
	private DataPoint Centroid;
	
	public Cluster(int _Num_DataPoints)
	{
		Num_DataPoints = _Num_DataPoints;
	}
	public void add_Point(DataPoint Point){DataInCluster.add(Point);}
	
	public int getNum_DataPoints() {
		return Num_DataPoints;
	}
	public void setNum_DataPoints(int toSet) {
		Num_DataPoints = toSet;
	}
	public List<DataPoint> DataInCluster() {
		return DataInCluster;
	}
	
	public void set_Centroid(DataPoint Center){
		Centroid = Center;
	}
	
	public DataPoint get_Centroid(){return Centroid;}

}
