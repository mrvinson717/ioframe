package com.fjw.myapp.util;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;

@SuppressWarnings("rawtypes")
public class ActivityManagerUtlis  {
	private List<Activity> activityList = new LinkedList<Activity>();
	private static ActivityManagerUtlis instance;

	private ActivityManagerUtlis() {
	}

	public static ActivityManagerUtlis getInstance() {
		if (null == instance) {
			instance = new ActivityManagerUtlis();
		}
		return instance;

	}

	public void addActivity(Activity activity) {
		if(activity!=null)
		  activityList.add(activity);
	}


	public void exit(Activity currentactivity,Class classz) {

		for (int i=0,c=activityList.size();i<c;i++) {
			Activity activity = activityList.get(i);
			if(activity!=null && !(classz.isInstance(activity)))
			   activity.finish();
		}
		
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        currentactivity.startActivity(startMain);
        currentactivity.finish();
		android.os.Process.killProcess(android.os.Process.myPid());
		//System.exit(0);

	}
}
