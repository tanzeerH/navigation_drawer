package com.tanzeer.navdrawer;

import java.util.ArrayList;

import javax.security.auth.PrivateCredentialPermission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MenuListAdapter extends BaseAdapter {
	
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<String> list;
	public MenuListAdapter(Context contxt,ArrayList<String> l) {
		this.context=contxt;
		this.list=l;
	}	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size() ;
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView=inflater.inflate(R.layout.drawer_list_row,parent,false);
		TextView txt=(TextView)itemView.findViewById(R.id.textView1);
		txt.setText(list.get(position));
		return itemView;
	}

}
