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
	private int totalNumberOfPages;

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
			throw new IllegalArgumentException("The given page size cannot be equal or under zero");
		}

		this.list = list;
		this.pageSize = pageSize;
		pagedList = new LinkedHashMap<>();
		currentPage = -1;
		divideList();
	}

	/**
	 * Divides the given list into pages in <code>LinkedHashMap</code>. Every key in the map
	 * responds to a page number and the key's value contains elements with size
	 * <code>pageSize</code>.
	 */
	private void divideList() {
		float size = list.size();
		float pages = pageSize;
		totalNumberOfPages = (int) (Math.ceil(size / pages));
		int startIndex = 0;
		int endIndex = pageSize;

		for (int i = 0; i < totalNumberOfPages; i++) {
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
	 * Returns the next elements of the list. If there are no next page it returns empty string.
	 * 
	 * @return - the next elements
	 */
	public String next() {
		currentPage++;
		if (currentPage < totalNumberOfPages) {
			List<Object> subList = pagedList.get(currentPage);
			return subList.toString();
		}

		currentPage = totalNumberOfPages - 1;
		return "";
	}

	/**
	 * Returns the previous elements of the list. If there are no previous page it throws
	 * <code>IllegalArgumentException</code>.
	 * 
	 * @return - the previous elements
	 */
	public String previous() {
		currentPage--;
		if (currentPage == -1) {
			throw new IllegalArgumentException("There are no more previous pages");
		}

		List<Object> subList = pagedList.get(currentPage);
		return subList.toString();
	}

	/**
	 * Returns true if there is next page of elements.
	 * 
	 * @return - true if there is next page of elements
	 */
	public boolean hasNext() {
		if ((currentPage + 1) < totalNumberOfPages) {
			return true;
		}

		return false;
	}

	/**
	 * Returns true if there is previous page of elements.
	 * 
	 * @return - true if there is previous page of elements
	 */
	public boolean hasPrevious() {
		if ((currentPage - 1) <= -1) {
			return false;
		}

		return true;
	}

	/**
	 * Sets the current page to the first page and returns the elements from the first page.
	 * 
	 * @return - the elements of the first page
	 */
	public String firstPage() {
		currentPage = -1;
		return next();
	}

	/**
	 * Sets the current page to the last page and returns the elements from the last page.
	 * 
	 * @return - the elements of the last page
	 */
	public String lastPage() {
		currentPage = totalNumberOfPages;
		return previous();
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
