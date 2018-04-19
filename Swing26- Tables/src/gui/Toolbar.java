package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Toolbar extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1106347544861376924L;

	private static final Logger log = LogManager.getLogger(Toolbar.class);

	private final JButton helloBtn;
	private final JButton goodByeBtn;

	private ToolbarListener toolbarListener;

	public Toolbar() {
		helloBtn = new JButton("Hello");
		goodByeBtn = new JButton("GoodBye");

		helloBtn.addActionListener(this);
		goodByeBtn.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEtchedBorder());

		add(helloBtn);
		add(goodByeBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = null;
		JButton clicked = (JButton) e.getSource();

		if (clicked == helloBtn) {
			log.debug("helloBtn clicked");
			msg = "Hello\n";
		} else if (clicked == goodByeBtn) {
			log.debug("goodByeBtn clicked");
			msg = "GoodBye\n";
		}

		if (toolbarListener != null) {
			toolbarListener.actionPerformed(msg);
		}
	}

	public void setToolbarListener(ToolbarListener toolbarListener) {
		this.toolbarListener = toolbarListener;
	}

}
