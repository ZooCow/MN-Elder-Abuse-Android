package com.application.mnelderdependentabuse;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.application.mnelderdependentabuse.Adapters.VideoAdapter;
import com.application.mnelderdependentabuse.Classes.VideoItem;
import com.application.mnelderdependentabuse.Classes.VideoXMLParser;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class VideosFragment extends ListFragment {

	ListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.videos, container, false);
		listView = (ListView) view.findViewById(android.R.id.list);

		//The URL for the XML file
		String url = "http://www.justinrassier.com/storage/xml/Videos.xml";
		
		//need to perform networking things like HTTP GET off of the main thread
		new HttpGetTask().execute(url);

		return view;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		VideoItem item = (VideoItem) l.getAdapter().getItem(position);

		getActivity().startActivity(
				new Intent(Intent.ACTION_VIEW, Uri.parse(item.URL)));

	}

	//The async task to perform the HTTP get for the XML
	public class HttpGetTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... urls) {
			
			//Perform the get
			HttpGet get = new HttpGet(urls[0]);
			DefaultHttpClient httpClient = new DefaultHttpClient();
			String result = null;
			HttpResponse httpResponse;
			try {
				httpResponse = httpClient.execute(get);
				HttpEntity httpEntity = httpResponse.getEntity();
				result = EntityUtils.toString(httpEntity);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		@Override
		protected void onPostExecute(String result) {

			// Parse into an array
			VideoXMLParser parser = new VideoXMLParser();
			VideoItem[] videoData = parser.Parse(result);
			
			//Create the adapter
			VideoAdapter adapter = new VideoAdapter(getActivity(),
					R.layout.listview_item_row, videoData);

			// Assign adapter to ListView
			listView.setAdapter(adapter);
		}

	}

}