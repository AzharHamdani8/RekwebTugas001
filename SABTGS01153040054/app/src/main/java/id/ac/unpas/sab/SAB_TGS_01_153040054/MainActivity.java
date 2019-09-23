package id.ac.unpas.sab.SAB_TGS_01_153040054;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    Button buttonProfile, buttonGallery, buttonContact, buttonSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeContent(ProfileFragment.newInstance(this));

        buttonProfile = (Button) findViewById(R.id.btn_profile);
        buttonGallery = (Button) findViewById(R.id.btn_gallery);
        buttonContact = (Button) findViewById(R.id.btn_contact);
        buttonSetting = (Button) findViewById(R.id.btn_setting);

        buttonProfile.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(ProfileFragment.newInstance(MainActivity.this));
            }
        });
        buttonGallery.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(GalleryFragment.newInstance(MainActivity.this));
            }
        });
        buttonContact.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(ContactFragment.newInstance(MainActivity.this));
            }
        });
        buttonSetting.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(SettingFragment.newInstance(MainActivity.this));
            }
        });
    }

    private void changeContent(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commitAllowingStateLoss();
    }


}
