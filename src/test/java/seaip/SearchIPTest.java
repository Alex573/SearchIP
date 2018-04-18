package seaip;

import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SearchIPTest {

    private ArrayList<String> listTest = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        listTest.add("192.168.0.2");
        listTest.add("192.168.0.3");
        listTest.add("192.168.0.4");
        listTest.add("192.168.0.5");
        listTest.add("192.168.0.6");
        listTest.add("192.168.0.7");
        listTest.add("192.168.0.8");
    }

    @Test
    public void findList() throws UnknownHostException {
        ArrayList<String> checkList = SearchIP.getIpList("192.168.0.1","192.168.0.9");
        assertEquals("The list is incorrct",listTest,checkList);

    }
    @Test
    public void findListDescending() throws UnknownHostException {
        ArrayList<String> checkList = SearchIP.getIpList("192.168.0.9","192.168.0.1");
        assertEquals("The list is incorrct",listTest,checkList);
    }
    @Test(expected = UnknownHostException.class)
    public void cathExeption() throws UnknownHostException {
        ArrayList<String> checkList = SearchIP.getIpList("test","999.888.777.6666");

    }

}