package comhs.fundationdev.hairstyle.view.interfaces;

import java.util.List;

public interface InterfaceSRV {
    void carregarFragValor();

    void carregarServicos();

    List<String> getStringServices();

    void indicarPosicaoServicos(int i);

    void showMensageSRV(String str);
}
