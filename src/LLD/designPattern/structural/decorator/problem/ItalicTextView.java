package LLD.designPattern.structural.decorator.problem;

class ItalicTextView implements TextView {
    @Override
    public void render() {
        System.out.print("Rendering italic text");
    }
}
