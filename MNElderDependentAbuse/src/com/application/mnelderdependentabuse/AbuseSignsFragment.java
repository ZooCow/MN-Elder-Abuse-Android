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

		Log.i("AbuseSignsFragment", "Clicken on Position " + position);

		String url = "about:blank";

		switch (position) {
			case 0: url = "https://dl.dropbox.com/s/hlcxwo1k5z8j33c/AbuseSigns_Bruises.htm"; break;
			case 1: url = "https://dl.dropbox.com/s/3l4agwv0n2cu0i7/abuseSigns_pressureUlcers.htm"; break; 
			case 2: url = "https://dl.dropbox.com/s/tn82pke42mjwjx9/abuseSigns_medicalCareSupervision.htm";  break;
			case 3: url = "https://dl.dropbox.com/s/4401dmq2lqrnd94/abuseSigns_careGiverRelationship.htm";  break;
			case 4: url = "https://dl.dropbox.com/s/rbth3be5fdpk67d/abuseSigns_financialIndicators.htm";  break;
			case 5: url = "https://dl.dropbox.com/s/4asonp78cnwibgm/abuseSigns_memoryCognitiveLoss.htm";  break;
			case 6: url = "https://dl.dropbox.com/s/7f8rp4uwby3o6n2/abuseSigns_assistiveDevices.htm";  break;
			case 7: url = "https://dl.dropbox.com/s/oe7w70yu72ihzor/abuseSigns_homeEnvironment.htm";  break;
			case 8: url = "https://dl.dropbox.com/s/fkprb836fnn3fkd/abuseSigns_personalMaintenance.htm";  break;
			case 9: url = "https://dl.dropbox.com/s/taynn1s7lvyfk0i/abuseSigns_sexualAbuse.htm";  break;
			case 10: url = "https://dl.dropbox.com/s/bl536cgi25mvm55/abuseSigns_interviews.htm";  break;
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