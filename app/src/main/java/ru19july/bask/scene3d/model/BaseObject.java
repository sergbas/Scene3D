package ru19july.bask.scene3d.model;

import java.util.ArrayList;

public abstract class BaseObject {
	public int index;
	public double n2;
	public Material material;
	
	public BaseObject()
	{
		material = new Material(0.1, 0.1);
	}
	
	public ArrayList<RayPoint> Intersection(Ray ray)
	{
		return null;
	}
	
	public Color GetColor(Vector p)
	{
		return material.color;
	}
	
	public int GetPointPosition(Vector point)
	{
		return 1;
	}
}
