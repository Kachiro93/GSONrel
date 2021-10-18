package com.example.gson.activity;

import static com.example.gson.utils.NetworkUtils.getResponseURL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gson.R;
import com.example.gson.adapter.UserAdapter;
import com.example.gson.pojo.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.chromium.base.task.AsyncTask;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<User> adapter;
    ListView listView;
    public static final String URL_SERVER_JSON = "http://bx17827.rdock.ru/";
    public  static final  String jsonText = "[{\"id\":1,\"title\":\"titllfgbsyjhifgvjhvgsrfgb\"},{\"id\":2,\"title\":\"title2dafsdgbsgSDvSdrfbsgbs\"},{\"id\":3,\"title\":\"titllsdfaasfsfsgbsgaasrfgb\"},{\"id\":4,\"title\":\"titllsdfsfsfsgbsssgsrfgb\"},{\"id\":5,\"title\":\"titllsdfsfsfsgbsgwwsrfgb\"},{\"id\":6,\"title\":\"titllsdfsfsfsgbsgffsrfgb\"},{\"id\":7,\"title\":\"titllsdfsfsfsgbsgsrfgb\"},{\"id\":8,\"title\":\"titllsdfsfsfsgbsgsrfgb\"},{\"id\":9,\"title\":\"titllsdfsfsfsgbsgsrfgb\"},{\"id\":10,\"title\":\"titllsdfsfsfsgbsgsrfgb\"},{\"id\":11,\"title\":\"titllsdfsfsfsgbsgsrfgb\"},{\"id\":12,\"title\":\"titllsdfsfsfsgbsgsSDVrfgb\"},{\"id\":13,\"title\":\"titllsdfsfzdfvsfsgbsgsSDVrfgb\"},{\"id\":14,\"title\":\"titllsdfsffdbsfsgbsgsSDVrfgb\"},{\"id\":15,\"title\":\"titllsdfsfsfgbxfgfsgbsgsSDVrfgb\"},{\"id\":16,\"title\":\"titllsdxfgbxfgbfsfsfsgbsgsSDVrfgb\"},{\"id\":17,\"title\":\"titllzdfbzdfbzdfsdfsfsfsgbsgsSDVrfgb\"},{\"id\":18,\"title\":\"titllsdfsdfzbzdfbzdfbfsfsgbsgsSDVrfgb\"},{\"id\":19,\"title\":\"titllsdfsfsfsgbsSDvSDvSDvSgsSDVrfgb\"},{\"id\":20,\"title\":\"titllsdfsfsfsgbsSDvSDvSDvSgsSDzdfbzdfbzdfbVrfgb\"}]";
    class JsonTask extends AsyncTask<String> {


        protected String doInBackground() {

            return null;
        }

        protected void onPostExecute(String jsonText) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);

//        URL url = null;
//        try {
//            url = new URL(URL_SERVER_JSON);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
////
////        String jsonText = null;
////        try {
////            jsonText = getResponseURL(url);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type userstype = new TypeToken<ArrayList<User>>(){}.getType();

        ArrayList<User> users = gson.fromJson(jsonText, userstype);
        UserAdapter adapter = new UserAdapter(MainActivity.this, users);
        listView.setAdapter(adapter);

    }
}