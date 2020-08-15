package comhs.fundationdev.hairstyle.view.interfaces;

import java.util.List;

public interface InterfaceUC {
    int getPosicaoCliente();

    int getPosicaoUsuario();

    List<String> getStringClients();

    List<String> getStringUsers();

    void indicarPosicaoCliente(int i);

    void indicarPosicaoUsuario(int i);

    void showMensageUC(String str);
}
