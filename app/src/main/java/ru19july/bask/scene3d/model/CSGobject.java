package ru19july.bask.scene3d.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CSGobject {
	public String Name;
	public ArrayList<Integer> objIndex;

	public ArrayList<Operation> operations;
	
	public CSGobject(String name)
	{
		Name = name;
		objIndex = new ArrayList<Integer>();
		operations = new ArrayList<Operation>();
	}

	public int Calculate(HashMap<Integer, Integer> pointPosition) {
		int result = 0;
		
		for(int i=0;i<operations.size();i++)
		{
			Operation op = operations.get(i);
			int subResult = op.GetResult(pointPosition);
			//Log.i("Calculate:operations", pointPosition.get(op.Left) + " " + op.Name + " " + pointPosition.get(op.Right) + " => " + subResult);

			result = subResult;
		}
		return result;
	}
}
