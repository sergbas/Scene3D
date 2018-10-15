package ru19july.bask.scene3d;
/*
* Based on:
* http://jakubdziworski.github.io/java/2016/04/01/antlr_visitor_vs_listener.html
* */
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;
import java.util.Random;

import ru19july.bask.scene3d.model.*;
import ru19july.bask.scene3d.parser.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    final static int THREADS = 4;

    public static Bitmap bitmap;
    static int j;
    static Canvas canvas;
    long start;

    private ResponseReceiver receiver;
    public static ImageView image;
    public static Scene scene;

    ProgressDialog pd;
    Handler h;

    static int steps = 1;
    static int MAX_REFLECTIONS = 1;
    static int MAX_REFRACTIONS = 0;
    static double estimated = 0;
    static double donePercents = 0;
    static long time = 0;

    Button runButt;
    private Context context;
    private boolean showCornellBox = false;
    private boolean multithreadType = false;
    boolean testCSG = false;

    public class ResponseReceiver extends BroadcastReceiver {
        public static final String ACTION_RESP = "ru19july.bask.scene3d.intent.action.MESSAGE_PROCESSED";

        @Override
        public void onReceive(Context context, Intent intent) {
            //Log.e(TAG, "ResponseReceiver.onReceive");
            TextView result = (TextView) findViewById(R.id.text);
            //String text = intent.getStringExtra(RenderIntentService.PARAM_OUT_MSG);
            image.setImageBitmap(bitmap);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String code = "scene MyScene {\n" +
                "    start(){start}\n" +
                "    cylinder(100, 200, 50);" +
                "    sphere(128, 256, 10) {\n" +
                "        drawSphere\n" +
                "        invalidate\n" +
                "    }\n" +
                "    move(toX, toY) {\n" +
                "        updateCoordinates\n" +
                "        swapBuffers\n" +
                "        draw\n" +
                "    }\n" +
                "};";

        ListenerOrientedParser parser1 = new ListenerOrientedParser();
        LangScene parsedCode1 = parser1.parse(code);
        Gson gson = new Gson();
        String json1 = gson.toJson(parsedCode1);

        Log.d(TAG, "ListenerOrientedParser: " + json1);

        VisitorOrientedParser parser2 = new VisitorOrientedParser();
        LangScene parsedCode2 = parser2.parse(code);
        String json2 = gson.toJson(parsedCode2);
        Log.d(TAG, "VisitorOrientedParser : " + json2);

        executeCode(parsedCode1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        context = this;

        runButt = (Button) findViewById(R.id.button1);

        Board board = new Board();

        IntentFilter filter = new IntentFilter(ResponseReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);

        image = (ImageView) findViewById(R.id.imageView1);
        image.setImageBitmap(board.Init());
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(image != null && bitmap != null)
            image.setImageBitmap(bitmap);
    }

    public Scene InitScene()
    {
        Log.e(TAG, "InitScene");
        Scene sc = new Scene();
        sc.light = new Vector(0.0f, -199f, 0.0f);

        sc.SetCamera(new Vector(-110.1f, -110.1f, -110.1f), 180f, 0f);
        sc.MaxReflection = MAX_REFLECTIONS;
        sc.MaxRefraction = MAX_REFRACTIONS;
        sc.FOCUS = 300;
        sc.Shadows = false;

        Random r = new Random();

        if(showCornellBox) {
            sc.BeginCSG("CornellBox");
            sc.AddObject(new Plane(new Vector(0, 0, 100), new Vector(0, -1, 0), Color.Yellow(), 0.3, 0.0, 1.1));//back
            sc.AddObject(new Plane(new Vector(0, 200, 0), new Vector(0, 0, 1), Color.Red(), 0.3, 0.0, 1.1));//floor
            sc.AddObject(new Plane(new Vector(0, -200, 0), new Vector(0, 0, -1), Color.White(), 0.3, 0.0, 1.1));//bottom
            sc.AddObject(new Plane(new Vector(200, 0, 0), new Vector(-1, 0, 0), Color.Green(), 0.3, 0.0, 1.1));//left
            sc.AddObject(new Plane(new Vector(-200, 0, 0), new Vector(1, 0, 0), Color.Blue(), 0.3, 0.0, 1.1));//right
            sc.EndCSG();
            sc.csgObjects.get(0).operations.add(new Operation("+", 0, 1));
            sc.csgObjects.get(0).operations.add(new Operation("+", 0, 2));
            sc.csgObjects.get(0).operations.add(new Operation("+", 0, 3));
            sc.csgObjects.get(0).operations.add(new Operation("+", 0, 4));
        }


        if(testCSG)
        {
            sc.BeginCSG("CSG_Difference");
            sc.AddObject(new Sphere( 30f, -5f, 20f, 100f, Color.Red(), 0.1f, 0.0f, 1.1f));
            sc.AddObject(new Sphere(-30f, 10f, -10f, 100f, Color.Green(), 0.1f, 0.0f, 1.1f));
            sc.EndCSG();
            sc.csgObjects.get(sc.csgObjects.size()-1).operations.add(new Operation("-", 6, 5));

            sc.BeginCSG("CSG_Union");
            sc.AddObject(new Sphere( 90f, 30f, 90f, 100f, Color.Blue(), 0.1f, 0.0f, 1.1f));
            sc.AddObject(new Sphere( 50f, 50f, 50f, 100f, Color.Magenta(), 0.1f, 0.0f, 1.1f));
            sc.EndCSG();
            sc.csgObjects.get(sc.csgObjects.size()-1).operations.add(new Operation("&", 7, 8));
        }
        else{
            sc.BeginCSG("Balls");
            for(int i=0;i<10;i++)
            {
                try {
                    Thread.sleep(i*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int x = r.nextInt(300)-150;
                int y = r.nextInt(400)-200;
                int z = r.nextInt(200)-100;
                Log.i("sphere x,y,z", x+","+y+","+z);

                Color col = Color.FromArgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
                Sphere sph = new Sphere(
                        x, y, z,
                        r.nextInt(90)+10, col, 0.1, 0.5, 1.5);
                sc.AddObject(sph);
            }
            sc.EndCSG();
        }
        return sc;
    }

    @SuppressLint("HandlerLeak")
    public void Render(final Scene scene)
    {
        Log.i("Render", ">>");

        start = System.currentTimeMillis();

        j = 64;

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setTitle("Rendering");
        pd.setMessage("Please wait...");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMax(480-60-64);
        pd.setIndeterminate(true);
        pd.show();

        bitmap = Bitmap.createBitmap(320, 480, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        final Renderer renderer = new Renderer(scene);

        h = new Handler() {
            public void handleMessage(Message msg) {
                pd.setIndeterminate(false);

                time = System.currentTimeMillis() - start;

                final Paint p = new Paint();
                p.setAntiAlias(false);
                p.setStyle(Paint.Style.FILL_AND_STROKE);
                p.setStrokeWidth(1);

                if (pd.getProgress() < pd.getMax()) {
                    pd.incrementProgressBy(steps);
                    //pd.incrementSecondaryProgressBy(10);
                    h.sendEmptyMessageDelayed(0, 100);

                    time = System.currentTimeMillis() - start;
                    donePercents = 100*(j-64)/(420-64);
                    if(donePercents>0)
                        estimated = 100*time/donePercents;

                    long seconds = (long)((estimated - time)/1000);
                    long minutes = seconds / 60;

                    pd.setMessage("Please wait... " + minutes + "m " + (seconds % 60) + "s");

                    for (int i = 0; i < 320; i++)
                    {

                        Color c = renderer.Render(i - 320 / 2, j - 480 / 2);
                        int icol = 0xff000000 + (c.R << 16) + (c.G << 8) + c.B;
                        p.setColor(icol);

                        if(steps == 1)
                            canvas.drawPoint(i, j, p);
                        else
                            canvas.drawRect(i, j, i+steps+1, j+steps+1, p);

                        i+=(steps-1);
                    }
                    j+=steps;
                }
                else {
                    pd.dismiss();
                }

                time = System.currentTimeMillis() - start;

                image.setImageBitmap(bitmap);
            }
        };
        h.sendEmptyMessageDelayed(0, 200);

        image.setImageBitmap(bitmap);
    }

    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Log.e(TAG, "click");
                scene = InitScene();

                if(!multithreadType)
                    Render(scene);
                else {
                    Intent msgIntent = new Intent(context, RenderIntentService.class);
                    //msgIntent.putExtra(RenderIntentService.PARAM_IN_MSG, scene);
                    startService(msgIntent);
                }
                break;
            default:
                break;
        }
    }

    private void executeCode(LangScene scene) {
        Log.d(TAG, "executeCode: " + scene.getName());
        List<LangMethod> methods = scene.getMethods();
        for(LangMethod method : methods){
            Log.d(TAG, "-method: " + method.getName());

            List<LangParameter> parameters = method.getParameters();
            List<LangInstruction> instructions = method.getInstructions();

            if(method.getName().equals("sphere")){
                Log.d(TAG, ">>> RENDER: rlSphere(x=" + parameters.get(0).getValue() +
                        ", y=" + parameters.get(1).getValue() +
                        ", radius=" + parameters.get(2).getValue() + ")");

            }
            for (LangInstruction instruction : instructions){
                Log.d(TAG, "--instruction: " + instruction.getName());
            }
        }
    }

}
