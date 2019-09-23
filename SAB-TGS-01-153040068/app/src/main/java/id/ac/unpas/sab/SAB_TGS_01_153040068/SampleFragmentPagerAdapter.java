package id.ac.unpas.sab.SAB_TGS_01_153040068;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 5;
    private String tabTitles[] = new String[] { "Profile", "Gallery", "Contact", "Cek Mahasiswa","Setting" };

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position){
        if (position == 0) {
            return ProfileFragment.newInstance(position);
        }else if (position == 1) {
            return GalleryFragment.newInstance(position);
        }else if (position == 2) {
            return ContactFragment.newInstance(position);
        }else if (position == 3) {
            return CekmhsFragment.newInstance(position);
        }else {
            return SettingFragment.newInstance(position);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}