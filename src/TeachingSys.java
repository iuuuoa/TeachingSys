import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TeachingSys {
    public static void main(String[] args) throws IOException {
        System.out.println("**********欢迎进入经典软件体系结构教学软件**********");
        while(true) {
            System.out.println("请选择软件体系结构风格：");
            System.out.println("1.主程序-子程序         2.面向对象");
            System.out.println("3.事件系统              4.管道-过滤器");
            System.out.println("5.退出");
            int choose1,choose2;
            Scanner in = new Scanner(System.in);
            choose1 = in.nextInt();

            switch(choose1) {
                case 1:
                    //主程序-子程序
                    demo1 kwic = new demo1();
                    kwic.main1(kwic);
                    kwic.add();

                    System.out.println("是否继续使用：1.是       2.否");
                    choose2 = in.nextInt();
                    if (choose2 == 1){
                        break;
                    } else if (choose2 == 2) {
                        System.out.println("谢谢使用");
                        System.exit(0);//系统退出
                    }

                case 2:
                    //面向对象
                    ob_Input input = new ob_Input();
                    input.input("C:\\Users\\DELL\\Desktop\\input.txt");
                    ob_Shift shift = new ob_Shift(input.getLineTxt());
                    shift.shift();
                    ob_Alphabetizer alphabetizer = new ob_Alphabetizer(shift.getKwicList());
                    alphabetizer.sort();
                    ob_Output output = new ob_Output(alphabetizer.getKwicList());
                    output.output("C:\\Users\\DELL\\Desktop\\output2.txt");
                    output.add();

                    System.out.println("是否继续使用：1.是       2.否");
                   choose2 = in.nextInt();
                    if (choose2 == 1){
                        break;
                    } else if (choose2 == 2) {
                        System.out.println("谢谢使用");
                        System.exit(0);//系统退出
                    }

                case 3:
                    //事件系统
                    ev_KWICSubject kwicSubject = new ev_KWICSubject();
                    //创建观察者
                    ev_Input input3 = new ev_Input("C:\\Users\\DELL\\Desktop\\input.txt");
                    ev_Shift shift3 = new ev_Shift(input3.getLineTxt());
                    ev_Alphabetizer alphabetizer3 = new ev_Alphabetizer(shift3.getKwicList());
                    ev_Output output3 = new ev_Output(alphabetizer3.getKwicList(), "C:\\Users\\DELL\\Desktop\\output3.txt");

                    // 将观察者加入主题
                    kwicSubject.addObserver(input3);
                    kwicSubject.addObserver(shift3);
                    kwicSubject.addObserver(alphabetizer3);
                    kwicSubject.addObserver(output3);
                    // 逐步调用各个观察者
                    kwicSubject.startKWIC();

                    System.out.println("是否继续使用：1.是       2.否");
                    choose2 = in.nextInt();
                    if (choose2 == 1){
                        break;
                    } else if (choose2 == 2) {
                        System.out.println("谢谢使用");
                        System.exit(0);//系统退出
                    }

                case 4:
                    //管道-过滤器
                    File inFile = new File("C:\\Users\\DELL\\Desktop\\input.txt");
                    File outFile = new File("C:\\Users\\DELL\\Desktop\\output4.txt");
                    pf_Pipe pipe1 = new pf_Pipe();
                    pf_Pipe pipe2 = new pf_Pipe();
                    pf_Pipe pipe3 = new pf_Pipe();
                    pf_Input input4 = new pf_Input(inFile, pipe1);
                    pf_Shift shift4 = new pf_Shift(pipe1, pipe2);
                    pf_Alphabetizer alphabetizer4  = new pf_Alphabetizer(pipe2, pipe3);
                    pf_Filter output4 = new pf_Output(outFile,pipe3);
                    input4.transform();
                    shift4.transform();
                    alphabetizer4.transform();
                    output4.transform();

                    System.out.println("是否继续使用：1.是       2.否");
                    choose2 = in.nextInt();
                    if (choose2 == 1){
                        break;
                    } else if (choose2 == 2) {
                        System.out.println("谢谢使用");
                        System.exit(0);//系统退出
                    }

                case 5:
                    //退出
                    System.out.println("谢谢使用");
                    System.exit(0);//系统退出

                default:
                    System.out.println("您输入的操作有误，请重新输入！");
                    break;
            }
        }
    }
}
