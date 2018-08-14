package com.tanzania.hemmy.mysystemdemographforme.Repository;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tanzania.hemmy.mysystemdemographforme.Activities.StartingActivity;
import com.tanzania.hemmy.mysystemdemographforme.Api.BusApi;
import com.tanzania.hemmy.mysystemdemographforme.Class.Token;
import com.tanzania.hemmy.mysystemdemographforme.Class.Users;
import com.tanzania.hemmy.mysystemdemographforme.Dao.TokenDao;
import com.tanzania.hemmy.mysystemdemographforme.Dao.UsersDao;
import com.tanzania.hemmy.mysystemdemographforme.Database.MsafiriDatabase;
import com.tanzania.hemmy.mysystemdemographforme.Helper.AppSingleton;
import com.tanzania.hemmy.mysystemdemographforme.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UsersRepository {
    private Context context;
    TokenDao tokenDao;
    UsersDao usersDao;
    MsafiriDatabase msafiriDatabase;
    public UsersRepository(Context context){
        this.context = context;
        msafiriDatabase = MsafiriDatabase.getDatabase(context);
        tokenDao = msafiriDatabase.TokenDao();
        usersDao = msafiriDatabase.UsersDao();
    }

    public void loginToSystem(final String username, final String password){
        String cancelTag = "TextToCancledRequest";
        String url = BusApi.loginToSystem;
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("jhajjhahjshhsjhsjsa","hh"+response);
                try {
                    JSONObject loginJsonObject = new JSONObject(response);
                    boolean status = loginJsonObject.getBoolean(context.getString(R.string.json_status));

                    if (status) {
                        JSONObject dataDetails = loginJsonObject.getJSONObject("data");
                        JSONObject userDetails = dataDetails.getJSONObject("user");
                        String tokenDetails = dataDetails.getString(context.getString(R.string.shared_token));

                        String firstName = userDetails.getString(context.getString(R.string.shared_first_name));
                        String lastName = userDetails.getString(context.getString(R.string.shared_last_name));
                        String email = userDetails.getString(context.getString(R.string.shared_email));
                        String gender = userDetails.getString(context.getString(R.string.shared_gender));
                        String address = userDetails.getString(context.getString(R.string.shared_address));
                        String role = userDetails.getString(context.getString(R.string.shared_role));
                        String customer_id = userDetails.getString(context.getString(R.string.shared_id));
                        String phone_no = userDetails.getString(context.getString(R.string.shared_phone_number));
                        boolean phone_verified = userDetails.getBoolean(context.getString(R.string.shared_phone_verified));
                        Token token = new Token(customer_id,tokenDetails,false,(System.currentTimeMillis() + 10000));
                        Users users = new Users(
                                firstName,
                                lastName,
                                email,
                                password,
                                gender,
                                address,
                                role,
                                String.valueOf(phone_verified),
                                customer_id,
                                phone_no,
                                "00"
                        );

                        InsertOfflineDb offlineDb = new InsertOfflineDb(context,usersDao,tokenDao,users,token);
                        offlineDb.execute();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email",username);
                params.put("password",password);
                return params;
            }
        };

        AppSingleton.getInstance(context).addToRequestQueue(request,cancelTag);
    }

    private static class InsertOfflineDb extends AsyncTask<Void, Void, Void>{
        UsersDao usersDao;
        TokenDao tokenDao;
        Users users;
        Token token;
        Context context;

        public InsertOfflineDb(Context context,UsersDao usersDao, TokenDao tokenDao, Users users, Token token) {
            this.usersDao = usersDao;
            this.tokenDao = tokenDao;
            this.users = users;
            this.token = token;
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            usersDao.insert(users);
            tokenDao.insert(token);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            context.startActivity(new Intent(context, StartingActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }
}
