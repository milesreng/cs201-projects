import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private HashMap<WordGram, ArrayList<String>> myMap;

    public EfficientWordMarkov() {
        this(3);
    }

    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }

    @Override
    public void setTraining(String text) {
        super.setTraining(text);
		myMap.clear();

        for (int i = 0; i <= myWords.length - myOrder; i++) {
            WordGram wg = new WordGram(myWords, i, myOrder);
            myMap.putIfAbsent(wg, new ArrayList<String>());
            
            if (i + myOrder < myWords.length) {
                String word = myWords[i + myOrder];
                myMap.get(wg).add(word);
            } else {
                myMap.get(wg).add(PSEUDO_EOS);
            }
        }
    }

    @Override
	public ArrayList<String> getFollows(WordGram wg) {
		if (!myMap.containsKey(wg)) {
			throw new NoSuchElementException(wg.toString() + " not in map");
		}
		return myMap.get(wg);
	}	
}
