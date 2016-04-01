package com.austinmchau.simplettdice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Austin on 3/31/16.
 */
public class TableViewFragment extends Fragment {

    //
    //Mark: Data Store
    //

    ListView listView;

    List<Map<String, String>> historyList = new ArrayList<>();

    public void addHistory(String entry, String timeStamp) {
        Map<String, String> datum = new HashMap<>(2);
        datum.put("entry", entry);
        datum.put("timestamp", timeStamp);
        historyList.add(0, datum);
        adapter.notifyDataSetChanged();
    }

    SimpleAdapter adapter;


    //
    //Mark: Internal Methods
    //



    //
    //Mark: Fragment Life Cycle
    //

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table_view_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.historyListView);
        adapter = new SimpleAdapter(
                getActivity(),
                historyList,
                android.R.layout.simple_list_item_2,
                new String[] {"entry", "timestamp"},
                new int[] { android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);

        return view;
    }
}