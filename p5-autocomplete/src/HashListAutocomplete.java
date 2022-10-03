import java.util.*;

public class HashListAutocomplete implements Autocompletor {
    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;

    public HashListAutocomplete(String[] terms, double[] weights) {
		if (terms == null || weights == null) {
			throw new NullPointerException("One or more arguments null");
		} else if (terms.length != weights.length) {
            throw new IllegalArgumentException("Arguments are not of equal length");
        }
		
		initialize(terms, weights);
	}

    @Override
    public void initialize(String[] terms, double[] weights) {
        myMap = new HashMap<String, List<Term>>();
        for (int j = 0; j < terms.length; j++) {
            String t = terms[j];
            double w = weights[j];
            int max = MAX_PREFIX;

            if (t.length() < MAX_PREFIX) {
                max = t.length();
            }

            for (int i = 0; i <= max; i++) {
                String prefix = t.substring(0, i);
                Term word = new Term(t, w);

                if (!myMap.containsKey(prefix)) {
                    myMap.put(prefix, new ArrayList<Term>());
                }

                myMap.get(prefix).add(word);
            }
        }

        for (String k : myMap.keySet()) {
            Collections.sort(myMap.get(k), Comparator.comparing(Term::getWeight).reversed());
        }
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if (prefix.length() > MAX_PREFIX) {
            prefix = prefix.substring(0, MAX_PREFIX);
        }

        if (myMap.containsKey(prefix)) {
            List<Term> all = myMap.get(prefix);
            List<Term> list = all.subList(0, Math.min(k, all.size())); 
            return list;
        }

        return new ArrayList<Term>();
    }

    @Override
    public int sizeInBytes() {
        if (mySize == 0) {
            for (String prefix : myMap.keySet()) {
                mySize += prefix.length() * BYTES_PER_CHAR;
            }

            for (Term word : myMap.get("")) {
                mySize += BYTES_PER_DOUBLE;
                mySize += word.getWord().length() * BYTES_PER_CHAR;
            }
        }
        return mySize;
    }
}
