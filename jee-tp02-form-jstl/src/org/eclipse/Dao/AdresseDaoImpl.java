package org.eclipse.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.beans.Adresse;
import org.eclipse.utils.MyConnection;

public class AdresseDaoImpl implements GenericDao<Adresse> {
	
	String table = "adresse";
	
	@Override
	public Adresse save(Adresse adresse) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into "+table+" (rue,codepostal,ville,clientID) values (?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, adresse.getRue());
				ps.setString(2, adresse.getCodePostal());
				ps.setString(3, adresse.getVille());
				ps.setInt(4, adresse.getClientID());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					adresse.setNum(resultat.getInt(1));
					return adresse;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Adresse remove(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("delete from "+table+" where num = ? ");
				ps.setInt(1, id);
				int rows = ps.executeUpdate();
				if (rows == 1) {
					System.out.println("Le tuple a bien été supprimé!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Adresse update(Adresse adresse) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update "+table+" set rue = ?, codepostal = ?, ville = ? where num = ? ");
				ps.setString(1, adresse.getRue());
				ps.setString(2, adresse.getCodePostal());
				ps.setString(3, adresse.getVille());
				ps.setInt(4, adresse.getNum());
				ps.executeUpdate();
				//System.out.println("L'utilisateur avec id " + adresse.getNum() + " a bien été modifié: " + adresse.toString());
				return adresse;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Adresse findById(int num) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from "+table+" where num = ? ");
				ps.setInt(1, num);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					return new Adresse(r.getInt("num"), r.getString("rue"), r.getString("codepostal"), r.getString("ville"), r.getInt("clientID"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Adresse> getAll() {
		Connection c = MyConnection.getConnection();
		List<Adresse> listAdresses = new ArrayList<Adresse>();
		String sql = "select * from "+table;
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			Adresse adresse = null;
			while (rs.next()) {
				adresse = new Adresse(rs.getInt("num"), rs.getString("rue"), rs.getString("codepostal"), rs.getString("ville"), rs.getInt("clientID"));
				listAdresses.add(adresse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listAdresses;
	}

}
