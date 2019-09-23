package id.ac.unpas.sab.SAB_TGS_01_153040068;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CekmhsFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private EditText nrp,nama;
    private Button submit;

    public static CekmhsFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CekmhsFragment fragment = new CekmhsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cekmhs, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);

        //instansiasi object berdasarkan id pada EditText di xml
        nrp = (EditText) view.findViewById(R.id.nrp);
        nama = (EditText) view.findViewById(R.id.nama);
        //instansiasi object berdasarkan id pada Button di xml
        submit = (Button) view.findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                String kodeJurusan;

                String jurusan = String.valueOf(nrp.getText());
                String namaprak = String.valueOf(nama.getText());
                if(jurusan.trim().length()==9 ){
                    String kode = jurusan.substring(6,9);
                    if(kode.equals("000")||kode.equals("   ")){

                        Toast.makeText(getActivity(), "nrp yang anda masukan salah", Toast.LENGTH_LONG).show();

                    }
                    else if(namaprak.isEmpty()){
                        Toast.makeText(getActivity(), "nama tidak boleh kosong", Toast.LENGTH_LONG).show();
                    }
                    else {
                        kodeJurusan= jurusan.substring(2,5);

                        if(kodeJurusan.equals("304")){
                            Toast.makeText(getActivity(), "Hello SAB, perkenalkan saya praktikan "+nama.getText()+" dengan nrp "+nrp.getText()+" adalah mahasiswa Teknik Informatika Unpas" , Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(getActivity(), "Hello SAB, perkenalkan saya praktikan "+nama.getText()+" dengan nrp "+nrp.getText()+" adalah Bukan mahasiswa Teknik Informatika Unpas" , Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else {
                    Toast.makeText(getActivity(), "jumlah NRP harus 9", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

}
