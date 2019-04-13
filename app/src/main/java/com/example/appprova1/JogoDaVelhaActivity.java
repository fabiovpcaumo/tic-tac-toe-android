package com.example.appprova1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class JogoDaVelhaActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Integer> arrayX = new ArrayList<>();
    private ArrayList<Integer> arrayO = new ArrayList<>();
    private boolean xIsNext = false;
    private TextView status, tvArrayX, tvArrayO, gameProgress;
    private Button zerozero, zeroone, zerotwo, onezero, oneone, onetwo, twozero, twoone, twotwo;
    private ArrayList<Integer> wincondition1, wincondition2, wincondition3, wincondition4,
            wincondition5, wincondition6, wincondition7, wincondition8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_da_velha);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.JOGO_MESSAGE);

        TextView textView = findViewById(R.id.textView4);
        textView.setText(message);

//        Botões da primeira linha
        zerozero = findViewById(R.id.button3);
        zerozero.setOnClickListener(this);
        zeroone = findViewById(R.id.button4);
        zeroone.setOnClickListener(this);
        zerotwo = findViewById(R.id.button5);
        zerotwo.setOnClickListener(this);


//        Botões da segunda linha
        onezero = findViewById(R.id.button6);
        onezero.setOnClickListener(this);
        oneone = findViewById(R.id.button7);
        oneone.setOnClickListener(this);
        onetwo = findViewById(R.id.button8);
        onetwo.setOnClickListener(this);

//        Botões da terceira linha
        twozero = findViewById(R.id.button9);
        twozero.setOnClickListener(this);
        twoone = findViewById(R.id.button10);
        twoone.setOnClickListener(this);
        twotwo = findViewById(R.id.button11);
        twotwo.setOnClickListener(this);

        // Status do jogo
        status = findViewById(R.id.textView9);
        tvArrayX = findViewById(R.id.textView7);
        tvArrayO = findViewById(R.id.textView8);
        gameProgress = findViewById(R.id.textView14);

        //Linhas horizontais
        wincondition1 = new ArrayList<>(Arrays.asList(0, 1, 2));
        wincondition2 = new ArrayList<>(Arrays.asList(3, 4, 5));
        wincondition3 = new ArrayList<>(Arrays.asList(6, 7, 8));

        // Linhas verticais
        wincondition4 = new ArrayList<>(Arrays.asList(0, 3, 6));
        wincondition5 = new ArrayList<>(Arrays.asList(1, 4, 7));
        wincondition6 = new ArrayList<>(Arrays.asList(2, 5, 8));

        // Linhas diagonais
        wincondition7 = new ArrayList<>(Arrays.asList(0, 4, 8));
        wincondition8 = new ArrayList<>(Arrays.asList(2, 4, 6));

    }

    @Override
    public void onClick(View v) {
        int buttonValue = 0;

        if (v.getId() == R.id.button3) {
            addToArray(buttonValue);
            changeButtonState(zerozero);
            xIsNext = !xIsNext;
        } else if (v.getId() == R.id.button4) {
            buttonValue = 1;
            addToArray(buttonValue);
            changeButtonState(zeroone);
            xIsNext = !xIsNext;
        } else if (v.getId() == R.id.button5) {
            buttonValue = 2;
            addToArray(buttonValue);
            changeButtonState(zerotwo);
            xIsNext = !xIsNext;
        } else if (v.getId() == R.id.button6) {
            buttonValue = 3;
            addToArray(buttonValue);
            changeButtonState(onezero);
            xIsNext = !xIsNext;
        } else if (v.getId() == R.id.button7) {
            buttonValue = 4;
            addToArray(buttonValue);
            changeButtonState(oneone);
            xIsNext = !xIsNext;
        } else if (v.getId() == R.id.button8) {
            buttonValue = 5;
            addToArray(buttonValue);
            changeButtonState(onetwo);
            xIsNext = !xIsNext;
        } else if (v.getId() == R.id.button9) {
            buttonValue = 6;
            addToArray(buttonValue);
            changeButtonState(twozero);
            xIsNext = !xIsNext;
        } else if (v.getId() == R.id.button10) {
            buttonValue = 7;
            addToArray(buttonValue);
            changeButtonState(twoone);
            xIsNext = !xIsNext;
        } else {
            buttonValue = 8;
            addToArray(buttonValue);
            changeButtonState(twotwo);
            xIsNext = !xIsNext;
        }
        changeGameState();
        gameProgress.setText(checkVictory(arrayO));
        gameProgress.setText(checkVictory(arrayX));
    }

    private void changeButtonState(Button button) {

        if (xIsNext) {
            button.setText("O");
        } else {
            button.setText("X");
        }
        button.setOnClickListener(null);
    }

    private void changeGameState() {
        status.setText(xIsNext ? "Próximo jogador: X" : "Próximo jogador: O");

        tvArrayO.setText(arrayO.toString());
        tvArrayX.setText(arrayX.toString());
    }

    private void addToArray(int value) {

        if (this.xIsNext) {
            this.arrayO.add(value);

        } else {
            this.arrayX.add(value);

        }

    }

    private void deactivateAll() {
        zerozero.setOnClickListener(null);
        zeroone.setOnClickListener(null);
        zerotwo.setOnClickListener(null);
        onezero.setOnClickListener(null);
        oneone.setOnClickListener(null);
        onetwo.setOnClickListener(null);
        twozero.setOnClickListener(null);
        twoone.setOnClickListener(null);
        twotwo.setOnClickListener(null);
    }

    private String checkVictory(ArrayList<Integer> array) {
        if (array.containsAll(wincondition1) || array.containsAll(wincondition2) ||
                array.containsAll(wincondition3) || array.containsAll(wincondition4) ||
                array.containsAll(wincondition5) || array.containsAll(wincondition6) ||
                array.containsAll(wincondition7) || array.containsAll(wincondition8)
        ) {
            deactivateAll();
            if (array.equals(arrayX)) {
                System.out.println("X");
                return "X é o vencedor!";
            } else {
                System.out.println("O");
                return "O é o vencedor!";
            }

        }
        return "Jogo em progresso";
    }
}


