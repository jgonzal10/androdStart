package co.com.jgo.zazul.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**

 */
public class KeyboardUtil {
    public static void hideKeyboard(Activity activity) {
        try{
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }catch (Exception e){
            // Ignore exceptions if any
            //Log.e("KeyBoardUtil", e.toString(), e);
        }
    }

    public static void showKeyboard(Activity activity) {
        try{
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }catch (Exception e){
            // Ignore exceptions if any
            //Log.e("KeyBoardUtil", e.toString(), e);
        }
    }

}
