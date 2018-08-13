package com.tanzania.hemmy.mysystemdemographforme.Repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tanzania.hemmy.mysystemdemographforme.Api.BusApi;
import com.tanzania.hemmy.mysystemdemographforme.Class.History;
import com.tanzania.hemmy.mysystemdemographforme.Class.Token;
import com.tanzania.hemmy.mysystemdemographforme.Dao.HistoryDao;
import com.tanzania.hemmy.mysystemdemographforme.Dao.TokenDao;
import com.tanzania.hemmy.mysystemdemographforme.Helper.AppSingleton;
import com.tanzania.hemmy.mysystemdemographforme.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HistoryRepository {
    Context context;
    TokenDao tokenDao;
    HistoryDao historyDao;
    private History history;

    public void loadHistoryData(final String string){
        String cancel = "CancelLoadingData";
        Token token[] = tokenDao.getCustomer(false);
        String customerId = String.valueOf(token[0].getId());
        String link = BusApi.customerHistoryBooking  + customerId + "/" + string;
        StringRequest requestData = new StringRequest(Request.Method.GET, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Log.e("response","my " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean status = jsonObject.getBoolean(context.getString(R.string.json_status));
                    if(status){
                        JSONArray dataArray = jsonObject.getJSONArray("data");
                        int totalNumber = dataArray.length();
                        Log.e("Date ", "Num " + totalNumber + " data : " + dataArray.toString());
                        if(totalNumber > 0){
                            for (int i = 0; i < totalNumber; i++){
                                JSONObject objectData =  dataArray.getJSONObject(i);
                                JSONObject booked_seat = objectData.getJSONObject("booked_seat");
                                JSONObject bus = objectData.getJSONObject("bus");
                                JSONObject company = objectData.getJSONObject("company");
                                history = new History(
                                        objectData.getString("departure_time"),
                                        objectData.getString("arrival_time"),
                                        booked_seat.getString("fare"),
                                        booked_seat.getString("discount"),
                                        bus.getBoolean("visible"),
                                        "20 hours",
                                        booked_seat.getString("help_line_no"),
                                        bus.getString("bus_name"),
                                        bus.getString("model"),
                                        bus.getInt("max_seat_no"),
                                        bus.getString("phone"),
                                        bus.getBoolean("visible"),
                                        objectData.getString("from"),
                                        objectData.getString("to"),
                                        booked_seat.getString("_id"),
                                        booked_seat.getString("_id"),
                                        bus.getString("_id"),
                                        company.getString("_id"),
                                        string
                                );
                                historyDao.insert(history);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put(context.getString(R.string.map_header_parameter), tokenDao.getToken(false));
                return headers;
            }
        };

        AppSingleton.getInstance(context).addToRequestQueue(requestData,cancel);
    }
}
