package com.example.appprova1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String JOGO_MESSAGE = "com.example.appprova1.JOGO_DA_VELHA";
    public static final String SOBRE_MESSAGE = "com.example.appprova1.SOBRE_APP";
    public static int gameCounter = 0;
    private TextView tvGameCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGameCounter = findViewById(R.id.textView10);
        tvGameCounter.setText(Integer.toString(gameCounter));
    }

    public void startJogo(View view){
        gameCounter += 1;
        Intent intent = new Intent(this, JogoDaVelhaActivity.class);
        intent.putExtra(JOGO_MESSAGE, "Jogo da Velha");
        startActivity(intent);
    }

    public void startSobre(View view){
        Intent intent = new Intent(this, SobreAppActivity.class);
        intent.putExtra(SOBRE_MESSAGE, "Sobre o Aplicativo");
        startActivity(intent);
    }
}
