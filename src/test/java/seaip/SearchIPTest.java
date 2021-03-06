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

    /**
     * IP address lookup check in order
     *
     * @throws UnknownHostException when line is not ip address
     */
    @Test
    public void findList() throws UnknownHostException {
        ArrayList<String> checkList = SearchIP.getIpList("192.168.0.1", "192.168.0.9");
        assertEquals("The list is incorrct", listTest, checkList);
    }

    /**
     * Reverse ip address lookup check
     *
     * @throws UnknownHostException when line is not ip address
     */
    @Test
    public void findListDescending() throws UnknownHostException {
        ArrayList<String> checkList = SearchIP.getIpList("192.168.0.9", "192.168.0.1");
        assertEquals("The list is incorrct", listTest, checkList);
    }

    /**
     * Error throwing check in case of incorrect ip address entered
     *
     * @throws UnknownHostException when line is not ip address
     */
    @Test(expected = UnknownHostException.class)
    public void cathExeption() throws UnknownHostException {
        ArrayList<String> checkList = SearchIP.getIpList("test", "999.888.777.6666");

    }

}