package com.example.pr_27_angelika;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Paint mPainto = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;

    public Draw2D(Context context) {
        super(context);

        // Выводим значок из ресурсов
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.kitten);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);
        mPainto.setStyle(Paint.Style.FILL);
        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);


        // Рисуем солнце
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(width - 30, 30, 250, mPaint);


        mPaint.setColor(Color.GREEN);
        //  canvas.drawRect(20, 650, 950, 680, mPaint);
        canvas.drawRect(0, canvas.getHeight() - 65, width, height, mPaint);


        // Рисуем текст
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(42);
        canvas.drawText("Место отдыха котят!", 14, height - 68, mPaint);

        // Текст под углом
        // int x = 810;
        int x = width - 350;
        int y = 500;

        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(40);
        String beam = "Лучик солнца!";

        canvas.save();
        // Создаём ограничивающий прямоугольник для наклонного текста
        // поворачиваем холст по центру текста
        canvas.rotate(-55, x + mRect.exactCenterX(), y + mRect.exactCenterY());

        // Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(beam, x, y, mPaint);

        // восстанавливаем холст
        canvas.restore();

        // Выводим изображение
        // canvas.drawBitmap(mBitmap, 450, 530, mPaint);
        canvas.drawBitmap(mBitmap, width - mBitmap.getWidth(), height - mBitmap.getHeight() - 10, mPaint);
    }
}