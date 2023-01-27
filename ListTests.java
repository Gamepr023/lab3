import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

class MyStringChecker implements StringChecker {
    String string;

    public MyStringChecker(String s) {
        string = s;
    }

    public boolean checkString(String s) {
        if (s.equals(string)) {
            return true;
        }
        return false;
    }
}

public class ListTests {
    @Test
    public void testFilter() {
        List<String> list = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        StringChecker sc = new MyStringChecker("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        output.add("a");
        output.add("a");
        output.add("a");
        assertEquals(output, ListExamples.filter(list, sc));
    }

    @Test
    public void testMerge() {
        List<String> list1 = new ArrayList<>();
        list1.add("a"); list1.add("c"); list1.add("d");

        List<String> list2 = new ArrayList<>();
        list2.add("a"); list2.add("b"); list2.add("d"); list2.add("e"); list2.add("f");

        List<String> output = new ArrayList<>();
        output.add("a"); output.add("a"); output.add("b"); output.add("c"); 
        output.add("d"); output.add("d"); output.add("e"); output.add("f");
 
        assertEquals(output, ListExamples.merge(list1,list2));
    }

    @Test
    public void testMerge2() {
        List<String> list1 = new ArrayList<>();
        list1.add("a"); list1.add("c"); list1.add("d"); list1.add("f");

        List<String> list2 = new ArrayList<>();
        list2.add("a"); list2.add("b"); list2.add("e");

        List<String> output = new ArrayList<>();
        output.add("a"); output.add("a"); output.add("b"); output.add("c"); 
        output.add("d"); output.add("e"); output.add("f");
        
        assertEquals(output, ListExamples.merge(list1,list2));
    }
}
