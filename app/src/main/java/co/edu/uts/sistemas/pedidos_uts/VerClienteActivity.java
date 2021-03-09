package co.edu.uts.sistemas.pedidos_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.uts.sistemas.pedidos_uts.model.Cliente;
import co.edu.uts.sistemas.pedidos_uts.model.Producto;

public class VerClienteActivity extends AppCompatActivity {
    private int posicion;
    private Cliente cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cliente);
        posicion=getIntent().getIntExtra("posicion", -1);
        cliente=Informacion.clientes.get(posicion);
        verInformacionCliente();
    }
    public void eliminar(View view) {
        Informacion.clientes.remove(posicion);
        setResult(RESULT_OK);
        finish();
    }
    public void volver(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
    private void verInformacionCliente() {
        EditText doc = findViewById(R.id.txtDocumentoCliente);
        EditText nom = findViewById(R.id.txtNombreCliente);
        EditText dir = findViewById(R.id.txtDireccionCliente);
        EditText tel = findViewById(R.id.txtCelular);
        EditText email = findViewById(R.id.txtEmail);

        doc.setText(cliente.getDocumento());
        nom.setText(cliente.getNombre());
        dir.setText(cliente.getDireccion());
        tel.setText(cliente.getCelular());
        email.setText(cliente.getEmail());
    }
    public void enviar(View view) {
        EditText doc = findViewById(R.id.txtDocumentoCliente);
        EditText nom = findViewById(R.id.txtNombreCliente);
        EditText dir = findViewById(R.id.txtDireccionCliente);
        EditText tel = findViewById(R.id.txtCelular);
        EditText email = findViewById(R.id.txtEmail);

        String txtDocumentoCliente = doc.getText().toString();
        String txtNombreCliente = nom.getText().toString();
        String txtDireccionCliente = dir.getText().toString();
        String txtCelular = tel.getText().toString();
        String txtEmail = email.getText().toString();

        if (txtNombreCliente.length()>0 && txtDocumentoCliente.length()>0 && txtDireccionCliente.length()>0
                && txtCelular.length()>0 && txtEmail.length()>0
                && !Informacion.existeCliente(txtEmail, posicion)) {
            int documento = Integer.parseInt(txtDocumentoCliente);
            int celular = Integer.parseInt(txtCelular);
            cliente.setDocumento(documento);
            cliente.setNombre(txtNombreCliente);
            cliente.setDireccion(txtDireccionCliente);
            cliente.setCelular(celular);
            cliente.setEmail(txtEmail);

            Informacion.clientes.set(posicion, cliente);

            setResult(RESULT_OK);
            finish();
            //startActivity(intent);
        } else {
            Toast.makeText(this, "Todos los datos son obligatorios", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED);
        }
    }
}