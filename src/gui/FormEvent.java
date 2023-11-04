package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {

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
    private String gajiCat;

    public FormEvent (Object source, String gender, String pendidikanAkhirCat, String keaktifanOrganisasiCat,
                      String bidangKompetensiCat, String pengalamanAkademikCat, String sertifikasiKeahlianCat,
                      String sertifikasiBootcampCat, String ipkCat, String pengalamanMagangCat,
                      String kemampuanBahasaInggrisCat, String gajiCat) {
        super(source);

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
        this.gajiCat = gajiCat;
    }

    public String getGender() {

        return gender;
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

    public String getGajiCat() {

        return gajiCat;
    }

}
