package id.putraprima.databindingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import java.util.Objects;

import id.putraprima.databindingjava.databinding.ActivityDetailBinding;
import id.putraprima.databindingjava.models.Mahasiswa;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        Mahasiswa mahasiswa = Objects.requireNonNull(getIntent().getExtras()).getParcelable("MAHASISWA");
        binding.setMahasiswa(mahasiswa);
    }
}