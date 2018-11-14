package ru19july.bask.scene3d.model;

import java.util.ArrayList;

public class Plane extends BaseObject {
    public double d;
    public Vector N;
    public Vector P;

    public Plane(Vector P, Vector N, Color col, double reflect, double transparent, double n) {
        this.P = P;
        this.N = N.normalize();
        this.d = P.magnitude();
        material.color = col;
        material.reflictivity = reflect;
        material.transparency = transparent;
        n2 = n;
    }

    public ArrayList<RayPoint> Intersection(Ray ray) {
        ArrayList<RayPoint> RayIntersection = new ArrayList<RayPoint>();

        Vector D = Vector.op_minus(ray.p2, ray.p1).normalize();
        double t = (-this.d - Vector.op_mult(ray.p1, this.N)) / Vector.op_mult(D, N);

        if (t > 0) {
            RayPoint rp = new RayPoint();
            rp.p = Vector.op_plus(ray.p1, Vector.op_mult(D, t));
            rp.normal = N;
            rp.t = t;
            rp.obj_index = this.index;
            RayIntersection.add(rp);
        }
        return RayIntersection;
    }

    public Color GetColor(Vector p) {
    	/*
    	double dist = Vector.op_minus(p, this.P).magnitude();
        int k = ((int)(dist / 50)) % 2;
        Color col = Color.FromArgb(0, 0, 0);
        if (k == 1) col = Color.FromArgb(150, 150, 150);
    	*/

        return material.color;
    }

    public int GetPointPosition(Vector point) {
        return 1;
    }

}