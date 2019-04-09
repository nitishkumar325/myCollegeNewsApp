package e.nitishkumar.minor_project;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

class adapter extends FragmentPagerAdapter{
    List<Fragment> list=new ArrayList<>();
    String[]title=new String[]{"tab1","tab2","tab3"};
    public adapter(FragmentManager fm,List<Fragment>list) {
        super(fm);
        this.list=list;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return title.length;
    }
}
