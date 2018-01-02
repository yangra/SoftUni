package main.bg.softuni.network;

public interface AsynchDownloader extends Downloader{

    void downloadOnNewThread(String fileUrl);
}
