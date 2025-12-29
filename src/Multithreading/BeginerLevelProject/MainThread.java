package Multithreading.BeginerLevelProject;

public class MainThread {
    public static void main(String[] args) {
        MusicThread musicThread = new MusicThread();
        ClockThread clockThread = new ClockThread();
        DownloadThread downloadThread = new DownloadThread();
        musicThread.start();
        clockThread.start();
        downloadThread.start();
    }
}
