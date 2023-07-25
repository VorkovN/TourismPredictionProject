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

package ru.relex.models.server2ml;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.io.IOException;
/**
 * Параметры для ML модели от сервера
 */
@Schema(description = "Параметры для ML модели от сервера")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-07-25T01:18:48.012222797Z[GMT]")
@Builder
public class ServerToMl {
  @SerializedName("name")
  private String name = null;

  @SerializedName("latitude")
  private Float latitude = null;

  @SerializedName("longitude")
  private Float longitude = null;

  @SerializedName("coeffNearestPopularity")
  private Float coeffNearestPopularity = null;

  @SerializedName("carAvailability")
  private Boolean carAvailability = null;

  @SerializedName("busAvailability")
  private Boolean busAvailability = null;

  @SerializedName("bigCarAvailability")
  private Boolean bigCarAvailability = null;

  @SerializedName("shipAvailability")
  private Boolean shipAvailability = null;

  @SerializedName("planeAvailability")
  private Boolean planeAvailability = null;

  @SerializedName("theatre")
  private Boolean theatre = null;

  @SerializedName("ethnicCenter")
  private Boolean ethnicCenter = null;

  @SerializedName("museum")
  private Boolean museum = null;

  @SerializedName("childrensTourism")
  private Boolean childrensTourism = null;

  @SerializedName("cityAttractions")
  private Boolean cityAttractions = null;

  @SerializedName("attraction")
  private Boolean attraction = null;

  @SerializedName("culturalCentre")
  private Boolean culturalCentre = null;

  @SerializedName("shipbuilding")
  private Boolean shipbuilding = null;

  @SerializedName("nationalPark")
  private Boolean nationalPark = null;

  @SerializedName("sanatorium")
  private Boolean sanatorium = null;

  @SerializedName("lookout")
  private Boolean lookout = null;

  @SerializedName("skiResort")
  private Boolean skiResort = null;

  public ServerToMl name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Имя объекта
   * @return name
  **/
  @Schema(description = "Имя объекта")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServerToMl latitude(Float latitude) {
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

  public ServerToMl longitude(Float longitude) {
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

  public ServerToMl coeffNearestPopularity(Float coeffNearestPopularity) {
    this.coeffNearestPopularity = coeffNearestPopularity;
    return this;
  }

   /**
   * Коэффициент кол-ва запросов в месяц окружающих объектов
   * @return coeffNearestPopularity
  **/
  @Schema(description = "Коэффициент кол-ва запросов в месяц окружающих объектов")
  public Float getCoeffNearestPopularity() {
    return coeffNearestPopularity;
  }

  public void setCoeffNearestPopularity(Float coeffNearestPopularity) {
    this.coeffNearestPopularity = coeffNearestPopularity;
  }

  public ServerToMl carAvailability(Boolean carAvailability) {
    this.carAvailability = carAvailability;
    return this;
  }

   /**
   * Доступность автомобиля
   * @return carAvailability
  **/
  @Schema(description = "Доступность автомобиля")
  public Boolean isCarAvailability() {
    return carAvailability;
  }

  public void setCarAvailability(Boolean carAvailability) {
    this.carAvailability = carAvailability;
  }

  public ServerToMl busAvailability(Boolean busAvailability) {
    this.busAvailability = busAvailability;
    return this;
  }

   /**
   * Доступность автобуса
   * @return busAvailability
  **/
  @Schema(description = "Доступность автобуса")
  public Boolean isBusAvailability() {
    return busAvailability;
  }

  public void setBusAvailability(Boolean busAvailability) {
    this.busAvailability = busAvailability;
  }

  public ServerToMl bigCarAvailability(Boolean bigCarAvailability) {
    this.bigCarAvailability = bigCarAvailability;
    return this;
  }

   /**
   * Доступность внедорожника
   * @return bigCarAvailability
  **/
  @Schema(description = "Доступность внедорожника")
  public Boolean isBigCarAvailability() {
    return bigCarAvailability;
  }

  public void setBigCarAvailability(Boolean bigCarAvailability) {
    this.bigCarAvailability = bigCarAvailability;
  }

  public ServerToMl shipAvailability(Boolean shipAvailability) {
    this.shipAvailability = shipAvailability;
    return this;
  }

   /**
   * Доступность внедорожника
   * @return shipAvailability
  **/
  @Schema(description = "Доступность внедорожника")
  public Boolean isShipAvailability() {
    return shipAvailability;
  }

  public void setShipAvailability(Boolean shipAvailability) {
    this.shipAvailability = shipAvailability;
  }

  public ServerToMl planeAvailability(Boolean planeAvailability) {
    this.planeAvailability = planeAvailability;
    return this;
  }

   /**
   * Доступность самолета
   * @return planeAvailability
  **/
  @Schema(description = "Доступность самолета")
  public Boolean isPlaneAvailability() {
    return planeAvailability;
  }

  public void setPlaneAvailability(Boolean planeAvailability) {
    this.planeAvailability = planeAvailability;
  }

  public ServerToMl theatre(Boolean theatre) {
    this.theatre = theatre;
    return this;
  }

   /**
   * Театр
   * @return theatre
  **/
  @Schema(description = "Театр")
  public Boolean isTheatre() {
    return theatre;
  }

  public void setTheatre(Boolean theatre) {
    this.theatre = theatre;
  }

  public ServerToMl ethnicCenter(Boolean ethnicCenter) {
    this.ethnicCenter = ethnicCenter;
    return this;
  }

   /**
   * Этнический центр
   * @return ethnicCenter
  **/
  @Schema(description = "Этнический центр")
  public Boolean isEthnicCenter() {
    return ethnicCenter;
  }

  public void setEthnicCenter(Boolean ethnicCenter) {
    this.ethnicCenter = ethnicCenter;
  }

  public ServerToMl museum(Boolean museum) {
    this.museum = museum;
    return this;
  }

   /**
   * Музей
   * @return museum
  **/
  @Schema(description = "Музей")
  public Boolean isMuseum() {
    return museum;
  }

  public void setMuseum(Boolean museum) {
    this.museum = museum;
  }

  public ServerToMl childrensTourism(Boolean childrensTourism) {
    this.childrensTourism = childrensTourism;
    return this;
  }

   /**
   * Детский туризм
   * @return childrensTourism
  **/
  @Schema(description = "Детский туризм")
  public Boolean isChildrensTourism() {
    return childrensTourism;
  }

  public void setChildrensTourism(Boolean childrensTourism) {
    this.childrensTourism = childrensTourism;
  }

  public ServerToMl cityAttractions(Boolean cityAttractions) {
    this.cityAttractions = cityAttractions;
    return this;
  }

   /**
   * Городские достопримечательности
   * @return cityAttractions
  **/
  @Schema(description = "Городские достопримечательности")
  public Boolean isCityAttractions() {
    return cityAttractions;
  }

  public void setCityAttractions(Boolean cityAttractions) {
    this.cityAttractions = cityAttractions;
  }

  public ServerToMl attraction(Boolean attraction) {
    this.attraction = attraction;
    return this;
  }

   /**
   * Достопримечательность
   * @return attraction
  **/
  @Schema(description = "Достопримечательность")
  public Boolean isAttraction() {
    return attraction;
  }

  public void setAttraction(Boolean attraction) {
    this.attraction = attraction;
  }

  public ServerToMl culturalCentre(Boolean culturalCentre) {
    this.culturalCentre = culturalCentre;
    return this;
  }

   /**
   * Культурный центр
   * @return culturalCentre
  **/
  @Schema(description = "Культурный центр")
  public Boolean isCulturalCentre() {
    return culturalCentre;
  }

  public void setCulturalCentre(Boolean culturalCentre) {
    this.culturalCentre = culturalCentre;
  }

  public ServerToMl shipbuilding(Boolean shipbuilding) {
    this.shipbuilding = shipbuilding;
    return this;
  }

   /**
   * Судостроение
   * @return shipbuilding
  **/
  @Schema(description = "Судостроение")
  public Boolean isShipbuilding() {
    return shipbuilding;
  }

  public void setShipbuilding(Boolean shipbuilding) {
    this.shipbuilding = shipbuilding;
  }

  public ServerToMl nationalPark(Boolean nationalPark) {
    this.nationalPark = nationalPark;
    return this;
  }

   /**
   * Нац. парк
   * @return nationalPark
  **/
  @Schema(description = "Нац. парк")
  public Boolean isNationalPark() {
    return nationalPark;
  }

  public void setNationalPark(Boolean nationalPark) {
    this.nationalPark = nationalPark;
  }

  public ServerToMl sanatorium(Boolean sanatorium) {
    this.sanatorium = sanatorium;
    return this;
  }

   /**
   * Санаторий
   * @return sanatorium
  **/
  @Schema(description = "Санаторий")
  public Boolean isSanatorium() {
    return sanatorium;
  }

  public void setSanatorium(Boolean sanatorium) {
    this.sanatorium = sanatorium;
  }

  public ServerToMl lookout(Boolean lookout) {
    this.lookout = lookout;
    return this;
  }

   /**
   * Обзорная площадка
   * @return lookout
  **/
  @Schema(description = "Обзорная площадка")
  public Boolean isLookout() {
    return lookout;
  }

  public void setLookout(Boolean lookout) {
    this.lookout = lookout;
  }

  public ServerToMl skiResort(Boolean skiResort) {
    this.skiResort = skiResort;
    return this;
  }

   /**
   * Горнолыжный курорт
   * @return skiResort
  **/
  @Schema(description = "Горнолыжный курорт")
  public Boolean isSkiResort() {
    return skiResort;
  }

  public void setSkiResort(Boolean skiResort) {
    this.skiResort = skiResort;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerToMl serverToMl = (ServerToMl) o;
    return Objects.equals(this.name, serverToMl.name) &&
        Objects.equals(this.latitude, serverToMl.latitude) &&
        Objects.equals(this.longitude, serverToMl.longitude) &&
        Objects.equals(this.coeffNearestPopularity, serverToMl.coeffNearestPopularity) &&
        Objects.equals(this.carAvailability, serverToMl.carAvailability) &&
        Objects.equals(this.busAvailability, serverToMl.busAvailability) &&
        Objects.equals(this.bigCarAvailability, serverToMl.bigCarAvailability) &&
        Objects.equals(this.shipAvailability, serverToMl.shipAvailability) &&
        Objects.equals(this.planeAvailability, serverToMl.planeAvailability) &&
        Objects.equals(this.theatre, serverToMl.theatre) &&
        Objects.equals(this.ethnicCenter, serverToMl.ethnicCenter) &&
        Objects.equals(this.museum, serverToMl.museum) &&
        Objects.equals(this.childrensTourism, serverToMl.childrensTourism) &&
        Objects.equals(this.cityAttractions, serverToMl.cityAttractions) &&
        Objects.equals(this.attraction, serverToMl.attraction) &&
        Objects.equals(this.culturalCentre, serverToMl.culturalCentre) &&
        Objects.equals(this.shipbuilding, serverToMl.shipbuilding) &&
        Objects.equals(this.nationalPark, serverToMl.nationalPark) &&
        Objects.equals(this.sanatorium, serverToMl.sanatorium) &&
        Objects.equals(this.lookout, serverToMl.lookout) &&
        Objects.equals(this.skiResort, serverToMl.skiResort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, latitude, longitude, coeffNearestPopularity, carAvailability, busAvailability, bigCarAvailability, shipAvailability, planeAvailability, theatre, ethnicCenter, museum, childrensTourism, cityAttractions, attraction, culturalCentre, shipbuilding, nationalPark, sanatorium, lookout, skiResort);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerToMl {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    coeffNearestPopularity: ").append(toIndentedString(coeffNearestPopularity)).append("\n");
    sb.append("    carAvailability: ").append(toIndentedString(carAvailability)).append("\n");
    sb.append("    busAvailability: ").append(toIndentedString(busAvailability)).append("\n");
    sb.append("    bigCarAvailability: ").append(toIndentedString(bigCarAvailability)).append("\n");
    sb.append("    shipAvailability: ").append(toIndentedString(shipAvailability)).append("\n");
    sb.append("    planeAvailability: ").append(toIndentedString(planeAvailability)).append("\n");
    sb.append("    theatre: ").append(toIndentedString(theatre)).append("\n");
    sb.append("    ethnicCenter: ").append(toIndentedString(ethnicCenter)).append("\n");
    sb.append("    museum: ").append(toIndentedString(museum)).append("\n");
    sb.append("    childrensTourism: ").append(toIndentedString(childrensTourism)).append("\n");
    sb.append("    cityAttractions: ").append(toIndentedString(cityAttractions)).append("\n");
    sb.append("    attraction: ").append(toIndentedString(attraction)).append("\n");
    sb.append("    culturalCentre: ").append(toIndentedString(culturalCentre)).append("\n");
    sb.append("    shipbuilding: ").append(toIndentedString(shipbuilding)).append("\n");
    sb.append("    nationalPark: ").append(toIndentedString(nationalPark)).append("\n");
    sb.append("    sanatorium: ").append(toIndentedString(sanatorium)).append("\n");
    sb.append("    lookout: ").append(toIndentedString(lookout)).append("\n");
    sb.append("    skiResort: ").append(toIndentedString(skiResort)).append("\n");
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