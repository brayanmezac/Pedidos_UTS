package co.edu.uts.sistemas.pedidos_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProductoActivity extends AppCompatActivity {

    EditText nombre, apellido, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);



        nombre = (EditText)findViewById(R.id.nombre);
        apellido = (EditText)findViewById(R.id.apellido);
        edad = (EditText)findViewById(R.id.edad);


    }

    public void enviar(View view){
         Intent menu = new Intent(this, MenuActivity.class);

         menu.putExtra("nombre", nombre.getText().toString());
         menu.putExtra("apellido", apellido.getText().toString());
         menu.putExtra("edad", edad.getText().toString());

        startActivity(menu);
    }

   /* public void ingresar(View view) {
        EditText user = findViewById(R.id.txtUser);
        EditText clave = findViewById(R.id.txtClave);

        String txtUser = user.getText().toString();
        String txtClave = clave.getText().toString();

        if (Informacion.user.equals(txtUser) && Informacion.passws.equals(txtClave)) {
            Toast.makeText(this, "Usuario/Contraseña validos!!!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            intent.putExtra("nombre", "Freddy");
            intent.putExtra("apellido", "Mendez");
            intent.putExtra("edad", 42);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Usuario/Contraseña NO SON validos!!!", Toast.LENGTH_SHORT).show();
        }
    }*/
}