package br.ifrs.so;

import java.io.*;


/**
 *
 * @author 0300152
 */
public class Main {

    public static void main(String args[]) {

        String s = null;

        try {
            
	    // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("ps -ef");
            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                String extensao = s.substring(s.indexOf(".")+1,s.length());
                
                switch (extensao){
                    case "mp3":
                        p = Runtime.getRuntime().exec("mv "+s+" /Músicas");
                        break;
                    case "mp4":
                        p = Runtime.getRuntime().exec("mv "+s+" /Vídeos");
                        break;
                    case "txt":
                    case "xls":
                    case "docx":
                        p = Runtime.getRuntime().exec("mv "+s+" /Documentos");
                        break;
                }
                System.out.println("Entensão:" + extensao);
                
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                
            }
            
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
        /*String x= "arquivo.mp4";
        String teste = x.substring(x.indexOf(".")+1,x.length());
        System.out.println("Entensão:" + teste);*/
    }
}