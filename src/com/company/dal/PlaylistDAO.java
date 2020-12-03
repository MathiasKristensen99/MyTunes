package com.company.dal;

import com.company.be.Playlist;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    PlaylistSongsDAO PlaylistSongInfo = new PlaylistSongsDAO();
    SQLServerDataSource ds;
}

public PlaylistDAO() throws IOException {
    this.ds = new SQLServerDataSource();
    DatabaseConnectionDAO connectionInfo = new DatabaseConnectionDAO();
    List<String> infoList = connectionInfo.getDatabaseInfo();
    ds.setDatabaseName(infoList.get(0));
    ds.setUser(infoList.get(1));
    ds.setPassword(infoList.get(2));
    ds.setPortNumber(Integer.parseInt(infoList.get(3)));
    ds.setServerName(infoList.get(4));
}
    public List<Playlist> getPlaylists() {
        List<Playlist> Playlists = new ArrayList<>();
}