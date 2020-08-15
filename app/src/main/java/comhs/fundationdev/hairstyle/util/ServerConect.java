package comhs.fundationdev.hairstyle.util;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.search.SearchAuth.StatusCodes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comhs.fundationdev.hairstyle.control.ControlLogin;
import comhs.fundationdev.hairstyle.database.repository.tabelas.UserTable;
import comhs.fundationdev.hairstyle.negocio.objects.Atendimento;
import cz.msebera.android.httpclient.client.methods.HttpPost;


/*
TODO: Solve HTTP connections
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
*/

public class ServerConect {
    private final int INSERE_ATENDIMENTO = 1;
    private Context ctx;
    private String urlConsulta;

    private class NameValuePair {
        protected String name;
        protected String value;

        NameValuePair(String name2, String value2) {
            this.name = name2;
            this.value = value2;
        }

        /* access modifiers changed from: protected */
        public String getName() {
            return this.name;
        }

        /* access modifiers changed from: protected */
        public String getValue() {
            return this.value;
        }
    }

    public ServerConect(Context ctx2, String tipoConsulta) {
        this.ctx = ctx2;
        this.urlConsulta = tipoConsulta;
    }

    public boolean inserir(Object object) {
        Atendimento atendimento = (Atendimento) object;
        settingData(atendimento.toJsonObject(atendimento));
        return false;
    }

    public JSONArray buscarTodos() {
        JSONArray jsonObject = null;
        ParametersObject object = new ParametersObject();
        object.setAction("0");
        object.setCollOne("");
        object.setCollTwo("");
        try {
            jsonObject = new JSONArray(buscarItem(object));
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                return null;
            }
        }
        return jsonObject;
    }

    public JSONArray buscarItens(String collOne, String collTwo) {
        JSONArray jsonObject = null;
        ParametersObject object = new ParametersObject();
        object.setAction("1");
        object.setCollOne(collOne);
        object.setCollTwo(collTwo);
        try {
            jsonObject = new JSONArray(buscarItem(object));
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                return null;
            }
        }
        return jsonObject;
    }

    public JSONArray buscarItens(String collOne) {
        JSONArray jsonObject = null;
        ParametersObject object = new ParametersObject();
        object.setAction("1");
        object.setCollOne(collOne);
        object.setCollTwo("");
        try {
            jsonObject = new JSONArray(buscarItem(object));
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                return null;
            }
        }
        return jsonObject;
    }

    public JSONObject buscarItem(String collOne) {
        JSONObject jsonObject = null;
        ParametersObject object = new ParametersObject();
        object.setAction("1");
        object.setCollOne(collOne);
        object.setCollTwo("");
        try {
            jsonObject = new JSONObject(buscarItem(object));
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                return null;
            }
        }
        return jsonObject;
    }

    public JSONObject buscarItem(String collOne, String collTwo) {
        JSONObject jsonObject = null;
        ParametersObject object = new ParametersObject();
        object.setAction("2");
        object.setCollOne(collOne);
        object.setCollTwo(collTwo);
        try {
            jsonObject = new JSONObject(buscarItem(object));
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                return null;
            }
        }
        return jsonObject;
    }

    public boolean alterarItem(Object item) {
        return false;
    }

    public boolean excluirItem(int item) {
        ParametersObject object = new ParametersObject();
        object.setAction("-1");
        object.setCollOne(String.valueOf(item));
        object.setCollTwo("");
        try {
            JSONObject jsonObject = new JSONObject(buscarItem(object));
            try {
                if (jsonObject.getBoolean("answer")) {
                    JSONObject jSONObject = jsonObject;
                    return true;
                }
                return false;
            } catch (Exception e) {
                JSONObject jSONObject2 = jsonObject;
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public void sendingData() {
        try {
            ArrayList<String> args = new ArrayList<>();
            args.add("Lucas");
            args.add("Lucas");
            args.add("Lucas");
            settingData(args);
            ControlLogin.TASK_RESULT = Boolean.valueOf(true);
        } catch (Exception e) {
            Log.e("Error", e.toString());
            ControlLogin.TASK_RESULT = Boolean.valueOf(false);
        }
    }

    private String buscarItem(ParametersObject o) {
        URL url = null;
        try {
            url = new URL(this.urlConsulta);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(StatusCodes.AUTH_DISABLED);
            urlConnection.setConnectTimeout(15000);
            /*
            TODO: Solve HTTP connections
            urlConnection.setRequestMethod(HttpGet.METHOD_NAME);
            */
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            List<NameValuePair> params = new ArrayList<>();
            params.add(new NameValuePair("action", o.getAction()));
            params.add(new NameValuePair("collOne", o.getCollOne()));
            params.add(new NameValuePair("collTwo", o.getCollTwo()));
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(params));
            writer.flush();
            writer.close();
            os.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        InputStream in = null;
        try {
            in = new BufferedInputStream(urlConnection.getInputStream());
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line);
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        urlConnection.disconnect();
        return builder.toString();
    }
/*

    public JSONArray buscarUsuarios() {
        URL url = null;
        try {
            url = new URL(this.urlConsulta);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(StatusCodes.AUTH_DISABLED);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod(HttpGet.METHOD_NAME);
            urlConnection.setDoInput(true);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        InputStream in = null;
        try {
            in = new BufferedInputStream(urlConnection.getInputStream());
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line);
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        urlConnection.disconnect();
        try {
            return new JSONArray(builder.toString());
        } catch (Exception e5) {
            return null;
        }
    }
*/

    public JSONObject buscarUsuario(String collOne) {
        JSONObject jsonObject = null;
        ParametersObject object = new ParametersObject();
        object.setAction("1");
        object.setCollOne(collOne);
        object.setCollTwo("");
        try {
            jsonObject = new JSONObject(buscarUsuario(object));
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                return null;
            }
        }
        return jsonObject;
    }

    private String buscarUsuario(ParametersObject o) {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new NameValuePair("action", o.getAction()));
        params.add(new NameValuePair("collOne", o.getCollOne()));
        params.add(new NameValuePair("collTwo", o.getCollTwo()));
        URL url = null;
        try {
            this.urlConsulta += "?" + getQuery(params);
        } catch (UnsupportedEncodingException e) {
        }
        try {
            url = new URL(this.urlConsulta);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(StatusCodes.AUTH_DISABLED);
            urlConnection.setConnectTimeout(15000);
            /*
            TODO: Solve HTTP connections
            urlConnection.setRequestMethod(HttpGet.METHOD_NAME);
            */
            urlConnection.setDoInput(true);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        InputStream in = null;
        try {
            in = new BufferedInputStream(urlConnection.getInputStream());
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line);
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        urlConnection.disconnect();
        return builder.toString();
    }

    private void settingData(ArrayList<String> args) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(this.urlConsulta).openConnection();
            urlConnection.setRequestMethod(HttpPost.METHOD_NAME);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();
            JSONObject jsonObject = new JSONObject();
            JSONArray arrayServicos = new JSONArray();
            String str = (String) args.get(0);
            getClass();
            if (str.equals(Integer.valueOf(1))) {
                jsonObject.put("cliente", args.get(1));
                jsonObject.put(UserTable.NOME_TABELA, args.get(2));
                jsonObject.put("dataInicio", args.get(3));
                jsonObject.put("horaInicio", args.get(4));
                int i = 5;
                while (i < args.size()) {
                    JSONObject jsonServico = new JSONObject();
                    int i2 = i + 1;
                    jsonServico.put("servico", args.get(i));
                    int i3 = i2 + 1;
                    jsonServico.put("valorCobrado", args.get(i2));
                    arrayServicos.put(jsonServico);
                    i = i3 + 1;
                }
                jsonObject.put("servicos", arrayServicos);
            }
            Log.d("json", jsonObject.toString());
            Log.d("request", "starting");
            OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
            writer.write(jsonObject.toString());
            writer.flush();
            Log.e("connection status", urlConnection.getResponseMessage());
            BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(urlConnection.getInputStream())));
            StringBuilder strBuilder = new StringBuilder();
            while (true) {
                String line = reader.readLine();
                if (line != null) {
                    strBuilder.append(line);
                } else {
                    writer.close();
                    reader.close();
                    urlConnection.disconnect();
                    Log.e("Response Server", strBuilder.toString());
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void settingData(JSONObject args) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(this.urlConsulta).openConnection();
            urlConnection.setRequestMethod(HttpPost.METHOD_NAME);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setReadTimeout(StatusCodes.AUTH_DISABLED);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();
            Log.d("json", args.toString());
            Log.d("request", "starting");
            OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
            writer.write(args.toString());
            writer.flush();
            Log.e("connection status", urlConnection.getResponseMessage());
            writer.close();
            int code = urlConnection.getResponseCode();
            urlConnection.disconnect();
            Log.e("Response Server = ", String.valueOf(code));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (NameValuePair pair : params) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }
        return result.toString();
    }

    public void connect() throws Exception {
        Log.e("Android", "SQL Connection start");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement statement = DriverManager.getConnection("jdbc:mysql://" + "192.168.1.2" + "/" + "hairStyle" + "", "root", "MiriaN1208").createStatement();
        ResultSet set = statement.executeQuery("Select * from User");
        statement.setQueryTimeout(0);
        while (set.next()) {
            Log.e("Data:", set.getString("id"));
        }
    }

    public JSONObject readUserOld(Object usr) throws Exception {
        JSONObject jsonObject = null;
        ParametersObject object = new ParametersObject();
        object.setAction("1");
        object.setCollOne(usr.toString());
        object.setCollTwo("");
        try {
            JSONObject jsonObject2 = new JSONObject(buscarItem(object));
            try {
                System.out.println(jsonObject2.toString());
                jsonObject = jsonObject2;
            } catch (Exception e) {
                e = e;
                jsonObject = jsonObject2;
                e.printStackTrace();
                ControlLogin.TASK_RESULT = Boolean.valueOf(true);
                return jsonObject;
            }
        } catch (Exception e2) {
            e2 = e2;
            e2.printStackTrace();
            ControlLogin.TASK_RESULT = Boolean.valueOf(true);
            return jsonObject;
        }
        try {
            ControlLogin.TASK_RESULT = Boolean.valueOf(true);
            return jsonObject;
        } catch (Exception e3) {
            Log.e("Error", e3.toString());
            ControlLogin.TASK_RESULT = Boolean.valueOf(false);
            return null;
        }
    }
}
