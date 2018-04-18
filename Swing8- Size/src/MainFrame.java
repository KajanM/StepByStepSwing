import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	private final Toolbar toolbar;
	private final FormPanel formPanel;
	private final TextPanel textPanel;
	
	public MainFrame() {
		super("Hello World");
		
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		textPanel = new TextPanel();
		
		toolbar.setToolbarListener(new ToolbarListener() {
			
			@Override
			public void actionPerformed(String text) {
				textPanel.appendText(text);
			}
		});
		
		setLayout(new BorderLayout());
		
		add(toolbar, BorderLayout.NORTH);
		add(formPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
