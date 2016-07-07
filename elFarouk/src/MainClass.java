
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamal Rashad
 */
public class MainClass {
    public static void main(String[] args) {
        mac();
    }

    public static void mac()
    {
        InetAddress ip;
	try {
			
		ip = InetAddress.getLocalHost();
//1-
//                System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
		
//                2-
//		System.out.print("Current MAC address : "+mac);
//                JOptionPane.showMessageDialog(null, mac);
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
                
                // هنطبع ال3-  Sb 
//                System.out.println("");
//                System.out.println(sb);
                if(sb.toString().equalsIgnoreCase("00-19-BB-E1-E5-67")){
                   
                     login l =new login();
       l.setVisible(true);
		//System.out.println(sb.toString());
             }
                else{
                    JOptionPane.showMessageDialog(null, "من  فضلك الرجوع لمالك البرنامج  01200078037");
                }
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
    }
}
