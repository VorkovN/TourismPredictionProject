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
import org.openapitools.client.model.TourismObjectType;

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
 * Данные подключенных клиентов
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-24T20:59:40.132732482+03:00[Europe/Moscow]")
public class GuiToServer {
  public static final String SERIALIZED_NAME_TOURISM_OBJECT_TYPE = "tourismObjectType";
  @SerializedName(SERIALIZED_NAME_TOURISM_OBJECT_TYPE)
  private TourismObjectType tourismObjectType;

  public static final String SERIALIZED_NAME_LATITUDE = "latitude";
  @SerializedName(SERIALIZED_NAME_LATITUDE)
  private Float latitude = null;

  public static final String SERIALIZED_NAME_LONGITUDE = "longitude";
  @SerializedName(SERIALIZED_NAME_LONGITUDE)
  private Float longitude = null;

  public GuiToServer() {
  }

  public GuiToServer tourismObjectType(TourismObjectType tourismObjectType) {
    
    this.tourismObjectType = tourismObjectType;
    return this;
  }

   /**
   * Get tourismObjectType
   * @return tourismObjectType
  **/
  @javax.annotation.Nullable
  public TourismObjectType getTourismObjectType() {
    return tourismObjectType;
  }


  public void setTourismObjectType(TourismObjectType tourismObjectType) {
    this.tourismObjectType = tourismObjectType;
  }


  public GuiToServer latitude(Float latitude) {
    
    this.latitude = latitude;
    return this;
  }

   /**
   * Широта
   * @return latitude
  **/
  @javax.annotation.Nullable
  public Float getLatitude() {
    return latitude;
  }


  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }


  public GuiToServer longitude(Float longitude) {
    
    this.longitude = longitude;
    return this;
  }

   /**
   * Долгота
   * @return longitude
  **/
  @javax.annotation.Nullable
  public Float getLongitude() {
    return longitude;
  }


  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GuiToServer guiToServer = (GuiToServer) o;
    return Objects.equals(this.tourismObjectType, guiToServer.tourismObjectType) &&
        Objects.equals(this.latitude, guiToServer.latitude) &&
        Objects.equals(this.longitude, guiToServer.longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tourismObjectType, latitude, longitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GuiToServer {\n");
    sb.append("    tourismObjectType: ").append(toIndentedString(tourismObjectType)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
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
    openapiFields.add("tourismObjectType");
    openapiFields.add("latitude");
    openapiFields.add("longitude");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GuiToServer
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GuiToServer.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GuiToServer is not found in the empty JSON string", GuiToServer.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GuiToServer.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GuiToServer` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GuiToServer.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GuiToServer' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GuiToServer> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GuiToServer.class));

       return (TypeAdapter<T>) new TypeAdapter<GuiToServer>() {
           @Override
           public void write(JsonWriter out, GuiToServer value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GuiToServer read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GuiToServer given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GuiToServer
  * @throws IOException if the JSON string is invalid with respect to GuiToServer
  */
  public static GuiToServer fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GuiToServer.class);
  }

 /**
  * Convert an instance of GuiToServer to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

