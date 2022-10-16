import java.util.LinkedList;
import java.util.List;

public class ev_Subject {

    //观察者数组
    private List<ev_Observer> vector = new LinkedList<>();


    //增加一个观察者
    public void addObserver(ev_Observer observer) {
        vector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(ev_Observer observer) {
        vector.remove(observer);
    }

    //通知所有观察者
    public void notifyAllObserver() {
        for(ev_Observer observer : vector) {
            observer.toDo();
        }
    }

    // 通知特定观察者
    public void notifyOneObserver(int i) {
        vector.get(i).toDo();
    }

}
