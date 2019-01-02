package com.example.alumno.hoteladaspalace.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumno.hoteladaspalace.Adapters.BedroomActivity;
import com.example.alumno.hoteladaspalace.Models.Habitacion;
import com.example.alumno.hoteladaspalace.R;

import java.util.ArrayList;


public class Reservation_BeedromFragment extends AppCompatActivity {

    ListView list;
    //String titles[] = {"Title One","Title Two","Title Three","Title Four"};
    //String description[]={"Description One...","Description Two...","Description Three...","Description Four.."};
   // int imgs[]={R.drawable.habitacionindividual,R.drawable.doble,R.drawable.doblecama,R.drawable.cuartofamiliar,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom);

        list =findViewById(R.id.lis1);
        ArrayList<Habitacion> habitacionList = Habitacion.getHabitaciones();
        //create instance of class MyAdapter
        Reservation_BeedromFragment.MyAdapters adapters =
                new Reservation_BeedromFragment.MyAdapters( this, habitacionList);
        //set adapter to list
        list.setAdapter(adapters);
        //handle item clicks
        //i*ll show toast on each item click, using name method you can move to different activity on each item click
        //pass data to some activity etc
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //we have currently  four items
                if ( position ==0){
                    Toast.makeText(Reservation_BeedromFragment.this, "Item One Clicked...", Toast.LENGTH_SHORT).show();
                }
                if ( position ==1){
                    Toast.makeText(Reservation_BeedromFragment.this, "Item Two Clicked...", Toast.LENGTH_SHORT).show();
                }
                if ( position ==2){
                    Toast.makeText(Reservation_BeedromFragment.this, "Item Three Clicked...", Toast.LENGTH_SHORT).show();
                }
                if ( position ==3){
                    Toast.makeText(Reservation_BeedromFragment.this, "Item Four Clicked...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    class MyAdapters extends ArrayAdapter<Habitacion> {
        Context context;
       // ArrayList<Habitacion> list = new ArrayList<>();
//        String myTitles[];
//        String myDescription[];
//        int [] imgs;
        MyAdapters (Context c, ArrayList<Habitacion> _list){
            super(c, 0, _list);
            //this.list = _list;
            //super(c,R.layout.activity_reservation,R.id.txtdoble,titles);
            this.context=c;
//            this.imgs=imgs;
//            this.myTitles=titles;
//            this.myDescription=description;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Habitacion habitacionObj = (Habitacion)getItem(position);

            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View activity_reservation = layoutInflater.inflate(R.layout.activity_reservation,parent,false);
            ImageView images=activity_reservation.findViewById(R.id.habitaciondoble);
            TextView myTitle=activity_reservation.findViewById(R.id.txtdoble);
            TextView myDescription=activity_reservation.findViewById(R.id.txthabitacion);
            //images.setImageResource(imgs[position]);
            myTitle.setText(habitacionObj.codigo);
            myDescription.setText(habitacionObj.codigo);
            return activity_reservation;
        }
    }
}
