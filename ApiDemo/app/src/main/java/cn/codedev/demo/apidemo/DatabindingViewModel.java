package cn.codedev.demo.apidemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

/**
 * Created by panxb on 21/05/17.
 */

public class DatabindingViewModel extends BaseObservable {
    private List<SpinnerData> entries;

    private String selectedItem;

    @Bindable
    public List<SpinnerData> getEntries() {
        return entries;
    }

    public void setEntries(List<SpinnerData> entries) {
        this.entries = entries;
        notifyPropertyChanged(BR.entries);
    }

    @Bindable
    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
        notifyPropertyChanged(BR.selectedItem);
    }
}
