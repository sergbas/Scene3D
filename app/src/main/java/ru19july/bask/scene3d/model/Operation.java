package ru19july.bask.scene3d.model;

import android.util.Log;

import java.util.HashMap;

public class Operation {
	private static final String TAG = Operation.class.getSimpleName();
	public int Left;
	public int Right;
	public String Name;

	public Operation(String name, int left, int right){
		Name = name;
		Left = left;
		Right = right;
	}
	
	public int GetResult(HashMap<Integer, Integer> pointPosition)
	{
		Log.d(TAG, "GetResult, pointPosition: " + pointPosition);
		if(pointPosition == null) return 0;

		Log.d(TAG, "GetResult: " + Name + ":" + pointPosition);
		Log.d(TAG, "GetResult. L/R: " + Left + " / " + Right);

		int left = pointPosition.get(Left)+1;
		int right = pointPosition.get(Right)+1;
		int result = 0;

		if (Name.equals("-"))
			result = OperationRule.RuleTable[left][right][1];
		if (Name.equals("+"))
			result = OperationRule.RuleTable[left][right][3];
		if (Name.equals("&"))
			result = OperationRule.RuleTable[left][right][4];

		//Log.i("GetResult()", "A(" + (left-1) + ") "+Name+" " + "B("+(right-1) + ") = " + result);

		return result;
	}
}
