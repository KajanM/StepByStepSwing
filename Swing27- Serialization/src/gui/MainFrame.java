package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.Controller;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -4338620565171230172L;
	private static Logger log = LogManager.getLogger(MainFrame.class);

	private final Controller controller;

	private final Toolbar toolbar;
	private final FormPanel formPanel;
	private final TextPanel textPanel;
	private final TablePanel tablePanel;
	private final JFileChooser fileChooser;

	public MainFrame() {
		super("Hello World");

		controller = new Controller();

		toolbar = new Toolbar();
		formPanel = new FormPanel();
		textPanel = new TextPanel();
		tablePanel = new TablePanel();
		fileChooser = new JFileChooser();

		tablePanel.setPeople(controller.getPeople());
		
		File resourceDir = new File(System.getProperty("user.dir") + "/src/resources");
		fileChooser.setCurrentDirectory(resourceDir);
		fileChooser.addChoosableFileFilter(new PersonFileFilter());

		setJMenuBar(createMenuBar());

		toolbar.setToolbarListener(new ToolbarListener() {
			@Override
			public void actionPerformed(String text) {
				textPanel.appendText(text);
			}
		});

		formPanel.setFormListener(new FormListener() {
			@Override
			public void okBtnPressed(FormEvent event) {
				// displayInTextPanel(event);
				controller.addPerson(event);
				tablePanel.refresh();
			}

			@SuppressWarnings("unused")
			private void displayInTextPanel(FormEvent event) {
				textPanel.appendText("Name: " + event.getName() + "\n");
				textPanel.appendText("Occupation: " + event.getOccupation() + "\n");
				textPanel.appendText("AgeCatId: " + event.getAgeCatId() + "\n");
				textPanel.appendText("EmpCat: " + event.getEmpCategory() + "\n");
				textPanel.appendText("isSLCitien: " + event.isSLCitizen() + "\n");
				textPanel.appendText("TaxID: " + event.getTaxID() + "\n");
				textPanel.appendText("Gender: " + event.getGender() + "\n");
			}
		});

		setLayout(new BorderLayout());

		add(toolbar, BorderLayout.NORTH);
		add(formPanel, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);

		setMinimumSize(new Dimension(400, 450));
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exportFormData = new JMenuItem("Export Data...");
		JMenuItem importFormData = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		importFormData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Loading from file failed!", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					log.debug(fileChooser.getSelectedFile());
				}
			}
		});

		exportFormData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Saving to file failed!", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					log.debug(fileChooser.getSelectedFile());
				}
			}
		});

		fileMenu.add(exportFormData);
		fileMenu.add(importFormData);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);

		showFormItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
		});

		showMenu.add(showFormItem);

		JMenu windowMenu = new JMenu("Window");
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		return menuBar;
	}
}
