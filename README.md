project :- esp-git-language-repo

GET request in local:- http://localhost:8080/readGitRepos?language=java

Language is a query param it is a string type

readGitRepos method uses GITHUB API as below to get the repository information based on the language type

https://api.github.com/search/repositories?q=language:"+language+"&sort=stars&order=desc";

For a given language it will return the list of below attributes I just copied one GitHubResponseDTO(Please check this class for more info) object for java value.

Example data:- 
 "projectId": 267775629,
 "name": "hello-algorithm",
 "url": "https://api.github.com/users/geekxh",
 "ownerLogin": "geekxh",
 "full_name": "geekxh/hello-algorithm",
 "html_url": "https://github.com/geekxh/hello-algorithm"

The DTO to refer:-
GitHubResponseDTO {
 /** Project Id*/
	private Long projectId;
	
	/** Project Name*/
	private String name;
	
	/** GitHub API URL*/
	private String url;
	
	/** owner login*/
	private String ownerLogin;
	
	/** Project Name and owner name*/
	private String full_name;
	
	/** Project URL*/
	private String html_url;
 }
