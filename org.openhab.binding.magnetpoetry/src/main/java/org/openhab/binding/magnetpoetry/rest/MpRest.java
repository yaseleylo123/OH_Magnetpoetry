package org.openhab.binding.magnetpoetry.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MpRest {

    private JsonArray getJsonItems() {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://localhost:8080/rest/items?recursive=false");
        httpGet.addHeader("Accept", "application/json");
        JsonArray jsonItems = null;
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String output;
            List<String> outputs = new ArrayList<String>();
            while ((output = br.readLine()) != null) {
                outputs.add(output);
            }
            httpClient.getConnectionManager().shutdown();

            Gson gson = new Gson();
            String data = outputs.get(0);
            JsonParser jsonParser = new JsonParser();
            jsonItems = (JsonArray) jsonParser.parse(data);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonItems;
    }

    public List<MpItem> getItems() {
        JsonArray jsonItems = this.getJsonItems();
        List<MpItem> items = new ArrayList<MpItem>();
        for (JsonElement jsonElement : jsonItems) {
            String link = null;
            String type = null;
            String name = null;
            String label = null;
            JsonObject object = (JsonObject) jsonElement;
            if (object.has("link")) {
                link = object.get("link").getAsString();
            }
            if (object.has("type")) {
                type = object.get("type").getAsString();
            }
            if (object.has("name")) {
                name = object.get("name").getAsString();
            }
            if (object.has("label")) {
                label = object.get("name").getAsString();
            }
            MpItem newItem = new MpItem(link, type, name, label);
            items.add(newItem);
        }
        return items;
    }
}
