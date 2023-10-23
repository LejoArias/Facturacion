package com.example.factutacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private EditText producto;
    private EditText precio;
    private EditText cantidad;
    private TableLayout tableLayout;
    private String[] header={"CANTIDAD","PRODUCTO","PRECIO"};
    private ArrayList<String[]> rows =  new ArrayList<>();
    private table Table;

    private TextView sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    producto = (EditText) findViewById(R.id.producto);
    precio = (EditText) findViewById(R.id.precio);
    cantidad = (EditText) findViewById(R.id.cantidad);
    tableLayout = (TableLayout) findViewById(R.id.table);
    sub = (TextView) findViewById(R.id.sub);

    Table = new table(tableLayout,getApplicationContext());
    Table.addHeader(header);
    Table.addData(getClients());
    }
    public void facturar(View view){
        Intent intent = new Intent(this, factura.class);
        startActivity(intent);
    }
    public void agregar(View view){
        String[]item = new String[]{cantidad.getText().toString(),producto.getText().toString(),precio.getText().toString()};
        Table.addItems(item);
    }
    private ArrayList<String[]>getClients(){
        rows.add(new String[]{"1","audifonos","500.000"});
        rows.add(new String[]{"2","celular","700.000"});
        rows.add(new String[]{"3","computador","3.000.000"});
        return rows;
    }
}