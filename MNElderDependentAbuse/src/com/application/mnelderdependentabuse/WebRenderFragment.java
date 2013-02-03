package com.application.mnelderdependentabuse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class WebRenderFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.web, container, false);
        
        WebView myWebView = (WebView) view.findViewById(R.id.webview);
        myWebView.loadUrl(getArguments().getString("URL")); 
                 
       return view;
        
    }


    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

    // ...
}