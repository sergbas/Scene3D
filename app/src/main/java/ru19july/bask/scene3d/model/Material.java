package ru19july.bask.scene3d.model;

public class Material {
	public double diffuse;
	public double specular;
	public double reflictivity = 0.1;
	public double transparency = 0.1;
	public double translucency;
	public Color color;
	
	public Material(double reflect, double transparent){
		reflictivity = reflect;
		translucency = transparent;
	}
}
