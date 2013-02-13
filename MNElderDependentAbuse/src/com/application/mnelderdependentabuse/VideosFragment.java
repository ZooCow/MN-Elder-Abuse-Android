package com.application.mnelderdependentabuse;

import com.application.mnelderdependentabuse.Adapters.VideoAdapter;
import com.application.mnelderdependentabuse.Classes.VideoItem;
import com.application.mnelderdependentabuse.Classes.VideoXMLParser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class VideosFragment extends ListFragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videos, container, false);
        
        
        //Perform the HTTP Request and get XML here
	     String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	     		"<Videos>" +
	     		"<Video><Title>MN Brass</Title><URL>http://www.youtube.com/watch?v=LZUcPDLNQfQ</URL><Video>" +
	     		"<Video><Title>Awesome Cat Video</Title><URL>http://www.youtube.com/watch?v=dIR3XFuY4Qs</URL><Video>"+
	     		"</Videos>";
	     
        //Parse into an array
        VideoXMLParser parser = new VideoXMLParser();
        VideoItem[] videoData = parser.Parse(xml); 
        

        
       VideoAdapter adapter = new VideoAdapter(getActivity(),R.layout.listview_item_row, videoData);
      
       ListView listView = (ListView) view.findViewById(android.R.id.list);
        // Assign adapter to ListView
        listView.setAdapter(adapter); 
        
        return view;
    }


	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		VideoItem item = (VideoItem)l.getAdapter().getItem(position);
		
		getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(item.URL)));

	}



}