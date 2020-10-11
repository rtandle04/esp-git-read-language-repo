package com.informatica.git.language.repo.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.informatica.git.language.repo.dto.GitHubResponseDTO;
import com.informatica.git.language.repo.dto.GitHubRestEndpointResponse;
import com.informatica.git.language.repo.dto.Item;
import com.informatica.git.language.repo.dto.Owner;


/**
 * The class uses the git api to get the repositroy information based on the language string
 * @author RamakanthTandle
 *
 */
@Service
public class ReadGitHubLanguageRepoServiceImpl implements ReadGitHubLanguageRepoService{
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Override
	public List<GitHubResponseDTO> readGitHubRepos(String language) throws Exception {

		List<GitHubResponseDTO> gitHubResponseDTOList = new ArrayList<>();

		
	 String url="https://api.github.com/search/repositories?q=language:"+language+"&sort=stars&order=desc";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = restTemplate();
		ResponseEntity<GitHubRestEndpointResponse> response = null;
		try {
			response = restTemplate.exchange(url, HttpMethod.GET, entity, GitHubRestEndpointResponse.class);
		}
		
		
		catch(HttpStatusCodeException e){
		     String errorpayload = e.getResponseBodyAsString();
		     throw new Exception(errorpayload);
		     //do whatever you want
		} catch(RestClientException e){
			throw new Exception("Language value is incorrect please check and try again"); 
		}
		
		
		if (null!=response) {
			GitHubRestEndpointResponse gitHubRestEndpointBody = response.getBody();
			List<Item> items = gitHubRestEndpointBody.getItems();
			for (Item item : items) {
				// Preparing the json list of dtos
				GitHubResponseDTO gitHubResponseDTO = new GitHubResponseDTO();

				gitHubResponseDTO.setProjectId(item.getId());
				gitHubResponseDTO.setFull_name(item.getFull_name());
				gitHubResponseDTO.setHtml_url(item.getHtml_url());
				gitHubResponseDTO.setName(item.getName());

				Owner owner = item.getOwner();
				gitHubResponseDTO.setOwnerLogin(owner.getLogin());
				gitHubResponseDTO.setUrl(owner.getUrl());
				gitHubResponseDTOList.add(gitHubResponseDTO);
			}
		}
		
		
		return gitHubResponseDTOList;
	}
}
