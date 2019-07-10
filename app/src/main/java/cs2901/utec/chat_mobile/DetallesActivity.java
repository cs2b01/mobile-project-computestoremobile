package cs2901.utec.chat_mobile;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class DetallesActivity extends AppCompatActivity {


    public Activity getActivity(){
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        Intent intent = getIntent();
        String message = intent.getStringExtra("nombre");
        setTitle(message + " - Caracteristicas");
        TextView codigo = findViewById(R.id.editText);
        TextView marca = findViewById(R.id.editText2);
        TextView cantidad = findViewById(R.id.editText3);
        TextView precio = findViewById(R.id.editText4);
        codigo.setText("Codigo : " + intent.getStringExtra("codigo"));
        marca.setText("Marca : " + intent.getStringExtra("marca"));
        cantidad.setText("Cantidad : " + intent.getStringExtra("cantidad"));
        precio.setText("Precio : " + intent.getStringExtra("precio"));
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

}
