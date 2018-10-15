package ru19july.bask.scene3d.model;

public class Vector
{
	public double m_x, m_y, m_z;
	
	public Vector()
	{
		m_x=m_y=m_z=0.0f;
	}

	public Vector(double x,double y,double z)
	{
		m_x = x;
		m_y = y;
		m_z=z;
	}

	public Vector(Vector vec)
	{
		m_x=vec.m_x;
		m_y=vec.m_y;
		m_z=vec.m_z;
	}

	static public Vector op_plus (Vector v1, Vector v2)
	{
		Vector result = new Vector();

		result.m_x = v1.m_x + v2.m_x;
		result.m_y = v1.m_y + v2.m_y;
		result.m_z = v1.m_z + v2.m_z;

		return result;
	}

	static public Vector op_plus (Vector v1, double d)
	{
		Vector result = new Vector();

		// perform arithmetic
		result.m_x=v1.m_x+d;
		result.m_y=v1.m_y+d;
		result.m_z=v1.m_z+d;

		return result;
	}

	static public Vector op_minus (Vector v1, Vector v2)
	{
		Vector result = new Vector();

		result.m_x=v1.m_x-v2.m_x;
		result.m_y=v1.m_y-v2.m_y;
		result.m_z=v1.m_z-v2.m_z;

		return result;
	}
	
	static public double op_mult (Vector v1, Vector v2)
	{
		double result = v1.m_x*v2.m_x + v1.m_y*v2.m_y + v1.m_z*v2.m_z;
		return result;
	}

	static public Vector op_mult (Vector vec, double f)
	{
		Vector result=new Vector();

		result.m_x=vec.m_x*f;
		result.m_y=vec.m_y*f;
		result.m_z=vec.m_z*f;

		return result;
	}

	static public Vector op_div (Vector v1, Vector v2)
	{
		Vector result = new Vector();

		if(v2.m_x!=0.0f)
			result.m_x=v1.m_x/v2.m_x;
		else
			result.m_x=0.0f;

		if(v2.m_y!=0.0f)
			result.m_y=v1.m_y/v2.m_y;
		else
			result.m_y=0.0f;

		if(v2.m_z!=0.0f)
			result.m_z=v1.m_z/v2.m_z;
		else
			result.m_z=0.0f;

		return result;
	}

	public double magnitude()
	{
		return Math.sqrt( (m_x*m_x) + (m_y*m_y) + (m_z*m_z));
	}

	public double magnitude2()
	{
		return (m_x*m_x) + (m_y*m_y) + (m_z*m_z);
	}

	public Vector normalize()
	{
		Vector result = new Vector();

		double mag=this.magnitude();

		if(mag == 0.0f)
			return result;

		result.m_x=m_x/mag;
		result.m_y=m_y/mag;
		result.m_z=m_z/mag;

		return result;
	}

	public double dotproduct(Vector vec)
	{
		double mag=this.magnitude()*vec.magnitude();

		if(mag!=0.0f)
			return ( (m_x*vec.m_x) + (m_y*vec.m_y) + (m_z*vec.m_z) )/mag;
		else
			return 0.0f;
	}

	public Vector crossproduct(Vector vec)
	{
		Vector result=new Vector();

		result.m_x=(m_y*vec.m_z) - (m_z*vec.m_x);
		result.m_y=(m_z*vec.m_x) - (m_x*vec.m_z);
		result.m_z=(m_x*vec.m_y) - (m_y*vec.m_x);

		return result;
	}

}