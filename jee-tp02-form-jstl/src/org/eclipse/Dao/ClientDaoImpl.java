package org.eclipse.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.beans.Client;
import org.eclipse.utils.MyConnection;

public class ClientDaoImpl implements GenericDao<Client> {
	
	String table = "client";
	
	@Override
	public Client save(Client client) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into "+table+" (nom,prenom,telephone) values (?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, client.getNom());
				ps.setString(2, client.getPrenom());
				ps.setString(3, client.getTelephone());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					client.setNum(resultat.getInt(1));
					return client;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Client remove(int id) {
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
	
	public Client update(Client client) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update "+table+" set nom = ?, prenom = ?, telephone = ? where num = ? ");
				ps.setString(1, client.getNom());
				ps.setString(2, client.getPrenom());
				ps.setString(3, client.getTelephone());
				ps.setInt(4, client.getNum());
				ps.executeUpdate();
				System.out.println(
						"L'utilisateur avec id " + client.getNum() + " a bien été modifié: " + client.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Client findById(int num) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from "+table+" where num = ? ");
				ps.setInt(1, num);
				ResultSet r = ps.executeQuery();
				if (r.next())
					return new Client(r.getInt("num"), r.getString("nom"), r.getString("prenom"), r.getString("telephone"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Client> getAll() {
		Connection c = MyConnection.getConnection();
		List<Client> listClients = new ArrayList<Client>();
		String sql = "select * from "+table;
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			Client client = null;
			while (rs.next()) {
				client = new Client();
				client.setNum(rs.getInt(1));
				client.setNom(rs.getString(2));
				client.setPrenom(rs.getString(3));
				client.setTelephone(rs.getString(4));
				listClients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClients;
	}

}
