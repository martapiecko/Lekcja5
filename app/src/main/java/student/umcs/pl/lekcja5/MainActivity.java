package student.umcs.pl.lekcja5;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private String[] lang;
    private String[] phrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.languages);

        initResources();
        initLanguagesListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id){
                Toast.makeText(getApplicationContext(),phrases[pos], Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initResources(){
        Resources res = getResources();
        lang = res.getStringArray(R.array.languages);
        phrases = res.getStringArray(R.array.hello_world);
    }

    private void initLanguagesListView() {
        lv.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, lang));
    }
}




