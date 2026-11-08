package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    //lena juste aamlna variable matricule mezlt bedhabet mnaarech chneya taamel khater mezelt ma9ritch el partie mtaa el cours  eli tehki ala el intant hedhy parti aaweni feha claude
    private static final String MATRICULE = "14779584";

    EditText nom, naissance, destination;
    Spinner motif;
    Button inspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//lena juste bech naamlou el reccupertaion mtaa el btn el select  w el input mel xml
        nom = findViewById(R.id.edit_nom_AT);
        naissance = findViewById(R.id.edit_naissance_AT);
        destination = findViewById(R.id.edit_destination_SS);
        motif = findViewById(R.id.spinner_motif_SS);
        inspecter = findViewById(R.id.btn_inspecter_SS);

//lena kifkif mnaarech kifeh naabi el select lena aaweni claude
        String[] motifs = {
                "Tourisme",
                "Modification du passé",
                "Fuite"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                motifs
        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        motif.setAdapter(adapter);

//lena bech naamlou el tratment eli ysir ki nenzlou ala el button inspecter
        inspecter.setOnClickListener(v -> {
//lena aamlna recupertation de donnee eli ktebhom el ustilisateur
            String nomVoyageur = nom.getText().toString().trim();
            String anneeN = naissance.getText().toString().trim();
            String anneeD = destination.getText().toString().trim();
//lena 3mlna check bech nchouchou ken fama input fergha
            if(nomVoyageur.isEmpty() || anneeN.isEmpty() || anneeD.isEmpty()){
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }
//lena jebna el reaison mtaa el vaoyage
            String raison = motif.getSelectedItem().toString();

// i thnik lena aamlna el creation mtaa el intent
            Intent intent = new Intent(MainActivity.this, VerificationActivity.class);
// lena bech nbaathou les donnees lel activity verification ken
            intent.putExtra(IntentKeys.createKey(MATRICULE, "NOM_VOYAGEUR"), nomVoyageur);
            intent.putExtra(IntentKeys.createKey(MATRICULE, "ANNEE_NAISSANCE"), anneeN);
            intent.putExtra(IntentKeys.createKey(MATRICULE, "ANNEE_DESTINATION"),anneeD);
            intent.putExtra(IntentKeys.createKey(MATRICULE, "MOTIF"),raison);
            intent.putExtra(IntentKeys.createKey(MATRICULE, "MATRICULE"),MATRICULE);

            startActivity(intent);
        });

    }
}