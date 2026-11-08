package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {
    // hnee declarina l matricule
    private static final String MATRICULE = "14779584";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
    //  aamalna recuperation mtaa l text views l fer8in bch nhotou fehom data li jeyetna ml intent mtaa l main activity
        TextView txtNom = findViewById(R.id.txt_nom_verif_AT);
        TextView txtAge = findViewById(R.id.txt_age_verif_AT);
        TextView txtMotif = findViewById(R.id.txt_motif_verif_AT);
//  aamalna recuperation mtaa les boutons
        Button btnApprove = findViewById(R.id.btn_approve_AT);
        Button btnRefuse = findViewById(R.id.btn_refuse_AT);
//  5arajna data ( nom, anneeNaissance, anneeDestination, motif ) ml intent w sta3malna getIntExtra / getStringExtra
        Intent intent = getIntent();
        String Nom = intent.getStringExtra(IntentKeys.createKey(MATRICULE,"NOM_VOYAGEUR"));
        int anneeNaissance = intent.getIntExtra(
                IntentKeys.createKey(MATRICULE, "ANNEE_NAISSANCE"), 0);

        int anneeDestination = intent.getIntExtra(
                IntentKeys.createKey(MATRICULE, "ANNEE_DESTINATION"), 0);

        String motif = intent.getStringExtra(
                IntentKeys.createKey(MATRICULE, "MOTIF"));
        //  hsebna l age temporel
        int ageTemporel = anneeDestination - anneeNaissance;
        // aabina text views l fer8in
        txtNom.setText("Traveler: " + Nom);
        txtAge.setText("Temporel Age: " + ageTemporel + " years");
        txtMotif.setText("Reason: " + motif);
        // aamalna verification ken ken l motif mte3ou 'Modification du passé' w ken age premier ou non
        if (motif.equals("Modification du passé") && estPremier(ageTemporel)){
            btnApprove.setEnabled(false);
        }
        btnApprove.setOnClickListener(v -> {
            envoyerVerdict(true,Nom);
        });
        btnRefuse.setOnClickListener(v -> {
            envoyerVerdict(false,Nom);
        });

    }
    // aamalna fonction bch tchouf ken nombre premier wala lee
    private boolean estPremier(int Nombre){
        if (Nombre < 2){
            return false;
        }
        for (int i = 2; i<=Math.sqrt(Nombre); i++ ){
            if (Nombre % i == 0){
                return false;
            }
        }
        return true;
    }
    // aamalna fonction bch naamlou creation lel intent w n3adiwha lel activité jeya
    private void envoyerVerdict(boolean Verdict, String Nom){
        Intent intent = new Intent(
                VerificationActivity.this, ResultActivity.class
        );
        intent.putExtra(IntentKeys.createKey(MATRICULE, "VERDICT"), Verdict);
        intent.putExtra(IntentKeys.createKey(MATRICULE, "NOM_VOYAGEUR"), Nom);
        startActivity(intent);
        finish();
    }

}