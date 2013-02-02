package com.application.mnelderdependentabuse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

public class VideosFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videos, container, false);
        
        WebView myWebView = (WebView) view.findViewById(R.id.webview);
        myWebView.loadUrl("https://dl.dropbox.com/s/vf5m574ctrgvlnz/Law_FinancialExploitation_StatutoryLaw.htm");
        
        // Look Into This: https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerFragment
        
		//startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=cxLG2wtE7TM")));

        return view;
    }

	@Override
	public void onClick(View v) {

		
		//Intent i = new Intent(getApplicationContext(), NewsDetailActivity.class);
		//i.putExtra("newsId", "1");
		//VideosFragment.this.startActivity(i);
		// TODO Auto-generated method stub
		
	}

    // ...
}