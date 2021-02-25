package co.edu.uts.sistemas.pedidos_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        int edad = getIntent().getIntExtra("edad", -1);
        if (nombre!=null && apellido!=null && edad!=-1) {
            TextView lbSaludo = findViewById(R.id.textView);
            lbSaludo.append("\n"+nombre+" "+apellido+"\n"+edad);
        }
    }

    public void ejecutar(View view) {
        if (view.getId()==R.id.btnSalirMenu) {
            finish();
        } else {
            // Llamar a la actividad ProductoActivity
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