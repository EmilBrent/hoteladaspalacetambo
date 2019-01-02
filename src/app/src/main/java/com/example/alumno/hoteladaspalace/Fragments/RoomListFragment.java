package com.example.alumno.hoteladaspalace.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumno.hoteladaspalace.MenuActivity;
import com.example.alumno.hoteladaspalace.Models.Habitacion;
import com.example.alumno.hoteladaspalace.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RoomListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RoomListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoomListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView list;
    private OnFragmentInteractionListener mListener;
    ArrayList<Habitacion> habitacionList;
    public RoomListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoomListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoomListFragment newInstance(String param1, String param2) {
        RoomListFragment fragment = new RoomListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_room_list, container, false);
        list =v.findViewById(R.id.lis1);
        habitacionList = Habitacion.getHabitaciones();
        //create instance of class MyAdapter
        RoomListFragment.MyAdapters adapters =
                new RoomListFragment.MyAdapters( this.getContext().getApplicationContext(), habitacionList);
        //set adapter to list
        list.setAdapter(adapters);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //we have currently  four items
                Habitacion habitacionEnCurso = habitacionList.get(position);
                MenuActivity o = (MenuActivity)getActivity();
                o.fragmentChange("habitacion");
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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

            LayoutInflater layoutInflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
