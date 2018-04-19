import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -4338620565171230172L;

	private final Toolbar toolbar;
	private final FormPanel formPanel;
	private final TextPanel textPanel;

	public MainFrame() {
		super("Hello World");

		toolbar = new Toolbar();
		formPanel = new FormPanel();
		textPanel = new TextPanel();

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
		add(textPanel, BorderLayout.CENTER);

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
				if(action == JOptionPane.OK_OPTION) {
					System.exit(0);
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
