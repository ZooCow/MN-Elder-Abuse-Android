package com.application.mnelderdependentabuse;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends SherlockFragmentActivity implements TabListener {

	Boolean onHomeTab; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar (the bar that appears on the top portion of the app)
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		getSupportActionBar().setDisplayUseLogoEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);

		// Create the tabs
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
		ActionBar.Tab homeTab = getSupportActionBar().newTab();
		homeTab.setText("blank");

		newTab0.setTabListener(this);
		newTab1.setTabListener(this);
		newTab2.setTabListener(this);
		newTab3.setTabListener(this);
		newTab4.setTabListener(this);
		homeTab.setTabListener(this);

		// Add the tabs to the tab bar
		// Home tab is not added because it should not be selectable, 
		// it should only appear if you hit back enough times. 
		getSupportActionBar().addTab(newTab0);
		getSupportActionBar().addTab(newTab1);
		getSupportActionBar().addTab(newTab2);
		getSupportActionBar().addTab(newTab3);
		getSupportActionBar().addTab(newTab4);

		// Start the app on the home "tab"
		getSupportActionBar().selectTab(homeTab);
		onHomeTab = true; 
	}


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		Log.i("Main Activity onTabSelected", "tab " + String.valueOf(tab.getPosition()) + " clicked");

		// Because we're no longer on the home button, we want to enable the ability to go home.
		onHomeTab = false; 
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		// Clear the back stack fragment history 
		// Helps ensure predictable outcomes when back is pressed after a new tag is selected.
		getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE); 

		// Change the fragment being viewed based on the tab selected.
		switch (tab.getPosition()) {
			case 0:	AbuseSignsFragment abuseSignsFragment = new AbuseSignsFragment();
			ft.replace(R.id.fragment_container, abuseSignsFragment);
			break;
	
			case 1: AgenciesFragment agenciesFragment = new AgenciesFragment();		
			ft.replace(R.id.fragment_container, agenciesFragment);
			break; 
	
			case 2: VideosFragment videosFragment = new VideosFragment();
			ft.replace(R.id.fragment_container, videosFragment); 
			break;
	
			case 3: SafeFragment safeFragment = new SafeFragment();
			ft.replace(R.id.fragment_container, safeFragment);
			break;
	
			case 4: MoreFragment moreFragment = new MoreFragment();
			ft.replace(R.id.fragment_container, moreFragment);
			break;
	
			default: HomeFragment homeFragment = new HomeFragment();
			ft.replace(R.id.fragment_container, homeFragment);
			onHomeTab = true;
			getSupportActionBar().setDisplayHomeAsUpEnabled(false);
			break;
		}
	}

	// Changes the fragment to a webview linking to the given url.
	// Called from within a fragment. 
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


	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		//  This is what the code would look like if we decide we need a settings menu.
		//	com.actionbarsherlock.view.MenuInflater inflater = getSupportMenuInflater();
		//	inflater.inflate(R.menu.activity_main, menu);

		return true;
	}

	// The behavior of the buttons on the action bar
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		int itemId = item.getItemId();
		switch (itemId) {
		case android.R.id.home: // The "back/up/home" button on the action bar.

			if(!getSupportFragmentManager().popBackStackImmediate() && !onHomeTab){
				Log.i("On Menu Select", "now going to home tab");
				goHome();
			}

			break;
		}

		return true;
	}

	// Changes the behavior of the hardware back button
	// Helps to ensure predictable behavior of the back button for the fragments.
	@Override
	public void onBackPressed() {
		Log.d("MainActivity", "onBackPressed Called");

		if(onHomeTab){
			super.onBackPressed();
		} else if(!getSupportFragmentManager().popBackStackImmediate()){
			Log.i("On Menu Select", "now going to home tab");
			goHome();
		}

	}

	// Switches to the hidden home tab. 
	public void goHome(){
		onHomeTab = true; 
		ActionBar.Tab homeTab = getSupportActionBar().newTab();
		homeTab.setTabListener(this);
		getSupportActionBar().selectTab(homeTab);
	}

}
