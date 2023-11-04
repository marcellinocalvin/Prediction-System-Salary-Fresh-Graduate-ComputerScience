package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.*;

public class UserPage extends JFrame {
    static private TextPanel textPanel;
    private ToolbarUser toolbar;
    private FormPanelUser formPanel;

    // DATA TRAINING
    static String[] arrayIDFinal = new String[0];

    static int[] arrayGenderFinal = new int[0];
    static int[] arrayPAFinal = new int[0];
    static int[] arrayKOFinal = new int[0];
    static int[] arrayBKFinal = new int[0];
    static int[] arrayPKFinal = new int[0];
    static int[] arraySKFinal = new int[0];
    static int[] arraySBFinal = new int[0];
    static int[] arrayIPKFinal = new int[0];
    static int[] arrayPMFinal = new int[0];
    static int[] arrayBIFinal = new int[0];

    static String[] arrayGajiFinal = new String[0];

    // DATA TESTING
    static String nama1 = "";
    static int gender1;
    static int pendidikanAkhir1;
    static int keaktifanOrganisasi1;
    static int bidangKompetensi1;
    static int pengalamanAkademik1;
    static int sertifikasiKeahlian1;
    static int sertifikasiBootcamp1;
    static int IPK1;
    static int pengalamanMagang1;
    static int kemampuanBInggris1;

    // Function Jarak Euclidean
    static double jarakEuclidean(int gender, int gender1, int pendidikanAkhir, int pendidikanAkhir1, int keaktifanOrganisasi,
                                 int keaktifanOrganisasi1, int bidangKompetensi, int bidangKompetensi1, int pengalamanAkademik,
                                 int pengalamanAkademik1, int sertifikasiKeahlian, int sertifikasiKeahlian1, int sertifikasiBootcamp,
                                 int sertifikasiBootcamp1, int IPK, int IPK1,
                                 int pengalamanMagang, int pengalamanMagang1, int kemampuanBInggris, int kemampuanBInggris1) {
        return Math.sqrt(Math.pow(gender - gender1, 2) + Math.pow(pendidikanAkhir - pendidikanAkhir1, 2) +
                Math.pow(keaktifanOrganisasi - keaktifanOrganisasi1, 2) + Math.pow(bidangKompetensi - bidangKompetensi1, 2) +
                Math.pow(pengalamanAkademik - pengalamanAkademik1, 2) + Math.pow(sertifikasiKeahlian - sertifikasiKeahlian1, 2) +
                Math.pow(sertifikasiBootcamp - sertifikasiBootcamp1, 2) + Math.pow(IPK - IPK1, 2) +
                Math.pow(pengalamanMagang - pengalamanMagang1, 2) + Math.pow(kemampuanBInggris - kemampuanBInggris1, 2));
    }

    public static void connect() {
        try {
            Driver MysqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserPage() {
        super("Hello World");

        setLayout(new BorderLayout());

        toolbar = new ToolbarUser();
        textPanel = new TextPanel();
        formPanel = new FormPanelUser();

        toolbar.setStringListener(new StringListenerUser() {
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }

            @Override
            public void refreshText() {
                textPanel.refreshText();
            }
        });

        formPanel.setFormListener(new FormListenerUser() {
            public void formEventOccurred(FormEventUser e) {
                String name = e.getName();
                String gender = e.getGender();
                String PA = e.getPendidikanAkhirCat();
                String KO = e.getKeaktifanOrganisasiCat();
                String BK = e.getBidangKompetensiCat();
                String PK = e.getPengalamanAkademikCat();
                String SK = e.getSertifikasiKeahlianCat();
                String SB = e.getSertifikasiBootcampCat();
                String ipk = e.getIpkCat();
                String PM = e.getPengalamanMagangCat();
                String KB = e.getKemampuanBahasaInggrisCat();

                // nama
                nama1 = name;

                // gender
                if(gender.equals("male")) {
                    gender1 = 1;
                } else {
                    gender1 = 2;
                }
                System.out.println(gender1);

                // pendidikan akhir
                if(PA.equals("D3")) {
                    pendidikanAkhir1 = 1;
                } else if (PA.equals("D4")) {
                    pendidikanAkhir1 = 2;
                } else {
                    pendidikanAkhir1 = 3;
                }

                // keaktifan organisasi
                if(KO.equals("Tidak Aktif")) {
                    keaktifanOrganisasi1 = 1;
                } else if(KO.equals("Kurang Aktif")) {
                    keaktifanOrganisasi1 = 2;
                } else if(KO.equals("Cukup Aktif")) {
                    keaktifanOrganisasi1 = 3;
                } else if(KO.equals("Aktif")) {
                    keaktifanOrganisasi1 = 4;
                } else {
                    keaktifanOrganisasi1 = 5;
                }

                // bidang kompetensi
                if(BK.equals("Web")) {
                    bidangKompetensi1 = 1;
                } else if(BK.equals("Aplikasi")) {
                    bidangKompetensi1 = 2;
                } else if (BK.equals("Data")) {
                    bidangKompetensi1 = 3;
                } else if (BK.equals("Cyber Security")) {
                    bidangKompetensi1 = 4;
                } else if (BK.equals("Machine Learning & AI")) {
                    bidangKompetensi1 = 5;
                } else if (BK.equals("UI/UX")) {
                    bidangKompetensi1 = 6;
                } else {
                    bidangKompetensi1 = 7;
                }

                // pengalaman akademik
                if(PK.equals("Ada")) {
                    pengalamanAkademik1 = 1;
                } else {
                    pengalamanAkademik1 = 2;
                }

                // sertifikasi keahlian
                if(SK.equals("Ada")) {
                    sertifikasiKeahlian1 = 1;
                } else {
                    sertifikasiKeahlian1 = 2;
                }

                // sertifikasi bootcamp
                if(SB.equals("Ada")) {
                    sertifikasiBootcamp1 = 1;
                } else {
                    sertifikasiBootcamp1 = 2;
                }

                // ipk
                if(ipk.equals("≤ 2.7")) {
                    IPK1 = 1;
                } else if(ipk.equals("> 2.8 sampai ≤ 3")) {
                    IPK1 = 2;
                } else if(ipk.equals("> 3.1 sampai ≤ 3.5")) {
                    IPK1 = 3;
                } else {
                    IPK1 = 4;
                }

                // pengalaman magang
                if(PM.equals("Ada")) {
                    pengalamanMagang1 = 1;
                } else {
                    pengalamanMagang1 = 2;
                }

                // kemampuan bahasa Inggris
                if(KB.equals("Tingkat Dasar")) {
                    kemampuanBInggris1 = 1;
                } else if(KB.equals("Tingkat Menengah")) {
                    kemampuanBInggris1 = 2;
                } else if(KB.equals("Tingkat Profesional")) {
                    kemampuanBInggris1 = 3;
                } else if(KB.equals("Tingkat Profesional Mahir")) {
                    kemampuanBInggris1 = 4;
                } else {
                    kemampuanBInggris1 = 5;
                }

                // Logika KNN ////////////////////////////////////

                String jdbcUrl = "jdbc:mysql://localhost:3306/dataset";
                String username = "root";
                String password = "";

                try {
                    connect();
                    Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                    Statement statement = connection.createStatement();

                    String sql = "select*from people";

                    ResultSet resultSet = statement.executeQuery(sql);

                    textPanel.appendText("koneksi sukses");

                    // ArrayList
                    ArrayList<String> listID = new ArrayList<>();
                    ArrayList<String> listGender = new ArrayList();
                    ArrayList<String> listPendidikanAkhir = new ArrayList();
                    ArrayList<String> listKeaktifanOrganisasi = new ArrayList();
                    ArrayList<String> listBidangKompetensi = new ArrayList<>();
                    ArrayList<String> listPengalamanAkademik = new ArrayList<>();
                    ArrayList<String> listSertifikasiKeahlian = new ArrayList<>();
                    ArrayList<String> listSertifikasiBootcamp = new ArrayList<>();
                    ArrayList<String> listIPK = new ArrayList<>();
                    ArrayList<String> listPengalamanMagang = new ArrayList<>();
                    ArrayList<String> listKemampuanBInggris = new ArrayList<>();
                    ArrayList<String> listGaji = new ArrayList<>();

                    while (resultSet.next()) {
                        listID.add(resultSet.getString(1));
                        listGender.add(resultSet.getString(2));
                        listPendidikanAkhir.add(resultSet.getString(3));
                        listKeaktifanOrganisasi.add(resultSet.getString(4));
                        listBidangKompetensi.add(resultSet.getString(5));
                        listPengalamanAkademik.add(resultSet.getString(6));
                        listSertifikasiKeahlian.add(resultSet.getString(7));
                        listSertifikasiBootcamp.add(resultSet.getString(8));
                        listIPK.add(resultSet.getString(9));
                        listPengalamanMagang.add(resultSet.getString(10));
                        listKemampuanBInggris.add(resultSet.getString(11));
                        listGaji.add(resultSet.getString(12));
                    }

                    // CONVERT !!!!!!!!!!!

                    // gender
                    for (int i = 0; i< listGender.size(); i++) {
                        if (listGender.get(i).equals("male")) {
                            listGender.set(i, String.valueOf(1));
                        } else {
                            listGender.set(i, String.valueOf(2));
                        }
                    }
                    // pendidikan Akhir
                    for (int i = 0; i< listPendidikanAkhir.size(); i++) {
                        if (listPendidikanAkhir.get(i).equals("D3")) {
                            listPendidikanAkhir.set(i, String.valueOf(1));
                        } else if (listPendidikanAkhir.get(i).equals("D4")) {
                            listPendidikanAkhir.set(i, String.valueOf(2));
                        } else {
                            listPendidikanAkhir.set(i, String.valueOf(3));
                        }
                    }
                    // keaktifan organisasi
                    for (int i = 0; i< listKeaktifanOrganisasi.size(); i++) {
                        if (listKeaktifanOrganisasi.get(i).equals("tidakAktif")) {
                            listKeaktifanOrganisasi.set(i, String.valueOf(1));
                        } else if (listKeaktifanOrganisasi.get(i).equals("kurangAktif")) {
                            listKeaktifanOrganisasi.set(i, String.valueOf(2));
                        } else if (listKeaktifanOrganisasi.get(i).equals("cukupAktif")) {
                            listKeaktifanOrganisasi.set(i, String.valueOf(3));
                        } else if (listKeaktifanOrganisasi.get(i).equals("aktif")) {
                            listKeaktifanOrganisasi.set(i, String.valueOf(4));
                        } else {
                            listKeaktifanOrganisasi.set(i, String.valueOf(5));
                        }
                    }
                    // bidang kompetensi
                    for (int i = 0; i< listBidangKompetensi.size(); i++) {
                        if (listBidangKompetensi.get(i).equals("web")) {
                            listBidangKompetensi.set(i, String.valueOf(1));
                        } else if (listBidangKompetensi.get(i).equals("aplikasi")) {
                            listBidangKompetensi.set(i, String.valueOf(2));
                        } else if (listBidangKompetensi.get(i).equals("data")) {
                            listBidangKompetensi.set(i, String.valueOf(3));
                        } else if (listBidangKompetensi.get(i).equals("cyberSecurity")) {
                            listBidangKompetensi.set(i, String.valueOf(4));
                        } else if (listBidangKompetensi.get(i).equals("machineLearningAI")) {
                            listBidangKompetensi.set(i, String.valueOf(5));
                        } else if (listBidangKompetensi.get(i).equals("uiUX")) {
                            listBidangKompetensi.set(i, String.valueOf(6));
                        } else {
                            listBidangKompetensi.set(i, String.valueOf(7));
                        }
                    }
                    // pengalaman Akademik
                    for (int i = 0; i< listPengalamanAkademik.size(); i++) {
                        if (listPengalamanAkademik.get(i).equals("ada")) {
                            listPengalamanAkademik.set(i, String.valueOf(1));
                        } else {
                            listPengalamanAkademik.set(i, String.valueOf(2));
                        }
                    }
                    // sertifikasi keahlian
                    for (int i = 0; i< listSertifikasiKeahlian.size(); i++) {
                        if (listSertifikasiKeahlian.get(i).equals("ada")) {
                            listSertifikasiKeahlian.set(i, String.valueOf(1));
                        } else {
                            listSertifikasiKeahlian.set(i, String.valueOf(2));
                        }
                    }
                    // sertifikasi Bootcamp
                    for (int i = 0; i< listSertifikasiBootcamp.size(); i++) {
                        if (listSertifikasiBootcamp.get(i).equals("ada")) {
                            listSertifikasiBootcamp.set(i, String.valueOf(1));
                        } else {
                            listSertifikasiBootcamp.set(i, String.valueOf(2));
                        }
                    }
                    // ipk
                    for (int i = 0; i< listIPK.size(); i++) {
                        if (listIPK.get(i).equals("under")) {
                            listIPK.set(i, String.valueOf(1));
                        } else if (listIPK.get(i).equals("notEnough")){
                            listIPK.set(i, String.valueOf(2));
                        } else if (listIPK.get(i).equals("enough")){
                            listIPK.set(i, String.valueOf(3));
                        } else {
                            listIPK.set(i, String.valueOf(4));
                        }
                    }
                    // pengalaman magang
                    for (int i = 0; i< listPengalamanMagang.size(); i++) {
                        if (listPengalamanMagang.get(i).equals("ada")) {
                            listPengalamanMagang.set(i, String.valueOf(1));
                        } else {
                            listPengalamanMagang.set(i, String.valueOf(2));
                        }
                    }
                    // kemampuan bahasa inggris
                    for (int i = 0; i< listKemampuanBInggris.size(); i++) {
                        if (listKemampuanBInggris.get(i).equals("dasar")) {
                            listKemampuanBInggris.set(i, String.valueOf(1));
                        } else if (listKemampuanBInggris.get(i).equals("menengah")){
                            listKemampuanBInggris.set(i, String.valueOf(2));
                        } else if (listKemampuanBInggris.get(i).equals("profesional")){
                            listKemampuanBInggris.set(i, String.valueOf(3));
                        } else if (listKemampuanBInggris.get(i).equals("profesionalMahir")){
                            listKemampuanBInggris.set(i, String.valueOf(4));
                        } else {
                            listKemampuanBInggris.set(i, String.valueOf(5));
                        }
                    }

                    System.out.println(listID);
                    System.out.println(listGender);
                    System.out.println(listPendidikanAkhir);
                    System.out.println(listKeaktifanOrganisasi);
                    System.out.println(listBidangKompetensi);
                    System.out.println(listPengalamanAkademik);
                    System.out.println(listSertifikasiKeahlian);
                    System.out.println(listSertifikasiBootcamp);
                    System.out.println(listIPK);
                    System.out.println(listPengalamanMagang);
                    System.out.println(listKemampuanBInggris);
                    System.out.println(listGaji);

                    // array id

                    arrayIDFinal = listID.toArray(new String[0]);

                    // array gender
                    int[] arrayGender = new int[listGender.size()];

                    for(int i = 0; i < listGender.size(); i++){
                        arrayGender[i] = Integer.parseInt(listGender.get(i));
                    }

                    arrayGenderFinal = arrayGender;

                    // array pendidikan akhir
                    int[] arrayPA = new int[listPendidikanAkhir.size()];

                    for(int i = 0; i < listPendidikanAkhir.size(); i++){
                        arrayPA[i] = Integer.parseInt(listPendidikanAkhir.get(i));
                    }

                    arrayPAFinal = arrayPA;

                    // array keaktifan organisasi
                    int[] arrayKO = new int[listKeaktifanOrganisasi.size()];

                    for(int i = 0; i < listKeaktifanOrganisasi.size(); i++){
                        arrayKO[i] = Integer.parseInt(listKeaktifanOrganisasi.get(i));
                    }

                    arrayKOFinal = arrayKO;

                    // array bidang kompetensi
                    int[] arrayBK = new int[listBidangKompetensi.size()];

                    for(int i = 0; i < listBidangKompetensi.size(); i++){
                        arrayBK[i] = Integer.parseInt(listBidangKompetensi.get(i));
                    }

                    arrayBKFinal = arrayBK;

                    // array pengalaman akademik
                    int[] arrayPK = new int[listPengalamanAkademik.size()];

                    for(int i = 0; i < listPengalamanAkademik.size(); i++){
                        arrayPK[i] = Integer.parseInt(listPengalamanAkademik.get(i));
                    }

                    arrayPKFinal = arrayPK;

                    // array sertifikasi keahlian
                    int[] arraySK = new int[listSertifikasiKeahlian.size()];

                    for(int i = 0; i < listSertifikasiKeahlian.size(); i++){
                        arraySK[i] = Integer.parseInt(listSertifikasiKeahlian.get(i));
                    }

                    arraySKFinal = arraySK;

                    // array sertifikasi bootcamp
                    int[] arraySB = new int[listSertifikasiBootcamp.size()];

                    for(int i = 0; i < listSertifikasiBootcamp.size(); i++){
                        arraySB[i] = Integer.parseInt(listSertifikasiBootcamp.get(i));
                    }

                    arraySBFinal = arraySB;

                    // array ipk
                    int[] arrayIPK = new int[listIPK.size()];

                    for(int i = 0; i < listIPK.size(); i++){
                        arrayIPK[i] = Integer.parseInt(listIPK.get(i));
                    }

                    arrayIPKFinal = arrayIPK;

                    // array pengalaman magang
                    int[] arrayPM = new int[listPengalamanMagang.size()];

                    for(int i = 0; i < listPengalamanMagang.size(); i++){
                        arrayPM[i] = Integer.parseInt(listPengalamanMagang.get(i));
                    }

                    arrayPMFinal = arrayPM;

                    // array kemampuan bahasa inggris
                    int[] arrayBI = new int[listKemampuanBInggris.size()];

                    for(int i = 0; i < listKemampuanBInggris.size(); i++){
                        arrayBI[i] = Integer.parseInt(listKemampuanBInggris.get(i));
                    }

                    arrayBIFinal = arrayBI;

                    // array gaji
                    arrayGajiFinal = listGaji.toArray(new String[0]);

                    for(int i = 0; i < arrayIDFinal.length; i++) {
                        System.out.print(arrayIDFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayGenderFinal.length; i++) {
                        System.out.print(arrayGenderFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayPAFinal.length; i++) {
                        System.out.print(arrayPAFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayKOFinal.length; i++) {
                        System.out.print(arrayKOFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayBKFinal.length; i++) {
                        System.out.print(arrayBKFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayPKFinal.length; i++) {
                        System.out.print(arrayPKFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arraySKFinal.length; i++) {
                        System.out.print(arraySKFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arraySBFinal.length; i++) {
                        System.out.print(arraySBFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayIPKFinal.length; i++) {
                        System.out.print(arrayIPKFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayPMFinal.length; i++) {
                        System.out.print(arrayPMFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayBIFinal.length; i++) {
                        System.out.print(arrayBIFinal[i] + " ");
                    }
                    System.out.println();
                    for(int i = 0; i < arrayGajiFinal.length; i++) {
                        System.out.print(arrayGajiFinal[i] + " ");
                    }
                    System.out.println();

                    Map knn = new HashMap<>();
                    // append text
                    textPanel.appendText(name + ": " + gender + PA + KO + BK + PK + SK + SB + ipk + PM + KB + "\n");

                    textPanel.appendText("Data Testing \n");
                    textPanel.appendText("Nama                                              : " + nama1 + "\n");
                    textPanel.appendText("Gender                                            : " + gender1 + "\n");
                    textPanel.appendText("Pendidikan Akhir                           : " + pendidikanAkhir1 + "\n");
                    textPanel.appendText("Keaktifan Organisasi                   : " + keaktifanOrganisasi1 + "\n");
                    textPanel.appendText("Bidang Kompetensi                     : " + bidangKompetensi1 + "\n");
                    textPanel.appendText("Pengalaman Akademik               : " + pengalamanAkademik1 + "\n");
                    textPanel.appendText("Sertifikasi Keahlian                      : " + sertifikasiKeahlian1 + "\n");
                    textPanel.appendText("Sertifikasi Bootcamp                    : " + sertifikasiBootcamp1 + "\n");
                    textPanel.appendText("IPK                                                   : " + IPK1 + "\n");
                    textPanel.appendText("Pengalaman Magang                  : " + pengalamanMagang1 + "\n");
                    textPanel.appendText("Kemampuan Bahasa Inggris    : " + kemampuanBInggris1 + "\n");

                    textPanel.appendText("\n");
                    textPanel.appendText("Hasil Jarak Euclidean \n");
                    textPanel.appendText("ID       " +
                            "GD      " +
                            "PA      " +
                            "KO      " +
                            "BK      " +
                            "PK      " +
                            "SK      " +
                            "SB      " +
                            "IP      " +
                            "PM      " +
                            "KI      " +
                            "ED       " + "\n");
                    for (int a = 0; a < arrayGajiFinal.length; a++) {
                        double hasilED = jarakEuclidean(arrayGenderFinal[a], gender1, arrayPAFinal[a], pendidikanAkhir1,
                                arrayKOFinal[a], keaktifanOrganisasi1, arrayBKFinal[a], bidangKompetensi1,
                                arrayPKFinal[a], pengalamanAkademik1, arraySKFinal[a], sertifikasiKeahlian1,
                                arraySBFinal[a], sertifikasiBootcamp1, arrayIPKFinal[a], IPK1, arrayPMFinal[a], pengalamanMagang1,
                                arrayBIFinal[a], kemampuanBInggris1);
                        textPanel.appendText("\n");
                        textPanel.appendText(arrayIDFinal[a] + "          " +
                                arrayGenderFinal[a] + "         " +
                                arrayPAFinal[a] + "         " +
                                arrayKOFinal[a] + "         " +
                                arrayBKFinal[a] + "         " +
                                arrayPKFinal[a] + "         " +
                                arraySKFinal[a] + "         " +
                                arraySBFinal[a] + "         " +
                                arrayIPKFinal[a] + "        " +
                                arrayPMFinal[a] + "         " +
                                arrayBIFinal[a] + "        " +
                                hasilED);

                        knn.put(hasilED, arrayGajiFinal[a]);
                    }

                    // Hasil dari KNN
                    textPanel.appendText("\n");
                    textPanel.appendText("\n");
                    textPanel.appendText("Hasil k-NN \n");

                    Map knn_hasil = new TreeMap(knn);
                    printMap(knn_hasil);

                    textPanel.appendText("\n");
                    textPanel.appendText("Hasil Keputusan : " + nama1 + " " + knn_hasil.values().toArray()[0] + "\n");

                    // CLOSE CONNECTION
                    resultSet.close();
                    statement.close();
                    connection.close();

                    textPanel.appendText("koneksi selesai \n");

                } catch (SQLException s) {
                    s.printStackTrace();
                }

                // System.out.println(e.getGender());
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(1100, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void printMap(Map map) {
        Set s = map.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Double key = (Double) entry.getKey();
            String value = (String) entry.getValue();
            textPanel.appendText(key + " => " + value + "\n");
        } // while
        textPanel.appendText("========================> \n");
    }
}