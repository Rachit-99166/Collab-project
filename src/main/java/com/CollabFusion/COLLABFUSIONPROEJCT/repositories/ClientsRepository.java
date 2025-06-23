package com.CollabFusion.COLLABFUSIONPROEJCT.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.CollabFusion.COLLABFUSIONPROEJCT.models.Client;

@Repository
public class ClientsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> getClients() {
        // var clients = new ArrayList<Client>();
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients ORDER BY id ASC";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);  //SqlRowSet is same as jdbc ResultSet
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
}
