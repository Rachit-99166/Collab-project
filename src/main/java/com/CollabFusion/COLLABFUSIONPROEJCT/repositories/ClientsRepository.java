package com.CollabFusion.COLLABFUSIONPROEJCT.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.CollabFusion.COLLABFUSIONPROEJCT.models.Client;

@Repository
public class ClientsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> getClients() {
        var clients = new ArrayList<Client>();
        String sql = "SELECT * FROM clients ORDER BY id ASC";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            Client client = new Client();
            client.setId(rows.getInt("id"));
            client.setTitle(rows.getString("title"));
            client.setContributorName(rows.getString("contributor_name"));
            client.setEmail(rows.getString("email"));
            client.setPublisherName(rows.getString("publisher_name"));
            client.setCreatedAt(rows.getString("created_at"));
            clients.add(client);
        }
        return clients;
    }

    // public Client getClient(int id) {
    //     String sql = "SELECT * FROM clients WHERE id = ?";
    //     SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
    //     if (rows.next()) {
    //         Client client = new Client();
    //         client.setId(rows.getInt("id"));
    //         client.setTitle(rows.getString("title"));
    //         client.setContributorName(rows.getString("contributor_name"));
    //         client.setEmail(rows.getString("email"));
    //         client.setPublisherName(rows.getString("publisher_name"));
    //         client.setCreatedAt(rows.getString("created_at"));
    //         return client;
    //     }
    //     return null;
    // }
    // public Client createClient(Client client) {
    //     String sql = "INSERT INTO clients (title, contributor_name, email," + " publisher_name, created_at) VALUES (?, ?, ?, ?, ?)";
    //     int count = jdbcTemplate.update(
    //             sql,
    //             client.getTitle(),
    //             client.getContributorName(),
    //             client.getEmail(),
    //             client.getPublisherName(),
    //             client.getCreatedAt());
    //     if (count > 0) {
    //         int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    //         return getClient(id);
    //     }
    //     return null;
    // }
    // public Client updateClient(Client client) {
    //     String sql = "UPDATE clients SET title = ?, contributor_name = ?, email = ?," + "publisher_name = ?, created_at = ? WHERE id = ?";
    //     jdbcTemplate.update(sql,
    //             client.getTitle(),
    //             client.getContributorName(),
    //             client.getEmail(),
    //             client.getPublisherName(),
    //             client.getCreatedAt(),
    //             client.getId());
    //     return getClient(client.getId());
    // }
}
