package comhs.fundationdev.hairstyle.negocio.objects;

import org.json.JSONObject;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Entidade implements Serializable {
    public abstract Entidade toEntidade(JSONObject object);
    public abstract JSONObject toJsonObject(Entidade object);

}