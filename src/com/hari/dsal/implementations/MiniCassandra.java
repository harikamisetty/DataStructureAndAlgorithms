package com.hari.dsal.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MiniCassandra {
    Map<String, TreeMap<Integer, Column>> rowMap;
    public MiniCassandra() {
        // do intialization if necessary
        rowMap = new HashMap<>();
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
    */

    public void insert(String row_key, int column_key, String value) {
        // write your code here
        TreeMap<Integer, Column> columnMap = rowMap.getOrDefault(row_key, new TreeMap<>());
        Column column = new Column(column_key, value);
        columnMap.put(column_key, column);
        rowMap.put(row_key, columnMap);
    }

    /*
     * @param row_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String row_key, int column_start, int column_end) {
        if (!rowMap.containsKey(row_key)) {
            return new ArrayList<Column>();
        }

        TreeMap<Integer, Column> columnMap = rowMap.get(row_key);
        NavigableMap<Integer, Column> rangeMap = columnMap.subMap(column_start, true, column_end, true);
        List<Column> ans = new ArrayList<>();
        for (Integer key : rangeMap.keySet()) {
            ans.add(rangeMap.get(key));
        }

        return ans;
    }
}
