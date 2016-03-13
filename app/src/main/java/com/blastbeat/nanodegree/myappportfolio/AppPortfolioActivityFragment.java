package com.blastbeat.nanodegree.myappportfolio;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class AppPortfolioActivityFragment extends Fragment {
    private static final PortfolioApp sstreamerApp =
            new PortfolioApp("Spotify Streamer", "This button will launch 'Spotify Streamer'!");
    private static final PortfolioApp scoresApp =
            new PortfolioApp("Scores App", "This button will launch 'Scores App'!");
    private static final PortfolioApp libraryApp =
            new PortfolioApp("Library App", "This button will launch 'Library App'!");
    private static final PortfolioApp buildApp =
            new PortfolioApp("Build it Bigger", "This button will launch 'Build it Bigger'!");
    private static final PortfolioApp xyzreaderApp =
            new PortfolioApp("XYZ Reader", "This button will launch 'XYZ Reader'!");
    private static final PortfolioApp capstoneApp =
            new PortfolioApp("Capstone: My own app", "This button will launch my capstone app!", true);

    private static final PortfolioApp apps[] = { sstreamerApp, scoresApp, libraryApp, buildApp, xyzreaderApp, capstoneApp };
    public AppPortfolioActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_app_portfolio, container, false);
        ListView listView = (ListView)rootView.findViewById(R.id.app_list_view);
        PortfolioAppArrayAdapter adapter= new PortfolioAppArrayAdapter(getActivity(), R.layout.app_list_item, apps);
        listView.setAdapter(adapter);
        return rootView;
    }
}
