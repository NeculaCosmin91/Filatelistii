package com.example.filatelistii.Necesar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ColectiiJsonParser {
    public static final String CATEGORIE_COLECTIE = "categorieColectie";
    public static final String NUME_COLECTIE = "numeColectie";
    public static final String AN_COLECTIE = "anColectie";
    public static final String NUME_TARA = "numeTara";


    public static List<Colectii> fromJson(String json){
      try {
           JSONArray array= new JSONArray(json);
          return citireColectii(array);
       } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }

    private static List<Colectii> citireColectii(JSONArray array) throws JSONException {
       List<Colectii> colectie= new ArrayList<>();
       for(int i=0;i<array.length();i++){
            Colectii colectii= citireColectii(array.getJSONObject(i));
            colectie.add(colectii);
        }
       return colectie;
    }

   private static Colectii citireColectii(JSONObject jsonObject) throws JSONException {
      String categorieColectie= jsonObject.getString(CATEGORIE_COLECTIE);
       String numeColectie=jsonObject.getString(
               NUME_COLECTIE);
        int anColectie=jsonObject.getInt(
                AN_COLECTIE);
        String numeTara= jsonObject.getString(
                NUME_TARA);

      return new Colectii(categorieColectie, numeColectie, anColectie, numeTara);
    }
}
