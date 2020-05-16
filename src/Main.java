import services.utils.Format;

public class Main {
    public static void main(String[] args) {

        Format.instance().start(4*40);
        Format.instance().drawLine("id","name","pwd","createtime");
        Format.instance().end();
        Format.instance().drawLine("1","罗志然","oppp","2008-12-29 16:25:46");
//        Format.instance().drawLine("nafsdafme","d","namfasdfe");
        Format.instance().end();
    }
}
