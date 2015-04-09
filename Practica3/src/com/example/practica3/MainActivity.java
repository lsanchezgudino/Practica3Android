package com.example.practica3;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ArrayList<Libro> datos = new ArrayList<Libro>();  
        
        datos.add(new Libro(R.drawable.m9788131903742, "Homeopatia Predictiva", "Parte II Teoría de las Agudas"));
        datos.add(new Libro(R.drawable.m9789707830387, "Farmacopea Homeopática Mexicana", "Propiedades Curativas de los 4 Reinos"));
        datos.add(new Libro(R.drawable.m9789700773100, "Materia Medica de Kent", "Medicamentos"));
        datos.add(new Libro(R.drawable.m9789500602884, "El libro de los músculos", "Los músculos"));
        datos.add(new Libro(R.drawable.m9788484452157, "La Biblia de la homeopatía ", "Remedios homeopáticos"));
        datos.add(new Libro(R.drawable.m9788434228689, "El gran libro del Cuerpo Humano", "partes del cuerpo"));
        datos.add(new Libro(R.drawable.m9788431529949, "El gran libro de la Homeopátia", "Medicamentos Homeopáticos"));
        datos.add(new Libro(R.drawable.m9788170211105, "Farmacopea Homeopática", "Propiedades Curativas de los 4 Reinos"));
        datos.add(new Libro(R.drawable.m9788131914946, "HOMEOPATÍA LA Ciencia de la Curación", "Curación con Homeopátia"));
        datos.add(new Libro(R.drawable.m9788131905616, "Materia Medica Homeopática", "Medicamentos homeopaticos"));
        
        lista = (ListView) findViewById(R.id.listView1);
        lista.setAdapter(new LibrosActivity(this, R.layout.listview_item, datos){
			@Override
			public void onEntrada(Object listview_item, View view) {
		        if (listview_item != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Libro) listview_item).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Libro) listview_item).get_textoDebajo()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Libro) listview_item).get_idImagen());
		        }
			}
		});
        
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                abrirNuevo(pariente,view,posicion,id);
			}
        });
        

    }
    public void abrirNuevo(AdapterView<?> pariente, View view, int posicion, long id){
    	Intent intent = new Intent(this, PortadaView.class );
    	Libro item = (Libro) lista.getAdapter().getItem(posicion);
    	intent.putExtra("imagen",item.get_idImagen());
    	intent.putExtra("debajo",item.get_textoDebajo().toString());
    	intent.putExtra("encima",item.get_textoEncima().toString()); 
        startActivity(intent);
 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
