package com.informatica.git.language.repo.service;

import java.util.List;

import com.informatica.git.language.repo.dto.GitHubResponseDTO;

public interface ReadGitHubLanguageRepoService {

	List<GitHubResponseDTO> readGitHubRepos(String language) throws Exception;
}
