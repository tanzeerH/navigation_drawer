package com.tanzeer.navdrawer;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends SherlockActivity implements
		OnItemClickListener {
	private DrawerLayout drawerLayout;
	private ListView listView;
	ActionBarDrawerToggle actionBarDrawerToggle;
	ArrayList<String> Options = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Options.add("Profile");
		Options.add("Nearest");
		Options.add("Search");
		Options.add("Log Out");
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		listView = (ListView) findViewById(R.id.listview_drawer);
		MenuListAdapter adapter = new MenuListAdapter(getApplicationContext(),
				Options);
		listView.setAdapter(adapter);
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		drawerLayout.setBackgroundColor(Color.WHITE);
		Log.v("msg", "here");
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				
				super.onDrawerOpened(drawerView);
			}

		};
		drawerLayout.setDrawerListener(actionBarDrawerToggle);
		listView.setOnItemClickListener(this);
		if (savedInstanceState == null)
			;
	}

	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			Log.v("msg", "here1");
			if (drawerLayout.isDrawerOpen(listView)) {
				drawerLayout.closeDrawer(listView);
			} else {
				drawerLayout.openDrawer(listView);
			}
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		actionBarDrawerToggle.syncState();
		super.onPostCreate(savedInstanceState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		actionBarDrawerToggle.onConfigurationChanged(newConfig);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

	}
}
