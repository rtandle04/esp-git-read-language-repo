project :- esp-git-language-repo

GET request:-http://localhost:8080/readGitRepos?language=java
Language is a query param it is a string type

readGitRepos method uses GITHUB API to get the repository information based on the language type

https://api.github.com/search/repositories?q=language:"+language+"&sort=stars&order=desc";

For a given language it will return the list of below attributes I just copied one GitHubResponseDTO(Please check this class for more info) object for java value.

 "projectId": 267775629,
 "name": "hello-algorithm",
 "url": "https://api.github.com/users/geekxh",
 "ownerLogin": "geekxh",
 "full_name": "geekxh/hello-algorithm",
 "html_url": "https://github.com/geekxh/hello-algorithm"
