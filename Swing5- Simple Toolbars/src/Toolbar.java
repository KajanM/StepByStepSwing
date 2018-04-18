import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
	
	private final JButton helloBtn;
	private final JButton goodByeBtn;
	
	public Toolbar() {
		helloBtn = new JButton("Hello");
		goodByeBtn = new JButton("GoodBye");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloBtn);
		add(goodByeBtn);
	}

}
