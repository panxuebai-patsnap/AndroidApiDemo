package cn.codedev.demo.apidemo;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/**
 * Created by Harrison.Pan on 21/05/17.
 */
public class SpinnerBindingAdapter {

    public static final String TAG = SpinnerBindingAdapter.class.getName();


    @BindingAdapter(value = {"selectedItem"})
    public static void setSelectedItem(Spinner spinner, Object value) {
        Log.d(TAG, "setSelectedItem:" + value);
        if (value == null) {
            return;
        }
        SpinnerAdapter adapter = spinner.getAdapter();
        if (adapter != null) {
            final int count = adapter.getCount();
            for (int i = 0; i < count; i++) {
                Object object = adapter.getItem(i);
                if (TextUtils.equals(object.toString(), value.toString())) {
                    spinner.setSelection(i);
                    break;
                }
            }
        }
    }

    @InverseBindingAdapter(attribute = "selectedItem", event = "selectedItemAttrChanged")
    public static Object getSelectedItem(Spinner spinner) {
        Log.d(TAG, "getSelectedItem:" + spinner.getSelectedItem().toString());
        return spinner.getSelectedItem().toString();
    }

    @BindingAdapter(value = "selectedItemAttrChanged")
    public static void selectedItemAttrChanged(final Spinner spinner, final InverseBindingListener inverseBindingListener) {
        Log.d(TAG, "selectedItemAttrChanged");
        inverseBindingListener.onChange();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (inverseBindingListener != null) {
                    inverseBindingListener.onChange();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
