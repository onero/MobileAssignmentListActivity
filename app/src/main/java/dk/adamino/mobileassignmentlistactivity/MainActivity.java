package dk.adamino.mobileassignmentlistactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dk.adamino.mobileassignmentlistactivity.BE.Entity;
import dk.adamino.mobileassignmentlistactivity.Model.EntityModel;

public class MainActivity extends AppCompatActivity {

    private EntityModel mEntityModel = EntityModel.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Regular ListView
         */
//        setContentView(R.layout.activity_main_list);
//        final ListView listView = findViewById(R.id.main_list);

        /**
         * Recyclerview
         */
        setContentView(R.layout.activity_main_recycler);
        final RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//        String[] values = new String[]{"test"};
        Entity first = new Entity("Test 1");
        Entity second = new Entity("Test 2");
        Entity third = new Entity("Test 3");
        final List<Entity> entitities = new ArrayList<>();
        entitities.add(first);
        entitities.add(second);
        entitities.add(third);
        mEntityModel.setEntities(entitities);


        /**
         * Standard ListView
         */
//        ListAdapter adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, values);
//        listView.setAdapter(adapter);



        /**
         * Improved custom adapter
         */
//        MyListAdapter adapter = new MyListAdapter(this, entitities);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String text = entitities.get(position).getName();
//                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
//            }
//        });

        /**
         * Incredible recyclerview adapter
         */
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter();

        recyclerView.setAdapter(adapter);


    }
}
