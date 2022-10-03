import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	public EfficientMarkov(){
		this(3);
	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();
		
		for (int i = 0; i <= myText.length() - this.myOrder; i++) {
			String kgram = myText.substring(i, i + this.myOrder);
			myMap.putIfAbsent(kgram, new ArrayList<String>());

			if (i + this.myOrder < myText.length()) {
				String ch = myText.substring(i + this.myOrder, i + this.myOrder + 1);
				myMap.get(kgram).add(ch);
			} else {
				myMap.get(kgram).add(PSEUDO_EOS);
			}
		}
	}


	@Override
	public ArrayList<String> getFollows(String key) {
		if (!myMap.containsKey(key)) {
			throw new NoSuchElementException(key + " not in map");
		}
		return myMap.get(key);
	}	
}
