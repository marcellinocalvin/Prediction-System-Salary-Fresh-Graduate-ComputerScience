package gui;

import model.*;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {

    private List<Person> db;

    private String[] colNames = {"ID", "Gender", "Pendidikan Akhir", "Keaktifan Organisasi",
            "Bidang Kompetensi", "Pengalaman Akademik", "Sertifikasi Keahlian", "Sertifikasi Bootcamp",
            "IPK", "Pengalaman Magang", "Kemampuan Bahasa Inggris", "Gaji"};

    public PersonTableModel() {
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int col) {

        switch(col) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        if(db == null) return;

        Person person = db.get(row);

        switch(col) {
            case 1:
                person.setGender(Gender.valueOf((String)value));
                break;
            case 2:
                person.setPendidikanAkhirCat(PendidikanAkhirCategory.valueOf((String)value));
                break;
            case 3:
                person.setKeaktifanOrganisasiCat(KeaktifanOrganisasiCategory.valueOf((String)value));
                break;
            case 4:
                person.setBidangKompetensiCat(BidangKompetensiCategory.valueOf((String)value));
                break;
            case 5:
                person.setPengalamanAkademikCat(PengalamanAkademikCategory.valueOf((String)value));
                break;
            case 6:
                person.setSertifikasiKeahlianCat(SertifikasiKeahlianCategory.valueOf((String)value));
                break;
            case 7:
                person.setSertifikasiBootcampCat(SertifikasiBootcampCategory.valueOf((String)value));
                break;
            case 8:
                person.setIpkCat(IPKCategory.valueOf((String)value));
                break;
            case 9:
                person.setPengalamanMagangCat(PengalamanMagangCategory.valueOf((String)value));
                break;
            case 10:
                person.setKemampuanBahasaInggrisCat(KemampuanBahasaInggrisCategory.valueOf((String)value));
                break;
            case 11:
                person.setGajiCat(GajiCategory.valueOf((String)value));
                break;
            default:
                return;
        }
    }

    public void setData(List<Person> db) {
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Person person = db.get(row);

        switch(col) {
            case 0:
                return person.getId();
            case 1:
                return person.getGender();
            case 2:
                return person.getPendidikanAkhirCat();
            case 3:
                return person.getKeaktifanOrganisasiCat();
            case 4:
                return person.getBidangKompetensiCat();
            case 5:
                return person.getPengalamanAkademikCat();
            case 6:
                return person.getSertifikasiKeahlianCat();
            case 7:
                return person.getSertifikasiBootcampCat();
            case 8:
                return person.getIpkCat();
            case 9:
                return person.getPengalamanMagangCat();
            case 10:
                return person.getKemampuanBahasaInggrisCat();
            case 11:
                return person.getGajiCat();
        }

        return null;
    }
}
