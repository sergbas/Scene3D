package ru19july.bask.scene3d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import ru19july.bask.scene3d.parser.LangClass;
import ru19july.bask.scene3d.parser.LangInstruction;
import ru19july.bask.scene3d.parser.LangMethod;
import ru19july.bask.scene3d.parser.ListenerOrientedParser;
import ru19july.bask.scene3d.Parser.VisitorOrientedParser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String code = "class Sphere {\n" +
                "    start(){start}\n" +
                "    draw(ZZZ) {\n" +
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
        LangClass parsedCode1 = parser1.parse(code);
        Gson gson = new Gson();
        String json1 = gson.toJson(parsedCode1);

        Log.d(TAG, "ListenerOrientedParser: " + json1);

        VisitorOrientedParser parser2 = new VisitorOrientedParser();
        LangClass parsedCode2 = parser2.parse(code);
        String json2 = gson.toJson(parsedCode2);
        Log.d(TAG, "VisitorOrientedParser : " + json2);

        executeCode(parsedCode1);
    }

    private void executeCode(LangClass langClass) {
        Log.d(TAG, "executeCode: " + langClass.getName());
        List<LangMethod> methods = langClass.getMethods();
        for(LangMethod method : methods){
            Log.d(TAG, "-method: " + method.getName());

            List<LangInstruction> instructions = method.getInstructions();

            for (LangInstruction instruction : instructions){
                Log.d(TAG, "--instruction: " + instruction.getName());
            }
        }
    }
}
