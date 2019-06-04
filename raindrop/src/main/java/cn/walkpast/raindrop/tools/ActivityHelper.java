package cn.walkpast.raindrop.tools;

import android.app.Activity;
import android.util.Log;

import java.util.Stack;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 14:21.
 * modify at: 2019/6/3 14:21.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class ActivityHelper {

    private static final String TAG="ActivityTool";
    private static Stack<Activity> activityStack;
    private static ActivityHelper instance;

    private ActivityHelper() {
    }

    public static synchronized ActivityHelper getInstance() {
        if (instance == null) {
            instance = new ActivityHelper();
        }
        return instance;
    }


    public synchronized void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
        Log.i(TAG, activity.getClass().getName()+" was added in ActivityManager.");
    }


    public void removeActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            Log.i(TAG, activity.getClass().getName()+" was removed in ActivityManager.");
        }
    }
}
