package e.nitishkumar.minor_project;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list.add(new firstfragment());list.add(new secondfragment());list.add(new fourthfragment());
        tabLayout=(TabLayout)findViewById(R.id.mytablayout);
        viewPager=(ViewPager)findViewById(R.id.mypager);
        viewPager.setAdapter(new adapter(getSupportFragmentManager(),list));
        tabLayout.setupWithViewPager(viewPager);
    }
}
