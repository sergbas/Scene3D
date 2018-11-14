package ru19july.bask.scene3d.model;

public class Color {
	public int R;
	public int G;
	public int B;
	
	//Color - ��� ������!
	public static Color Black()
	{
		return FromArgb(0, 0, 0);
	}
	
	public static Color Red()
	{
		return FromArgb(255, 0, 0);
	}
	
	public static Color Green()
	{
		return FromArgb(0, 255, 0);
	}
	
	public static Color Blue()
	{
		return FromArgb(0, 0, 255);
	}
	
	public static Color Yellow()
	{
		return FromArgb(255, 255, 0);
	}
	
	public static Color Cyan()
	{
		return FromArgb(0, 255, 255);
	}
	
	public static Color Magenta()
	{
		return FromArgb(255, 0, 255);
	}
	
	public static Color White()
	{
		return FromArgb(255, 255, 255);
	}
	
	public static Color Gray()
	{
		return FromArgb(127, 127, 127);
	}
	
	public static Color FromArgb(int r, int g, int b)
	{
		Color c = new Color();
		c.R = r;
		c.G = g;
		c.B = b;
		return c;
	}
	
	public static int ToInt(Color c)
	{
		return 0xff000000 + (c.B & 0xff) + ((c.G >> 8) & 0xff) + ((c.R >> 16) & 0xff); 
	}
}
