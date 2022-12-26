package com.atilimciftci.myapplication;
import java.io.Serializable;
public class Bilgiler implements Serializable
{
    private String adiSoyadi;
    private String telefonNo;
    private String eMail;
    public Bilgiler(String adiSoyadi, String telefonNo, String eMail){
    this.adiSoyadi = adiSoyadi;
    this.eMail = eMail;
    this.telefonNo = telefonNo;
    public String getAdiSoyadi(){
        return adiSoyadi;
    }
    public String getTelefonNo(){
        return telefonNo;
    }
    public String geteMail(){
        return eMail;
    }
}
    package com.atilimciftci.myapplication;
    import androidx.appcompat.app.AppCompatActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import com.atilimciftci.myapplication.databinding.ActivityMainBinding;
    public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
    public void digerActivity(View view){
        String adiSoyadi = binding.editTextTextAdiSoyadi.getText().toString();
        String eMail= binding.editTextTextEmail.getText().toString();
        String telefonNo= binding.editTextTelefon.getText().toString();
        Bilgiler bilgilerSerializable = new Bilgiler(adiSoyadi,eMail,telefonNo);
        Intent intent = new Intent(this.getApplicationContext(),Activity2.class);
        intent.putExtra(“bilgiler”,bilgilerSerializable);
        startActivity(intent);
        package com.atilimciftci.myapplication;
        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import com.atilimciftci.myapplication.databinding.Activity2Binding;
        public class Activity2 extends AppCompatActivity {
        private Activity2Binding binding;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = Activity2Binding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);
            Intent intent = getIntent();
            Bilgiler bilgiler = (Bilgiler) intent.getSerializableExtra(“bilgiler”);
            binding.textViewAdiSoyadi.setText(bilgiler.getAdiSoyadi());
            binding.textViewEmail.setText(bilgiler.geteMail());
            binding.textViewTelefonNo.setText(bilgiler.getTelefonNo());