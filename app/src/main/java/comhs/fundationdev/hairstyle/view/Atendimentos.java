package comhs.fundationdev.hairstyle.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.control.ControlAtendimento;

public class Atendimentos extends AppCompatActivity {
    private ControlAtendimento control;
    private Spinner sClientes;
    private Spinner sServicos;
    private EditText edtValor;
    private Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendimentos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.control = new ControlAtendimento(getApplicationContext());
        this.sClientes = (Spinner) findViewById(R.id.atendimentosClientes);
        this.sServicos = (Spinner) findViewById(R.id.atendimentosSevicos);
        this.edtValor = (EditText) findViewById(R.id.atendimentosValor);
        this.btnAdicionar = (Button) findViewById(R.id.atendimentosConfirmar);

        this.sClientes.setAdapter(new ArrayAdapter<>(getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item, control.listarClientes()));

        this.sServicos.setAdapter(new ArrayAdapter<>(getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item, control.listarServicos()));

        this.sServicos.setVisibility(View.GONE);
        this.btnAdicionar.setVisibility(View.GONE);
        findViewById(R.id.atendimentosLayout).setVisibility(View.GONE);

        this.sClientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    sServicos.setVisibility(View.VISIBLE);
                } else {
                    sServicos.setVisibility(View.GONE);
                    btnAdicionar.setVisibility(View.GONE);
                    findViewById(R.id.atendimentosLayout).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        this.sServicos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    btnAdicionar.setVisibility(View.VISIBLE);
                    findViewById(R.id.atendimentosLayout).setVisibility(View.VISIBLE);
                } else {
                    btnAdicionar.setVisibility(View.GONE);
                    findViewById(R.id.atendimentosLayout).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                *//*

                onDestroy();

            }
        });
        */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
