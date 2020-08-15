package comhs.fundationdev.hairstyle.view;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import comhs.fundationdev.hairstyle.R;

public class SettingsActivity extends Activity {
    private String dbName;
    private EditText edtDbName;
    private EditText edtIp;
    private EditText edtPassowrd;
    private EditText edtUser;
    private String ip;
    private String password;
    private SharedPreferences preferences;
    private String user;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        carregarPreferencias();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        finish();
    }

    public void salvarPreferencias(View v) {
        Toast.makeText(getApplicationContext(), "Salvando preferencias", 1).show();
        this.preferences = getSharedPreferences(getString(R.string.preference_file), 0);
        Editor editor = this.preferences.edit();
        editor.putString(getString(R.string.preference_user), this.edtUser.getText().toString());
        editor.putString(getString(R.string.preference_base), this.edtDbName.getText().toString());
        editor.putString(getString(R.string.preference_pswd), this.edtPassowrd.getText().toString());
        editor.putString(getString(R.string.preference_server), this.edtIp.getText().toString());
        editor.commit();
        onDestroy();
    }

    private void carregarPreferencias() {
        this.preferences = getSharedPreferences(getString(R.string.preference_file), 0);
        this.user = getResources().getString(R.string.preference_user_default);
        this.ip = getResources().getString(R.string.preference_server_default);
        this.password = getResources().getString(R.string.preference_pswd_default);
        this.dbName = getResources().getString(R.string.preference_base_default);
        this.user = this.preferences.getString(getString(R.string.preference_user), this.user);
        this.ip = this.preferences.getString(getString(R.string.preference_server), this.ip);
        this.password = this.preferences.getString(getString(R.string.preference_pswd), this.password);
        this.dbName = this.preferences.getString(getString(R.string.preference_base), this.dbName);
        this.edtUser = (EditText) findViewById(R.id.edtUser);
        this.edtIp = (EditText) findViewById(R.id.edtIp);
        this.edtPassowrd = (EditText) findViewById(R.id.edtPassowrd);
        this.edtDbName = (EditText) findViewById(R.id.edtDbName);
        this.edtUser.setText(this.user);
        this.edtIp.setText(this.ip);
        this.edtPassowrd.setText(this.password);
        this.edtDbName.setText(this.dbName);
    }
}
