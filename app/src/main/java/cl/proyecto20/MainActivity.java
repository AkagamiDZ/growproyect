package cl.proyecto20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BTInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, ingresodatos.class);
        BTInicio = (Button) findViewById(R.id.BTInicio);
        BTInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){startActivity(intent); }
        });
    }
}