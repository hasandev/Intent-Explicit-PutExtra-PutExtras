package dev.id.hasan.intentexplicitputextrawithbundle;

import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //Todo1: Deklarasi
    EditText txNama, txNIS, txAsalSekolah, txAlamat;
    RadioGroup rgGroup;
    RadioButton rbtLaki, rbtPerempuan;
    CheckBox cbtHoby1, cbtHoby2, cbtHoby3;
    Button btKirimData;
    CoordinatorLayout coordinatorLayout;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);

        //TODO2: Inisialisasi
        txNama = (EditText)findViewById(R.id.txtNama);
        txNIS = (EditText)findViewById(R.id.txtNIS);
        txAsalSekolah = (EditText)findViewById(R.id.txtAsalSekolah);
        txAlamat = (EditText)findViewById(R.id.txtAlamat);
        rgGroup = (RadioGroup)findViewById(R.id.rg_jk);
        rbtLaki = (RadioButton)findViewById(R.id.rb_laki);
        rbtPerempuan = (RadioButton)findViewById(R.id.rb_perempuan);
        cbtHoby1 = (CheckBox)findViewById(R.id.cbHoby1);
        cbtHoby2 = (CheckBox)findViewById(R.id.cbHoby2);
        cbtHoby3 = (CheckBox)findViewById(R.id.cbHoby3);
        btKirimData = (Button)findViewById(R.id.btnKirimData);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.clLayoutWidget);

        //TODO3: Buat Action Button
        btKirimData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO5: Panggil Method validator EditText
                validasiEditText();
            }
        });
    }

    //TODO4: Membuat Proses Validasi Untuk EditText
    public void validasiEditText() {
        if(txNama.getText().toString().length()==0){
            txNama.setError("Isi Nama Lengkap Dulu Bro!!");
            txNama.requestFocus();
        }else if(txNIS.getText().toString().length()==0){
            txNIS.setError("Isi NIS Dulu Bro!!");
            txNIS.requestFocus();
        }else if(txAsalSekolah.getText().toString().length()==0){
            txAsalSekolah.setError("Isi Asal Sekolah Dulu Bro!!");
            txAsalSekolah.requestFocus();
        }else if(txAlamat.getText().toString().length()==0){
            txAlamat.setError("Isi Alamat Dulu Bro!!");
            txAlamat.requestFocus();
        }else {

            String NamaLengkap = txNama.getText().toString();
            String NIS = txNIS.getText().toString();
            String AsalSekolah = txAsalSekolah.getText().toString();
            String Alamat = txAlamat.getText().toString();

            builder.setTitle("Inputan User")
                    .setMessage("Nama Lengkap : " + NamaLengkap + "\n" +
                            "NIS : " + NIS + "\n" +
                            "Asal Sekolah : " + AsalSekolah + "\n" +
                            "Alamat : " + Alamat)
                    .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton("Censel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }AlertDialog dialog = builder.create();
        dialog.show();
    }
}
