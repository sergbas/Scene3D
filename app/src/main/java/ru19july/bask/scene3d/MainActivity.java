package ru19july.bask.scene3d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import ru19july.bask.scene3d.parser.LangClass;
import ru19july.bask.scene3d.parser.ListenerOrientedParser;
import ru19july.bask.scene3d.Parser.VisitorOrientedParser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String code = "class SomeClass {\n" +
                "    fun1 {\n" +
                "        instruction11\n" +
                "        instruction12\n" +
                "    }\n" +
                "    fun2 {\n" +
                "        instruction21\n" +
                "        instruction22\n" +
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
    }
}
