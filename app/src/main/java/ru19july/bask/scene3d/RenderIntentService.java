package ru19july.bask.scene3d;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

import ru19july.bask.scene3d.model.Renderer;
import ru19july.bask.scene3d.model.Scene;

import static ru19july.bask.scene3d.MainActivity.scene;

public class RenderIntentService extends IntentService {
    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_STATUS_MSG = "status";
    public static final String PARAM_OUT_MSG = "omsg";
    private static final String TAG = RenderIntentService.class.getSimpleName();

    private boolean isWorking = false;
    private Handler h;
    private ImageView image;
    private Canvas canvas;

    public RenderIntentService() {
        super("RenderIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG, "onHandleIntent");
        Scene s = (Scene) intent.getSerializableExtra(PARAM_IN_MSG);

        //if (state.equals("start")) isWorking = true;
        //if (state.equals("stop")) isWorking = false;

        drawRegion();
    }

    private void drawRegion() {
        image = MainActivity.image;
        MainActivity.bitmap = Bitmap.createBitmap(320, 480, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(MainActivity.bitmap);

        int sizeX = 4;
        int sizeY = 4;

        int dx = 320 / sizeX;
        int dy = 480 / sizeY;

        for (int j = 0; j < sizeY; j++)
            for (int i = 0; i < sizeX; i++)
                new MyRunnable(scene, i * dx, j * dy, (i + 1) * dx, (j + 1) * dy);
    }


    class MyRunnable implements Runnable {
        Thread thread;
        private int x1, y1, x2, y2;
        Renderer renderer;

        // Конструктор
        MyRunnable(Scene s, int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            renderer = new Renderer(s);

            thread = new Thread(this, "Thread");
            thread.start();
        }

        public void run() {
            try {
                final Paint p = new Paint();
                p.setAntiAlias(false);
                p.setStyle(Paint.Style.FILL_AND_STROKE);
                p.setStrokeWidth(1);

                for (int j = y1; j <= y2; j++) {
                    for (int i = x1; i <= x2; i++) {

                        //if enabled then rendering is ok, but very slow
                        //synchronized (scene)
                        {
                            ru19july.bask.scene3d.model.Color c = renderer.Render(i - 320 / 2, j - 480 / 2);
                            int icol = 0xff000000 + (c.R << 16) + (c.G << 8) + c.B;

                            //icol = getColorByXY(i, j);

                            p.setColor(icol);
                        }

                        canvas.drawPoint(i, j, p);

                        //System.currentTimeMillis()

                        //изредка обновляем картинку в UI
                        if (i % 16 == 0 && j % 16 == 0) {
                            Intent broadcastIntent = new Intent();
                            broadcastIntent.setAction(MainActivity.ResponseReceiver.ACTION_RESP);
                            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
                            broadcastIntent.putExtra(PARAM_OUT_MSG, i + ", " + j);
                            sendBroadcast(broadcastIntent);
                        }
                    }
                }
            } catch (Exception e) {
                Log.i(TAG, "Второй поток прерван");
            }
        }
    }

    private int getColorByXY(int i, int j) {
        int col = 0;

        //будем рисовать красный круг на синем фоне
        int dx = i - 160;
        int dy = j - 160;
        double d = Math.sqrt(dx * dx + dy * dy);
        if (d < 300) col = Color.RED;
        else if (d < 400) col = Color.argb(255, 0xff, 0x80, 0x00);
        else if (d < 500) col = Color.YELLOW;
        else col = (new Random()).nextDouble() < 0.99 ? Color.BLUE : Color.WHITE;
        return col;
    }

}