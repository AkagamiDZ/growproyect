package cl.proyecto20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ingresodatos extends AppCompatActivity {

    private EditText Ubicacion1;

    private Button agregarButon;
    private Button ingresoBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresodatos);
        Intent intent = new Intent(this,GPS.class);
        ingresoBoton = (Button) findViewById(R.id.Btingreso);
        ingresoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){startActivity(intent); }
        });

        Ubicacion1 = findViewById(R.id.D1);
        agregarButon = findViewById(R.id.BtAgregar);

        agregarButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ubi1 = Ubicacion1.getText().toString();


                Intent intent = new Intent(ingresodatos.this, GPS.class);

                intent.putExtra("Ubicacion1", ubi1);
                startActivity(intent);
            }
        });
    }

}
