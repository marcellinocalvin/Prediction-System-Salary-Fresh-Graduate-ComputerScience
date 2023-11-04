package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanelUser extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;

    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    private JComboBox pendidikanAkhirCmb;
    private JComboBox keaktifanOrganisasiCmb;
    private JComboBox bidangKompetensiCmb;
    private JComboBox pengalamanAkademikCmb;
    private JComboBox sertifikasiKeahlianCmb;
    private JComboBox sertifikasiBootcampCmb;
    private JComboBox ipkCmb;
    private JComboBox pengalamanMagangCmb;
    private JComboBox kemampuanBahasaInggrisCmb;

    private FormListenerUser formListener;
    private JButton okBtn;

    public FormPanelUser() {
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(10);

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");

        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");

        genderGroup = new ButtonGroup();

        maleRadio.setSelected(true);

        pendidikanAkhirCmb = new JComboBox();
        keaktifanOrganisasiCmb = new JComboBox();
        bidangKompetensiCmb = new JComboBox();
        pengalamanAkademikCmb = new JComboBox();
        sertifikasiKeahlianCmb = new JComboBox();
        sertifikasiBootcampCmb = new JComboBox();
        ipkCmb = new JComboBox();
        pengalamanMagangCmb = new JComboBox();
        kemampuanBahasaInggrisCmb = new JComboBox();
        okBtn = new JButton("OK");

        // Set up gender radios
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // Set up combo box pendidikan akhir
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("D3");
        //empModel.addElement("D4");
        empModel.addElement("S1");
        pendidikanAkhirCmb.setModel(empModel);
        pendidikanAkhirCmb.setSelectedIndex(0);
        pendidikanAkhirCmb.setEditable(true);

        // Set up combo box keaktifan organisasi
        DefaultComboBoxModel empModel2 = new DefaultComboBoxModel();
        empModel2.addElement("Tidak Aktif");
        empModel2.addElement("Kurang Aktif");
        empModel2.addElement("Cukup Aktif");
        empModel2.addElement("Aktif");
        empModel2.addElement("Sangat Aktif");
        keaktifanOrganisasiCmb.setModel(empModel2);
        keaktifanOrganisasiCmb.setSelectedIndex(0);
        keaktifanOrganisasiCmb.setEditable(true);

        // Set up combo box bidang kompetensi
        DefaultComboBoxModel empModel3 = new DefaultComboBoxModel();
        empModel3.addElement("Web");
        empModel3.addElement("Aplikasi");
        empModel3.addElement("Data");
        empModel3.addElement("Cyber Security");
        empModel3.addElement("Machine Learning & AI");
        empModel3.addElement("UI/UX");
        empModel3.addElement("Jaringan");
        bidangKompetensiCmb.setModel(empModel3);
        bidangKompetensiCmb.setSelectedIndex(0);
        bidangKompetensiCmb.setEditable(true);

        // Set up combo box pengalaman akademik
        DefaultComboBoxModel empModel4 = new DefaultComboBoxModel();
        empModel4.addElement("Ada");
        empModel4.addElement("Tidak Ada");
        pengalamanAkademikCmb.setModel(empModel4);
        pengalamanAkademikCmb.setSelectedIndex(0);
        pengalamanAkademikCmb.setEditable(true);

        // Set up combo box sertifikasi keahlian
        DefaultComboBoxModel empModel5 = new DefaultComboBoxModel();
        empModel5.addElement("Ada");
        empModel5.addElement("Tidak Ada");
        sertifikasiKeahlianCmb.setModel(empModel5);
        sertifikasiKeahlianCmb.setSelectedIndex(0);
        sertifikasiKeahlianCmb.setEditable(true);

        // Set up combo box sertifikat bootcamp
        DefaultComboBoxModel empModel6 = new DefaultComboBoxModel();
        empModel6.addElement("Ada");
        empModel6.addElement("Tidak Ada");
        sertifikasiBootcampCmb.setModel(empModel6);
        sertifikasiBootcampCmb.setSelectedIndex(0);
        sertifikasiBootcampCmb.setEditable(true);

        // Set up combo box IPK
        DefaultComboBoxModel empModel7 = new DefaultComboBoxModel();
        empModel7.addElement("≤ 2.7");
        empModel7.addElement("> 2.8 sampai ≤ 3");
        empModel7.addElement("> 3.1 sampai ≤ 3.5");
        empModel7.addElement("> 3.6 sampai 4");
        ipkCmb.setModel(empModel7);
        ipkCmb.setSelectedIndex(0);
        ipkCmb.setEditable(true);

        // Set up combo box pengalaman magang
        DefaultComboBoxModel empModel8 = new DefaultComboBoxModel();
        empModel8.addElement("Ada");
        empModel8.addElement("Tidak Ada");
        pengalamanMagangCmb.setModel(empModel8);
        pengalamanMagangCmb.setSelectedIndex(0);
        pengalamanMagangCmb.setEditable(true);

        // Set up combo box kemampuan bahasa Inggris
        DefaultComboBoxModel empModel9 = new DefaultComboBoxModel();
        empModel9.addElement("Tingkat Dasar");
        empModel9.addElement("Tingkat Menengah");
        empModel9.addElement("Tingkat Profesional");
        empModel9.addElement("Tingkat Profesional Mahir");
        empModel9.addElement("Tingkat Fasih atau Bahasa Asli");
        kemampuanBahasaInggrisCmb.setModel(empModel9);
        kemampuanBahasaInggrisCmb.setSelectedIndex(0);
        kemampuanBahasaInggrisCmb.setEditable(true);

        okBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String gender = genderGroup.getSelection().getActionCommand();
                String pendidikanAkhir = (String) pendidikanAkhirCmb.getSelectedItem();
                String keaktifanOrganisasi = (String) keaktifanOrganisasiCmb.getSelectedItem();
                String bidangKompetensi = (String) bidangKompetensiCmb.getSelectedItem();
                String pengalamanAkademik = (String) pengalamanAkademikCmb.getSelectedItem();
                String sertifikasiKeahlian = (String) sertifikasiKeahlianCmb.getSelectedItem();
                String sertifikasiBootcamp = (String) sertifikasiBootcampCmb.getSelectedItem();
                String ipk = (String) ipkCmb.getSelectedItem();
                String pengalamanMagang = (String) pengalamanMagangCmb.getSelectedItem();
                String kemampuanBahasaInggris = (String) kemampuanBahasaInggrisCmb.getSelectedItem();

                FormEventUser ev = new FormEventUser(this, name, gender ,
                        pendidikanAkhir, keaktifanOrganisasi,
                        bidangKompetensi, pengalamanAkademik, sertifikasiKeahlian, sertifikasiBootcamp,
                        ipk, pengalamanMagang, kemampuanBahasaInggris);

                if(formListener != null) {
                    formListener.formEventOccurred(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        ////////////// First Row /////////////////////////////////

        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        ////////////// Next Row /////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Gender: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(maleRadio, gc);

        ////////////// Next Row /////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(femaleRadio , gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Pendidikan"), gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        add(new JLabel("Akhir: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(pendidikanAkhirCmb, gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Keaktifan"), gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        add(new JLabel("Organisasi: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(keaktifanOrganisasiCmb, gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Bidang"), gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        add(new JLabel("Kompetensi: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(bidangKompetensiCmb, gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Pengalaman"), gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        add(new JLabel("Akademik: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(pengalamanAkademikCmb, gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Sertifikasi"), gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        add(new JLabel("Keahlian: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(sertifikasiKeahlianCmb, gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Sertifikasi"), gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        add(new JLabel("Bootcamp: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(sertifikasiBootcampCmb, gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("IPK: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ipkCmb, gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Pengalaman"), gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        add(new JLabel("Magang:"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(pengalamanMagangCmb, gc);

        //// Next ROW /////////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Kemampuan "), gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        add(new JLabel("Bahasa Inggris: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(kemampuanBahasaInggrisCmb, gc);

        ////////////// Next Row /////////////////////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okBtn, gc);
    }

    public void setFormListener(FormListenerUser listener) {
        this.formListener = listener;
    }
}
