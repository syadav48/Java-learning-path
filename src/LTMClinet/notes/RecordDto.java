package LTMClinet.notes;

record Dto(Integer id, String name){

}
public class RecordDto {
    public static void main(String[] args) {
        Dto dto1 = new Dto(5, "Suber");
        Dto dto2 = new Dto(6, "Dopher");
        System.out.println(dto2.id());
        System.out.println(dto1.name());
    }
}
