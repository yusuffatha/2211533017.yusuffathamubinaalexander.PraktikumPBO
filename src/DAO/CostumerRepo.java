package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import config.Database;
import model.Costumer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CostumerRepo implements CostumerDAO {
    private Connection connection;
    final String insert = "INSERT INTO costumer (nama, alamat, nohp) VALUES (?,?,?)";
    final String select = "SELECT * FROM costumer";
    final String delete = "DELETE FROM costumer WHERE id = ?";
    final String update = "UPDATE costumer SET nama = ?, alamat = ?, nohp = ? WHERE id = ?";

    public CostumerRepo() {
        connection = Database.koneksi();
    }

    @Override
    public void save(Costumer costumer) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(insert);
            st.setString(1, costumer.getNama());
            st.setString(2, costumer.getAlamat());
            st.setString(3, costumer.getNohp());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                  st.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public List<Costumer> show(){
	    List<Costumer> ls = null;
	    try {
	        ls = new ArrayList<Costumer>();
	        Statement st = connection.createStatement();
	        ResultSet rs = st.executeQuery(select);
	        while(rs.next()) {
	            Costumer costumer = new Costumer();
	            costumer.setId(rs.getString("id"));
	            costumer.setNama (rs.getString("nama"));
	            costumer.setAlamat(rs.getString("alamat"));
	            costumer.setNohp(rs.getString("nohp"));
	            ls.add(costumer);
	        }
	    }catch(SQLException e) {
	        Logger.getLogger(CostumerDAO.class.getName()).log(Level.SEVERE, null, e);
	    }
	    return ls;
	}

	@Override
	public void update (Costumer costumer) {
	    PreparedStatement st = null;
	    try {
	        st = connection.prepareStatement(update);
	        st.setString(1, costumer.getNama());
	        st.setString(2, costumer.getAlamat());
	        st.setString(3, costumer.getNohp());
	        st.setString(4, costumer.getId());
	    }catch(SQLException e) {
	        e.printStackTrace();
	    }finally {
	        try {
	            st.close();
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	    }
	}

	public void delete(String id) {
	    PreparedStatement st = null;
	    try {
	        st = connection.prepareStatement(delete);
	        st.setString(1, id);
	        st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            st.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
