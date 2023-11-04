package controller;

import gui.FormEvent;
import model.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Person> getPeople() {

        return db.getPeople();
    }

    public void removePerson(int index) {

        db.removePerson(index);
    }

    public void save() throws SQLException {
        db.save();
    }

    public void load() throws SQLException {
        db.load();
    }

    public void connect() throws Exception {
        db.connect();
    }

    public void disconnect() {
        db.disconnect();
    }

    public void addPerson(FormEvent ev) {
        String gender = ev.getGender();
        String pendidikanAkhirCat = ev.getPendidikanAkhirCat();
        String keaktifanOrganisasiCat = ev.getKeaktifanOrganisasiCat();
        String bidangKompetensiCat = ev.getBidangKompetensiCat();
        String pengalamanAkademikCat = ev.getPengalamanAkademikCat();
        String sertifikasiKeahlianCat = ev.getSertifikasiKeahlianCat();
        String sertfikasiBootcampCat = ev.getSertifikasiBootcampCat();
        String ipkCat = ev.getIpkCat();
        String pengalamanMagangCat = ev.getPengalamanMagangCat();
        String kemampuanBahasaInggrisCat = ev.getKemampuanBahasaInggrisCat();
        String gajiCat = ev.getGajiCat();

        Gender genderCategory;

        if(gender.equals("male")) {
            genderCategory = Gender.male;
        }
        else {
            genderCategory = Gender.female;
        }

        // pendidikan akhir ///////////////////////////
        PendidikanAkhirCategory pendidikanAkhirCategory;

        if(pendidikanAkhirCat.equals("D3")) {
            pendidikanAkhirCategory = PendidikanAkhirCategory.D3;
        }
        else if(pendidikanAkhirCat.equals("D4")) {
            pendidikanAkhirCategory = PendidikanAkhirCategory.D4;
        }
        else {
            pendidikanAkhirCategory = PendidikanAkhirCategory.S1;
            System.err.println(pendidikanAkhirCat);
        }

        // keaktifan organisasi ///////////////////////////
        KeaktifanOrganisasiCategory keaktifanOrganisasiCategory;

        if(keaktifanOrganisasiCat.equals("Tidak Aktif")) {
            keaktifanOrganisasiCategory = KeaktifanOrganisasiCategory.tidakAktif;
        }
        else if(keaktifanOrganisasiCat.equals("Kurang Aktif")) {
            keaktifanOrganisasiCategory = KeaktifanOrganisasiCategory.kurangAktif;
        }
        else if(keaktifanOrganisasiCat.equals("Cukup Aktif")) {
            keaktifanOrganisasiCategory = KeaktifanOrganisasiCategory.cukupAktif;
        }
        else if(keaktifanOrganisasiCat.equals("Aktif")) {
            keaktifanOrganisasiCategory = KeaktifanOrganisasiCategory.aktif;
        }
        else {
            keaktifanOrganisasiCategory = KeaktifanOrganisasiCategory.sangatAktif;
            System.err.println(keaktifanOrganisasiCat);
        }

        // bidang kompetensi ///////////////////////////
        BidangKompetensiCategory bidangKompetensiCategory;

        if(bidangKompetensiCat.equals("Web")) {
            bidangKompetensiCategory = BidangKompetensiCategory.web;
        }
        else if(bidangKompetensiCat.equals("Aplikasi")) {
            bidangKompetensiCategory = BidangKompetensiCategory.aplikasi;
        }
        else if(bidangKompetensiCat.equals("Data")) {
            bidangKompetensiCategory = BidangKompetensiCategory.data;
        }
        else if(bidangKompetensiCat.equals("Cyber Security")) {
            bidangKompetensiCategory = BidangKompetensiCategory.cyberSecurity;
        }
        else if(bidangKompetensiCat.equals("Machine Learning & AI")) {
            bidangKompetensiCategory = BidangKompetensiCategory.machineLearningAI;
        }
        else if(bidangKompetensiCat.equals("UI/UX")) {
            bidangKompetensiCategory = BidangKompetensiCategory.uiUX;
        }
        else {
            bidangKompetensiCategory = BidangKompetensiCategory.jaringan;
            System.err.println(bidangKompetensiCat);
        }

        // pengalaman akademik ///////////////////////////
        PengalamanAkademikCategory pengalamanAkademikCategory;

        if(pengalamanAkademikCat.equals("Ada")) {
            pengalamanAkademikCategory = PengalamanAkademikCategory.ada;
        }
        else {
            pengalamanAkademikCategory = PengalamanAkademikCategory.tidakAda;
            System.err.println(pengalamanAkademikCat);
        }

        // sertifikasi keahlian ///////////////////////////
        SertifikasiKeahlianCategory sertifikasiKeahlianCategory;

        if(sertifikasiKeahlianCat.equals("Ada")) {
            sertifikasiKeahlianCategory = SertifikasiKeahlianCategory.ada;
        }
        else {
            sertifikasiKeahlianCategory = SertifikasiKeahlianCategory.tidakAda;
            System.err.println(sertifikasiKeahlianCat);
        }

        // sertifikasi bootcamp ///////////////////////////
        SertifikasiBootcampCategory sertifikasiBootcampCategory;

        if(sertfikasiBootcampCat.equals("Ada")) {
            sertifikasiBootcampCategory = SertifikasiBootcampCategory.ada;
        }
        else {
            sertifikasiBootcampCategory = SertifikasiBootcampCategory.tidakAda;
            System.err.println(sertfikasiBootcampCat);
        }

        // IPK ///////////////////////////
        IPKCategory ipkCategory;

        if(ipkCat.equals("≤ 2.75")) {
            ipkCategory = IPKCategory.under;
        }
        else if(ipkCat.equals("> 2.75 sampai ≤ 3")) {
            ipkCategory = IPKCategory.notEnough;
        }
        else if(ipkCat.equals("> 3 sampai ≤ 3.5")) {
            ipkCategory = IPKCategory.enough;
        }
        else {
            ipkCategory = IPKCategory.above;
            System.err.println(ipkCat);
        }

        // pengalaman magang ///////////////////////////
        PengalamanMagangCategory pengalamanMagangCategory;

        if(pengalamanMagangCat.equals("Ada")) {
            pengalamanMagangCategory = PengalamanMagangCategory.ada;
        }
        else {
            pengalamanMagangCategory = PengalamanMagangCategory.tidakAda;
            System.err.println(pengalamanMagangCat);
        }

        // kemampuan bahasa inggris ///////////////////////////
        KemampuanBahasaInggrisCategory kemampuanBahasaInggrisCategory;

        if(kemampuanBahasaInggrisCat.equals("Tingkat Dasar")) {
            kemampuanBahasaInggrisCategory = KemampuanBahasaInggrisCategory.dasar;
        }
        else if(kemampuanBahasaInggrisCat.equals("Tingkat Menengah")) {
            kemampuanBahasaInggrisCategory = KemampuanBahasaInggrisCategory.menengah;
        }
        else if(kemampuanBahasaInggrisCat.equals("Tingkat Profesional")) {
            kemampuanBahasaInggrisCategory = KemampuanBahasaInggrisCategory.profesional;
        }
        else if(kemampuanBahasaInggrisCat.equals("Tingkat Profesional Mahir")) {
            kemampuanBahasaInggrisCategory = KemampuanBahasaInggrisCategory.profesionalMahir;
        }
        else {
            kemampuanBahasaInggrisCategory = KemampuanBahasaInggrisCategory.fasih;
            System.err.println(kemampuanBahasaInggrisCat);
        }

        // gaji ///////////////////////////
        GajiCategory gajiCategory;

        if(gajiCat.equals("< UMP")) {
            gajiCategory = GajiCategory.under;
        }
        else if(gajiCat.equals("= UMP")) {
            gajiCategory = GajiCategory.equals;
        }
        else {
            gajiCategory = GajiCategory.above;
            System.err.println(gajiCat);
        }

        Person person = new Person(genderCategory, pendidikanAkhirCategory,
                keaktifanOrganisasiCategory, bidangKompetensiCategory,
                pengalamanAkademikCategory, sertifikasiKeahlianCategory,
                sertifikasiBootcampCategory, ipkCategory, pengalamanMagangCategory,
                kemampuanBahasaInggrisCategory, gajiCategory);

        db.addPerson(person);
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
