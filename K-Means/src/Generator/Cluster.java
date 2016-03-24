package Generator;

import java.util.*;

public class Cluster {

	private int Num_DataPoints;
	private List<DataPoint> Points = new ArrayList<DataPoint>();
	
	public Cluster(int _Num_DataPoints)
	{
		Num_DataPoints = _Num_DataPoints;
	}
	
	public void add_Point(DataPoint Point){Points.add(Point);}
	
	public List<DataPoint> get_Points(){return Points;}
	
	public int get_Num_DataPoints(){return Num_DataPoints;}
}
