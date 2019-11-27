package TaskColLections;

import java.util.*;

public class CharList {

    private List<Character> charList;


    public CharList(String input) {
        charList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            charList.add(c);
        }
    }

    private CharList(List<Character> inputList) {
        charList = inputList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charList) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();

    }

    public int length() {
        return charList.size();
    }

    public char charAt(int index) {
        return charList.get(index);
    }

    public int indexOf(char inputChar) {
        return charList.indexOf(inputChar);
    }

    public CharList subString(int start, int end) {
        return new CharList(charList.subList(start, end));
    }

    public CharList removeDuplicates() {
        Set<Character> clearList = new HashSet<>(charList);
        return new CharList(new ArrayList<>(clearList));
    }

    public CharList replaceFirst(char inputChar) {
        charList.remove(charList.indexOf(inputChar));
        return new CharList(charList);
    }

    public CharList removeAll(char inputChar) {
        List<Character> toClear = new ArrayList<>(charList);
        List<Character> clearBy = new ArrayList<>();
        clearBy.add(inputChar);
        toClear.removeAll(clearBy);
        return new CharList(toClear);
    }

    public boolean isEmpty() {
        return charList.isEmpty();
    }

    public boolean contains(char inputChar) {
        return charList.contains(inputChar);
    }

    public CharList clearList() {
        List<Character> listToBeCleared = new ArrayList<>(charList);
        listToBeCleared.clear();
        return new CharList(charList);
    }

    public CharList sortList() {
        List<Character> listToBeSorted = new ArrayList<>(charList);
        Collections.sort(listToBeSorted);
        return new CharList(listToBeSorted);
    }

    public CharList reverseList() {
        List<Character> listToBeReversed = new ArrayList<>(charList);
        Collections.reverse(listToBeReversed);
        return new CharList(listToBeReversed);
    }

    public CharList mixedList() {
        List<Character> listToBeMixed = new ArrayList<>(charList);
        Collections.shuffle(listToBeMixed);
        return new CharList(listToBeMixed);
    }
}

