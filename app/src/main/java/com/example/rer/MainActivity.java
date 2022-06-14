package com.example.rer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCamera;
    Button btngalery;
    ImageView imageView;
    Paint paint = new Paint();
    float xPixel;
   // Bitmap bitmap = Bitmap.createBitmap(R.id.imageView);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera = findViewById(R.id.cameraButton);
        btngalery = findViewById(R.id.galeryButton);
        imageView = findViewById(R.id.imageView);
        ArrayList <Float> coords = new ArrayList<Float>();


        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  abrirCamara();
            }
        });

        btngalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSystemStorage();

            }
        });

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        xPixel = event.getX();
                        String xString = String.valueOf(xPixel);
                        System.out.println("\n The x coordinate is: " + xString);
                        coords.add(xPixel);
                        System.out.println("The ArrayList contains: " + coords);

                        if(coords.size()> 1) {

                            if (coords.get(0) > coords.get(1)) {

                                float addition = coords.get(0) - coords.get(1);
                                System.out.println("the distance between objects is: " + addition);
                            }

                            if (coords.get(0) < coords.get(1)) {

                                float addition = coords.get(1) - coords.get(0);
                                System.out.println("the distance between objects is: " + addition);
                            }

                        }

                }
                return false;
            }
        });

    }

//    public int getPixelColor(int x, int y) {
//        Color color = Bitmap.get
//    }

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 1);
       // }
    }

    private void openSystemStorage() {
        Intent intent2 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent2.setType("image/");
        startActivityForResult(intent2.createChooser(intent2,"seleccione la app"), 10);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imgBitmap);
        }

        if (requestCode ==10 && resultCode == RESULT_OK) {
            Uri path = data.getData();
            imageView.setImageURI(path);
        }
    }


     public void cleanArray (float anArray []) {
         for (int i = 0; i < anArray.length-1; i++) {
             anArray[i]=0;
             System.out.printf("\n el valor " + i + " es: " + anArray[i]);

         }

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}