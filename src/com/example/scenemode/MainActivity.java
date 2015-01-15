package com.example.scenemode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		
		Switch theswitch = (Switch) findViewById(R.id.theswitch);
		theswitch.setChecked(checkOpenStatus());
		
		theswitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				DataUtil.setOpenStatus(MainActivity.this, arg1 ? 1 : 0);
				if(!arg1){
					SetUtil.revertVolumeAndMode(MainActivity.this);
				}else{
					SetUtil.check(MainActivity.this);
				}
			}
		});
		
		findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				SetUtil.check(MainActivity.this);
			}
		});
		
		Log.wtf("zzz", "on MainActivity !");

//		Log.wtf("zzz", "on main register!");
//		
//		IntentFilter filter = new IntentFilter();
//		filter.addAction(Intent.ACTION_TIME_TICK);
//		filter.addAction(Intent.ACTION_TIME_CHANGED);
//		BootReceiver br = new BootReceiver();
//		getApplicationContext().registerReceiver(br, filter);
		
	}
	
	public boolean checkOpenStatus(){
		return DataUtil.getOpenStatus(this) > 0;
	}
	
	
	
	
}
