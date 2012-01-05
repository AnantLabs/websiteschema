/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package websiteschema.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author ray
 */
public class CollectionUtil {

    public static <T extends Comparable> List<Entry<String, T>> sortMapDesc(
            Map<String, T> keywordMap) {
        List<Entry<String, T>> arrayList = new ArrayList<Entry<String, T>>(
                keywordMap.entrySet());
        Collections.sort(arrayList, new Comparator<Entry<String, T>>() {

            @Override
            public int compare(Entry<String, T> e1,
                    Entry<String, T> e2) {
                return (e2.getValue()).compareTo(e1.getValue());
            }
        });
//        for (Entry<String, T> entry : arrayList) {
//            System.out.println(entry.getKey() + "  " + entry.getValue());
//        }
        return arrayList;
    }

    public static String toString(Collection<String> c) {
        StringBuilder sb = new StringBuilder();
        for (String s : c) {
            sb.append(s).append(",");
        }
        if (sb.toString().endsWith(",")) {
            return sb.substring(0, sb.length() - 1);
        } else {
            return sb.toString();
        }
    }

    public static void main(String args[]) {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("a", 0.1);
        map.put("b", 0.1);
        map.put("c", 0.2);
        List<Entry<String, Double>> sorted = CollectionUtil.sortMapDesc(map);
        for (Entry<String, Double> entry : sorted) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}
