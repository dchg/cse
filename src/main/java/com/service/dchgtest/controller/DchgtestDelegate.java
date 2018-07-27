package com.service.dchgtest.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.Enumeration;

@Component
public class DchgtestDelegate
{

    public String helloworld(String name)
    {
        String result = "name: " + name;

        result = result + ". \nLocal time: " + new Date();

        File file = new File(name);
        if (file.isDirectory())
        {
            result = result + ". \nFile list:";
            for (File f : file.listFiles())
            {
                result = result + " " + f.getName();
            }
        }
        if (file.isFile() && file.canRead())
        {
            try
            {
                result = result + ". \nFile content: " + FileUtils.readFileToString(file);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        Enumeration<NetworkInterface> netInterfaces = null;
        try
        {
            result = result + ". \nHostname: " + InetAddress.getLocalHost().getHostName();
            netInterfaces = NetworkInterface.getNetworkInterfaces();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        result = result + ". \nIp list:";
        while (netInterfaces != null && netInterfaces.hasMoreElements())
        {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> ips = ni.getInetAddresses();
            while (ips.hasMoreElements())
            {
                InetAddress ip = ips.nextElement();
                if (!ip.isLoopbackAddress() && ip instanceof Inet4Address)
                {
                    String address = ip.getHostAddress();
                    result = result + " " + address;
                }
            }
        }

        return result;
    }
}
