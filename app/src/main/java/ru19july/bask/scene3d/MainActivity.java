package ru19july.bask.scene3d;
/*
* Based on:
* http://jakubdziworski.github.io/java/2016/04/01/antlr_visitor_vs_listener.html
* */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import ru19july.bask.scene3d.parser.LangScene;
import ru19july.bask.scene3d.parser.LangInstruction;
import ru19july.bask.scene3d.parser.LangMethod;
import ru19july.bask.scene3d.parser.LangParameter;
import ru19july.bask.scene3d.parser.ListenerOrientedParser;
import ru19july.bask.scene3d.parser.VisitorOrientedParser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

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
