package com.company.dal;

import com.company.be.Playlist;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    PlaylistSongsDAO PlaylistSongInfo = new PlaylistSongsDAO();
    SQLServerDataSource ds;

    public PlaylistDAO() throws IOException {
    }
}