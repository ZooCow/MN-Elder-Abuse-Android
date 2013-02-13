package com.application.mnelderdependentabuse.Adapters;

import com.application.mnelderdependentabuse.R;
import com.application.mnelderdependentabuse.Classes.VideoItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VideoAdapter extends ArrayAdapter<VideoItem> {

	Context context;
	int layoutResourceId;
	VideoItem[] data = null;
	public VideoAdapter(Context context, int layoutResourceId, VideoItem[] data)
	{
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		//the layout view for the item. 
		View row = convertView;
		// a static holder. From what I gather this makes things more efficient. Other tutorials didn't use it
		VideoItemHolder holder = null;
		if(row == null)
		{
			LayoutInflater inflater  = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			
			holder = new VideoItemHolder();
			holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
			row.setTag(holder);
		}
		else
		{
			holder = (VideoItemHolder)row.getTag();
		}
		
		VideoItem videoItem = data[position];
		holder.txtTitle.setText(videoItem.Title);
		
		return row;
	
	}
	static class VideoItemHolder
	{
	 TextView txtTitle;
	}
}
