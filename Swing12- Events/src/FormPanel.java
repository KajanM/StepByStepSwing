import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private static final long serialVersionUID = -8577913918273600961L;
	
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

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		Insets labelInsets = new Insets(0, 0, 0, 5);
		Insets emptyInsets = new Insets(0, 0, 0, 0);

		gc.fill = GridBagConstraints.NONE;

		//////////////////////// First Row//////////////////////////////////////
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = labelInsets;
		gc.anchor = GridBagConstraints.LINE_END;
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);

		//////////////////////// Second Row//////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = labelInsets;
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);

		//////////////////////// Next Row//////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okButton, gc);

	}
}
