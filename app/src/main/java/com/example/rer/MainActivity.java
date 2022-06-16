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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCamera;
    Button btngalery;
    ImageView imageView;
    Paint paint = new Paint();
    float xPixel;
    Calibration calObj = new Calibration();
    ArrayList <Float> coords = new ArrayList<Float>();
    boolean imageIsBeingDisplay = false;
    TextView textView;
    String distanciaFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature((Window.FEATURE_NO_TITLE));
      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        btnCamera = findViewById(R.id.cameraButton);
        btngalery = findViewById(R.id.galeryButton);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textDistance);
        textView.setVisibility(TextView.INVISIBLE);


        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(TextView.INVISIBLE);
                coords = new ArrayList<Float>();
                  imageIsBeingDisplay= false;
                  abrirCamara();
            }
        });

        btngalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(TextView.INVISIBLE);
                coords = new ArrayList<Float>();
                imageIsBeingDisplay= false;
                openSystemStorage();
            }
        });

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(imageIsBeingDisplay) {
                    switch (event.getAction()) {

                        case MotionEvent.ACTION_DOWN:
                            xPixel = event.getX();
                            String xString = String.valueOf(xPixel);
                            System.out.println("\n The x coordinate is: " + xString);
                            coords.add(xPixel);
                            System.out.println("The ArrayList contains: " + coords);
                            textView.setText("Para calcular la distancia, seleccione el mismo objeto en ambos lados.\nPrimer punto seleccionado!");

                            if (coords.size() > 1) {

                                if (coords.get(0) > coords.get(1)) {

                                    float addition = coords.get(0) - coords.get(1);
                                    System.out.println("the distance between objects is: " + addition);
                                    distanciaFinal = String.format("%.2f",calObj.getDistanceFromDevice(addition));
                                    textView.setText("El objeto se encuentra aproximadamente a:\n"+ distanciaFinal + "cm");
                                    textView.setVisibility(TextView.VISIBLE);
                                }

                                if (coords.get(0) < coords.get(1)) {

                                    float addition = coords.get(1) - coords.get(0);
                                    System.out.println("the distance between objects is: " + addition);
                                    distanciaFinal = String.format("%.2f",calObj.getDistanceFromDevice(addition));
                                    textView.setText("El objeto se encuentra aproximadamente a:\n"+ distanciaFinal + "cm" );
                                    textView.setVisibility(TextView.VISIBLE);
                                }

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
            imageIsBeingDisplay= true;
            textView.setText("Para calcular la distancia, seleccione el mismo objeto en ambos lados.");
            textView.setVisibility(TextView.VISIBLE);
        }

        if (requestCode ==10 && resultCode == RESULT_OK) {
            Uri path = data.getData();
            imageView.setImageURI(path);
            imageIsBeingDisplay= true;
            textView.setText("Para calcular la distancia, seleccione el mismo objeto en ambos lados.");
            textView.setVisibility(TextView.VISIBLE);
        }
    }

}