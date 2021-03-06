package co.edu.uts.sistemas.pedidos_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.uts.sistemas.pedidos_uts.model.Producto;

public class VerProductoActivity extends AppCompatActivity {
    private int posicion;
    private Producto producto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);
        posicion=getIntent().getIntExtra("posicion", -1);
        producto=Informacion.productos.get(posicion);
        verInformacionProducto();
    }

    private void verInformacionProducto() {
        EditText cod = findViewById(R.id.txtCodigo);
        EditText nom = findViewById(R.id.txtNombre);
        EditText precio = findViewById(R.id.txtPrecio);

        cod.setText(producto.getCodigo());
        nom.setText(producto.getNombre());
        precio.setText(""+producto.getPrecio());
    }

    public void volver(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void eliminar(View view) {
        Informacion.productos.remove(posicion);
        setResult(RESULT_OK);
        finish();
    }

    public void enviar(View view) {
        EditText cod = findViewById(R.id.txtCodigo);
        EditText nom = findViewById(R.id.txtNombre);
        EditText precio = findViewById(R.id.txtPrecio);

        String txtCodigo = cod.getText().toString();
        String txtNombre = nom.getText().toString();
        String txtPrecio = precio.getText().toString();

        if (txtNombre.length()>0 && txtCodigo.length()>0 && txtPrecio.length()>0
           && !Informacion.existeProducto(txtCodigo, posicion)) {
            int precio_ = Integer.parseInt(txtPrecio);

            producto.setCodigo(txtCodigo);
            producto.setNombre(txtNombre);
            producto.setPrecio(precio_);

            Informacion.productos.set(posicion, producto);

            setResult(RESULT_OK);
            finish();
            //startActivity(intent);
        } else {
            Toast.makeText(this, "Todos los datos son obligatorios", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED);
        }
    }
}