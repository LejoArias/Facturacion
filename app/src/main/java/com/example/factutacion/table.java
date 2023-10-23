package com.example.factutacion;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class table {

    private TableLayout tableLayout;

    private Context context;
    private String[]header;
    private ArrayList<String[]>data;

    private TableRow tableRow;
    private TextView txtcel;
    private int indexC;
    private int indexR;


    public table(TableLayout tableLayout, Context context) {
        this.tableLayout = tableLayout;
        this.context = context;
    }
// RECIBIR DATOS DE LA TABLA
    public void addHeader(String[]header){
          this.header = header;
          createHeader();
    }
    public void addData(ArrayList<String[]>data){
         this.data = data;
         createDataTable();
    }
//CREAR FILA
    private void newRow(){
        tableRow = new TableRow(context);
    }
//CREAR CELDA
   private void newCel(){
        txtcel = new TextView(context);
        txtcel.setGravity(Gravity.CENTER);
        txtcel.setTextSize(25);
   }
   private void createHeader(){
        indexC = 0;
        newRow();
        while (indexC<header.length){
            newCel();
            txtcel.setText(header[indexC++]);
            tableRow.addView(txtcel,newTableRowParams());
        }
        tableLayout.addView(tableRow);
   }
   private void createDataTable(){
        String info;
        for(indexR = 1;indexR <= header.length; indexR++) {
            newRow();
            for(indexC = 0;indexC < header.length; indexC++) {
                newCel();
                String[] row = data.get(indexR - 1);
                info = (indexC < row.length) ? row[indexC] : "";
                txtcel.setText(info);
                tableRow.addView(txtcel, newTableRowParams());
            }
            tableLayout.addView(tableRow);
        }
   }
   //Agregar valores a la tabla
   public void addItems(String[]item){
        String info;
        data.add(item);
        indexC = 0;
        newRow();
        while (indexC< header.length){
            newCel();
            info = (indexC < item.length) ? item[indexC++] : "";
            txtcel.setText(info);
            tableRow.addView(txtcel,newTableRowParams());
        }
        tableLayout.addView(tableRow,data.size()-1);
   }
   
//GREGAR MARGENES A LA COLUMNA
    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(1,1,1,1);
        params.weight = 1;
        return params;
    }


}
