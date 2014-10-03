package com.sirma.itt.javacourse.collections.manager;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager} class.
 * 
 * @author smustafov
 */
public class ExceptionsMessageManagerTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessage(String)}
	 * with not existing message in the map.
	 * 
	 * @throws NoSuchMessageException
	 *             - expected exception
	 */
	@Test(expected = NoSuchMessageException.class)
	public void testAddExceptionMessageNotExistingMessage() throws NoSuchMessageException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.DebitCart);

		manager.addExceptionMessage("Not existing message");
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessageUsingCode(String)}
	 * with not existing message code in the map.
	 * 
	 * @throws NoSuchMessageCodeException
	 *             - expected exception
	 */
	@Test(expected = NoSuchMessageCodeException.class)
	public void testAddExceptionMessageCodeNotExistingMessage() throws NoSuchMessageCodeException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(
				ExceptionMessages.PostalCode);

		manager.addExceptionMessageUsingCode("Not existing message code");
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessageUsingCode(String)}
	 * with empty manager and trying to add message code.
	 * 
	 * @throws NoSuchMessageCodeException
	 *             - expected exception
	 */
	@Test(expected = NoSuchMessageCodeException.class)
	public void testWithEmptyManagerCode() throws NoSuchMessageCodeException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager();

		manager.addExceptionMessageUsingCode("Not existing message code");
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessageUsingCode(String)}
	 * with empty manager and trying to add message.
	 * 
	 * @throws NoSuchMessageException
	 *             - expected exception
	 */
	@Test(expected = NoSuchMessageException.class)
	public void testWithEmptyManager() throws NoSuchMessageException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager();

		manager.addExceptionMessage("Not existing message");
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessage(String)}
	 * with one element.
	 * 
	 * @throws NoSuchMessageException
	 *             - not expected exception
	 */
	@Test
	public void testAddExceptionWithOneElement() throws NoSuchMessageException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(
				ExceptionMessages.PostalCode);

		manager.addExceptionMessage(ExceptionMessages.PostalCode.getMessage());
		String actual = manager.getMessage();
		String expected = "Invalid postal code";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessage(String)}
	 * with three elements.
	 * 
	 * @throws NoSuchMessageException
	 *             - not expected exception
	 */
	@Test
	public void testAddExceptionWithThreeElements() throws NoSuchMessageException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(
				ExceptionMessages.PostalCode, ExceptionMessages.DebitCart,
				ExceptionMessages.PersonalID);

		manager.addExceptionMessage(ExceptionMessages.PostalCode.getMessage());
		manager.addExceptionMessage(ExceptionMessages.DebitCart.getMessage());
		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());
		String actual = manager.getMessage();
		String expected = "Invalid postal code|Invalid debit cart ID|Invalid personal ID";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessageUsingCode(String)}
	 * with three elements.
	 * 
	 * @throws NoSuchMessageCodeException
	 *             - not expected exception
	 */
	@Test
	public void testAddExceptionCodeWithThreeElements() throws NoSuchMessageCodeException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(
				ExceptionMessages.PostalCode, ExceptionMessages.DebitCart,
				ExceptionMessages.PersonalID);

		manager.addExceptionMessageUsingCode(ExceptionMessages.PostalCode.name());
		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		manager.addExceptionMessageUsingCode(ExceptionMessages.PersonalID.name());
		String actual = manager.getMessage();
		String expected = "Invalid postal code|Invalid debit cart ID|Invalid personal ID";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessage(String)}
	 * with one element.
	 * 
	 * @throws NoSuchMessageCodeException
	 *             - not expected exception
	 */
	@Test
	public void testAddExceptionCodeWithOneElement() throws NoSuchMessageCodeException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.DebitCart);

		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		String actual = manager.getMessage();
		String expected = "Invalid debit cart ID";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#addExceptionMessage(String)}
	 * by adding elements with code and message.
	 * 
	 * @throws NoSuchMessageCodeException
	 *             - not expected exception
	 * @throws NoSuchMessageException
	 *             - not expected exception
	 */
	@Test
	public void testAddExceptions() throws NoSuchMessageCodeException, NoSuchMessageException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(
				ExceptionMessages.DebitCart, ExceptionMessages.PersonalID,
				ExceptionMessages.PostalCode);

		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());
		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		manager.addExceptionMessage(ExceptionMessages.PostalCode.getMessage());
		String actual = manager.getMessage();
		String expected = "Invalid personal ID|Invalid debit cart ID|Invalid postal code";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#getMessages(String)}
	 * with three elements.
	 * 
	 * @throws NoSuchMessageCodeException
	 *             - not expected exception
	 * @throws NoSuchMessageException
	 *             - not expected exception
	 */
	@Test
	public void testGetMessagesWithThreeElements() throws NoSuchMessageCodeException,
			NoSuchMessageException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(
				ExceptionMessages.DebitCart, ExceptionMessages.PersonalID,
				ExceptionMessages.PostalCode);

		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());
		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		manager.addExceptionMessage(ExceptionMessages.PostalCode.getMessage());

		Collection<String> actual = ExceptionsMessageManager.getMessages(manager.getMessage());
		Collection<String> expected = new ArrayList<>();
		expected.add("Invalid personal ID");
		expected.add("Invalid debit cart ID");
		expected.add("Invalid postal code");

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.manager.ExceptionsMessageManager#getMessages(String)}
	 * with one element.
	 * 
	 * @throws NoSuchMessageCodeException
	 *             - not expected exception
	 * @throws NoSuchMessageException
	 *             - not expected exception
	 */
	@Test
	public void testGetMessagesWithOneElement() throws NoSuchMessageCodeException,
			NoSuchMessageException {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(
				ExceptionMessages.DebitCart, ExceptionMessages.PersonalID,
				ExceptionMessages.PostalCode);

		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());

		Collection<String> actual = ExceptionsMessageManager.getMessages(manager.getMessage());
		Collection<String> expected = new ArrayList<>();
		expected.add("Invalid personal ID");

		assertEquals(expected, actual);
	}

}
