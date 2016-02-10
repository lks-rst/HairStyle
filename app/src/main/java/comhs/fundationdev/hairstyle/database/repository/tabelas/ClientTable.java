package comhs.fundationdev.hairstyle.database.repository.tabelas;

/**
 * Created by lucas on 09/02/16.
 */
public class ClientTable {

    public static final String NOME_TABELA = "";

    public static String criaTabela(){
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE ");
        sb.append(NOME_TABELA);

        sb.append(");");

        return sb.toString();
    }
}
