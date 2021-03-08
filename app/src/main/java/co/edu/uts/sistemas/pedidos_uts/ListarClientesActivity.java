package co.edu.uts.sistemas.pedidos_uts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import co.edu.uts.sistemas.pedidos_uts.model.Cliente;


public class ListarClientesActivity extends AppCompatActivity {

    private boolean cambio=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);
        if (Informacion.clientes.size()>0) {
            ListView lista = findViewById(R.id.listaClientes);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ListarClientesActivity.this,VerClienteActivity.class);
                    intent.putExtra("posicion",i);
                    startActivityForResult(intent, 210);
                }
            });
            actualizarLista();
        }
    }
    public void volver(View view) {
        if (cambio) {
            setResult(RESULT_OK);
        }
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // code 110 Editar     btnEditar
        // code 120 Eliminar   btnEliminar
        if (requestCode==210 && resultCode==RESULT_OK) {
            actualizarLista();
            cambio=true;
        }
    }

    private void actualizarLista() {
        ListView lista = findViewById(R.id.listaClientes);

        ArrayAdapter<Cliente> adapter = new ArrayAdapter<>(
                ListarClientesActivity.this,
                android.R.layout.simple_list_item_1,
                Informacion.clientes
        );

        lista.setAdapter(adapter);
    }
}