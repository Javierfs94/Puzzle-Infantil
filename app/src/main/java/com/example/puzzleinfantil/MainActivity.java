package com.example.puzzleinfantil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // TODO: Cambiar a array dinamico
    ArrayList<String> piezasIzquierda = new ArrayList<String>();
    ArrayList<String> piezasCentrales = new ArrayList<String>();
    ArrayList<String> piezasDerecha = new ArrayList<String>();

    String pieza1 = "puzzle_1_1";
    String pieza2 = "puzzle_1_2";
    String pieza3 = "puzzle_1_3";

    // TODO Luego tienes que hacer dos cosas (LUEGO):
    //  - Inicializar el array de piezas de forma dinámica, leyendo del storage los ficheros
    //  - Inicializar las tres piezas a 3 random de ese array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botonIzquierda = (Button) findViewById(R.id.buttonIzquierda);
        final Button botonCentro = (Button) findViewById(R.id.buttonCentro);
        final Button botonDerecha = (Button) findViewById(R.id.buttonDerecha);

        botonIzquierda.setBackgroundResource(R.drawable.puzzle_2_1);
        botonCentro.setBackgroundResource(R.drawable.puzzle_1_2);
        botonDerecha.setBackgroundResource(R.drawable.puzzle_1_3);


        piezasIzquierda.add("puzzle_1_1");
        piezasIzquierda.add("puzzle_2_1");

        piezasCentrales.add("puzzle_1_2");
        piezasCentrales.add("puzzle_2_2");

        piezasDerecha.add("puzzle_1_3");
        piezasDerecha.add("puzzle_2_3");

        botonIzquierda.setOnClickListener(cambiarIzquierda);
        botonCentro.setOnClickListener(cambiarCentro);
        botonDerecha.setOnClickListener(cambiarDerecha);


    }

    private View.OnClickListener cambiarIzquierda = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Button botonIzquierda = (Button) findViewById(R.id.buttonIzquierda);
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
        }
    };

    private View.OnClickListener cambiarCentro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener cambiarDerecha = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };


}
