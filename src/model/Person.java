package model;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -826930066932346732L;

    private static int count = 1;

    private int id;
    private Gender gender;
    private PendidikanAkhirCategory pendidikanAkhirCat;
    private KeaktifanOrganisasiCategory keaktifanOrganisasiCat;
    private BidangKompetensiCategory bidangKompetensiCat;
    private PengalamanAkademikCategory pengalamanAkademikCat;
    private SertifikasiKeahlianCategory sertifikasiKeahlianCat;
    private SertifikasiBootcampCategory sertifikasiBootcampCat;
    private IPKCategory ipkCat;
    private PengalamanMagangCategory pengalamanMagangCat;
    private KemampuanBahasaInggrisCategory kemampuanBahasaInggrisCat;
    private GajiCategory gajiCat;

    public Person(Gender gender,
                  PendidikanAkhirCategory pendidikanAkhirCat,
                  KeaktifanOrganisasiCategory keaktifanOrganisasiCat,
                  BidangKompetensiCategory bidangKompetensiCat,
                  PengalamanAkademikCategory pengalamanAkademikCat,
                  SertifikasiKeahlianCategory sertifikasiKeahlianCat,
                  SertifikasiBootcampCategory sertifikasiBootcampCat,
                  IPKCategory ipkCat,
                  PengalamanMagangCategory pengalamanMagangCat,
                  KemampuanBahasaInggrisCategory kemampuanBahasaInggrisCat,
                  GajiCategory gajiCat) {
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

        this.id = count;
        count++;
    }

    public Person(int id, Gender gender,
                  PendidikanAkhirCategory pendidikanAkhirCat,
                  KeaktifanOrganisasiCategory keaktifanOrganisasiCat,
                  BidangKompetensiCategory bidangKompetensiCat,
                  PengalamanAkademikCategory pengalamanAkademikCat,
                  SertifikasiKeahlianCategory sertifikasiKeahlianCat,
                  SertifikasiBootcampCategory sertifikasiBootcampCat,
                  IPKCategory ipkCat,
                  PengalamanMagangCategory pengalamanMagangCat,
                  KemampuanBahasaInggrisCategory kemampuanBahasaInggrisCat,
                  GajiCategory gajiCat) {

        this(gender, pendidikanAkhirCat, keaktifanOrganisasiCat, bidangKompetensiCat, pengalamanAkademikCat, sertifikasiKeahlianCat, sertifikasiBootcampCat, ipkCat, pengalamanMagangCat, kemampuanBahasaInggrisCat, gajiCat);

        this.id = id;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PendidikanAkhirCategory getPendidikanAkhirCat() {
        return pendidikanAkhirCat;
    }

    public void setPendidikanAkhirCat(PendidikanAkhirCategory pendidikanAkhirCat) {
        this.pendidikanAkhirCat = pendidikanAkhirCat;
    }

    public KeaktifanOrganisasiCategory getKeaktifanOrganisasiCat() {
        return keaktifanOrganisasiCat;
    }

    public void setKeaktifanOrganisasiCat(KeaktifanOrganisasiCategory keaktifanOrganisasiCat) {
        this.keaktifanOrganisasiCat = keaktifanOrganisasiCat;
    }

    public BidangKompetensiCategory getBidangKompetensiCat() {
        return bidangKompetensiCat;
    }

    public void setBidangKompetensiCat(BidangKompetensiCategory bidangKompetensiCat) {
        this.bidangKompetensiCat = bidangKompetensiCat;
    }

    public PengalamanAkademikCategory getPengalamanAkademikCat() {
        return pengalamanAkademikCat;
    }

    public void setPengalamanAkademikCat(PengalamanAkademikCategory pengalamanAkademikCat) {
        this.pengalamanAkademikCat = pengalamanAkademikCat;
    }

    public SertifikasiKeahlianCategory getSertifikasiKeahlianCat() {
        return sertifikasiKeahlianCat;
    }

    public void setSertifikasiKeahlianCat(SertifikasiKeahlianCategory sertifikasiKeahlianCat) {
        this.sertifikasiKeahlianCat = sertifikasiKeahlianCat;
    }

    public SertifikasiBootcampCategory getSertifikasiBootcampCat() {
        return sertifikasiBootcampCat;
    }

    public void setSertifikasiBootcampCat(SertifikasiBootcampCategory sertifikasiBootcampCat) {
        this.sertifikasiBootcampCat = sertifikasiBootcampCat;
    }

    public IPKCategory getIpkCat() {
        return ipkCat;
    }

    public void setIpkCat(IPKCategory ipkCat) {
        this.ipkCat = ipkCat;
    }

    public PengalamanMagangCategory getPengalamanMagangCat() {
        return pengalamanMagangCat;
    }

    public void setPengalamanMagangCat(PengalamanMagangCategory pengalamanMagangCat) {
        this.pengalamanMagangCat = pengalamanMagangCat;
    }

    public KemampuanBahasaInggrisCategory getKemampuanBahasaInggrisCat() {
        return kemampuanBahasaInggrisCat;
    }

    public void setKemampuanBahasaInggrisCat(KemampuanBahasaInggrisCategory kemampuanBahasaInggrisCat) {
        this.kemampuanBahasaInggrisCat = kemampuanBahasaInggrisCat;
    }

    public GajiCategory getGajiCat() {
        return gajiCat;
    }

    public void setGajiCat(GajiCategory gajiCat) {

        this.gajiCat = gajiCat;
    }

    public String toString() {
        return id + ": " + gender;
    }
}
