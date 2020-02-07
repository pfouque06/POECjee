package org.eclipse.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.beans.Personne;
import org.eclipse.utils.MyConnection;

public class PersonneDao implements GenericDao<Personne> {
	
	@Override
	public Personne save(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into personne (username,password) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, personne.getUsername());
				ps.setString(2, personne.getPassword());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					personne.setNum(resultat.getInt(1));
					return personne;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Personne remove(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("delete from personne where num = ? ");
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
	
	public Personne update(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update personne set username = ?, password = ? where num = ? ");
				ps.setString(1, personne.getUsername());
				ps.setString(2, personne.getPassword());
				ps.setInt(3, personne.getNum());
				ps.executeUpdate();
				System.out.println(
						"L'utilisateur avec id " + personne.getNum() + " a bien été modifié: " + personne.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Personne findById(int num) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from personne where num = ? ");
				ps.setInt(1, num);
				ResultSet r = ps.executeQuery();
				if (r.next())
					return new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Personne> getAll() {
		Connection c = MyConnection.getConnection();
		List<Personne> listPersonnes = new ArrayList<Personne>();
		String sql = "select * from personne";
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			Personne personne = null;
			while (rs.next()) {
				personne = new Personne();
				personne.setNum(rs.getInt(1));
				personne.setUsername(rs.getString(2));
				personne.setPassword(rs.getString(3));
				listPersonnes.add(personne);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPersonnes;
	}

	@Override
	public boolean validate(Personne o) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		Connection c = MyConnection.getConnection();
		if (c!=null) {
			
			String sql = "select * from personne where username = ? and password = ? ";
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, o.getUsername());
				ps.setString(2, o.getPassword());
				//System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				status = rs.next();
			} catch (SQLException e) {
				// process sql exception
				e.printStackTrace();
			}
		}
		return status;
	}

}
