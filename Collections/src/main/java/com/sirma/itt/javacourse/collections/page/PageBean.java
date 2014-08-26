package com.sirma.itt.javacourse.collections.page;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds methods for given list and divides it to pages.
 * 
 * @author smustafov
 */
public class PageBean {

	private List<Object> list;
	private Map<Integer, List<Object>> pagedList;
	private int pageSize;
	private int currentPage;

	/**
	 * Creates a new PageBean with given list and how many elements to be paged on every page.
	 * 
	 * @param list
	 *            - the list to be paged
	 * @param pageSize
	 *            - the each page's number of elements to show
	 */
	public PageBean(List<Object> list, int pageSize) {
		if (pageSize <= 0) {
			throw new IllegalArgumentException();
		}

		this.list = list;
		this.pageSize = pageSize;
		pagedList = new LinkedHashMap<>();
		currentPage = 0;
		divideList();
	}

	/**
	 * Divides the list.
	 */
	private void divideList() {
		float size = list.size();
		float pages = pageSize;
		int numberOfPages = (int) (Math.ceil(size / pages));
		int startIndex = 0;
		int endIndex = pageSize;

		for (int i = 0; i < numberOfPages; i++) {
			List<Object> subList = list.subList(startIndex, endIndex);
			pagedList.put(i, subList);

			startIndex += pageSize;
			endIndex = startIndex + pageSize;
			if (endIndex >= list.size()) {
				endIndex = list.size();
			}
		}
	}

	/**
	 * Returns the next elements of the list.
	 * 
	 * @return - the next elements
	 */
	public String next() {
		List<Object> subList = pagedList.get(currentPage);
		currentPage++;
		return subList.toString();
	}

	/**
	 * Returns the previous elements of the list.
	 * 
	 * @return - the previous elements
	 */
	public String previous() {
		currentPage--;
		List<Object> subList = pagedList.get(currentPage);
		return subList.toString();
	}

	/**
	 * Returns the current page of the list.
	 * 
	 * @return - the current page
	 */
	public int getCurrentPageNumber() {
		return currentPage;
	}

}
