import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FormPanel extends JPanel {
	private static final long serialVersionUID = -8577913918273600961L;
	private static final Logger log = LogManager.getLogger(FormPanel.class);

	private final JTextField nameField;
	private final JTextField occupationField;
	private final JList<AgeCategory> ageCatList;
	private final JComboBox<String>	empCatCombo;
	private final JButton okButton;

	private FormListener formListener;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		ageCatList = new JList<>();
		empCatCombo = new JComboBox<>();
		okButton = new JButton("OK");

		setUpAgeCatList();
		
		setupEmpCombo();
	
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log.debug("okBtn pressed");
				
				String name = nameField.getText();
				String occupation = occupationField.getText();
				int ageCatId = ageCatList.getSelectedValue().getId();
				String empCat = (String) empCatCombo.getSelectedItem();
				
				FormEvent formEvent = new FormEvent(this, name, occupation, ageCatId, empCat);

				if (formListener != null) {
					formListener.okBtnPressed(formEvent);
				}
			}
		});

		layoutComponents();
	}
	
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

	private void layoutComponents() {
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
		add(new JLabel("Name:"), gc);

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
		add(new JLabel("Occuaption:"), gc);

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);

		//////////////////////// Next Row//////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = labelInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Age:"), gc);

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.LINE_START;
		add(ageCatList, gc);
		
		//////////////////////// Next Row//////////////////////////////////////
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.insets = labelInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Employment:"), gc);
		
		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.LINE_START;
		add(empCatCombo, gc);

		//////////////////////// Next Row//////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okButton, gc);
	}

	private void setUpAgeCatList() {
		DefaultListModel<AgeCategory> ageListModel = new DefaultListModel<>();
		ageListModel.addElement(new AgeCategory(0, "18 or below"));
		ageListModel.addElement(new AgeCategory(1, "18 to 65"));
		ageListModel.addElement(new AgeCategory(2, "65 or over"));
		ageCatList.setModel(ageListModel);

		ageCatList.setPreferredSize(new Dimension(112, 68));
		ageCatList.setBorder(BorderFactory.createEtchedBorder());
		ageCatList.setSelectedIndex(1);
	}

	private void setupEmpCombo() {
		DefaultComboBoxModel<String> empCatModel = new DefaultComboBoxModel<>();
		empCatModel.addElement("employed");
		empCatModel.addElement("self-employed");
		empCatModel.addElement("unemployed");
		empCatCombo.setModel(empCatModel);
		
		Dimension dim = empCatCombo.getPreferredSize();
		dim.width = 112;
		empCatCombo.setPreferredSize(dim);
		empCatCombo.setEditable(true);
		empCatCombo.setSelectedIndex(0);
	}
}

class AgeCategory {

	private int id;
	private String text;

	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return text;
	}
}
