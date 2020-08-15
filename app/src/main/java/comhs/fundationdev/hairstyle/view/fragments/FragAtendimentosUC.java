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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.view.interfaces.InterfaceUC;

public class FragAtendimentosUC extends Fragment {
    private OnItemClickListener clientSelected = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            FragAtendimentosUC.this.mCallback.indicarPosicaoCliente(position);
        }
    };
    private FragmentManager fragmentManager;
    private FragAtendimentosSRV fragmentSRV;
    private FragmentTransaction fragmentTransaction;
    private FrameLayout frameLayout;
    private ListView listClientes;
    /* access modifiers changed from: private */
    public InterfaceUC mCallback;
    private Spinner spnrUsuarios;
    private OnItemSelectedListener userSelected = new OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            FragAtendimentosUC.this.mCallback.indicarPosicaoUsuario(position);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_atendimentos_uc, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            this.mCallback = (InterfaceUC) getActivity();
            setUpLayout();
        } catch (ClassCastException e) {
            e.printStackTrace();
            throw new ClassCastException(getActivity().toString() + " must implement InterfaceUC interface");
        }
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
                this.fragmentSRV = new FragAtendimentosSRV();
                /* TODO: Verify this item
                this.fragmentTransaction.add(R.id.fragment_srv, this.fragmentSRV);
                */
                this.fragmentTransaction.add(R.id.fragment_vlr, this.fragmentSRV);
                this.fragmentTransaction.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                this.fragmentTransaction.addToBackStack("");
                this.fragmentTransaction.commit();
            }
        } catch (Exception e) {
        }
        setUpLayout();
    }

    private void setUpLayout() {
        this.spnrUsuarios = (Spinner) getActivity().findViewById(R.id.atendimentosUsuarios);
        this.listClientes = (ListView) getActivity().findViewById(R.id.atendimentosClientes);
        try {
            this.spnrUsuarios.setAdapter(new ArrayAdapter(getActivity().getApplication().getApplicationContext(), R.layout.spinner_item, this.mCallback.getStringUsers()));
            this.listClientes.setAdapter(new ArrayAdapter(getActivity().getApplication().getApplicationContext(), R.layout.spinner_item, this.mCallback.getStringClients()));
        } catch (Exception e) {
        }
        this.spnrUsuarios.setOnItemSelectedListener(this.userSelected);
        this.listClientes.setOnItemClickListener(this.clientSelected);
        if (this.mCallback.getPosicaoUsuario() != -1) {
            this.spnrUsuarios.setSelection(this.mCallback.getPosicaoUsuario());
        }
        if (this.mCallback.getPosicaoCliente() != -1) {
            this.listClientes.setSelected(true);
            this.listClientes.setSelection(this.mCallback.getPosicaoCliente());
        }
    }
}
