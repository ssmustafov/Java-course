package com.sirma.itt.javacourse.chathelper.utils;

/**
 * @author Sinan
 */
public enum QueryTypes {
	// Queries send by the server
	SentMessage, Refused, Failed, Closed, Success, ClientConnected, ClientDisconnected,

	// Queries send by the client
	Login, Logout, SendMessage
}
