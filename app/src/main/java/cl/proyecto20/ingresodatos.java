package cl.proyecto20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ingresodatos extends AppCompatActivity {

    EditText texto, nombre, apellido;
    Button btnEnviar, btnmap;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresodatos);
        Intent intent = new Intent(this, GPS.class);
        btnmap = (Button) findViewById(R.id.btnGPS);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        btnEnviar = findViewById(R.id.btnIngresar);


        inicializarFireBase();


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                databaseReference.child("Nombre").setValue(nombre.getText().toString());
                databaseReference.child("Apellido").setValue(apellido.getText().toString());
                Toast.makeText(getApplicationContext(), "Usuario ingresado correctamente", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Conexion perdida", Toast.LENGTH_LONG).show();

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
