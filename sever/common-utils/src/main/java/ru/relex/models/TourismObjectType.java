/*
 * Базовые модели для запросов
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ru.relex.models;

import java.util.Objects;
import java.util.Arrays;
import io.swagger.v3.oas.annotations.media.Schema;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Тип туристического объекта
 */
@JsonAdapter(TourismObjectType.Adapter.class)
public enum TourismObjectType {
  @SerializedName("theatre")
  THEATRE("theatre"),
  @SerializedName("ethnicCenter")
  ETHNICCENTER("ethnicCenter"),
  @SerializedName("museum")
  MUSEUM("museum"),
  @SerializedName("childrensTourism")
  CHILDRENSTOURISM("childrensTourism"),
  @SerializedName("cityAttractions")
  CITYATTRACTIONS("cityAttractions"),
  @SerializedName("attraction")
  ATTRACTION("attraction"),
  @SerializedName("culturalCentre")
  CULTURALCENTRE("culturalCentre"),
  @SerializedName("shipbuilding")
  SHIPBUILDING("shipbuilding"),
  @SerializedName("nationalPark")
  NATIONALPARK("nationalPark"),
  @SerializedName("sanatorium")
  SANATORIUM("sanatorium"),
  @SerializedName("lookout")
  LOOKOUT("lookout"),
  @SerializedName("skiResort")
  SKIRESORT("skiResort");

  private String value;

  TourismObjectType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static TourismObjectType fromValue(String input) {
    for (TourismObjectType b : TourismObjectType.values()) {
      if (b.value.equals(input)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<TourismObjectType> {
    @Override
    public void write(final JsonWriter jsonWriter, final TourismObjectType enumeration) throws IOException {
      jsonWriter.value(String.valueOf(enumeration.getValue()));
    }

    @Override
    public TourismObjectType read(final JsonReader jsonReader) throws IOException {
      Object value = jsonReader.nextString();
      return TourismObjectType.fromValue((String)(value));
    }
  }
}
