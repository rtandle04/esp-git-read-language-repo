package com.bulk.data;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.informatica.git.language.repo.dto.GitHubRestEndpointResponse;
import com.informatica.git.language.repo.service.ReadGitHubLanguageRepoServiceImpl;

@SpringBootTest(classes=EspBulkDataUploadApplicationTests.class)
class EspBulkDataUploadApplicationTests {
	
	

    @Mock
    private RestTemplate restTemplate;
 
    @InjectMocks
    private ReadGitHubLanguageRepoServiceImpl readGitService = new ReadGitHubLanguageRepoServiceImpl();
 
    @Test
    public void testReadGitService() throws Exception {
    	
    	GitHubRestEndpointResponse gitHubRestEndpointResponse = new GitHubRestEndpointResponse();
    	HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<GitHubRestEndpointResponse> response = null;
		
        Mockito
          .when(restTemplate.exchange("localhost", HttpMethod.GET, entity, GitHubRestEndpointResponse.class))
          .thenReturn(new ResponseEntity<GitHubRestEndpointResponse>(gitHubRestEndpointResponse, HttpStatus.OK));
 
        readGitService.readGitHubRepos("java");
     
      
    }

}
