package datastructures.array;

public class MyString extends MyArray<Character> {

    public MyString(String string) {
        super();

        for (int i = 0; i < string.length(); i++) {
            push(string.charAt(i));
        }
    }

    public void reverse() {
        if (length >= 2) {
            for (int i = 0; i < length / 2; i++) {
                int pos = length - i - 1;
                Character t = get(pos);
                set(pos, get(i));
                set(i, t);
            }
        }
    }

    public static void main(String[] args) {
        MyString string = new MyString("Hi - my name is Aadi!");
        string.reverse();
        System.out.println(string);
    }
}
