package com.flights.service.util;

import java.util.Base64;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ecr.AmazonECR;
import com.amazonaws.services.ecr.AmazonECRClientBuilder;
import com.amazonaws.services.ecr.model.AuthorizationData;
import com.amazonaws.services.ecr.model.GetAuthorizationTokenRequest;
import com.amazonaws.services.ecr.model.GetAuthorizationTokenResult;

import com.amazonaws.util.StringUtils;

public class AWSUtil {

	public static void main(String[] args) {

		AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAIGFYGF6S5ZXTAYRA",
				"G5s43H+PVdYp4qRdz0vLeaRBZHo82ChjgDz1ukiD");

		AmazonECR amazonECR = AmazonECRClientBuilder.standard().withRegion("us-east-2")
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

		GetAuthorizationTokenResult authorizationToken = amazonECR
				.getAuthorizationToken(new GetAuthorizationTokenRequest());
	
		/*
		 Now, you will need to fetch the authorization data from the list and then get the encoded token from authorization data. 
		 NOTE: Token will be encoded with base64.
		 */
		List<AuthorizationData> authorizationData = authorizationToken.getAuthorizationData();
		String encodedToken = authorizationData.get(0).getAuthorizationToken();
		
		System.out.println(" encodedToken token "+encodedToken);
		
		byte[] token=Base64.getUrlDecoder().decode(encodedToken);
		String decodeToken =new String(token);
		
		System.out.println(" decoded token "+decodeToken);
		
				
		/*String myToken  = "vickyscab24@gmail.com:Bench_123";
		
		byte[] bytetoken   = Base64.getEncoder().encode(myToken.getBytes());
       String encodedToken =new String(bytetoken);
		
		System.out.println(" encoded token "+encodedToken);
		
		byte[] token=Base64.getUrlDecoder().decode(bytetoken);
		String decodeToken =new String(token);
		
		System.out.println(" decoded token "+decodeToken);
		
		*/
	}

}
