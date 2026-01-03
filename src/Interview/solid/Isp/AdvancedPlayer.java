package Interview.solid.Isp;

class AdvancedMediaPlayer
        implements AudioPlayer, VideoPlayer, LiveStreaming {

    @Override
    public void playAudio() {
        System.out.println("Playing audio...");
    }

    @Override
    public void playVideo() {
        System.out.println("Playing video...");
    }

    @Override
    public void streamLive() {
        System.out.println("Streaming live...");
    }
}

