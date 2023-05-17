package com.example.conversorbitcoin;

import static com.example.conversorbitcoin.R.id.TituloConversao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RadioGroup radiogroup;
    RadioButton rbReal, rbDolar;
    Button VerificaCotacao, Converter, Limpar;
    EditText CotacBitcoin, QuantBitcoin;
    TextView ResultConversao, TextConversao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiogroup = findViewById(R.id.radiogroup);
        rbReal = findViewById(R.id.rbReal);
        rbDolar = findViewById(R.id.rbDolar);
        VerificaCotacao = findViewById(R.id.VerificaCotacao);
        Converter = findViewById(R.id.Converter);
        Limpar = findViewById(R.id.Limpar);
        CotacBitcoin = findViewById(R.id.CotacBitcoin);
        QuantBitcoin = findViewById(R.id.QuantBitcoin);
        ResultConversao = findViewById(R.id.ResultConversao);
        TextConversao = findViewById(R.id.TituloConversao);

    }



    public void limparCampos(View v) {
        CotacBitcoin.setText("");
        QuantBitcoin.setText("");
        ResultConversao.setText("");
        Limpar.setVisibility(View.INVISIBLE);
        radiogroup.clearCheck();
    }

    public void calcular(View v) {
        String cotacao = CotacBitcoin.getText().toString();
        String quantidade = QuantBitcoin.getText().toString();
        Double valorConvertido = 0.0;

        int selectedRadioButtonId = radiogroup.getCheckedRadioButtonId();

        if (cotacao.isEmpty() || quantidade.isEmpty() || selectedRadioButtonId == -1) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Double CotacBitcoin2 = Double.parseDouble(cotacao);
            Double QuantBitcoin2 = Double.parseDouble(quantidade);

            if (rbReal.isChecked()) {
                valorConvertido = QuantBitcoin2 * CotacBitcoin2;
                TextConversao.setText("VALOR CONVERTIDO");
                ResultConversao.setText("R$: "+valorConvertido);
                Limpar.setVisibility(View.VISIBLE);
            } else if (rbDolar.isChecked()) {
                valorConvertido = QuantBitcoin2 * CotacBitcoin2;
                TextConversao.setText("VALOR CONVERTIDO");
                ResultConversao.setText("U$: "+valorConvertido);
                Limpar.setVisibility(View.VISIBLE);
            }
        }

    }

    public void verCotacao(View v){
        Intent intent;
        int selectedRadioButtonId = radiogroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId == -1) {
            Toast.makeText(this, "Selecione alguma moeda", Toast.LENGTH_SHORT).show();
            return;
        }
        if (rbReal.isChecked()) {
            intent = new Intent(MainActivity.this, Tela2_1.class);
        } else if (rbDolar.isChecked()) {
            intent = new Intent(MainActivity.this, Tela2_2.class);
        } else {
            return;
        }
        startActivity(intent);
    }
}