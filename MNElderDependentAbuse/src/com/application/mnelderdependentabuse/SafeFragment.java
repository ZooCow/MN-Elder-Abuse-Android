package com.application.mnelderdependentabuse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
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

public class SafeFragment extends ListFragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.safe, container, false);


        ListView listView = (ListView) view.findViewById(android.R.id.list);
        String[] values = new String[] {"Financial Exploitation", "Physical Abuse and Neglect", "Sexual Abuse", "Civil vs. Criminal"};


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

		Log.i("Safe Law Fragment", "Clicked on position " + position);

		String url = "about:blank";

		switch (position) {
			case 0: url = "about:blank"; break;
			case 1: url = "about:blank"; break; 
			case 2: url = "about:blank";  break;
			case 3: url = "about:blank";  break;
			default: url = "about:blank";  break;
		}

		Activity activity = getActivity();
		((MainActivity) activity).transactFromInside(url);

	}
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

    // ...
}