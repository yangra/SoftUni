package P15;


import java.util.Scanner;

public class URLParcer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String url = scan.nextLine();
        String protocol = "";
        String server = "";
        String resource = "";
        if(url.indexOf("://")!=-1){
           String[] info =  url.split("://");
           protocol = info[0];
           if (info[1].indexOf("/")!=-1){
               String[] info1 = info[1].split("/");
               server = info1[0];
               for (int i = 1; i < info1.length; i++) {
                   resource += info1[i];
                   if ( i!= info1.length-1){
                       resource += "/";
                   }
               }
           }else{
               server = info[1];
           }

        }else{
            if (url.indexOf("/")!=-1){
                String[] info = url.split("/");
                server = info[0];
                for (int i = 1; i < info.length; i++) {
                    resource += info[i];
                    if ( i!= info.length-1){
                        resource += "/";
                    }
                }
            }else{
                server = url;
            }
        }

        System.out.printf("[protocol] = \"%s\"\n",protocol);
        System.out.printf("[server] = \"%s\"\n",server);
        System.out.printf("[resource] = \"%s\"\n",resource);
    }
}
