package Interview.solid.Isp;

public class MediaApp {
    public static void main(String[] args) {

        AudioPlayer audio = new MusicPlayer();
        audio.playAudio();

        VideoPlayer video = new MoviePlayer();
        video.playVideo();

        LiveStreaming live = new LiveTvPlayer();
        live.streamLive();

        AdvancedMediaPlayer advanced = new AdvancedMediaPlayer();
        advanced.playAudio();
        advanced.playVideo();
        advanced.streamLive();
    }
}

