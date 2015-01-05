package com.sirma.itt.javacourse.chatclient.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import com.sirma.itt.javacourse.chatclient.client.Client;
import com.sirma.itt.javacourse.chathelper.utils.Date;

/**
 * Represents the user interface for the client.
 * 
 * @author Sinan
 */
public class ClientView implements View, ActionListener {
	public static final String SEND_MESSAGE_BUTTON_ACTION_COMMAND = "send";
	public static final String DISCONNECT_BUTTON_ACTION_COMMAND = "disconnect";
	private static final String NEW_LINE = System.lineSeparator();
	private static final String WINDOW_TITLE = "Chat Client";
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;
	private static final int ONLINE_CLIENTS_LIST_WIDTH = 180;
	private JFrame frame = new JFrame();
	private JList<String> onlineClientsList;
	private DefaultListModel<String> onlineClientsListModel;
	private JButton logoutButton;
	private JButton sendMessageButton;
	private JTextArea chatMessagesArea;
	private JTextField clientField;
	private Client client;

	/**
	 * Creates a new user interface for the server.
	 */
	public ClientView() {
		frame.setTitle(WINDOW_TITLE);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createButtons();
		createTextAreas();
		createLists();

		JScrollPane consoleScrollPane = new JScrollPane();
		consoleScrollPane.setViewportView(chatMessagesArea);

		JScrollPane listScrollPane = new JScrollPane(onlineClientsList);

		clientField = new JTextField(35);
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(clientField);
		bottomPanel.add(sendMessageButton);
		bottomPanel.add(logoutButton);

		frame.setLayout(new BorderLayout());
		frame.add(consoleScrollPane, BorderLayout.CENTER);
		frame.add(listScrollPane, BorderLayout.EAST);
		frame.add(bottomPanel, BorderLayout.PAGE_END);

		frame.setVisible(true);

		client = new Client(this);
		client.connectToServer();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void appendMessageToChatArea(String message) {
		String date = Date.getCurrentDate(Date.SIMPLE_DATE_FORMAT);
		String formattedMessage = String.format("[%s]: %s%s", date, message, NEW_LINE);
		chatMessagesArea.append(formattedMessage);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addOnlineClient(String nickname) {
		onlineClientsListModel.addElement(nickname);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeOnlineClient(String nickname) {
		onlineClientsListModel.removeElement(nickname);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showNoticeDialog(String message) {
		JOptionPane.showMessageDialog(frame, message, "Notice", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resetUI() {
		sendMessageButton.setEnabled(true);
		logoutButton.setEnabled(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearOnlineClientsList() {
		onlineClientsListModel.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("send".equals(cmd)) {
			client.sendMessage(clientField.getText());
		}
	}

	/**
	 * Creates the text areas.
	 */
	private void createTextAreas() {
		chatMessagesArea = new JTextArea(5, 20);
		chatMessagesArea.setEditable(false);
		DefaultCaret consoleCaret = (DefaultCaret) chatMessagesArea.getCaret();
		consoleCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		TitledBorder chatMessagesBorder = BorderFactory.createTitledBorder("Chat messages");
		chatMessagesBorder.setTitleJustification(TitledBorder.CENTER);
		chatMessagesArea.setBorder(chatMessagesBorder);
	}

	/**
	 * Creates the buttons.
	 */
	private void createButtons() {
		sendMessageButton = new JButton("Send");
		sendMessageButton.setActionCommand(SEND_MESSAGE_BUTTON_ACTION_COMMAND);
		sendMessageButton.addActionListener(this);

		logoutButton = new JButton("Logout");
		logoutButton.setActionCommand("logout");
		logoutButton.addActionListener(this);
	}

	/**
	 * 
	 */
	private void createLists() {
		onlineClientsListModel = new DefaultListModel<String>();

		onlineClientsList = new JList<String>(onlineClientsListModel);
		onlineClientsList.setFixedCellWidth(ONLINE_CLIENTS_LIST_WIDTH);

		TitledBorder onlineClientsBorder = BorderFactory.createTitledBorder("Online clients");
		onlineClientsBorder.setTitleJustification(TitledBorder.CENTER);
		onlineClientsList.setBorder(onlineClientsBorder);
	}

	// /**
	// * Updates the text of the UI elements. Must be invoked when the locale is changed.
	// */
	// private void onLocaleChange() {
	// startButton.setText(bundle.getString("start"));
	// stopButton.setText(bundle.getString("stop"));
	// labelLang.setText(bundle.getString("chooseLang"));
	// labelPort.setText(bundle.getString("choosePort"));
	// }

}
