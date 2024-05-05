package Models;

public class Admin {

    public Admin(int id, String cin, String firstName, String lastName, String email, String phone){
        super(id,cin,firstName,lastName,email,phone);
    }

    public static Admin get(int id) {
        String query = "SELECT * FROM admins WHERE admin_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return new Admin(
                        result.getInt("admin_id"),
                        result.getString("cin"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("tele")
                );
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    

    public static void update(int id, String cin, String firstName, String lastName, String email, String phone) {
        String query = "UPDATE secretaries SET cin=?,first_name = ?, last_name = ?, email = ?, tele = ? WHERE secretary_id=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
