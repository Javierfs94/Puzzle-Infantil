package com.example.puzzleinfantil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> piezasIzquierda = new ArrayList<String>();
    ArrayList<String> piezasCentrales = new ArrayList<String>();
    ArrayList<String> piezasDerecha = new ArrayList<String>();

    Button botonIzquierda;
    Button botonCentro ;
    Button botonDerecha;

    String pieza1;
    String pieza2;
    String pieza3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonIzquierda = (Button) findViewById(R.id.buttonIzquierda);
        botonCentro = (Button) findViewById(R.id.buttonCentro);
        botonDerecha = (Button) findViewById(R.id.buttonDerecha);

        Field[] drawablesFields = com.example.puzzleinfantil.R.drawable.class.getFields();

        for (Field field : drawablesFields) {
            try {
               String[] cadenas = field.getName().split("_");
                if (cadenas[0].equals("puzzle")){
                    if (cadenas[2].equals("1")){
                        piezasIzquierda.add(field.getName());
                    }
                    if (cadenas[2].equals("2")){
                        piezasCentrales.add(field.getName());
                    }
                    if (cadenas[2].equals("3")){
                        piezasDerecha.add(field.getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        inicializarPiezas(piezasIzquierda, piezasCentrales, piezasDerecha);

        botonIzquierda.setOnClickListener(cambiarIzquierda);
        botonCentro.setOnClickListener(cambiarCentro);
        botonDerecha.setOnClickListener(cambiarDerecha);
    }

    private View.OnClickListener cambiarIzquierda = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int indice = piezasIzquierda.indexOf(pieza1);
            final String TAG = "MyActivity";
            int resID;

            if (indice == (piezasIzquierda.size()-1)){
                pieza1 = piezasIzquierda.get(0);
                resID = getResources().getIdentifier(pieza1 , "drawable", getPackageName());
                botonIzquierda.setBackgroundResource(resID);
            }else {
                pieza1 = piezasIzquierda.get(indice + 1);
                resID = getResources().getIdentifier(pieza1 , "drawable", getPackageName());
                botonIzquierda.setBackgroundResource(resID);
            }

            String[] pieza1Partida = pieza1.split("_");
            String[] pieza2Partida = pieza2.split("_");
            String[] pieza3Partida = pieza3.split("_");
            if (pieza1Partida[1].equals(pieza2Partida[1]) && pieza1Partida[1].equals(pieza3Partida[1])){
               lanzar();
            }
        }
    };

    private View.OnClickListener cambiarCentro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int indice = piezasCentrales.indexOf(pieza2);
            final String TAG = "MyActivity";
            int resID;

            if (indice == (piezasCentrales.size()-1)){
                pieza2 = piezasCentrales.get(0);
                resID = getResources().getIdentifier(pieza2 , "drawable", getPackageName());
                botonCentro.setBackgroundResource(resID);
            }else {
                pieza2 = piezasCentrales.get(indice + 1);
                resID = getResources().getIdentifier(pieza2 , "drawable", getPackageName());
                botonCentro.setBackgroundResource(resID);
            }

            String[] pieza1Partida = pieza1.split("_");
            String[] pieza2Partida = pieza2.split("_");
            String[] pieza3Partida = pieza3.split("_");
            if (pieza1Partida[1].equals(pieza2Partida[1]) && pieza1Partida[1].equals(pieza3Partida[1])){
                lanzar();
            }

        }
    };

    private View.OnClickListener cambiarDerecha = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int indice = piezasDerecha.indexOf(pieza3);
            final String TAG = "MyActivity";
            int resID;


            if (indice == (piezasDerecha.size()-1)){
                pieza3 = piezasDerecha.get(0);
                resID = getResources().getIdentifier(pieza3 , "drawable", getPackageName());
                botonDerecha.setBackgroundResource(resID);
            }else {
                pieza3 = piezasDerecha.get(indice + 1);
                resID = getResources().getIdentifier(pieza3 , "drawable", getPackageName());
                botonDerecha.setBackgroundResource(resID);
            }

            String[] pieza1Partida = pieza1.split("_");
            String[] pieza2Partida = pieza2.split("_");
            String[] pieza3Partida = pieza3.split("_");
            if (pieza1Partida[1].equals(pieza2Partida[1]) && pieza1Partida[1].equals(pieza3Partida[1])){
                lanzar();
            }
        }
    };

    private void lanzar() {
        Intent i = new Intent(this, Victory.class );
        startActivity(i);
    }

    private void inicializarPiezas(ArrayList<String> piezasIzquierda, ArrayList<String> piezasCentro, ArrayList<String> piezasDerecha ){
        Random random = new Random();
        pieza1 = piezasIzquierda.get(random.nextInt(piezasIzquierda.size()));
        pieza2 = piezasCentro.get(random.nextInt(piezasCentro.size()));
        pieza3 = piezasDerecha.get(random.nextInt(piezasDerecha.size()));

        botonIzquierda.setBackgroundResource(getResources().getIdentifier(pieza1, "drawable", getPackageName()));
        botonCentro.setBackgroundResource(getResources().getIdentifier(pieza2, "drawable", getPackageName()));
        botonDerecha.setBackgroundResource(getResources().getIdentifier(pieza3, "drawable", getPackageName()));

    }

}
