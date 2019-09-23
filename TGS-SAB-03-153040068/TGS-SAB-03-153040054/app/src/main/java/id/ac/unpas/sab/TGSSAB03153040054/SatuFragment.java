package id.ac.unpas.sab.TGSSAB03153040068;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin601 on 2/28/2018.
 */

public class SatuFragment extends android.support.v4.app.Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static SatuFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        SatuFragment fragment = new SatuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_satu, container, false);
        return view;
    }
}