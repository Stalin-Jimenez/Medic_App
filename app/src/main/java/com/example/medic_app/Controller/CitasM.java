package com.example.medic_app.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.medic_app.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CitasM#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CitasM extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CitasM() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CitasM.
     */
    // TODO: Rename and change types and number of parameters
    public static CitasM newInstance(String param1, String param2) {
        CitasM fragment = new CitasM();
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

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        ArrayAdapter<String> lisAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        ArrayAdapter<String> lisAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);



        String url = "http://192.168.31.54/Proyecto_PIS/ConsultaCitasA.php?idusuarios=1";
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            if (response != null) {
                                lisAdapter.add("====================================");
                                for(int x=response.length(); x<=response.length();x++){
                                    lisAdapter.add("Institucion: "+response.getString("institucion"));
                                    lisAdapter.add("Fecha: "+response.getString("fecha"));
                                    lisAdapter.add("Direccion: "+response.getString("direccion"));
                                    lisAdapter.add("Doctor: "+response.getString("usuariod"));
                                    lisAdapter.add("Correo: "+response.getString("correod"));
                                    lisAdapter.add("Paciente: "+response.getString("usuario"));
                                    lisAdapter.add("Correo: "+response.getString("usuario"));
                                    lisAdapter.add("====================================");
                                }

                            } else {

                                lisAdapter.add("Aun no tiene datos en el Sistema");

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

        String url1 = "http://192.168.31.54/Proyecto_PIS/ConsultaCitasP.php?idusuarios=1";
        JsonObjectRequest stringRequest1 = new JsonObjectRequest(Request.Method.GET, url1, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            if (response != null) {
                                lisAdapter1.add("====================================");
                                for(int x=response.length(); x<=response.length();x++){
                                    lisAdapter1.add("Institucion: "+response.getString("institucion"));
                                    lisAdapter1.add("Fecha: "+response.getString("fecha"));
                                    lisAdapter1.add("Direccion: "+response.getString("direccion"));
                                    lisAdapter1.add("Doctor: "+response.getString("usuariod"));
                                    lisAdapter1.add("Correo: "+response.getString("correod"));
                                    lisAdapter1.add("Paciente: "+response.getString("usuario"));
                                    lisAdapter1.add("Correo: "+response.getString("usuario"));
                                    lisAdapter1.add("====================================");
                                }

                            } else {

                                lisAdapter1.add("Aun no tiene datos en el Sistema");

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest1);


        View view = inflater.inflate(R.layout.fragment_citas_m, container, false);

        ListView listView = (ListView) view.findViewById(R.id.MostrarCitaA);
        listView.setAdapter(lisAdapter);

        ListView listView1 = (ListView) view.findViewById(R.id.MostrarCitaP);
        listView1.setAdapter(lisAdapter1);

        return view;
    }
}