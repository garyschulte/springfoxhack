/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.opengov.spark.avro;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public interface SparkService {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"SparkService\",\"namespace\":\"com.opengov.spark.avro\",\"types\":[{\"type\":\"record\",\"name\":\"SubmitBatch\",\"doc\":\"record type for submitting a job to spark service\",\"fields\":[{\"name\":\"entityId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\",\"order\":\"ignore\"},\"doc\":\"attribute the job to this customer entity id, required\"},{\"name\":\"userId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"attribute the job to this customer user id, required\"},{\"name\":\"jobName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"name for the job, required\"},{\"name\":\"commandTags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"doc\":\"tag(s) which uniquely identify the command used to submit job, required\"},{\"name\":\"clusterTags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"doc\":\"tag(s) which uniquely identify the cluster to execute job, required\"},{\"name\":\"commandArgs\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}],\"doc\":\"argument(s) to be passed to the spark job, optional\",\"default\":null},{\"name\":\"jobUuid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"job identifier to use for the spark job, optional\",\"default\":null}]}],\"messages\":{}}");

  @SuppressWarnings("all")
  public interface Callback extends SparkService {
    public static final org.apache.avro.Protocol PROTOCOL = com.opengov.spark.avro.SparkService.PROTOCOL;
  }
}