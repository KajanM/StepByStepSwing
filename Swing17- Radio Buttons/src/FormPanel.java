import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private final JComboBox<String> empCatCombo;
	private final JCheckBox citizenCheckBox;
	private final JLabel taxIdLabel;
	private final JTextField taxIdField;
	private final JButton okButton;
	
	private final JRadioButton maleRadio;
	private final JRadioButton femaleRadio;
	private final ButtonGroup genderGroup;

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
		citizenCheckBox = new JCheckBox();
		taxIdLabel = new JLabel("Tax ID:");
		taxIdField = new JTextField(10);
		okButton = new JButton("OK");
		
		maleRadio = new JRadioButton("male");
		femaleRadio = new JRadioButton("female");
		
		maleRadio.setActionCommand("male");
		femaleRadio.setActionCommand("female");
		
		genderGroup = new ButtonGroup();
		
		maleRadio.setSelected(true);
		
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);

		setUpAgeCatList();

		setupEmpCombo();

		// set up tax id
		taxIdLabel.setEnabled(false);
		taxIdField.setEnabled(false);

		citizenCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean selected = citizenCheckBox.isSelected();
				taxIdLabel.setEnabled(selected);
				taxIdField.setEnabled(selected);
			}
		});

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log.debug("okBtn pressed");

				String name = nameField.getText();
				String occupation = occupationField.getText();
				int ageCatId = ageCatList.getSelectedValue().getId();
				String empCat = (String) empCatCombo.getSelectedItem();
				boolean isSLCitizen = citizenCheckBox.isSelected();
				String taxID = taxIdField.getText();
				
				String gender = genderGroup.getSelection().getActionCommand();

				FormEvent formEvent = new FormEvent(this, name, occupation, ageCatId, empCat, isSLCitizen, taxID, gender);

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
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Name:"), gc);

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(nameField, gc);

		//////////////////////// Second Row//////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = labelInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Occuaption:"), gc);

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
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
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
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
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(empCatCombo, gc);

		//////////////////////// Next Row//////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = labelInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("SL Citizen:"), gc);

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(citizenCheckBox, gc);

		//////////////////////// Next Row//////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = labelInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(taxIdLabel, gc);

		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(taxIdField, gc);
		
		//////////////////////// Next Row//////////////////////////////////////
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.insets = labelInsets;
		gc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Gener:"), gc);
		
		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(maleRadio, gc);
		
		//////////////////////// Next Row//////////////////////////////////////
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 1;
		gc.insets = emptyInsets;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(femaleRadio, gc);

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
