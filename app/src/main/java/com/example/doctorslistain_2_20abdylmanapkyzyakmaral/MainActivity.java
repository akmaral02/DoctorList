package com.example.doctorslistain_2_20abdylmanapkyzyakmaral;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Consult> list = new ArrayList<>();
    private MainAdapter adapter;
    private Button btnAdd;
    public static final String KEY1 = "key";
    private static final int REQUEST_CODE = 2;
    public static final int REQUEST_COD = 3;
    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.rv_doctors);
        btnAdd = findViewById(R.id.btnAdd);
        setInitialData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter((ArrayList<Consult>) list, this);
        recyclerView.setAdapter(adapter);

//        adapter.setOnClickListener((MainAdapter.ItemClickListener) this);

//        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//
//            Consult consult = (Consult) data.getSerializableExtra(ApplicationActivity.KEY);
//            adapter.addData(consult);
//
//        }
//        if (requestCode == REQUEST_COD && resultCode == RESULT_OK && data != null) {
//            Consult consult = (Consult) data.getSerializableExtra(ApplicationActivity.KEY);
//            adapter.changeData(consult, position);
//        }

    }

//    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(
//            ItemTouchHelper.UP | ItemTouchHelper.DOWN,
//
//            ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT
//
//    ) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView,
//                              @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//
//            int positionDrag = viewHolder.getAdapterPosition();
//            int positionTarget = target.getAdapterPosition();
//
//            Collections.swap(adapter.list, positionDrag, positionTarget);
//            adapter.notifyItemMoved(positionDrag, positionTarget);
//
//            return true;
//        }

//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//            adapter.list.remove(viewHolder.getAdapterPosition());
//            adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
//        }
//    };


    public void onItemClick(int position) {
//        this.position =position;
//        Intent intent = new Intent(MainActivity.this, ApplicationActivity.class);
//        intent.putExtra(KEY1, adapter.list.get(position));
//        startActivityForResult(intent, REQUEST_COD);
//

    }
    private void setInitialData(){

        list.add(new Consult ("Виолетта Тимуровна", "501", R.drawable.doctor07));
        list.add(new Consult ("Федорова София Фёдоровна", "502", R.drawable.doctor07));
        list.add(new Consult ("Мирослава Захаровна", "503", R.drawable.doctor07));
        list.add(new Consult ("Маргарита Леонидовна", "504", R.drawable.doctor07));
        list.add(new Consult ("Лилия Дмитриевна", "505", R.drawable.doctor07));
        list.add(new Consult ("Александра Данииловна", "505", R.drawable.doctor07));
        list.add(new Consult ("Екатерина Николаевна", "506", R.drawable.doctor07));
        list.add(new Consult ("Вероника Павловна", "507", R.drawable.doctor07));
        list.add(new Consult ("Екатерина Владимировна", "508", R.drawable.doctor07));
        list.add(new Consult ("Евгения Евгеньевна", "509", R.drawable.doctor07));

    }

    public void callPhone(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
