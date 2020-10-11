package com.informatica.git.language.repo.dto;

import java.util.List;

public class GitHubRestEndpointResponse {

	private List<Item> items;

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
		
}
