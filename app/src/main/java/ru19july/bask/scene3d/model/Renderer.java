package ru19july.bask.scene3d.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 1/25/2017.
 */
public class Renderer {
    private Scene scene;
    private int Reflections;
    private int Refractions;

    public Renderer(Scene s) {
        scene = s;
    }

    public Color Render(int x, int y) {
        Ray ray = ShootRay(x, y, 0.0);
        Reflections = 0;
        Refractions = 0;
        Color c = FullTrace(ray);
        return c;
    }

    private Ray ShootRay(int x, int y, double alpha) {
        Ray ray = new Ray();
        Vector p2 = new Vector(x + scene.getF_1()[0][3], y + scene.getF_1()[1][3], 0f + scene.getF_1()[2][3]);
        Vector p1 = new Vector(0f + scene.getF_1()[0][3], 0f + scene.getF_1()[1][3], -scene.FOCUS + scene.getF_1()[2][3]);

        Vector pob1 = new Vector(
                p1.m_x * Math.cos(alpha) - p1.m_y * Math.sin(alpha),
                p1.m_x * Math.sin(alpha) + p1.m_y * Math.cos(alpha),
                p1.m_z);
        Vector pob2 = new Vector(
                p2.m_x * Math.cos(alpha) - p2.m_y * Math.sin(alpha),
                p2.m_x * Math.sin(alpha) + p2.m_y * Math.cos(alpha),
                p2.m_z);

        ray.p1 = scene.EkrToObj(pob1);
        ray.p2 = scene.EkrToObj(pob2);

        return ray;
    }

    private Color FullTrace(Ray ray) {
        Color color = new Color();
        //color = (new Color()).Gray();
        RayPoint rp = Trace(ray);
        if (rp != null) {
            double ang_cos = Vector.op_mult((Vector.op_minus(scene.light, rp.p)).normalize(), rp.normal);
            Color obj_color = scene.objects.get(rp.obj_index).GetColor(rp.p);
            Color col = new Color();
            col.R = (int) (ang_cos * obj_color.R);
            col.G = (int) (ang_cos * obj_color.G);
            col.B = (int) (ang_cos * obj_color.B);

            //if (ang_cos>0)
            color = col;
            //else color = Color.Blue();

            if (scene.Shadows) {
                Ray ray2ligth = new Ray();
                ray2ligth.p1 = rp.p;
                ray2ligth.p2 = scene.light;
                ArrayList<RayPoint> pts = IntersectAllObjects(ray2ligth);

                if (pts.size() > 0) {
                    RayPoint pp = null;
                    double t_min = Double.MAX_VALUE;
                    for (int i = 0; i < pts.size(); i++)
                        if (pts.get(i).t < t_min && pts.get(i).t > 0) {
                            t_min = pts.get(i).t;
                            pp = pts.get(i);
                        }

                    if (pp != null)
                        if (pp.t > 1)
                            color = Color.FromArgb((int) (0.5f * color.R),
                                    (int) (0.5f * color.G),
                                    (int) (0.5f * color.B));
                }
            }

            if (Reflections++ < scene.MaxReflection && scene.objects.get(rp.obj_index).material.reflictivity > 0) {
                Vector fall = Vector.op_minus(rp.p, ray.p1).normalize();
                Vector norm = rp.normal.normalize();
                double cs = Vector.op_mult(fall, norm);
                Vector reflect = Vector.op_minus(fall, Vector.op_mult(Vector.op_mult(norm, cs), 2));

                Ray ray2 = new Ray();
                ray2.p1 = Vector.op_plus(rp.p, (Vector.op_mult(reflect, 0.000001f)));
                ray2.p2 = Vector.op_plus(rp.p, reflect);

                Color c2 = FullTrace(ray2);

                c2.R = (int) (c2.R * scene.objects.get(rp.obj_index).material.reflictivity);
                c2.G = (int) (c2.G * scene.objects.get(rp.obj_index).material.reflictivity);
                c2.B = (int) (c2.B * scene.objects.get(rp.obj_index).material.reflictivity);

                color = Color.FromArgb((int) ((color.R + c2.R) > 255 ? 255 : (color.R + c2.R)),
                        (int) ((color.G + c2.G) > 255 ? 255 : (color.G + c2.G)),
                        (int) ((color.B + c2.B) > 255 ? 255 : (color.B + c2.B)));
            }

            if (Refractions++ < scene.MaxRefraction && scene.objects.get(rp.obj_index).material.transparency > 0) {
                Vector fall = Vector.op_minus(rp.p, ray.p1).normalize();
                Vector norm = rp.normal.normalize();
                double cs1 = -Vector.op_mult(fall, norm);
                double n1 = 1.0002926f;
                double n2 = scene.objects.get(rp.obj_index).n2;
                double n = n1 / n2;
                double sq = 1.0f - n * n * (1.0f - cs1 * cs1);
                //if (sq>=0)
                {
                    double cs2 = Math.sqrt(sq);
                    Vector refr = Vector.op_plus(Vector.op_mult(fall, n), Vector.op_mult(norm, (n * cs1 - cs2)));

                    //Random rnd = new Random();
                    Ray ray2 = new Ray();
                    ray2.p1 = Vector.op_plus(rp.p, (Vector.op_mult(refr, 0.000001f)));
                    ray2.p2 = Vector.op_plus(rp.p, refr);

                    Color c3 = new Color();
                    c3 = FullTrace(ray2);

                    c3.R = (int) (c3.R * scene.objects.get(rp.obj_index).material.transparency);
                    c3.G = (int) (c3.G * scene.objects.get(rp.obj_index).material.transparency);
                    c3.B = (int) (c3.B * scene.objects.get(rp.obj_index).material.transparency);

                    //Log.i("c3", c3.R + ", " + c3.G + ", " + c3.B);

                    color = Color.FromArgb(((color.R + c3.R) > 255 ? 255 : (color.R + c3.R)),
                            ((color.G + c3.G) > 255 ? 255 : (color.G + c3.G)),
                            ((color.B + c3.B) > 255 ? 255 : (color.B + c3.B)));
                }

            }
        }
        return color;
    }


    private RayPoint Trace(Ray ray) {
        RayPoint pp = null;

        ArrayList<RayPoint> intersections = IntersectAllObjects(ray);

        double t_min = Double.MAX_VALUE;
        for (int i = 0; i < intersections.size(); i++)
            if (intersections.get(i).t <= t_min) {
                t_min = intersections.get(i).t;
                pp = intersections.get(i);
            }

        return pp;
    }

    private ArrayList<RayPoint> IntersectAllObjects(Ray ray) {
        ArrayList<RayPoint> RayIntersection = new ArrayList<RayPoint>();

        for (int j = 0; j < scene.csgObjects.size(); j++) {
            CSGobject csg = scene.csgObjects.get(j);
            for (int i = 0; i < csg.objIndex.size(); i++) {
                int indx = csg.objIndex.get(i);

                BaseObject obj = scene.objects.get(indx);
                obj.index = indx;

                //Log.e("Renderer", "scene.objects.set: " + indx + " => " + obj);
                //TODO: изменить!!!
                scene.objects.set(indx, obj);

                ArrayList<RayPoint> rps = scene.objects.get(indx).Intersection(ray);

                for (int k = 0; k < rps.size(); k++) {
                    //HashMap, but not Hashtable, because we don't need nulls and synchronization (low speed)
                    //multi-threading needs Hashtable
                    HashMap<Integer, Integer> pointPosition = new HashMap<Integer, Integer>();

                    pointPosition.put(indx, 0);//the point k LAYS ON (0) the primitive i
                    //Log.i("pointPosition.put", i + "->" + 0);

                    for (int i2 = 0; i2 < csg.objIndex.size(); i2++) {
                        if (i2 == i) continue;

                        int indx2 = csg.objIndex.get(i2);
                        BaseObject obj2 = scene.objects.get(indx2);
                        //obj2.index = indx2;
                        //objects.set(indx2, obj2);

                        //if(indx == indx2) continue;

                        int ploc = obj2.GetPointPosition(rps.get(k).p);
                        pointPosition.put(indx2, ploc);
                        //Log.i("pointPosition.put", i2 + "->" + ploc);
                    }

                    int pos = csg.Calculate(pointPosition);

                    //Log.i("IntersectAllObjects", "pos:" + pos);
                    if (pos == 0 || pos == 1)
                        RayIntersection.add(rps.get(k));
                }
            }
        }

        return RayIntersection;
    }

}