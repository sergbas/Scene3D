package ru19july.bask.scene3d.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Board {

	public Board()
	{
		
	}
	
	public Bitmap Init(){
		Bitmap bitmap = Bitmap.createBitmap(320, 480, Config.ARGB_8888);
        
        Canvas canvas = new Canvas(bitmap);
        Paint p = new Paint();
        p.setAntiAlias(true);  
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(1);  
          
        Paint p2 = new Paint();
        p2.setAntiAlias(true);  
        p2.setColor(0xffffffff);   
        p2.setStyle(Paint.Style.FILL);

        int sizeX = 10;
        int sizeY = 10;
        int cellsX = 320 / sizeX;
        int cellsY = (480 - 64 - 60) / sizeY;

        for(int j=0;j<cellsY;j++)
        {
        	for(int i=0;i<cellsX; i++)
        	{
                p.setColor(0xff777777);
                if((i+j)%2 != 0)
                    p.setColor(0xffffffff);
                
        		canvas.drawRect(i*sizeX,  j*sizeY + 64, (i+1)*sizeX-1, (j+1)*sizeY-1 + 64, p);
        	}
        }

        return bitmap;
	}
}
