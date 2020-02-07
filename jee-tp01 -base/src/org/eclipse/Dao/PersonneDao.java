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
				PreparedStatement ps = c.prepareStatement("insert into personne (nom,prenom) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
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
				PreparedStatement ps = c.prepareStatement("update personne set nom = ?, prenom = ? where num = ? ");
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
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
				personne.setNom(rs.getString(2));
				personne.setPrenom(rs.getString(3));
				listPersonnes.add(personne);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPersonnes;
	}

}
