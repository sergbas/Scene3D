package ru19july.bask.scene3d.model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class Scene implements Serializable {
	private static final String TAG = "Scene";
	private final double[][] F = new double[4][4];
	private final double[][] F_1 = new double[4][4];
	public double FOCUS = 10000.0f;
	public final double alpha = 0.0f;
	public boolean Shadows = true;
	public int MaxReflection = 3;
	public int MaxRefraction = 0;
	public Vector light;
	
	public ArrayList<BaseObject> objects;//private
	public ArrayList<CSGobject> csgObjects;//private

	public Scene()
	{
		objects = new ArrayList<BaseObject>();
		csgObjects = new ArrayList<CSGobject>();
		light = new Vector();
	}

	public void SetCamera(Vector pos, double p, double q)
	{
		double lat = q * Math.PI/180.0f;
		double lon = p * Math.PI/180.0f;
		double cos_a = Math.cos(lat);
		double sin_a = Math.sin(lat);
		double cos_b = Math.cos(lon);
		double sin_b = Math.sin(lon);
		double Sa = pos.m_x * cos_a - pos.m_y * sin_a;
		double Sb = -pos.m_z * cos_b + sin_b * (pos.m_x * sin_a + pos.m_y * cos_a);
		double Sc = pos.m_z * sin_b + cos_b * (pos.m_x * sin_a + pos.m_y * cos_a);
		F[0][0] = - cos_a;
		F[1][0] = - sin_a * sin_b;
		F[2][0] = - sin_a * cos_b;
		F[3][0] = 0.0f;
		F[0][1] = sin_a;
		F[1][1] = - cos_a * sin_b;
		F[2][1] = - cos_a * cos_b;
		F[3][1] = 0.0f;
		F[0][2] = 0.0f;
		F[1][2] = cos_b * sin_b;
		F[2][2] = sin_b;
		F[3][2] = 0.0f;
		F[0][3] = Sa;
		F[1][3] = Sb;
		F[2][3] = Sc;
		F[3][3] = 1.0f;
		
		F_1[0][0] = - cos_a;
		F_1[1][0] = sin_a;
		F_1[2][0] = 0.0f;
		F_1[3][0] = 0.0f;
		F_1[0][1] = - sin_a * sin_b;
		F_1[1][1] = - sin_b * cos_a;
		F_1[2][1] = cos_b;
		F_1[3][1] = 0.0f;
		F_1[0][2] = - sin_a * cos_b;
		F_1[1][2] = - cos_b * cos_a;
		F_1[2][2] = - sin_b;
		F_1[3][2] = 0.0f;
		F_1[0][3] = pos.m_x;
		F_1[1][3] = pos.m_y;
		F_1[2][3] = pos.m_z;
		F_1[3][3] = 1.0f;
	}

	protected Vector EkrToObj(Vector p)
	{
		return new Vector(
			p.m_x * F_1[0][0] + p.m_y * F_1[0][1] + p.m_z * F_1[0][2] + F_1[0][3],
			p.m_x * F_1[1][0] + p.m_y * F_1[1][1] + p.m_z * F_1[1][2] + F_1[1][3],
			p.m_x * F_1[2][0] + p.m_y * F_1[2][1] + p.m_z * F_1[2][2] + F_1[2][3]
		);
	}
	
	public void BeginCSG(String name) {
		CSGobject csg = new CSGobject(name);
		csgObjects.add(csg);
	}


	public void AddObject(BaseObject object) {
		objects.add(object);
		CSGobject csg = csgObjects.get(csgObjects.size()-1);
		csg.objIndex.add(objects.size()-1);

		Gson gson = new Gson();
		String json = gson.toJson(object);
		Log.e(TAG, "AddObject: " + json + " => " +  objects);
	}


	public void EndCSG() {
		Log.i("CSG '" + csgObjects.get(csgObjects.size()-1).Name + "'", "objects:" + csgObjects.get(csgObjects.size()-1).objIndex.size() );
	}

	public double[][] getF_1() {
		return F_1;
	}

}
