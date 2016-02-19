package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;

import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.negocio.objects.Servico;
import comhs.fundationdev.hairstyle.util.ServerConect;

/**
 * Created by lucas on 11/02/16.
 */
public class ServicePersistency implements Persistencia<Servico> {
    private Context ctx;
    private StringBuilder sBuilder;
    private ServerConect conection;

    public ServicePersistency(Context context)
    {
        this.ctx = context;
        this.sBuilder = new StringBuilder();
        this.conection = new ServerConect(context, (context.getString(R.string.url_user)));
    }

    @Override
    public void inserir(Servico object) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public void inserir(String strObject) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<Servico> buscarTodos() throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<Servico> buscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<Servico> buscarTodos(String descricao) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<String> buscarString() throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public Servico buscarItem(String referencia) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public Servico buscarItem(int referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public Servico buscarItem(String referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<Servico> buscarItens(String referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public Boolean alterarItem(Servico item) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public Boolean alterarItem(Long id, Servico item) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public void excluirItem(Servico item) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public void excluirItem(int id) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }
}
