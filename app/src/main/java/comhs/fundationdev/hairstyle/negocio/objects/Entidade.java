package comhs.fundationdev.hairstyle.negocio.objects;

import java.io.Serializable;
import org.json.JSONObject;

public abstract class Entidade implements Serializable {
    public abstract Entidade toEntidade(JSONObject jSONObject);

    public abstract JSONObject toJsonObject(Entidade entidade);
}
