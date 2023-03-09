import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class Controller {

    private View view;
    private View2 view2;
    private DatabaseConnection databaseConnection;

    public Controller(View view, View2 view2, DatabaseConnection databaseConnection) {
        this.view = view;
        this.view2 = view2;
        this.databaseConnection = databaseConnection;

        this.view.addEx3aListener(new Ex3aListener());
        this.view2.addBackListener(new Back());
        this.view.addEx3bListener(new Ex3bListener());
        this.view.addEx4aListener(new Ex4aListener());
        this.view.addEx4bListener(new Ex4bListener());
        this.view.addEx5aListener(new Ex5aListener());
        this.view.addEx5bListener(new Ex5bListener());
        this.view.addEx6aListener(new Ex6aListener());
        this.view.addEx6bListener(new Ex6bListener());
    }

    class Ex3aListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("am apasa butonul 3a");
                String query = "SELECT an, titlu, durata,gen,studio, id_producator  FROM film WHERE gen='SF' AND an>1990 ORDER BY an ASC, titlu ASC;";

                Connection connection = databaseConnection.getConnection();

                ResultSet resultSet = connection.createStatement().executeQuery(query);
                String rez = "";
                while (resultSet.next()) {

                    rez += resultSet.getString("titlu") + "  " + resultSet.getInt("an") +
                            "   " + resultSet.getInt("durata") + "   " +
                            "   " + resultSet.getString("gen") + "   " + resultSet.getString("studio") +
                            "   " + resultSet.getInt("id_producator") +
                            "\n";


                }
                if (rez.equals("")) {
                    rez = "Nu exista";
                }
                view2.setTextArea(rez);
                view2.setVisible(true);
                System.out.println(rez);
                /*
                setezi view2 pe setVisible true
                si ii setezi textArea-ul cu rez
                      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 */

            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("ceva nu a mers okay");
            }

        }
    }

    class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view2.dispose();

        }
    };

    class Ex3bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                System.out.println("Am apasat butonul 3b");
                String query = "SELECT nume, sex, castig_net, moneda,id_persoana,data_nasterii,moneda,adresa FROM persoana WHERE sex = 'F' AND moneda = 'USD' AND castig_net > 1000000 ORDER BY nume ASC";

                Connection connection = databaseConnection.getConnection();
                ResultSet resultSet = connection.createStatement().executeQuery(query);
                String rez = "";
                while (resultSet.next()) {        //for accessing results by column label

                    rez += resultSet.getInt("id_persoana") +
                            "    " + resultSet.getString("nume") + "  " +
                            "   " + resultSet.getString("adresa") + "   " +
                            "   " + resultSet.getString("sex") + "   " + resultSet.getString("data_nasterii") +
                            "   " + resultSet.getInt("castig_net") + "  " +
                            "   " + resultSet.getString("moneda") + "\n";


                }
                if (rez.equals("")) {
                    rez = "Nu exista";
                }
                view2.setTextArea(rez);
                view2.setVisible(true);
                System.out.println(rez);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("ceva nu a mers okay");
            }
        }
    }

    class Ex4aListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("Am apasat butonul 4a");
                Connection connection = databaseConnection.getConnection();
                String query = " SELECT s.nume, s.adresa, s.id_presedinte,p.nume,p.sex ,p.adresa,p.data_nasterii,p.castig_net,p.moneda FROM Studio s INNER JOIN Film f ON s.nume=f.studio INNER JOIN Persoana p ON f.id_producator = p.id_persoana WHERE f.titlu = 'Iron Man 3';";
                ResultSet resultSet = connection.createStatement().executeQuery(query);
                String rez = "";
                while (resultSet.next()) {

                    rez += "Detalii studio: "+ " "+ resultSet.getString(1) + " " + resultSet.getString(2) + " " +
                            resultSet.getInt(3) + "  \n Detalii persoana:  " +
                            resultSet.getString(4) +
                            "    " + resultSet.getString(5) + "  " +
                            "   " + resultSet.getString(6) + "   " +
                            "   " + resultSet.getString(7 )+ "   " + resultSet.getInt(8) +
                            "   " + resultSet.getString(9) + "\n";
                }
                if (rez.equals("")) {
                    rez = "Nu exista";
                }
                view2.setTextArea(rez);
                view2.setVisible(true);
                System.out.println(rez);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("ceva nu a mers okay");
            }
        }


    }

    class Ex4bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("Am apasat butonul 4b");
                Connection connection = databaseConnection.getConnection();
   String query = "SELECT p1.nume,d.id_actor,p2.nume,d2.id_actor,d.titlu_film, d.an_film, p1.sex,p2.nume,p2.sex  FROM Persoana p1  INNER JOIN Persoana p2 ON p1.sex!=p2.sex LEFT JOIN Distributie d ON p1.id_persoana=d.id_actor LEFT JOIN Distributie d2 ON p2.id_persoana=d2.id_actor WHERE d.titlu_film=d2.titlu_film AND d.an_film=d2.an_film";
                                //String query = "SELECT * FROM `distributie`  left JOIN persoana ON persoana.id_persoana = distributie.id_actor WHERE titlu_film = 'Hal B.Wallis';";

                ResultSet resultSet = connection.createStatement().executeQuery(query);
                String rez = "";
                while (resultSet.next()) {

                    rez += resultSet.getString(1) + "  " + resultSet.getInt(2) + "\n";
                }
                if (rez.equals("")) {
                    rez = "Nu exista";
                }
                view2.setTextArea(rez);
                view2.setVisible(true);
                System.out.println(rez);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("ceva nu a mers okay");
            }
        }
    }

    class Ex5aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                System.out.println("Am apasat butonul 5a");
                Connection connection = databaseConnection.getConnection();

                String query = " SELECT * FROM film WHERE EXISTS (SELECT * FROM distributie WHERE distributie.id_actor = film.id_producator);";

                ResultSet resultSet = connection.createStatement().executeQuery(query);
                String rez = "";
                while (resultSet.next()) {

                    rez += resultSet.getString("titlu") + "  " + resultSet.getInt("an") +
                            "   " + resultSet.getInt("durata") + "   " +
                            "   " + resultSet.getString("gen") + "   " + resultSet.getString("studio") +
                            "   " + resultSet.getInt("id_producator") + "\n";
                }
                if (rez.equals("")) {
                    rez = "Nu exista";
                }
                view2.setTextArea(rez);
                view2.setVisible(true);
                System.out.println(rez);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("ceva nu a mers okay");
            }
        }
    }

    class Ex5bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                System.out.println("Am apasat butonul 5b");
                Connection connection = databaseConnection.getConnection();
                String query = "SELECT titlu, an, gen ,studio, durata,id_producator FROM Film WHERE durata >= ALL(SELECT durata FROM Film)";

                ResultSet resultSet = connection.createStatement().executeQuery(query);
                String rez = "";
                while (resultSet.next()) {

                    rez += resultSet.getString("titlu") + "  " + resultSet.getInt("an") +
                            "   " + resultSet.getInt("durata") + "   " +
                            "   " + resultSet.getString("gen") + "   " + resultSet.getString("studio") +
                            "   " + resultSet.getInt("id_producator") + "\n";
                }
                if (rez.equals("")) {
                    rez = "Nu exista";
                }
                view2.setTextArea(rez);
                view2.setVisible(true);
                System.out.println(rez);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("ceva nu a mers okay");
            }
        }
    }

    class Ex6aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                System.out.println("Am apasat butonul 6a");
                Connection connection = databaseConnection.getConnection();
                String query = "SELECT  COUNT(*)  FROM distributie WHERE EXISTS(SELECT * FROM film  WHERE distributie.titlu_film=film.titlu AND film.gen = 'comedie');";
                //IMI ARATA id_actor;???????????
                ResultSet resultSet = connection.createStatement().executeQuery(query);
                String rez = "";
                while (resultSet.next()) {

                    rez += resultSet.getInt(1) + "   " + "\n";

                }
                if (rez.equals("")) {
                    rez = "Nu exista";
                }
                view2.setTextArea(rez);
                view2.setVisible(true);
                System.out.println(rez);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("ceva nu a mers okay");
            }
        }
    }

    class Ex6bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                System.out.println("Am apasat butonul 6b");
                Connection connection = databaseConnection.getConnection();
                String query = "SELECT  MIN(castig_net), AVG(castig_net),MAX(castig_net) FROM persoana JOIN studio ON studio.id_presedinte=persoana.id_persoana;";
                ResultSet resultSet = connection.createStatement().executeQuery(query);
                String rez = "";
                while (resultSet.next()) {

                    rez += "MIN= "+ resultSet.getInt(1) + "\n"+
                            "AVG= " + resultSet.getInt(2) +  "\n"+"MAX= " + resultSet.getInt(3) + "\n";

                }
                if (rez.equals("")) {
                    rez = "Nu exista";
                }
                view2.setTextArea(rez);
                view2.setVisible(true);
                System.out.println(rez);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("ceva nu a mers okay");
            }
        }
    }

}