package c16_moderate.c6_frequencyOfNames;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

public class FrequencyOfNames {
    private static class Pairs {
        public String n1;
        public String n2;


        public Pairs(String n1, String n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        public boolean contains(String s) {
            return n1.equals(s) || n2.equals(s);
        }

        @Override
        public String toString() {
            return "Pairs{" +
                    "n1='" + n1 + '\'' +
                    ", n2='" + n2 + '\'' +
                    '}';
        }
    }

    public static class NameFrequency {
        public String name;
        public int freq;

        public NameFrequency(String name, int freq) {
            this.name = name;
            this.freq = freq;
        }
    }


    public static HashMap<String, Integer> getFrequencyOfNames(ArrayList<NameFrequency> names,
                                                               ArrayList<Pairs> pairs) {
        //Each name
        //Check to see if it is in our hashmap of names, to Frequenccy Map contains value;
        //if yes, get the map and increment the counter.
        //if no look for it in the list of pairs and all of its
        HashMap<String, Integer> nameToFreq = new HashMap<>();
        HashMap<String, String> nameToMapKey = new HashMap<>();


        for (NameFrequency name : names) {
            if (!nameToMapKey.containsKey(name.name)) {
                HashSet<String> similarName = getSimilarNames(name.name, pairs);
                //Map all these names to one name:
                for (String s : similarName)
                    nameToMapKey.put(s, name.name);
                nameToFreq.put(name.name, name.freq);
            } else {
                String key = nameToMapKey.get(name.name);
                int current = nameToFreq.get(key);
                current += name.freq;
                nameToFreq.replace(key, current);
            }
        }
        return nameToFreq;
    }

    public static HashSet<String> getSimilarNames(String name, ArrayList<Pairs> pairs) {
        HashSet<String> result = new HashSet<>();
        ArrayList<Pairs> toRemove = new ArrayList();
        Queue<String> q = new ArrayDeque();
        q.add(name);
        while (!q.isEmpty()) {
            String current = q.remove();
            result.add(current);
            for (Pairs p : pairs) {
                if (p.contains(current)) {
                    String matchingName = current == p.n1 ? p.n2 : p.n1;
                    if (!result.contains(matchingName))
                        q.add(matchingName);
                    toRemove.add(p);//Remove this pair from future iterations
                }
            }
            pairs.removeAll(toRemove);
        }
        return result;
    }

    @Test
    public void nameFrequencies() {
        NameFrequency n1 = new NameFrequency("John", 15);
        NameFrequency n2 = new NameFrequency("Jon", 12);
        NameFrequency n3 = new NameFrequency("Hana", 13);
        NameFrequency n4 = new NameFrequency("Hanna", 4);
        NameFrequency n5 = new NameFrequency("Hannah", 19);

        ArrayList<NameFrequency> names = new ArrayList<>();
        names.add(n1);
        names.add(n2);
        names.add(n3);
        names.add(n4);
        names.add(n5);

        Pairs p1 = new Pairs("John", "Johnny");
        Pairs p2 = new Pairs("Johnny", "Jon");
        Pairs p3 = new Pairs("Jon", "John");
        Pairs p4 = new Pairs("Hana", "Hanna");
        Pairs p5 = new Pairs("Hana", "Hannah");

        ArrayList<Pairs> pairs = new ArrayList<>();
        pairs.add(p1);
        pairs.add(p2);
        pairs.add(p3);
        pairs.add(p4);
        pairs.add(p5);


        HashMap<String, Integer> actual = getFrequencyOfNames(names, pairs);

        Assert.assertEquals(2, actual.size());
        Assert.assertTrue(actual.containsValue(27));
        Assert.assertTrue(actual.containsValue(36));
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FrequencyOfNames.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}