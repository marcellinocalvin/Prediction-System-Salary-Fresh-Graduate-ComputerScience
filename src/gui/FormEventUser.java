package gui;

import java.util.EventObject;

public class FormEventUser extends EventObject {

    private String name;
    private String gender;
    private String pendidikanAkhirCat;
    private String keaktifanOrganisasiCat;
    private String bidangKompetensiCat;
    private String pengalamanAkademikCat;
    private String sertifikasiKeahlianCat;
    private String sertifikasiBootcampCat;
    private String ipkCat;
    private String pengalamanMagangCat;
    private String kemampuanBahasaInggrisCat;

    public FormEventUser(Object source) {
        super(source);
    }

    public FormEventUser(Object source, String name, String gender, String pendidikanAkhirCat, String keaktifanOrganisasiCat,
                         String bidangKompetensiCat, String pengalamanAkademikCat, String sertifikasiKeahlianCat,
                         String sertifikasiBootcampCat, String ipkCat, String pengalamanMagangCat,
                         String kemampuanBahasaInggrisCat) {
        super(source);

        this.name = name;
        this.gender = gender;
        this.pendidikanAkhirCat = pendidikanAkhirCat;
        this.keaktifanOrganisasiCat = keaktifanOrganisasiCat;
        this.bidangKompetensiCat = bidangKompetensiCat;
        this.pengalamanAkademikCat = pengalamanAkademikCat;
        this.sertifikasiKeahlianCat = sertifikasiKeahlianCat;
        this.sertifikasiBootcampCat = sertifikasiBootcampCat;
        this.ipkCat = ipkCat;
        this.pengalamanMagangCat = pengalamanMagangCat;
        this.kemampuanBahasaInggrisCat = kemampuanBahasaInggrisCat;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPendidikanAkhirCat() {

        return pendidikanAkhirCat;
    }

    public String getKeaktifanOrganisasiCat() {

        return keaktifanOrganisasiCat;
    }

    public String getBidangKompetensiCat() {

        return bidangKompetensiCat;
    }

    public String getPengalamanAkademikCat() {

        return pengalamanAkademikCat;
    }

    public String getSertifikasiKeahlianCat() {

        return sertifikasiKeahlianCat;
    }

    public String getSertifikasiBootcampCat() {

        return sertifikasiBootcampCat;
    }

    public String getIpkCat() {

        return ipkCat;
    }

    public String getPengalamanMagangCat() {

        return pengalamanMagangCat;
    }

    public String getKemampuanBahasaInggrisCat() {

        return kemampuanBahasaInggrisCat;
    }

}
