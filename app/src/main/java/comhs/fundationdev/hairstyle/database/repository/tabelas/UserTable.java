package comhs.fundationdev.hairstyle.database.repository.tabelas;

import comhs.fundationdev.hairstyle.database.repository.Types;

import static comhs.fundationdev.hairstyle.database.repository.Types.PRIMARY_KEY;

/**
 * Created by lucas on 04/02/16.
 */
public class UserTable {

    public static final String NOME_TABELA = "usuario";
    public static final String COD = "user";
    public static final String USER = "name";
    public static final String PSWD = "password";

    public static String criaTabela(){
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE ");
        sb.append(NOME_TABELA);
        sb.append(" ( ");
        sb.append(COD);
        sb.append(Types.INTEIRO + PRIMARY_KEY);
        sb.append(",");
        sb.append(USER);
        sb.append(Types.CHAR);
        sb.append(",");
        sb.append(PSWD);
        sb.append(Types.CHAR);
        sb.append(");");

        return sb.toString();
    }
}
