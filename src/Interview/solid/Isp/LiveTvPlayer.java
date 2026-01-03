package Interview.solid.Isp;

class LiveTvPlayer implements LiveStreaming {

    @Override
    public void streamLive() {
        System.out.println("Streaming live...");
    }
}

