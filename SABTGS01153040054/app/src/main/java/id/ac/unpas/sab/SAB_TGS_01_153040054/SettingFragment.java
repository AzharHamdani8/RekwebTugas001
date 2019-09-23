package id.ac.unpas.sab.SAB_TGS_01_153040054;

        import android.app.Fragment;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;

/**
 * Created by admin601 on 2/28/2018.
 */

public class SettingFragment extends Fragment {
    Button BtnLogout;
    public static MainActivity mainActivity;
    public static SettingFragment newInstance (MainActivity activity){
        mainActivity = activity;
        return new SettingFragment();
    }
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.fragment_setting, container, false);
        BtnLogout = (Button) view.findViewById(R.id.btn_logout);
        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.startActivity(new Intent(mainActivity, LoginActivity.class));
                mainActivity.finish();
            }
        });
        return view;
    }


}