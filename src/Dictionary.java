import java.util.ArrayList;
import java.util.Iterator;

/**
 * Incomplete dictionary implementation using an ArrayList.
 * Both key and value are strings.
 * @author Will Brown
 * @version 1.0
 * Fall 2021
 */
public class Dictionary implements DictionaryInterface<String, String> {
	
	private ArrayList<Entry> dictionaryList = new ArrayList<Entry>();

	@Override
	public String add(String key, String value) {
		Entry newEntry = new Entry(key, value);
		//String replacedEntry = null;
		int dictIndex;
		
		// Loop through all entries until one is reached which is either equal to key or ahead of it
		for (dictIndex = 0;
				dictIndex < getSize() && newEntry.compareTo(dictionaryList.get(dictIndex)) > 0;
				dictIndex++);
		
		// Adds the new entry to the proper location in the dictionary, or replaces the value of the existing entry.
		if (dictIndex < getSize())
			if (newEntry.compareTo(dictionaryList.get(dictIndex)) == 0)
				return dictionaryList.set(dictIndex, newEntry).getValue();
			else
				dictionaryList.add(dictIndex, newEntry);
		else
			dictionaryList.add(newEntry);
		
		return null;
	}
	
	/**
	 * Implements the same functionality as add, but does not sort new entries.
	 * @param key An object search key of the new entry.
	 * @param value An object associated with the search key.
	 * @return Either null if the new entry was added to the dictionary
               or the value that was associated with key if that value
               was replaced.
	 */
	public String addUnsorted(String key, String value) {
		for (Entry dictEntry : dictionaryList)
			if (dictEntry.getKey().equals(key)) {
				String replacedValue = dictEntry.getValue();
				dictEntry.setValue(value);
				return replacedValue;
			}
			
		dictionaryList.add(new Entry(key, value));
		return null;
	}

	@Override
	public String remove(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<String> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<String> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		return dictionaryList.size();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Sort the dictionary in alphabetical order.
	 * This uses insertion sort internally.
	 */
	public void sort() {
		SortArrayList.selectionSort(dictionaryList, getSize());
	}
	
	/**
	 * Returns the contents of the dictionary as a string.
	 * This output is usable as the contents of a CSV file with zero alterations.
	 * @return the contents of the dictionary
	 */
	public String toString() {
		String dictionaryString = "";
		for (Entry anEntry : dictionaryList)
			dictionaryString += "\"" + anEntry.getKey() + "\",\"" + anEntry.getValue() + "\"\n";
		
		return dictionaryString;
	}
	
}
