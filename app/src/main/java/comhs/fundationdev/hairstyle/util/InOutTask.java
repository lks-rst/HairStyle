package comhs.fundationdev.hairstyle.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class InOutTask extends AsyncTask<Void, Void, Void> {
    private Context context;
    private ProgressDialog dialog;

    public InOutTask(Context ctx) {
        this.context = ctx;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        System.out.println("On onPreExecute " + getClass());
        this.dialog = new ProgressDialog(this.context);
        this.dialog.setMessage("Conectando ao servidor!");
        this.dialog.setCancelable(false);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.show();
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... params) {
        System.out.println("On doInBackground " + getClass());
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        System.out.println("On onPostExecute " + getClass());
        this.dialog.dismiss();
    }
}
