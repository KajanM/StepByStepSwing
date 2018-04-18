import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	private final JTextArea textArea;
	private final JButton btn;
	
	public MainFrame() {
		super("Hello World");
		
		textArea = new JTextArea();
		btn = new JButton("Click Me!");
		
		setLayout(new BorderLayout());
		
		add(textArea, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
