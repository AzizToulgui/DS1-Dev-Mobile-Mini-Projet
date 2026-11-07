package com.example.douanetemporelle;

import android.os.Bundle;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    }
}