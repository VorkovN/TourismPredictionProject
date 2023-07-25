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

package ru.relex.models.gui2server;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
//import com.google.gson.stream.JsonWriter;
//import io.swagger.client.model.TourismObjectType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

/**
 * Данные подключенных клиентов
 */
@Schema(description = "Данные подключенных клиентов")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-07-24T21:35:33.532498505Z[GMT]")
@Builder
@Getter
public class GuiToServer {
  @SerializedName("tourismObjectType")
  private String tourismObjectType = null;

  @SerializedName("latitude")
  private Float latitude = null;

  @SerializedName("longitude")
  private Float longitude = null;


   /**
   * Get tourismObjectType
   * @return tourismObjectType
  **/


  public void setTourismObjectType(String tourismObjectType) {
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
  @Schema(description = "Широта")
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
  @Schema(description = "Долгота")
  public Float getLongitude() {
    return longitude;
  }

  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
