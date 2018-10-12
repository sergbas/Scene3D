package ru19july.bask.scene3d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ru19july.bask.scene3d.Parser.LangClass;
import ru19july.bask.scene3d.Parser.ListenerOrientedParser;
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
        Log.d(TAG, "ListenerOrientedParser: " + parsedCode1);

        VisitorOrientedParser parser2 = new VisitorOrientedParser();
        LangClass parsedCode2 = parser2.parse(code);
        Log.d(TAG, "VisitorOrientedParser: " + parsedCode2);
    }
}
