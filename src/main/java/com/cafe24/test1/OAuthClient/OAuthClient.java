package com.cafe24.test1.OAuthClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;

public class OAuthClient {

	// private  String protocol = "https";
	private String mallId = "goslim56";
	private String host = mallId + ".cafe24api.com";
	// private  int PORT = 8080;
	private String codePath = "/api/v2/oauth/authorize";
	// private  String USER_AGENT = "Mozila/5.0";
	private String authorizationEndpoint = "https://"+mallId+".cafe24api.com/api/v2/oauth/authorize";
	private String tokenEndpoint = "https://" + mallId + ".cafe24api.com/api/v2/oauth/token";
	private String responseType = "code";
	private String clinedId = "OrDNpoxQAltu0kiGDBV2NA";
	private String clinedSecret = "fKbVthTYAK4MV1GOhBkgTG";
	private String scope = "mall.read_application,mall.write_application";
//	 private  String redirectUri = "https://www.goslim12.com:8080";
	private String redirectUri = "https://127.0.0.1:8443/test1/request_token";
	private String state = "gyeong-han";
	private  OAuth2Template cafe24OAuth2Template = new OAuth2Template(
			clinedId, 
			clinedSecret, 
			authorizationEndpoint,
			tokenEndpoint
	);
	public String getMallId() {
		return mallId;
	}
	public void setMallId(String mallId) {
		this.mallId = mallId;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getCodePath() {
		return codePath;
	}
	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}
	public String getAuthorizationEndpoint() {
		return authorizationEndpoint;
	}
	public void setAuthorizationEndpoint(String authorizationEndpoint) {
		this.authorizationEndpoint = authorizationEndpoint;
	}
	public String getTokenEndpoint() {
		return tokenEndpoint;
	}
	public void setTokenEndpoint(String tokenEndpoint) {
		this.tokenEndpoint = tokenEndpoint;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public String getClinedId() {
		return clinedId;
	}
	public void setClinedId(String clinedId) {
		this.clinedId = clinedId;
	}
	public String getClinedSecret() {
		return clinedSecret;
	}
	public void setClinedSecret(String clinedSecret) {
		this.clinedSecret = clinedSecret;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public OAuth2Template getCafe24OAuth2Template() {
		return cafe24OAuth2Template;
	}
	public void setCafe24OAuth2Template(OAuth2Template cafe24oAuth2Template) {
		cafe24OAuth2Template = cafe24oAuth2Template;
	}
	
	
	
	
	
	
	
	
	// public  void getCode() throws ClientProtocolException, IOException {
	//
	//
	// URIBuilder uriBuilder = new URIBuilder();
	// uriBuilder.setScheme(OAuthClient.protocol)
	// .setHost(OAuthClient.host)
	//// .setPort(HttpClient.PORT)
	// .setPath(OAuthClient.codePath)
	// .addParameter("response_type", OAuthClient.responseType)
	// .addParameter("client_id", OAuthClient.clinedId)
	// .addParameter("scope", OAuthClient.scope)
	// .addParameter("redirect_uri", OAuthClient.redirectUri)
	// .addParameter("state", OAuthClient.state);
	//
	// URI uri = null;
	// try {
	// uri = uriBuilder.build();
	// } catch (URISyntaxException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.out.println(uri.toString());
	//
	//
	//// // http client 생성
	// CloseableHttpClient httpClient = HttpClients.createDefault();
	//// // get 메서드와 URL 설정
	//// HttpGet httpGet = new HttpGet(uri);
	// HttpGet httpGet = new HttpGet(uri);//
	// HttpClientContext context = HttpClientContext.create();
	// httpClient.execute(httpGet, context);
	//
	// List<URI> redirectURIs = context.getRedirectLocations();
	// if (redirectURIs != null && !redirectURIs.isEmpty()) {
	// for (URI redirectURI : redirectURIs) {
	// System.out.println("Redirect URI: " + redirectURI);
	// }
	// URI finalURI = redirectURIs.get(redirectURIs.size() - 1);
	// }
	// }

}
