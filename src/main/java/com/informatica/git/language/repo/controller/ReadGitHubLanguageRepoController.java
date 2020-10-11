package com.informatica.git.language.repo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.informatica.git.language.repo.dto.GitHubResponseDTO;
import com.informatica.git.language.repo.service.ReadGitHubLanguageRepoServiceImpl;

@RestController
public class ReadGitHubLanguageRepoController {
	
	@Autowired
	ReadGitHubLanguageRepoServiceImpl readGitHubLanguageRepoService;
	
	@RequestMapping(value = "/readGitRepos",method = RequestMethod.GET)
	public List<GitHubResponseDTO> readGitHubRepos(@RequestParam String language) throws Exception{
		return readGitHubLanguageRepoService.readGitHubRepos(language);
	}
}
