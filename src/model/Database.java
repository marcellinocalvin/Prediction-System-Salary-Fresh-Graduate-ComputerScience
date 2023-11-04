package model;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database {

    private List<Person> people;

    private Connection con;

    public Database() {

        people = new LinkedList<Person>();
    }

    public void connect() throws Exception {

        if(con != null) return;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }

        String url = "jdbc:mysql://localhost:3306/dataset";

        con = DriverManager.getConnection(url, "root", "");
    }

    public void disconnect() {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection");
            }
        }
    }

    public void save() throws SQLException {

        String checkSql = "select count(*) as count from people where id=?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);

        String insertSql = "insert into people (id, gender, pendidikan_akhir, keaktifan_organisasi, bidang_kompetensi, pengalaman_akademik, sertifikasi_keahlian, sertifikasi_bootcamp, ipk, pengalaman_magang, kemampuan_b_inggris, gaji) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(insertSql);

        String updateSql = "update people set gender=?, pendidikan_akhir=?, keaktifan_organisasi=?, bidang_kompetensi=?, pengalaman_akademik=?, sertifikasi_keahlian=?, sertifikasi_bootcamp=?, ipk=?, pengalaman_magang=?, kemampuan_b_inggris=?, gaji=? where id=?";
        PreparedStatement updatedStatement = con.prepareStatement(updateSql);

        for(Person person: people) {
            int id = person.getId();
            Gender gender = person.getGender();
            PendidikanAkhirCategory pa = person.getPendidikanAkhirCat();
            KeaktifanOrganisasiCategory ko = person.getKeaktifanOrganisasiCat();
            BidangKompetensiCategory bk = person.getBidangKompetensiCat();
            PengalamanAkademikCategory pk = person.getPengalamanAkademikCat();
            SertifikasiKeahlianCategory sk = person.getSertifikasiKeahlianCat();
            SertifikasiBootcampCategory sb = person.getSertifikasiBootcampCat();
            IPKCategory ip = person.getIpkCat();
            PengalamanMagangCategory pm = person.getPengalamanMagangCat();
            KemampuanBahasaInggrisCategory kb = person.getKemampuanBahasaInggrisCat();
            GajiCategory gaji = person.getGajiCat();

            checkStmt.setInt(1, id);

            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();

            int count = checkResult.getInt(1);

            if(count == 0) {
                System.out.println("Inserting person with ID " + id);

                int col = 1;
                insertStatement.setInt(col++, id);
                insertStatement.setString(col++, gender.name());
                insertStatement.setString(col++, pa.name());
                insertStatement.setString(col++, ko.name());
                insertStatement.setString(col++, bk.name());
                insertStatement.setString(col++, pk.name());
                insertStatement.setString(col++, sk.name());
                insertStatement.setString(col++, sb.name());
                insertStatement.setString(col++, ip.name());
                insertStatement.setString(col++, pm.name());
                insertStatement.setString(col++, kb.name());
                insertStatement.setString(col++, gaji.name());

                insertStatement.executeUpdate();
            }
            else {
                System.out.println("Updating person with ID " + id);

                int col = 1;
                updatedStatement.setString(col++, gender.name());
                updatedStatement.setString(col++, pa.name());
                updatedStatement.setString(col++, ko.name());
                updatedStatement.setString(col++, bk.name());
                updatedStatement.setString(col++, pk.name());
                updatedStatement.setString(col++, sk.name());
                updatedStatement.setString(col++, sb.name());
                updatedStatement.setString(col++, ip.name());
                updatedStatement.setString(col++, pm.name());
                updatedStatement.setString(col++, kb.name());
                updatedStatement.setString(col++, gaji.name());
                updatedStatement.setInt(col++, id);

                updatedStatement.executeUpdate();
            }
        }
        updatedStatement.close();
        insertStatement.close();
        checkStmt.close();
    }

    public void load() throws SQLException {
        people.clear();

        String sql = "select id, gender, pendidikan_akhir, keaktifan_organisasi, bidang_kompetensi, pengalaman_akademik, sertifikasi_keahlian, sertifikasi_bootcamp, ipk, pengalaman_magang, kemampuan_b_inggris, gaji from people order by id";
        Statement selectStatement = con.createStatement();

        ResultSet results = selectStatement.executeQuery(sql);

        while(results.next()) {
            int id = results.getInt("id");
            String gender = results.getString("gender");
            String pendidikanAkhir = results.getString("pendidikan_akhir");
            String keaktifanOrganisasi = results.getString("keaktifan_organisasi");
            String bidangKompetensi = results.getString("bidang_kompetensi");
            String pengalamanAkademik = results.getString("pengalaman_akademik");
            String sertifikasiKeahlian = results.getString("sertifikasi_keahlian");
            String sertifikasiBootcamp = results.getString("sertifikasi_bootcamp");
            String ipk = results.getString("ipk");
            String pengalamanMagang = results.getString("pengalaman_magang");
            String kemampuanBInggris = results.getString("kemampuan_b_inggris");
            String gaji = results.getString("gaji");

            Person person = new Person(id, Gender.valueOf(gender), PendidikanAkhirCategory.valueOf(pendidikanAkhir),
                    KeaktifanOrganisasiCategory.valueOf(keaktifanOrganisasi), BidangKompetensiCategory.valueOf(bidangKompetensi),
                    PengalamanAkademikCategory.valueOf(pengalamanAkademik), SertifikasiKeahlianCategory.valueOf(sertifikasiKeahlian),
                    SertifikasiBootcampCategory.valueOf(sertifikasiBootcamp), IPKCategory.valueOf(ipk),
                    PengalamanMagangCategory.valueOf(pengalamanMagang), KemampuanBahasaInggrisCategory.valueOf(kemampuanBInggris),
                    GajiCategory.valueOf(gaji));
            people.add(person);
        }

        results.close();
        selectStatement.close();
    }

    public void addPerson(Person person) {

        people.add(person);
    }

    public void removePerson(int index) {
        people.remove(index);
    }

    public List<Person> getPeople() {

        return Collections.unmodifiableList(people);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Person[] persons = people.toArray(new Person[people.size()]);

        oos.writeObject(persons);

        oos.close();
    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Person[] persons = (Person[]) ois.readObject();

            people.clear();

            people.addAll(Arrays.asList(persons));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }

}
