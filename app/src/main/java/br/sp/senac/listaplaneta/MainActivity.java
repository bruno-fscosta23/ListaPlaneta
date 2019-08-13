package br.sp.senac.listaplaneta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] namePlanetas = {"Jupiter", "Lua", "Marte", "Plutão", "Saturno", "Sol", "Terra", "Venus"};
    int[] imagePlanetas = {R.drawable.jupiter, R.drawable.lua, R.drawable.marte, R.drawable.plutao,
            R.drawable.saturno, R.drawable.sol, R.drawable.terra, R.drawable.venus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.lstPlanetas);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ListarDadosPlanetasActivity.class);
                intent.putExtra("name", namePlanetas[position]);
                intent.putExtra("image", imagePlanetas[position]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imagePlanetas.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.carrega_planetas, null);

            TextView name = (TextView) view1.findViewById(R.id.planetas);
            ImageView image = (ImageView) view1.findViewById(R.id.imgPlanetas);

            name.setText(namePlanetas[position]);
            image.setImageResource(imagePlanetas[position]);


            return view1;
        }
    }
}
