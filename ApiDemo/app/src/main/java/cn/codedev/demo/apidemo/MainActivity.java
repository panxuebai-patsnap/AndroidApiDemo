package cn.codedev.demo.apidemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.codedev.demo.apidemo.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        DatabindingViewModel viewModel = new DatabindingViewModel();
        List<SpinnerData> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SpinnerData d = new SpinnerData(i, "value" + i);
            datas.add(d);
        }
        viewModel.setEntries(datas);
        binding.setViewModel(viewModel);
    }
}
