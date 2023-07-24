/*
 * Базовые модели для запросов
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.ObjectInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * Статистика от сервера
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-24T20:57:11.039974107+03:00[Europe/Moscow]")
public class ServerToGui {
  public static final String SERIALIZED_NAME_NEAREST_HOTELS = "nearestHotels";
  @SerializedName(SERIALIZED_NAME_NEAREST_HOTELS)
  private List<ObjectInfo> nearestHotels;

  public static final String SERIALIZED_NAME_NEAREST_CAFE = "nearestCafe";
  @SerializedName(SERIALIZED_NAME_NEAREST_CAFE)
  private List<ObjectInfo> nearestCafe;

  public ServerToGui() {
  }

  public ServerToGui nearestHotels(List<ObjectInfo> nearestHotels) {
    
    this.nearestHotels = nearestHotels;
    return this;
  }

  public ServerToGui addNearestHotelsItem(ObjectInfo nearestHotelsItem) {
    if (this.nearestHotels == null) {
      this.nearestHotels = new ArrayList<>();
    }
    this.nearestHotels.add(nearestHotelsItem);
    return this;
  }

   /**
   * Список ближайших КСР
   * @return nearestHotels
  **/
  @javax.annotation.Nullable
  public List<ObjectInfo> getNearestHotels() {
    return nearestHotels;
  }


  public void setNearestHotels(List<ObjectInfo> nearestHotels) {
    this.nearestHotels = nearestHotels;
  }


  public ServerToGui nearestCafe(List<ObjectInfo> nearestCafe) {
    
    this.nearestCafe = nearestCafe;
    return this;
  }

  public ServerToGui addNearestCafeItem(ObjectInfo nearestCafeItem) {
    if (this.nearestCafe == null) {
      this.nearestCafe = new ArrayList<>();
    }
    this.nearestCafe.add(nearestCafeItem);
    return this;
  }

   /**
   * Список ближайших общепитов
   * @return nearestCafe
  **/
  @javax.annotation.Nullable
  public List<ObjectInfo> getNearestCafe() {
    return nearestCafe;
  }


  public void setNearestCafe(List<ObjectInfo> nearestCafe) {
    this.nearestCafe = nearestCafe;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerToGui serverToGui = (ServerToGui) o;
    return Objects.equals(this.nearestHotels, serverToGui.nearestHotels) &&
        Objects.equals(this.nearestCafe, serverToGui.nearestCafe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nearestHotels, nearestCafe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerToGui {\n");
    sb.append("    nearestHotels: ").append(toIndentedString(nearestHotels)).append("\n");
    sb.append("    nearestCafe: ").append(toIndentedString(nearestCafe)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("nearestHotels");
    openapiFields.add("nearestCafe");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ServerToGui
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ServerToGui.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ServerToGui is not found in the empty JSON string", ServerToGui.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ServerToGui.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ServerToGui` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("nearestHotels") != null && !jsonObj.get("nearestHotels").isJsonNull()) {
        JsonArray jsonArraynearestHotels = jsonObj.getAsJsonArray("nearestHotels");
        if (jsonArraynearestHotels != null) {
          // ensure the json data is an array
          if (!jsonObj.get("nearestHotels").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `nearestHotels` to be an array in the JSON string but got `%s`", jsonObj.get("nearestHotels").toString()));
          }

          // validate the optional field `nearestHotels` (array)
          for (int i = 0; i < jsonArraynearestHotels.size(); i++) {
            ObjectInfo.validateJsonObject(jsonArraynearestHotels.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("nearestCafe") != null && !jsonObj.get("nearestCafe").isJsonNull()) {
        JsonArray jsonArraynearestCafe = jsonObj.getAsJsonArray("nearestCafe");
        if (jsonArraynearestCafe != null) {
          // ensure the json data is an array
          if (!jsonObj.get("nearestCafe").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `nearestCafe` to be an array in the JSON string but got `%s`", jsonObj.get("nearestCafe").toString()));
          }

          // validate the optional field `nearestCafe` (array)
          for (int i = 0; i < jsonArraynearestCafe.size(); i++) {
            ObjectInfo.validateJsonObject(jsonArraynearestCafe.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ServerToGui.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ServerToGui' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ServerToGui> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ServerToGui.class));

       return (TypeAdapter<T>) new TypeAdapter<ServerToGui>() {
           @Override
           public void write(JsonWriter out, ServerToGui value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ServerToGui read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ServerToGui given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ServerToGui
  * @throws IOException if the JSON string is invalid with respect to ServerToGui
  */
  public static ServerToGui fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ServerToGui.class);
  }

 /**
  * Convert an instance of ServerToGui to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

