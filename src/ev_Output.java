import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ev_Output implements ev_Observer {
    private ArrayList<String> kwicList;
    private BufferedWriter outputFile;
    private String filename;
    public ev_Output(ArrayList<String> kwicList, String filename) {
        this.kwicList = kwicList;
        this.filename = filename;
    }

    @Override
    public void toDo(){
        Iterator<String> it = kwicList.iterator();
        try {
            outputFile = new BufferedWriter(new FileWriter(filename));
            while (it.hasNext()) {
                outputFile.write(it.next()+"\n");
            }
            outputFile.write("\r\n");//换行
            outputFile.write("--------------事件系统-观察者模式文字说明--------------");
            outputFile.write("\r\n");//换行
            outputFile.write("观察者模式是对象的行为模式，又叫发布-订阅（Publish/Subscribe）模式、模型-视图（Model/View）模式、源-监听器（Source/Listener）模式或从属者（Dependents）模式。\n" +
                    "\n" +
                    "观察者模式一般是一种一对多的关系，可以有任意个（一个或多个）观察者对象同时监听某一个对象。监听的对象叫观察者（后面提到监听者，其实就指观察者，两者是等价的），被监听的对象叫被观察者（Observable，也叫主题 Subject）。被观察者对象在状态或内容发生变化时，会通知所有观察者对象，使它们能够做出相应的变化（如自动更新自己的信息）。");
            outputFile.write("\r\n");//换行
            outputFile.write("\r\n");//换行
            outputFile.write("--------------关键代码--------------");
            outputFile.write("\r\n");//换行
            outputFile.write("public class Subject {\n" +
                    "\n" +
                    "    //观察者数组\n" +
                    "    private List<Observer> vector = new LinkedList<>();\n" +
                    "\n" +
                    "\n" +
                    "    //增加一个观察者\n" +
                    "    public void addObserver(Observer observer) {\n" +
                    "        vector.add(observer);\n" +
                    "    }\n" +
                    "\n" +
                    "    //删除一个观察者\n" +
                    "    public void deleteObserver(Observer observer) {\n" +
                    "        vector.remove(observer);\n" +
                    "    }\n" +
                    "\n" +
                    "    //通知所有观察者\n" +
                    "    public void notifyAllObserver() {\n" +
                    "        for(Observer observer : vector) {\n" +
                    "            observer.toDo();\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    // 通知特定观察者\n" +
                    "    public void notifyOneObserver(int i) {\n" +
                    "        vector.get(i).toDo();\n" +
                    "    }\n" +
                    "\n" +
                    "}\t\n");
            outputFile.write("\r\n");//换行
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (outputFile!=null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
