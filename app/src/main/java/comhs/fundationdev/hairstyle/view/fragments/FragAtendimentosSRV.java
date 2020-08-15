package comhs.fundationdev.hairstyle.view.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.view.interfaces.InterfaceSRV;

public class FragAtendimentosSRV extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    /* access modifiers changed from: private */
    public FragAtendimentosVLR fragmentVLR;
    private FrameLayout frameLayout;
    private ListView listServicos;
    /* access modifiers changed from: private */
    public InterfaceSRV mCallback;
    private OnItemClickListener serviceSelected = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            FragAtendimentosSRV.this.mCallback.indicarPosicaoServicos(position);
            if (FragAtendimentosSRV.this.fragmentVLR != null) {
                FragAtendimentosSRV.this.fragmentVLR.indicarServico();
            } else {
                FragAtendimentosSRV.this.mCallback.carregarFragValor();
            }
        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_atendimentos_srv, null);
    }

    public void onStart() {
        super.onStart();
        try {
            this.frameLayout = (FrameLayout) getActivity().findViewById(R.id.fragment_vlr);
            this.fragmentManager = getFragmentManager();
            this.fragmentTransaction = this.fragmentManager.beginTransaction();
            if (this.frameLayout != null) {
                this.fragmentManager = getFragmentManager();
                this.fragmentTransaction = this.fragmentManager.beginTransaction();
                this.fragmentVLR = new FragAtendimentosVLR();
                this.fragmentTransaction.add(R.id.fragment_vlr, this.fragmentVLR);
                this.fragmentTransaction.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                this.fragmentTransaction.addToBackStack("");
                this.fragmentTransaction.commit();
            }
        } catch (Exception e) {
        }
        setUpLayout();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            this.mCallback = (InterfaceSRV) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement InterfaceSRV interface");
        }
    }

    private void setUpLayout() {
        try {
            this.mCallback.carregarServicos();
        } catch (Exception e) {
        }
    }

    public void carregarListaServicos() {
        this.listServicos = (ListView) getActivity().findViewById(R.id.atendimentosSevicos);
        try {
            this.listServicos.setAdapter(new ArrayAdapter(getActivity().getApplication().getApplicationContext(), R.layout.spinner_item, this.mCallback.getStringServices()));
        } catch (Exception e) {
        }
        this.listServicos.setOnItemClickListener(this.serviceSelected);
    }
}
