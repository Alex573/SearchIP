package seaip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchIP {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first IP address: ");
        String ip1 = in.nextLine();
        System.out.println("Enter second IP address: ");
        String ip2 = in.nextLine();
        in.close();
        try {
            getIpList(ip1, ip2).forEach(System.out::println);
        } catch (UnknownHostException e) {
            System.out.println("Incorrectly entered IP address");
        }


    }

    public static ArrayList<String> getIpList(String ip1, String ip2) throws UnknownHostException {

        ArrayList<String> list = new ArrayList<>();

        long l1 = SearchIP.ipToLong(ip1);
        long l2 = SearchIP.ipToLong(ip2);

        long res = Math.abs(l1 - l2);

        long longStart = l2 > l1 ? l1 : l2;

        for (long i = 1; i < res; i++) {
            list.add(SearchIP.longToIp(longStart + i));
        }

        return list;
    }


    private static long ipToLong(String stringIp) throws UnknownHostException {

        InetAddress address = InetAddress.getByName(stringIp);

        ByteBuffer bb = ByteBuffer.wrap(address.getAddress());

        return (long) bb.getInt();
    }

    private static String longToIp(long longIp) throws UnknownHostException {

        ByteBuffer bb = ByteBuffer.allocate(4).putInt((int) longIp);

        InetAddress address = InetAddress.getByAddress(bb.array());

        return address.getHostAddress();
    }
}

