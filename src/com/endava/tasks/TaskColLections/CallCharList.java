package src.com.endava.tasks.TaskColLections;

public class CallCharList {

    public static void main(String[] args) {

        CharList test = new CharList("acb123123");
        System.out.println("Charlist is: " + test.toString());
        System.out.println("Index is: " + test.indexOf('1'));
        System.out.println("Length is: " + test.length());
        System.out.println("Char is: " + test.charAt(2));
        System.out.println("Substring is: " + test.subString(3, 5));
        System.out.println("Replaced Charlist: " + test.replaceFirst('1'));
        System.out.println("Charlist without duplicates: " + test.removeDuplicates());
        System.out.println("Charlist without occurrences: " + test.removeAll('2'));
        System.out.println("Charlist is empty: " + test.clearList().isEmpty());
        System.out.println("Charlist contains char: " + test.contains('q'));
        System.out.println("Charlist contains char: " + test.contains('a'));
        System.out.println("Cleared charlist: " + test.clearList());
        System.out.println("Sorted charlist: " + test.sortList());
        System.out.println("Reversed charlist: " + test.reverseList());
        System.out.println("Mixed list: " + test.mixedList());

    }
}