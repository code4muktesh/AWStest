package com.awsapp.util;
import java.io.File;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.awsapp.configs.AWS;
public class AwsS3 {

  
 public  String s3Upload(String path,String imageName)
 {
  String imageKey = imageName;
  String uploadPath = path;
  String s3bucketName = "testBucket";
  
  
  
  AmazonS3 s3client = new AmazonS3Client(new BasicAWSCredentials(AWS.s3AccessKey, AWS.s3AccessSecret));
  try 
  {
            System.out.println("Uploading a new object to S3 from a file\n");
            File file = new File(uploadPath);
            s3client.putObject(new PutObjectRequest(
                               s3bucketName, imageKey, file).withCannedAcl(CannedAccessControlList.PublicRead));
            

         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
              "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
            
            throw ase;
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
              "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
            throw ace;
        }
  
  return "https://s3-ap-southeast-1.amazonaws.com/" + s3bucketName + "/" + imageKey;
 }

}