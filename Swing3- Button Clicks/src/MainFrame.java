import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("Hello\n");
			}
		});
		
		setLayout(new BorderLayout());
		
		add(textArea, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
