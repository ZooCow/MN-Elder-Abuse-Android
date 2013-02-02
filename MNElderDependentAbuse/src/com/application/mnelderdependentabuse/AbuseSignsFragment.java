package com.application.mnelderdependentabuse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class AbuseSignsFragment extends ListFragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.abuse_signs, container, false);


        ListView listView = (ListView) view.findViewById(android.R.id.list);
        String[] values = new String[] { "Bruises", "Pressure Ulcers (Bed Sores)", "Medical Care & Supervision",
        		"Caregiver Relationship", "Financial Indicators", "Memory & Cognitive Loss", "Assisted Devices",
        		"Home Environment", "Personal Maintenance", "Sexual Abuse", "Interviews"};
        

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter); 
        
        return view;
        
    }

    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(l.getContext(), position, Toast.LENGTH_SHORT).show();
       // getActivity().transactFromInside("123"); // Do this or use get fragment manager. 

    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

    // ...
}