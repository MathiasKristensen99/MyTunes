package com.company.be;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistContainer {
    public class PlaylistsContainer {
        private List<Playlist> playlistsContainer;

        public PlaylistsContainer() {
            playlistsContainer = new ArrayList<>();
        }

        public void loadSongs(File file, int index) throws IOException {
            playlistsContainer.get(index).loadSongs(file);
        }

    }
}
