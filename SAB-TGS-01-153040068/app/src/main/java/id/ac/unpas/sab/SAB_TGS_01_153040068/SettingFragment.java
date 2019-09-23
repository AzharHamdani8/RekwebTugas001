package id.ac.unpas.sab.SAB_TGS_01_153040068;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by admin601 on 2/28/2018.
 */

public class SettingFragment extends android.support.v4.app.Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static SettingFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Button btnLogOut;

    public SettingFragment() {
        // Required empty public constructor
    }

    public static MainActivity mainActivity;

    public static SettingFragment newInstance(MainActivity activity) {
        mainActivity = activity;
        return new SettingFragment ();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        btnLogOut = (Button) view.findViewById(R.id.btn_logout);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        // set title dialog
        alertDialogBuilder.setTitle("Anda Yakin ingin Keluar?");

        // set pesan dari dialog
        alertDialogBuilder

                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        startActivity(intent);
                        // jika tombol diklik, maka akan menutup activity ini
                        getContext();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}
