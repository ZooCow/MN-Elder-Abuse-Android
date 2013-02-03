package com.application.mnelderdependentabuse;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;




import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends SherlockFragmentActivity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		getSupportActionBar().setDisplayUseLogoEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		ActionBar.Tab newTab0 = getSupportActionBar().newTab();
		newTab0.setText("Abuse Signs");
		ActionBar.Tab newTab1 = getSupportActionBar().newTab();
		newTab1.setText("Agencies");
		ActionBar.Tab newTab2 = getSupportActionBar().newTab();
		newTab2.setText("Videos");
		ActionBar.Tab newTab3 = getSupportActionBar().newTab();
		newTab3.setText("S.A.F.E Law");
		ActionBar.Tab newTab4 = getSupportActionBar().newTab();
		newTab4.setText("More");

		newTab0.setTabListener(this);
		newTab1.setTabListener(this);
		newTab2.setTabListener(this);
		newTab3.setTabListener(this);
		newTab4.setTabListener(this);

		getSupportActionBar().addTab(newTab0);
		getSupportActionBar().addTab(newTab1);
		getSupportActionBar().addTab(newTab2);
		getSupportActionBar().addTab(newTab3);
		getSupportActionBar().addTab(newTab4);

		// Check that the activity is using the layout version with 
		// the fragment_container FrameLayout
		if (findViewById(R.id.fragment_container) != null){


			// However, if we're being restored from a previous state,
			// then we don't need to do anything and should return or else
			// we could end up with overlapping fragments.
			
			if (savedInstanceState != null) {
				return;
			}
			
			if (savedInstanceState == null) {
				//FragmentManager fragmentManager = getSupportFragmentManager();
				// Or: FragmentManager fragmentManager = getSupportFragmentManager()
				//FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				//AbuseSignsFragment fragment = new AbuseSignsFragment();
				//fragmentTransaction.add(R.id.fragment_container, fragment);
				//fragmentTransaction.commit();
			}
		}



	}


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		Log.i("Main Activity onTabSelected", "tab " + String.valueOf(tab.getPosition()) + " clicked");
		
		if(tab.getPosition() == 0){
			AbuseSignsFragment abuseSignsFragment = new AbuseSignsFragment();
			ft.replace(R.id.fragment_container, abuseSignsFragment);

		} else if(tab.getPosition() == 1){
			AgenciesFragment agenciesFragment = new AgenciesFragment();		
			ft.replace(R.id.fragment_container, agenciesFragment);
		} else if(tab.getPosition() == 2){
			VideosFragment videosFragment = new VideosFragment();
			ft.replace(R.id.fragment_container, videosFragment);
		} else if(tab.getPosition() == 3){
			SafeFragment safeFragment = new SafeFragment();
			ft.replace(R.id.fragment_container, safeFragment);
		} else if(tab.getPosition() == 4){
			MoreFragment moreFragment = new MoreFragment();
			ft.replace(R.id.fragment_container, moreFragment);
		}
		
		//ft.commit();
	}
	
	public void transactFromInside(String urlString){
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		WebRenderFragment webFragment = new WebRenderFragment();
		Log.i("Transact From Inside", "Transacting " + urlString);
        Bundle args = new Bundle();
        args.putString("URL", urlString);
        webFragment.setArguments(args);
	
        fragmentTransaction.replace(R.id.fragment_container, webFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
		
	}
	
	

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	private void toastText(String message){
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		com.actionbarsherlock.view.MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);

		return true;
	}

}
