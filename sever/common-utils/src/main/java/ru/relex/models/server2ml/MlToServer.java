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
import java.io.IOException;
/**
 * Предсказания ML
 */
@Schema(description = "Предсказания ML")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-07-25T01:18:48.012222797Z[GMT]")

public class MlToServer {
  @SerializedName("name")
  private String name = null;// просто название постройки

  @SerializedName("popularity")
  private Float popularity = null;

  public MlToServer name(String name) {
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

  public MlToServer popularity(Float popularity) {
    this.popularity = popularity;
    return this;
  }

   /**
   * Ожидаемое кол-во запросов в яндекс за месяц
   * @return popularity
  **/
  @Schema(description = "Ожидаемое кол-во запросов в яндекс за месяц")
  public Float getPopularity() {
    return popularity;
  }

  public void setPopularity(Float popularity) {
    this.popularity = popularity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MlToServer mlToServer = (MlToServer) o;
    return Objects.equals(this.name, mlToServer.name) &&
        Objects.equals(this.popularity, mlToServer.popularity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, popularity);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MlToServer {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    popularity: ").append(toIndentedString(popularity)).append("\n");
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
