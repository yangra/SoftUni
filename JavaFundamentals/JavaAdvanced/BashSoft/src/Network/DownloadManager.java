package Network;

import IO.OutputWriter;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadManager {

    public static void downloadOnNewThread(String fileURL){
        Thread thread = new Thread(()->download(fileURL));
        OutputWriter.writeMessageOnNewLine(
                String.format("Worker thread %d started download...", thread.getId()));
        thread.setDaemon(false);
        thread.start();
    }

    public static void download(String fileURL){
        URL url = null;
        ReadableByteChannel rbc = null;
        FileOutputStream fos = null;
        try {
            if(Thread.currentThread().getName().equals("main")) {
                OutputWriter.writeMessageOnNewLine("Started downloading...");
            }

            url = new URL(fileURL);
            rbc = Channels.newChannel(url.openStream());

            String fileName = extractNameOfFile(url.toString());
            File file = new File(SessionData.currentPath +File.separator +fileName);

            fos = new FileOutputStream(file);
            fos.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);

            if(Thread.currentThread().getName().equals("main")) {
                OutputWriter.writeMessageOnNewLine("Download complete.");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            OutputWriter.displayException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            OutputWriter.displayException(e.getMessage());
        }finally{
            try{
                if(fos!=null){
                    fos.close();
                }
                if(rbc != null){
                    rbc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String extractNameOfFile(String fileURL) throws MalformedURLException {
        int indexOfLastSlash = fileURL.lastIndexOf('/');
        if(indexOfLastSlash == -1){
            throw new MalformedURLException(ExceptionMessages.INVALID_PATH);
        }

        return fileURL.substring(indexOfLastSlash+1);
    }
}
