package comhs.fundationdev.hairstyle.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.control.ControlAtendimento;
import comhs.fundationdev.hairstyle.negocio.objects.Servico;
import comhs.fundationdev.hairstyle.view.fragments.FragAtendimentosSRV;
import comhs.fundationdev.hairstyle.view.fragments.FragAtendimentosUC;
import comhs.fundationdev.hairstyle.view.fragments.FragAtendimentosVLR;
import comhs.fundationdev.hairstyle.view.interfaces.InterfaceSRV;
import comhs.fundationdev.hairstyle.view.interfaces.InterfaceUC;
import comhs.fundationdev.hairstyle.view.interfaces.InterfaceVLR;
import java.util.List;

public class Atendimentos extends AppCompatActivity implements InterfaceSRV, InterfaceUC, InterfaceVLR {
    private GoogleApiClient client;
    /* access modifiers changed from: private */
    public ControlAtendimento control;
    private GestureDetector gestureDetector;
    private int posicao = 0;

    private class Android_Gesture_Detector implements OnGestureListener, OnDoubleTapListener {
        private Android_Gesture_Detector() {
        }

        public boolean onDown(MotionEvent e) {
            Log.d("Gesture ", " onDown");
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d("Gesture ", " onSingleTapConfirmed");
            return true;
        }

        public boolean onSingleTapUp(MotionEvent e) {
            Log.d("Gesture ", " onSingleTapUp");
            return true;
        }

        public void onShowPress(MotionEvent e) {
            Log.d("Gesture ", " onShowPress");
        }

        public boolean onDoubleTap(MotionEvent e) {
            Log.d("Gesture ", " onDoubleTap");
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("Gesture ", " onDoubleTapEvent");
            return true;
        }

        public void onLongPress(MotionEvent e) {
            Log.d("Gesture ", " onLongPress");
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d("Gesture ", " onScroll");
            if (e1.getY() < e2.getY()) {
                Log.d("Gesture ", " Scroll Down");
            }
            if (e1.getY() > e2.getY()) {
                Log.d("Gesture ", " Scroll Up");
            }
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() < e2.getX()) {
                Log.d("Gesture ", "Left to Right swipe: " + e1.getX() + " - " + e2.getX());
                Log.d("Speed ", String.valueOf(velocityX) + " pixels/second");
                Log.d("Gesture ", "Left to Right swipe: " + e1.getX() + " - " + e2.getX());
                Log.d("Speed ", String.valueOf(velocityX) + " pixels/second");
                if (e2.getX() - e1.getX() > 25.0f) {
                    Atendimentos.this.displayFragment(1);
                }
            }
            if (e1.getX() > e2.getX()) {
                Log.d("Gesture ", "Right to Left swipe: " + e1.getX() + " - " + e2.getX());
                Log.d("Speed ", String.valueOf(velocityX) + " pixels/second");
                Atendimentos.this.displayFragment(0);
            }
            if (e1.getY() < e2.getY()) {
                Log.d("Gesture ", "Up to Down swipe: " + e1.getX() + " - " + e2.getX());
                Log.d("Speed ", String.valueOf(velocityY) + " pixels/second");
            }
            if (e1.getY() > e2.getY()) {
                Log.d("Gesture ", "Down to Up swipe: " + e1.getX() + " - " + e2.getX());
                Log.d("Speed ", String.valueOf(velocityY) + " pixels/second");
            }
            return true;
        }
    }

    private class CarregarDados extends AsyncTask<Void, Void, Void> {
        private CarregarDados() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            Atendimentos.this.control = new ControlAtendimento(Atendimentos.this.getApplicationContext());
            try {
                Atendimentos.this.control.buscarUsuarios();
                Atendimentos.this.control.buscarClientes();
                Atendimentos.this.control.buscarServicos();
            } catch (Exception e) {
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Atendimentos.this.resetFragment();
        }
    }

    private class CarregarServicos extends AsyncTask<Void, Void, Void> {
        private CarregarServicos() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            try {
                Atendimentos.this.control.buscarServicos();
            } catch (Exception e) {
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Atendimentos.this.notifySRV();
        }
    }

    private class SaveAttendance extends AsyncTask<Void, Void, Void> {
        private SaveAttendance() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            Atendimentos.this.control.salvarAtendimento();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (Atendimentos.this.control.isLargeScreen().booleanValue()) {
                Atendimentos.this.limparValores();
            } else {
                Atendimentos.this.resetFragment();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_atendimentos);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        new CarregarDados().execute(new Void[0]);
        this.gestureDetector = new GestureDetector(this, new Android_Gesture_Detector());
        this.client = new Builder(this).addApi(AppIndex.API).build();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!this.control.isLargeScreen().booleanValue()) {
            this.gestureDetector.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_atendimentos, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings /*2131624084*/:
                openPreferences();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void salvar(View v) {
        FragAtendimentosVLR fragment;
        float valor;
        String str = "";
        FragmentManager fragmentManager = getFragmentManager();
        try {
            fragment = (FragAtendimentosVLR) fragmentManager.findFragmentById(R.id.frame_fragment);
        } catch (Exception e) {
            fragment = (FragAtendimentosVLR) fragmentManager.findFragmentById(R.id.fragment_vlr);
        }
        String val = "";
        if (fragment != null) {
            val = fragment.getValor();
        }
        try {
            valor = Float.parseFloat(val);
        } catch (Exception e2) {
            valor = -1.0f;
        }
        if (this.control.getPosicaoUsuario() <= 0 || this.control.getPosicaoCliente() <= -1 || this.control.getServico() == null) {
            Toast.makeText(this, "Por favor verifique Usuario, Cliente e Serviço para o atendimento", 1).show();
            return;
        }
        Servico servico = this.control.getServico();
        if (valor == -1.0f) {
            valor = this.control.getServico().getValorMinimo();
        }
        servico.setValorRealizado(valor);
        if (this.control.getServico().getValorRealizado() < this.control.getServico().getValorMinimo() || this.control.getServico().getValorRealizado() > this.control.getServico().getValorMaximo()) {
            Toast.makeText(this, "ATENÇÂO!\nValor indicado não permitido.\nValor mínimo = " + this.control.getServico().getValorMinimo() + "\nValor máximo = " + this.control.getServico().getValorMaximo(), 1).show();
        } else {
            new SaveAttendance().execute(new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    public void resetFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragAtendimentosSRV fragment = null;
        try {
            fragment = (FragAtendimentosSRV) fragmentManager.findFragmentById(R.id.frame_fragment);
        } catch (Exception e) {
        }
        if (fragment != null) {
            fragmentTransaction.detach(fragment);
            fragmentTransaction.remove(fragment);
            fragmentTransaction.setTransition(8194);
            fragmentTransaction.commit();
        } else {
            FragAtendimentosVLR fragment2 = null;
            try {
                fragment2 = (FragAtendimentosVLR) fragmentManager.findFragmentById(R.id.frame_fragment);
            } catch (Exception e2) {
            }
            if (fragment2 != null) {
                fragmentTransaction.detach(fragment2);
                fragmentTransaction.remove(fragment2);
                fragmentTransaction.setTransition(8194);
                fragmentTransaction.commit();
            }
        }
        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        fragmentTransaction2.add(R.id.frame_fragment, new FragAtendimentosUC());
        fragmentTransaction2.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction2.commit();
        limparValores();
    }

    /* access modifiers changed from: private */
    public void displayFragment(int direction) {
        if (direction == 1) {
            if (this.posicao == 1) {
                this.control.setPosicaoServico(-1);
                this.control.setPosicaoCliente(-1);
                this.control.setPosicaoUsuario(-1);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                try {
                    FragAtendimentosSRV fragment = (FragAtendimentosSRV) fragmentManager.findFragmentById(R.id.frame_fragment);
                    if (fragment != null) {
                        fragmentTransaction.detach(fragment);
                        fragmentTransaction.remove(fragment);
                        fragmentTransaction.setTransition(8194);
                        fragmentTransaction.commit();
                    }
                    FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                    fragmentTransaction2.add(R.id.frame_fragment, new FragAtendimentosUC());
                    fragmentTransaction2.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction2.commit();
                    this.posicao = 0;
                } catch (Exception e) {
                }
            } else if (this.posicao == 2) {
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager2.beginTransaction();
                try {
                    FragAtendimentosVLR fragment2 = (FragAtendimentosVLR) fragmentManager2.findFragmentById(R.id.frame_fragment);
                    if (fragment2 != null) {
                        fragmentTransaction3.detach(fragment2);
                        fragmentTransaction3.remove(fragment2);
                        fragmentTransaction3.setTransition(8194);
                        fragmentTransaction3.commit();
                    }
                    FragmentTransaction fragmentTransaction4 = fragmentManager2.beginTransaction();
                    fragmentTransaction4.add(R.id.frame_fragment, new FragAtendimentosSRV());
                    fragmentTransaction4.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction4.commit();
                    this.posicao = 1;
                } catch (Exception e2) {
                }
            }
        } else if (this.posicao == 0) {
            FragmentManager fragmentManager3 = getFragmentManager();
            FragmentTransaction fragmentTransaction5 = fragmentManager3.beginTransaction();
            try {
                FragAtendimentosUC fragment3 = (FragAtendimentosUC) fragmentManager3.findFragmentById(R.id.frame_fragment);
                if (fragment3 != null) {
                    fragmentTransaction5.detach(fragment3);
                    fragmentTransaction5.remove(fragment3);
                    fragmentTransaction5.setTransition(8194);
                    fragmentTransaction5.commit();
                }
                FragmentTransaction fragmentTransaction6 = fragmentManager3.beginTransaction();
                fragmentTransaction6.add(R.id.frame_fragment, new FragAtendimentosSRV());
                fragmentTransaction6.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction6.commit();
                this.posicao = 1;
            } catch (Exception e3) {
            }
        } else if (this.posicao == 1) {
            FragmentManager fragmentManager4 = getFragmentManager();
            FragmentTransaction fragmentTransaction7 = fragmentManager4.beginTransaction();
            if (((FragAtendimentosVLR) fragmentManager4.findFragmentById(R.id.fragment_vlr)) == null) {
                try {
                    FragAtendimentosSRV fragment4 = (FragAtendimentosSRV) fragmentManager4.findFragmentById(R.id.frame_fragment);
                    if (fragment4 != null) {
                        fragmentTransaction7.detach(fragment4);
                        fragmentTransaction7.remove(fragment4);
                        fragmentTransaction7.setTransition(8194);
                        fragmentTransaction7.commit();
                    }
                    FragmentTransaction fragmentTransaction8 = fragmentManager4.beginTransaction();
                    FragAtendimentosVLR fragmentVLR = new FragAtendimentosVLR();
                    try {
                        fragmentTransaction8.add(R.id.frame_fragment, fragmentVLR);
                        fragmentTransaction8.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction8.commit();
                        this.posicao = 2;
                    } catch (Exception e4) {
                        FragAtendimentosVLR fragAtendimentosVLR = fragmentVLR;
                    }
                } catch (Exception e5) {
                }
            }
        }
    }

    private void openPreferences() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    /* access modifiers changed from: private */
    public void limparValores() {
        this.posicao = 0;
        this.control.setPosicaoUsuario(-1);
        this.control.setPosicaoCliente(-1);
        this.control.setPosicaoServico(-1);
    }

    /* access modifiers changed from: private */
    public void notifySRV() {
        try {
            ((FragAtendimentosSRV) getFragmentManager().findFragmentById(R.id.frame_fragment)).carregarListaServicos();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao carregar serviços", 1).show();
        }
    }

    public List<String> getStringServices() {
        return this.control.listarServicos();
    }

    public void indicarPosicaoServicos(int pos) {
        this.control.setPosicaoServico(pos);
        this.control.indicarServico(pos);
    }

    public void carregarFragValor() {
        if (this.control.isLargeScreen().booleanValue()) {
            displayFragment(0);
        } else {
            displayFragment(0);
        }
    }

    public void showMensageSRV(String s) {
        Toast.makeText(this, s, 1).show();
    }

    public List<String> getStringClients() {
        return this.control.listarClientes();
    }

    public List<String> getStringUsers() {
        return this.control.listarUsuarios();
    }

    public void indicarPosicaoUsuario(int pos) {
        if (pos > 0) {
            this.control.setPosicaoUsuario(pos);
            if (this.control.getPosicaoCliente() != -1 && !this.control.isLargeScreen().booleanValue()) {
                displayFragment(0);
                return;
            }
            return;
        }
        this.control.setPosicaoUsuario(-1);
    }

    public int getPosicaoUsuario() {
        return this.control.getPosicaoUsuario();
    }

    public int getPosicaoCliente() {
        return this.control.getPosicaoCliente();
    }

    public void indicarPosicaoCliente(int pos) {
        if (pos >= 0) {
            this.control.setPosicaoCliente(pos);
            if (this.control.getPosicaoUsuario() != -1 && !this.control.isLargeScreen().booleanValue()) {
                displayFragment(0);
                return;
            }
            return;
        }
        this.control.setPosicaoCliente(-1);
    }

    public void showMensageUC(String s) {
        Toast.makeText(this, s, 1).show();
    }

    public String getValor() {
        Servico s = this.control.getServico();
        return String.valueOf(s.getValorMinimo() + " - " + (s.getValorMaximo() > 0.0f ? s.getValorMaximo() : s.getValorMinimo()));
    }

    public void showMensageVLR(String s) {
        Toast.makeText(this, s, 1).show();
    }

    public void carregarServicos() {
        new CarregarServicos().execute(new Void[0]);
    }

    public String getValorMinimo() {
        return String.valueOf(this.control.getServico().getValorMinimo());
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
