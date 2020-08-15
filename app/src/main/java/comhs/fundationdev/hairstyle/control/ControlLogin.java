package comhs.fundationdev.hairstyle.control;

import android.content.Context;
import comhs.fundationdev.hairstyle.database.queries.UserModel;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.negocio.objects.User;

public class ControlLogin {
    public static Boolean TASK_END;
    public static Boolean TASK_RESULT;
    private Context ctx;
    private UserModel model;
    private String pswd;
    private String usr;
    private int usrCod;

    public ControlLogin(Context ctx2) {
        this.ctx = ctx2;
        this.model = new UserModel(ctx2);
        TASK_END = Boolean.valueOf(false);
        TASK_RESULT = Boolean.valueOf(false);
    }

    public User getServerData() {
        int usr2;
        Object buscarItem;
        try {
            usr2 = Integer.parseInt(getUsr());
        } catch (Exception e) {
            usr2 = -1;
        }
        if (usr2 != -1) {
            try {
                buscarItem = this.model.buscarItem(usr2, getPswd());
            } catch (GenercicException e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            try {
                buscarItem = this.model.buscarItem(getUsr(), getPswd());
            } catch (GenercicException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (User) buscarItem;
    }

    public Boolean checkPassword(String serverPswd) {
        return Boolean.valueOf(getPswd().equals(serverPswd));
    }

    public String getUsr() {
        return this.usr;
    }

    public void setUsr(String usr2) {
        this.usr = usr2;
    }

    public String getPswd() {
        return this.pswd;
    }

    public void setPswd(String pswd2) {
        this.pswd = pswd2;
    }

    public int getUsrCod() {
        return this.usrCod;
    }
}
