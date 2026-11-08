package com.example.douanetemporelle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    //lena aamalna declaration mta3 lmatricule
    private static final String MATRICULE = "14779584";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //aamalna recuperation mta3 layout wel textview wel button
        LinearLayout layout = findViewById(R.id.layout_result_YG);
        TextView txtResult = findViewById(R.id.txt_result_YG);
        Button btnNouveau = findViewById(R.id.btn_nouveau_YG);

        // sna3na instance mta3 intent jdida
        Intent intent = getIntent();

        // kharajna lverdict mel intent
        boolean verdict = intent.getBooleanExtra(
                IntentKeys.createKey(MATRICULE, "VERDICT"),
                false
        );

        // kharajna nom mel intent
        String nom = intent.getStringExtra(
                IntentKeys.createKey(MATRICULE, "NOM_VOYAGEUR")
        );

        // lehne ntestiw ken lverdict true wala false, ken true nhotou lbackground green
        //kenou false nhottou lbackground red
        if (verdict) {
            layout.setBackgroundColor(Color.GREEN);
            txtResult.setText("Bon voyage " + nom + " !");
        } else {
            layout.setBackgroundColor(Color.RED);
            txtResult.setText(
                    nom + " est en état d'arrestation temporelle"
            );
        }

        // ki yenzel luser nraj3ouh lel activité loule liheya mainactivity
        btnNouveau.setOnClickListener(v -> {

            Intent retour = new Intent(
                    ResultActivity.this,
                    MainActivity.class
            );

            retour.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(retour);
            finish();
        });
    }
}