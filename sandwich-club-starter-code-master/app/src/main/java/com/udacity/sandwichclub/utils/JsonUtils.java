package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        final String OWN_NAME = "name";
        final String OWN_MAIN_NAME = "mainName";
        final String OWN_ALSO_KNOWN_AS = "alsoKnownAs";

        final String OWN_PLACE = "placeOfOrigin";
        final String OWN_DESCRIPTION = "description";
        final String OWN_IMAGE = "image";
        final String OWN_INGREDIENTS = "ingredients";

        JSONObject sandwichJson = new JSONObject(json);

        JSONObject name = sandwichJson.getJSONObject(OWN_NAME);
        String mainName = name.getString(OWN_MAIN_NAME);

        JSONArray alsoKnowAsObj = name.getJSONArray(OWN_ALSO_KNOWN_AS);
        List<String> alsoKnowAsList = new ArrayList<String>();

        for(int i = 0; i < alsoKnowAsObj.length(); i++){
            String alsoKnownAs = alsoKnowAsObj.getString(i);
            alsoKnowAsList.add(alsoKnownAs);
        }

        String placeOfOrigin = sandwichJson.getString(OWN_PLACE);
        String description = sandwichJson.getString(OWN_DESCRIPTION);
        String image = sandwichJson.getString(OWN_IMAGE);

        JSONArray ingredientsObj = sandwichJson.getJSONArray(OWN_INGREDIENTS);
        List<String> ingredientsList = new ArrayList<String>();

        for(int i = 0; i < ingredientsObj.length(); i++){
            String ingredients = ingredientsObj.getString(i);
            ingredientsList.add(ingredients);
        }

        Sandwich sandObj = new Sandwich();

        sandObj.setMainName(mainName);
        sandObj.setAlsoKnownAs(alsoKnowAsList);
        sandObj.setPlaceOfOrigin(placeOfOrigin);
        sandObj.setDescription(description);
        sandObj.setImage(image);
        sandObj.setIngredients(ingredientsList);

        return sandObj;
    }
}
