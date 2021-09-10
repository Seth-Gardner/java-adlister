import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySqlAdsDao implements Ads {

    private Connection connection;

    public MySqlAdsDao() throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                Config.getUrl(),
                Config.getUsername(),
                Config.getPassword()
        );
    }



    @Override
    public List<Ad> all() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet ads = statement.executeQuery("SELECT * FROM ads");

        List<Ad> listOfAds = new ArrayList<>();
        while(ads.next()){
            long id = ads.getLong("id");
            long userId = ads.getLong("user_id");
            String title = ads.getString("title");
            String description = ads.getString("description");
            Ad currentAd = new Ad(id, userId, title, description);
            listOfAds.add(currentAd);
        }
        statement.close();
        return listOfAds;
    }

    @Override
    public void insert(Ad ad) throws SQLException {
        String query = "INSERT INTO ads (user_id, title, description) VALUES(" + ad.getUserId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')";

        System.out.println(query);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }
}
