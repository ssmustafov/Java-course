package com.sirma.itt.javacourse.collections.page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean} class.
 * 
 * @author smustafov
 */
public class PageBeanTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#previous()} by trying to get
	 * a previous page when there is no really a previous page.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPageBeanWithNoPrevPage() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);

		PageBean p = new PageBean(list, 2);
		p.next();
		p.previous();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#PageBean(List, int)} with
	 * negative page size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPageBeanWithNegativePageSize() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);

		new PageBean(list, -2);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#PageBean(List, int)} with
	 * zero page size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPageBeanWithZeroPageSize() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);

		new PageBean(list, 0);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#firstPage()} if it returns
	 * the real elements in the first page when there no called any next or previous pages.
	 */
	@Test
	public void testFirstPageInBeginning() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(55);
		list.add(-1);
		list.add(24);
		list.add(47);

		PageBean p = new PageBean(list, 2);
		String actual = p.firstPage();
		String expected = "[10, 3]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#firstPage()} if it returns
	 * the real elements in the first page when the current page is in the center.
	 */
	@Test
	public void testFirstPageInCenter() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(55);
		list.add(-1);
		list.add(24);
		list.add(47);

		PageBean p = new PageBean(list, 2);
		p.next();
		p.next();
		String actual = p.firstPage();
		String expected = "[10, 3]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#firstPage()} if it returns
	 * the real elements in the first page when the current page is in the center.
	 */
	@Test
	public void testFirstPageInEnd() {
		List<Object> list = new LinkedList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(55);
		list.add(-1);
		list.add(24);
		list.add(47);

		PageBean p = new PageBean(list, 2);
		p.next();
		p.next();
		p.next();
		p.next();
		String actual = p.firstPage();
		String expected = "[10, 3]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#lastPage()} if it returns the
	 * real elements in the last page when the current page is in the beginning.
	 */
	@Test
	public void testLastPageInBeginning() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(55);
		list.add(-1);
		list.add(24);
		list.add(47);

		PageBean p = new PageBean(list, 3);
		String actual = p.lastPage();
		String expected = "[47]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#lastPage()} if it returns the
	 * real elements in the last page when the current page is in the center.
	 */
	@Test
	public void testLastPageInCenter() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(55);
		list.add(-1);
		list.add(24);
		list.add(47);
		list.add("W");

		PageBean p = new PageBean(list, 3);
		p.next();
		p.next();
		String actual = p.lastPage();
		String expected = "[47, W]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#lastPage()} if it returns the
	 * real elements in the last page when the current page is in the end.
	 */
	@Test
	public void testLastPageInEnd() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(55);
		list.add(-1);
		list.add(24);
		list.add(47);
		list.add("W");

		PageBean p = new PageBean(list, 3);
		p.next();
		p.next();
		p.next();
		p.next();
		String actual = p.lastPage();
		String expected = "[47, W]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#next()} by calling it to the
	 * last page.
	 */
	@Test
	public void testNextToLastPage() {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(55);
		list.add(-1);
		list.add(24);
		list.add(47);

		PageBean p = new PageBean(list, 4);
		p.next();
		String actual = p.next();
		String expected = "[-1, 24, 47]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#next()} by calling it after
	 * the last page and if it returns empty string.
	 */
	@Test
	public void testNextAfterLastPage() {
		List<Object> list = new LinkedList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(55);
		list.add(-1);
		list.add(24);
		list.add(47);

		PageBean p = new PageBean(list, 3);
		p.next();
		p.next();
		p.next();
		String actual = p.next();
		String expected = "";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#hasNext()} when it's on the
	 * center page.
	 */
	@Test
	public void testHasNextPageInCenterPage() {
		List<Object> list = new ArrayList<>();
		list.add("d");
		list.add(3);
		list.add("f");
		list.add(55);
		list.add("s");
		list.add(24);
		list.add(47);
		list.add("W");

		PageBean p = new PageBean(list, 2);
		p.next();
		p.next();
		boolean actual = p.hasNext();

		assertTrue(actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#hasNext()} when it's on the
	 * first page.
	 */
	@Test
	public void testHasNextPageInFirstPage() {
		List<Object> list = new LinkedList<>();
		list.add("d");
		list.add(3);
		list.add("f");
		list.add(55);
		list.add("s");
		list.add(24);
		list.add(47);
		list.add("W");

		PageBean p = new PageBean(list, 2);
		p.next();
		boolean actual = p.hasNext();

		assertTrue(actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#hasNext()} when it's on the
	 * last page.
	 */
	@Test
	public void testHasNextPageInLastPage() {
		List<Object> list = new LinkedList<>();
		list.add("d");
		list.add(3);
		list.add("f");
		list.add(55);
		list.add("s");
		list.add(24);
		list.add(47);
		list.add("W");

		PageBean p = new PageBean(list, 2);
		p.next();
		p.next();
		p.next();
		p.next();
		boolean actual = p.hasNext();

		assertFalse(actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#hasPrevious()} when it's on
	 * the center page.
	 */
	@Test
	public void testHasPreviousPageInCenterPage() {
		List<Object> list = new ArrayList<>();
		list.add('d');
		list.add(3);
		list.add('f');
		list.add(55);
		list.add('s');
		list.add(24);
		list.add(47);
		list.add('W');

		PageBean p = new PageBean(list, 2);
		p.next();
		p.next();
		boolean actual = p.hasPrevious();

		assertTrue(actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#hasPrevious()} when it's on
	 * the last page.
	 */
	@Test
	public void testHasPreviousPageInLastPage() {
		List<Object> list = new ArrayList<>();
		list.add('d');
		list.add(3);
		list.add('f');
		list.add(55);
		list.add('s');
		list.add(24);
		list.add(47);
		list.add('W');

		PageBean p = new PageBean(list, 2);
		p.next();
		p.next();
		p.next();
		p.next();
		boolean actual = p.hasPrevious();

		assertTrue(actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.page.PageBean#hasPrevious()} when it's on
	 * the last page.
	 */
	@Test
	public void testHasPreviousPageInFirstPage() {
		List<Object> list = new ArrayList<>();
		list.add('d');
		list.add(3);
		list.add('f');
		list.add(55);
		list.add('s');
		list.add(24);
		list.add(47);
		list.add('W');

		PageBean p = new PageBean(list, 2);
		p.next();
		boolean actual = p.hasPrevious();

		assertFalse(actual);
	}

}
