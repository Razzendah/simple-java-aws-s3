package com.javas3;

import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class App {

	private static final String ACCESSKEY = "";
	private static final String SECRETKEY = "";
	private static final String REGION = "US-EAST-1";
	private static final String BUCKET_NAME = "";

	public static void main(String[] args) {

		AWSCredentials credentials = new BasicAWSCredentials(ACCESSKEY, SECRETKEY);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(REGION).build();

		String nombre_del_archivo_en_s3 = "ejemplofile.txt";
		s3Client.putObject(BUCKET_NAME, nombre_del_archivo_en_s3, new File("./archivo_ejemplo.txt"));
		System.out.println("done");
	}
}
