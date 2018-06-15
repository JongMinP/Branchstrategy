package com.cafe24.test1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.test1.OAuthClient.OAuthClient;

@Controller
public class Oauth2Controller {
	
//	@ResponseBody
	@RequestMapping("/authorization_code")
	public String authorization_code() {
		OAuthClient oauthClient = new OAuthClient();
		OAuth2Parameters parameters = new OAuth2Parameters();
		parameters.setScope(oauthClient.getScope());
        parameters.setRedirectUri(oauthClient.getRedirectUri());

        OAuth2Template oauth2Template = oauthClient.getCafe24OAuth2Template();

        String authorizeUrl = oauth2Template.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, parameters);
        System.out.println("authorizeUrl: " + authorizeUrl);

        return "redirect:" + authorizeUrl;
	}
	
	
	@ResponseBody
	@RequestMapping("/request_token")
	 public String request_token(Model model, HttpServletRequest request, @RequestParam String code) throws Exception {
        System.out.println("Daum Callback is called!!");
        System.out.println(code);

        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setOutputStreaming(false);
        
        OAuthClient oauthClient = new OAuthClient();
        
        OAuth2Template oauth2Template = oauthClient.getCafe24OAuth2Template();
        oauth2Template.setRequestFactory(simpleClientHttpRequestFactory);

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        multiValueMap.add("client_id", oauthClient.getClinedId());
        multiValueMap.add("client_secret", oauthClient.getClinedId());

        AccessGrant accessGrant = oauth2Template.exchangeForAccess(
                code,
                oauthClient.getRedirectUri(),
                multiValueMap
        );
        System.out.println("------ AccessGrant ------");
        System.out.println(accessGrant.getAccessToken());
        System.out.println(accessGrant.getRefreshToken());
        System.out.println(accessGrant.getExpireTime());
        System.out.println(accessGrant.getScope());
        System.out.println();
        
        
        System.out.println("local branch Test ");
        System.out.println("local branch Test ");
        System.out.println("local branch Test ");
        
        
        
        return "kkkk";

	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
