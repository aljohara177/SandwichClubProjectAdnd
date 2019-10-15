package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        JSONObject sandwichName = jsonObject.getJSONObject("name");

        String mainName = sandwichName.getString("mainName");

        JSONArray alsoKnownAsJson = sandwichName.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs = toListConverter(alsoKnownAsJson);

        String placeOfOrigin = jsonObject.getString("placeOfOrigin");

        String description = jsonObject.getString("description");

        String image = jsonObject.getString("image");

        JSONArray ingredientsJson = jsonObject.getJSONArray("ingredients");
        List<String> ingredients = toListConverter(ingredientsJson);

        Sandwich sandwichDetails = new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);

        return sandwichDetails;
    }

    public static List<String> toListConverter(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<String>();
        if (jsonArray != null) {
            for ( int i=0 ; i < jsonArray.length() ; i++) {

                list.add(jsonArray.getString(i));
            }
        }
        return list;
    }
}
