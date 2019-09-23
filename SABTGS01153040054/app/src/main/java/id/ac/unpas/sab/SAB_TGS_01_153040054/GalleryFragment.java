package id.ac.unpas.sab.SAB_TGS_01_153040054;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin601 on 2/28/2018.
 */

public class GalleryFragment extends Fragment {
    public static MainActivity mainActivity;
    public static GalleryFragment newInstance (MainActivity activity){
        mainActivity = activity;
        return new GalleryFragment();
    }
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.fragment_gallery, container, false);
        return view;
    }
}