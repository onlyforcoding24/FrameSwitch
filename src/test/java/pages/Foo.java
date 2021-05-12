package pages;

public class Foo {

    public static void main(String[] args) {

        String a = "23324_fg_dgdg_wer";
        int l = a.lastIndexOf('_');
        System.out.println(a.substring(0,l));
    }
}
