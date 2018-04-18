import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private final JTextField nameField;
	private final JTextField occupationField;
	private final JButton okButton;
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		JLabel nameLabel = new JLabel("Name:");
		nameField = new JTextField(10);
		JLabel occupationLabel = new JLabel("Occupation:");
		occupationField = new JTextField(10);
		okButton = new JButton("OK");
	}
}
