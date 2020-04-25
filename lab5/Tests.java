/*import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class Tests {

    @Test
    public void GOLTEST1(){

        List<String> MyListResult=new ArrayList<>();
        List<String> MyList=new ArrayList<>();
        int times = 3;
       
        MyList.add("0");MyList.add("1");MyList.add("0");
        MyList.add("0");MyList.add("1");MyList.add("1");
        MyList.add("0");MyList.add("0");MyList.add("0");
        MyList.add("0");MyList.add("1");MyList.add("1");
        MyList.add("0");MyList.add("0");MyList.add("1");
        MyList.add("0");MyList.add("0");MyList.add("1");
        MyList.add("0");MyList.add("1");MyList.add("0");
       
        GOL g = new GOL(MyList,times);

        MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");
        MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");
        MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");MyListResult.add("0");
        MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");
        MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");
        MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");
        MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");

        assertEquals(MyListResult,g);
    }

    @Test
    public void GOLTEST2(){

        List<String> MyListResult=new ArrayList<>();
        List<String> MyList=new ArrayList<>();
        int times = 2;

        MyList.add("0");MyList.add("0");MyList.add("0");MyList.add("0");
        MyList.add("0");MyList.add("0");MyList.add("0");MyList.add("0");
        MyList.add("0");MyList.add("0");MyList.add("0");MyList.add("0");

        GOL g = new GOL(MyList,times);

        MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");
        MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");
        MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");

        assertEquals(MyListResult,g);
    }

    @Test
    public void GOLTEST3(){

        List<String> MyListResult=new ArrayList<>();
        List<String> MyList=new ArrayList<>();
        int times = 3;

        MyList.add("1");MyList.add("1");MyList.add("1");MyList.add("1");
        MyList.add("0");MyList.add("0");MyList.add("0");MyList.add("0");
        MyList.add("0");MyList.add("0");MyList.add("0");MyList.add("0");

        GOL g = new GOL(MyList,times);

        MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");
        MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");
        MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");

        assertEquals(MyListResult,g);
    }

    @Test
    public void GOLTEST4(){

        List<String> MyListResult=new ArrayList<>();
        List<String> MyList=new ArrayList<>();
        int times = 4;

        MyList.add("0");MyList.add("1");MyList.add("0");
        MyList.add("0");MyList.add("1");MyList.add("0");
        MyList.add("0");MyList.add("1");MyList.add("0");
        MyList.add("0");MyList.add("1");MyList.add("0");
        MyList.add("0");MyList.add("1");MyList.add("0");

        GOL g = new GOL(MyList,times);

        MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");
        MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");
        MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");
        MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");
        MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");

        assertEquals(MyListResult,g);
    }

    @Test
    public void GOLTEST5(){

        List<String> MyListResult=new ArrayList<>();
        List<String> MyList=new ArrayList<>();
        int times = 3;

        MyList.add("1");MyList.add("1");MyList.add("1");
        MyList.add("0");MyList.add("1");MyList.add("1");
        MyList.add("0");MyList.add("0");MyList.add("1");

        GOL g = new GOL(MyList,times);

        MyListResult.add("0");MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");
        MyListResult.add("1");MyListResult.add("0");MyListResult.add("1");MyListResult.add("0");
        MyListResult.add("1");MyListResult.add("0");MyListResult.add("0");MyListResult.add("1");
        MyListResult.add("0");MyListResult.add("1");MyListResult.add("1");MyListResult.add("0");

        assertEquals(MyListResult,g);
    }
}*/