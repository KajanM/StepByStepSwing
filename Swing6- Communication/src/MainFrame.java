import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	private final Toolbar toolbar;
	private final TextPanel textPanel;
	
	public MainFrame() {
		super("Hello World");
		
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		
		toolbar.setTextPanel(textPanel);
		
		setLayout(new BorderLayout());
		
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
