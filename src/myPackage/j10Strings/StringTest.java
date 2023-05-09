package myPackage.j10Strings;

public class StringTest {
    public static void main(String[] args) {
//        String str = new String("Hello!");
        String str = "Hello";
        System.out.format("%s, how are you?\n", str); //printf()
//        System.out.println();

//        String Methods
        int x = str.length();
        System.out.println(x);
        String s = str.toUpperCase(); //toLowerCase()
        System.out.println(s);
        String toBeTrimmed = "       High Power      ";
        System.out.println(toBeTrimmed.trim());
        String name2 = "Harry - it's alright";
        System.out.println(name2.replace(" - ",": "));
        String name = "Siddhant";
        System.out.println(name.substring(4,6));  //substring(begIndex) - till end
        System.out.println(name.replace("d","tt"));
    }
}