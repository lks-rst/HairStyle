package comhs.fundationdev.hairstyle.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.Profile;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.control.ControlLogin;
import comhs.fundationdev.hairstyle.negocio.objects.User;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor>, Runnable {
    private static final int REQUEST_READ_CONTACTS = 0;
    /* access modifiers changed from: private */
    public ControlLogin control;
    private ProgressDialog dialog;
    /* access modifiers changed from: private */
    public UserLoginTask mAuthTask = null;
    /* access modifiers changed from: private */
    public AutoCompleteTextView mEmailView;
    /* access modifiers changed from: private */
    public View mLoginFormView;
    /* access modifiers changed from: private */
    public EditText mPasswordView;
    /* access modifiers changed from: private */
    public View mProgressView;
    /* access modifiers changed from: private */
    public User usr;

    private interface ProfileQuery {
        public static final int ADDRESS = 0;
        public static final int IS_PRIMARY = 1;
        public static final String[] PROJECTION = {"data1", "is_primary"};
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        View focusView = null;

        public UserLoginTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            LoginActivity.this.showProgress(true);
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            LoginActivity.this.usr = LoginActivity.this.control.getServerData();
            if (LoginActivity.this.usr != null) {
                this.focusView = LoginActivity.this.mPasswordView;
                return Boolean.valueOf(true);
            }
            this.focusView = LoginActivity.this.mEmailView;
            return Boolean.valueOf(false);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean success) {
            LoginActivity.this.mAuthTask = null;
            LoginActivity.this.showProgress(false);
            if (!success.booleanValue()) {
                LoginActivity.this.mEmailView.setError(LoginActivity.this.getString(R.string.error_invalid_user));
                this.focusView.requestFocus();
            } else if (LoginActivity.this.control.checkPassword(LoginActivity.this.usr.getPswd()).booleanValue()) {
                LoginActivity.this.serverConectionEnd();
            } else {
                LoginActivity.this.mPasswordView.setError(LoginActivity.this.getString(R.string.error_incorrect_password));
                this.focusView.requestFocus();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            LoginActivity.this.mAuthTask = null;
            LoginActivity.this.showProgress(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_login);
        new Handler().postDelayed(this, 3000);
    }

    private void populateAutoComplete() {
        if (mayRequestContacts()) {
            getLoaderManager().initLoader(0, null, this);
        }
    }

    private boolean mayRequestContacts() {
        if (VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
            return true;
        }
        if (shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
            Snackbar.make((View) this.mEmailView, (int) R.string.permission_rationale, -2).setAction(17039370, (OnClickListener) new OnClickListener() {
                @TargetApi(23)
                public void onClick(View v) {
                    LoginActivity.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            });
        } else {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
        }
        return false;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0 && grantResults.length == 1 && grantResults[0] == 0) {
            populateAutoComplete();
        }
    }

    private void attemptLogin() {
        this.mEmailView.setError(null);
        this.mPasswordView.setError(null);
        String email = this.mEmailView.getText().toString();
        String password = this.mPasswordView.getText().toString();
        boolean cancel = false;
        View focusView = null;
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            this.mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = this.mPasswordView;
            cancel = true;
        }
        if (TextUtils.isEmpty(email)) {
            this.mEmailView.setError(getString(R.string.error_field_required));
            focusView = this.mEmailView;
            cancel = true;
        } else if (isEmailValid(email)) {
            this.mEmailView.setError(getString(R.string.error_invalid_user));
            focusView = this.mEmailView;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
            return;
        }
        this.control.setUsr(this.mEmailView.getText().toString());
        this.control.setPswd(this.mPasswordView.getText().toString());
        this.mAuthTask = new UserLoginTask();
        this.mAuthTask.execute(new Void[0]);
    }

    private boolean isEmailValid(String email) {
        return email.contains(" ");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    /* access modifiers changed from: private */
    @TargetApi(13)
    public void showProgress(final boolean show) {
        int i;
        int i2;
        float f;
        float f2 = 1.0f;
        int i3 = 8;
        int i4 = 0;
        if (VERSION.SDK_INT >= 13) {
            int shortAnimTime = getResources().getInteger(17694720);
            View view = this.mLoginFormView;
            if (show) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view.setVisibility(i2);
            ViewPropertyAnimator duration = this.mLoginFormView.animate().setDuration((long) shortAnimTime);
            if (show) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            duration.alpha(f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    LoginActivity.this.mLoginFormView.setVisibility(show ? 8 : 0);
                }
            });
            View view2 = this.mProgressView;
            if (!show) {
                i4 = 8;
            }
            view2.setVisibility(i4);
            ViewPropertyAnimator duration2 = this.mProgressView.animate().setDuration((long) shortAnimTime);
            if (!show) {
                f2 = 0.0f;
            }
            duration2.alpha(f2).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    LoginActivity.this.mProgressView.setVisibility(show ? 0 : 8);
                }
            });
            return;
        }
        View view3 = this.mProgressView;
        if (show) {
            i = 0;
        } else {
            i = 8;
        }
        view3.setVisibility(i);
        View view4 = this.mLoginFormView;
        if (!show) {
            i3 = 0;
        }
        view4.setVisibility(i3);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, Uri.withAppendedPath(Profile.CONTENT_URI, "data"), ProfileQuery.PROJECTION, "mimetype = ?", new String[]{"vnd.android.cursor.item/email_v2"}, "is_primary DESC");
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(0));
            cursor.moveToNext();
        }
        addEmailsToAutoComplete(emails);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        this.mEmailView.setAdapter(new ArrayAdapter<>(this, 17367050, emailAddressCollection));
    }

    /* access modifiers changed from: private */
    public void serverConectionEnd() {
        this.mLoginFormView.setClickable(true);
        this.mLoginFormView.setEnabled(true);
        this.mEmailView.setText("");
        this.mPasswordView.setText("");
        Intent i = new Intent(this, Atendimentos.class);
        i.putExtra("USUARIO", this.usr);
        startActivity(i);
    }

    public void run() {
        startActivity(new Intent(this, Atendimentos.class));
        finish();
    }
}
