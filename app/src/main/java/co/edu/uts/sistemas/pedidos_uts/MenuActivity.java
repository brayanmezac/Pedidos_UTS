package co.edu.uts.sistemas.pedidos_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String edad = getIntent().getStringExtra("edad");

        if (nombre!=null && apellido!=null) {
            TextView lbSaludo = findViewById(R.id.textView);
            lbSaludo.append("\n"+nombre+" "+apellido+"\n"+edad);
        }
        /*
        try {

            int edad = getIntent().getExtras().getInt("edad", 3);

            if (nombre!=null && apellido!=null) {
                TextView lbSaludo = findViewById(R.id.textView);
                lbSaludo.append("\n"+nombre+" "+apellido+"\n"+edad);
            }

        } catch(Exception e) {
            
            Toast.makeText(getApplicationContext(), "ERROR: el valor de tipo String contiene caracteres no numéricos!!!", Toast.LENGTH_SHORT).show();
            
        }
        */
        /*getIntent().getExtras().getInt("edad", -1)*/


    }

    public void ejecutar(View view) {
        if (view.getId()==R.id.btnSalirMenu) {
            finish();
        } else {
            // Llamar a la actividad ProductoActivity
            if (view.getId()==R.id.btnDatos){
                Intent datos = new Intent(this, ProductoActivity.class);
                startActivity(datos);
            }
        }
    }

    /*
    ProductoActivity debe contener 3 EdiText para solicitar la siguiente información:
    * nombre
    * apellido
    * edad
    Ademas debe contener un boton llamado enviar que captura los datos de los
    EditText, los agrega a un intent y hace el llamado a MenuActivity
    enviandole el intent en la petición
     */


}