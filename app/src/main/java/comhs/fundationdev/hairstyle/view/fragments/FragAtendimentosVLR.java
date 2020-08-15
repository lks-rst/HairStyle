package comhs.fundationdev.hairstyle.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.view.interfaces.InterfaceVLR;

public class FragAtendimentosVLR extends Fragment {
    private EditText edtValor;
    private InterfaceVLR mCallback;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_atendimentos_vlr, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            this.mCallback = (InterfaceVLR) getActivity();
            setUpLayout();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement InterfaceVLR interface");
        }
    }

    public void onStart() {
        super.onStart();
    }

    private void setUpLayout() {
        this.edtValor = (EditText) getActivity().findViewById(R.id.atendimentosValor);
        try {
            indicarServico();
        } catch (Exception e) {
        }
    }

    public void indicarServico() {
        this.edtValor.setHint(this.mCallback.getValor());
    }

    public String getValor() {
        if (this.edtValor.getText().toString().length() > 0) {
            return this.edtValor.getText().toString();
        }
        return this.mCallback.getValorMinimo();
    }
}
