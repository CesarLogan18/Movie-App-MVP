

package com.rappi.rappitest.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.rappi.rappitest.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;


public final class CommonUtils {

    private static final String TAG = "CommonUtils";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static SweetAlertDialog showLoadingDialog(Context context) {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(ContextCompat.getColor(context, R.color.colorPrimary));
        pDialog.setTitleText(context.getString(R.string.all_loading_msg));
        pDialog.setCancelable(false);
        return pDialog;
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(new Date());
    }
}
