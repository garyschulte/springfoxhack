package com.opengov.spark.controllers;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.opengov.spark.avro.SubmitBatch;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@RestController
@RequestMapping(path = "/api/spark-service/v0/jobs")
public class SparkJobController {

  @ApiOperation(value = "create and execute a new spark batch job")
  @PostMapping(produces = "application/json", path = "/")
  @ApiResponses(value = {
      @io.swagger.annotations.ApiResponse(code = 200, message = "Job submitted"),
      @io.swagger.annotations.ApiResponse(code = 500, message = "Error submitting job")
  })
  public ApiResponse<String> postJob(@RequestBody SubmitBatch submitRequest) {
    return new ApiResponse<String>("stuff", 200);
  }

  @ApiOperation(value = "get details of a specific job", response = ApiResponse.class)
  @GetMapping(produces = "application/json", path = "/")
  @ApiResponses(value = {
      @io.swagger.annotations.ApiResponse(code = 200, message = "Job submitted"),
      @io.swagger.annotations.ApiResponse(code = 404, message = "Job id not found"),
      @io.swagger.annotations.ApiResponse(code = 503, message = "Job service unavailable")
  })
  public ApiResponse<String> getJobId(@RequestParam long jobId) {
    return new ApiResponse<String>("got " + jobId, 200);
  }




















  /* ------------- hack controller only - do not copy  -------------*/
  /* some BS so that the response *looks* like the webflux response */


  @JsonPropertyOrder({AbstractApiResponse.STATUS, ApiResponse.DATA})
  public class ApiResponse<T> extends AbstractApiResponse<T> {

    public static final String DATA = "data";

    protected T data;

    public ApiResponse(T data, int statusCode) {
      super(statusCode);
      this.data = data;
    }

    @JsonGetter(ApiResponse.DATA)
    public T data() {
      return this.data;
    }
  }
  abstract class AbstractApiResponse<T>  {

    public static final String STATUS = "status";

    private final Map<String, List<String>> headers;
    private final int code;

    AbstractApiResponse(int code) {
      headers = new HashMap<>();
      this.code = code;
    }

    public AbstractApiResponse<T> header(String name, String value) {
      headers.computeIfAbsent(name, k -> new ArrayList<>(1)).add(value);
      return this;
    }

    @JsonIgnore
    public void headers(BiConsumer<String, List<String>> consumer) {
      headers.forEach(consumer);
    }

    @JsonGetter(STATUS)
    public int statusCode() {
      return this.code;
    }
  }

}

