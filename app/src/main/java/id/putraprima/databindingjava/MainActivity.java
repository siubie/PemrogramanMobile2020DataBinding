package id.putraprima.databindingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioGroup;

import java.util.Calendar;

import id.putraprima.databindingjava.databinding.ActivityMainBinding;
import id.putraprima.databindingjava.models.Mahasiswa;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog picker;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mahasiswa = new Mahasiswa();
        mahasiswa.setJenisKelamin("Laki Laki");
        binding.edtTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                binding.edtTanggalLahir.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        binding.radioLakiLaki.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    mahasiswa.setJenisKelamin("Laki Laki");
                }
            }
        });

        binding.radioPerempuan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    mahasiswa.setJenisKelamin("Perempuan");
                }
            }
        });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa.setNama(binding.edtNama.getText().toString());
                mahasiswa.setNim(binding.edtNim.getText().toString());
                mahasiswa.setTanggalLahir(binding.edtTanggalLahir.getText().toString());
                mahasiswa.setJurusan(binding.spinnerJurusan.getSelectedItem().toString());

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                // put mahasiswa object to extra
                intent.putExtra("MAHASISWA",mahasiswa);

                startActivity(intent);
            }
        });

    }
}