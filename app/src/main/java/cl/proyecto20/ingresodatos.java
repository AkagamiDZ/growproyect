package cl.proyecto20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ingresodatos extends AppCompatActivity {

    EditText texto, nombre, apellido;
    Button btnEnviar, btnmap;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresodatos);
        Intent intent = new Intent(this, ingresodatos.class);
        btnmap = (Button) findViewById(R.id.btnGPS);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        btnEnviar = findViewById(R.id.btnIngresar);


        inicializarFireBase();


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                databaseReference.child("Mensaje").setValue(texto.getText().toString());
                databaseReference.child("Nombre").setValue(nombre.getText().toString());
                databaseReference.child("Apellido").setValue(apellido.getText().toString());
                Toast.makeText(getApplicationContext(), "Mensaje enviado exitosamente", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Consulta tu servidor MQTT y la base de datos de Firebase", Toast.LENGTH_LONG).show();

            }
        });
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){startActivity(intent); }
        });
    }

    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
