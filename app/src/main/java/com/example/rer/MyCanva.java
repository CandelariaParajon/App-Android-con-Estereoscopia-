//package com.example.rer;
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.RelativeLayout;
//
//public class MyCanva extends Activity {
//    private RelativeLayout rl_Main;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sms_read);
//        rl_Main = (RelativeLayout) findViewById(R.id.rl_main);
//        rl_Main.addView(new MyView(this));
//    }
//
//    class MyView extends View {
//
//
//        Paint paint = new Paint();
//        Point point = new Point();
//        public MyView(Context context) {
//            super(context);
//            paint.setColor(Color.RED);
//            paint.setStrokeWidth(15);
//            paint.setStyle(Paint.Style.STROKE);
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            Bitmap b= BitmapFactory.decodeResource(getResources(), R.drawable.imageView);
//            canvas.drawBitmap(b, 0, 0, paint);
//            canvas.drawCircle(point.x, point.y, 100, paint);
//        }
//
//        @Override
//        public boolean onTouchEvent(MotionEvent event) {
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    point.x = event.getX();
//                    point.y = event.getY();
//
//            }
//            invalidate();
//            return true;
//
//        }
//
//    }
//    class Point {
//        float x, y;
//    }
//}
