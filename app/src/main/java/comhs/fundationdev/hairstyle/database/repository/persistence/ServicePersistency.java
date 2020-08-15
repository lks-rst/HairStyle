package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.negocio.objects.Servico;
import comhs.fundationdev.hairstyle.util.ServerConect;

public class ServicePersistency implements Persistencia<Servico> {
    private ServerConect conection;
    private Context ctx;
    private Connection myConnection;
    private StringBuilder sBuilder = new StringBuilder();
    private Statement statement;

    public ServicePersistency(Context context) {
        this.ctx = context;
        this.conection = new ServerConect(context, context.getString(R.string.url_service));
        this.myConnection = PersistencySingleton.getMyDataBase(context);
    }

    public void inserir(Servico object) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void inserir(String strObject) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<Servico> buscarTodos() throws GenercicException {
        List<Servico> listaServicos = new ArrayList<>();
        try {
            this.statement = this.myConnection.createStatement();
            ResultSet set = this.statement.executeQuery("SELECT coiffeur.geral_produtos_preco.preco_preco, coiffeur.geral_produtos.PROD_CODIGO, coiffeur.geral_produtos.prod_descricao FROM coiffeur.geral_produtos, coiffeur.geral_produtos_preco where coiffeur.geral_produtos_preco.prod_codigo = coiffeur.geral_produtos.PROD_CODIGO AND coiffeur.geral_produtos.prod_atv = 9;");
            this.statement.setQueryTimeout(0);
            while (set.next()) {
                Servico servico = new Servico();
                servico.setCodigo(set.getInt("prod_codigo"));
                servico.setDescricao(set.getString("prod_descricao"));
                servico.setValorMaximo(set.getFloat("preco_preco"));
                servico.setValorMinimo(set.getFloat("preco_preco"));
                listaServicos.add(servico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaServicos;
    }

    public List<Servico> buscarTodos(int tMin, int tMax) throws GenercicException {
        List<Servico> listaServicos = new ArrayList<>();
        try {
            this.statement = this.myConnection.createStatement();
            ResultSet set = this.statement.executeQuery("SELECT prod.PROD_CODIGO AS codigo, prod.prod_descricao AS descricao, preco.preco_preco AS valor FROM coiffeur.geral_produtos AS prod INNER JOIN coiffeur.geral_produtos_preco AS preco ON (preco.preco_tabela = " + tMin + " OR preco.preco_tabela = " + tMax + " ) AND preco.prod_codigo = prod.prod_codigo where prod.prod_atv = 9" + " ORDER BY prod.PROD_CODIGO, preco.preco_tabela");
            this.statement.setQueryTimeout(0);
            while (set.next()) {
                boolean encontrado = false;
                Iterator i$ = listaServicos.iterator();
                while (true) {
                    if (!i$.hasNext()) {
                        break;
                    }
                    Servico s = (Servico) i$.next();
                    if (s.getCodigo() == set.getInt("codigo")) {
                        s.setValorMaximo(set.getFloat("valor"));
                        listaServicos.set(listaServicos.indexOf(s), s);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    Servico servico = new Servico();
                    servico.setCodigo(set.getInt("codigo"));
                    servico.setDescricao(set.getString("descricao"));
                    servico.setValorMinimo(set.getFloat("valor"));
                    servico.setValorMaximo(set.getFloat("valor"));
                    listaServicos.add(servico);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaServicos;
    }

    public List<Servico> buscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<Servico> buscarTodos(String descricao) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<String> buscarString() throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Servico buscarItem(String referencia) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Servico buscarItem(int referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Servico buscarItem(String referencia, String secondCollun) throws GenercicException {
        try {
            return (Servico) new Servico().toEntidade(this.conection.buscarItem(referencia));
        } catch (Exception e) {
            return null;
        }
    }

    public List<Servico> buscarItens(String referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Boolean alterarItem(Servico item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Boolean alterarItem(Long id, Servico item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void excluirItem(Servico item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void excluirItem(int id) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }
}
