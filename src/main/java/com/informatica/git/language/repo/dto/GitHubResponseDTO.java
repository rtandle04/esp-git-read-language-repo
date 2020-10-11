package com.informatica.git.language.repo.dto;
/**
 * 
 * @author RamakanthTandle
 *
 */
public class GitHubResponseDTO {

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
	

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * @return the html_url
	 */
	public String getHtml_url() {
		return html_url;
	}
	/**
	 * @param html_url the html_url to set
	 */
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the ownerLogin
	 */
	public String getOwnerLogin() {
		return ownerLogin;
	}
	/**
	 * @param ownerLogin the ownerLogin to set
	 */
	public void setOwnerLogin(String ownerLogin) {
		this.ownerLogin = ownerLogin;
	}	
}
