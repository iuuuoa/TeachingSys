public class ev_KWICSubject extends ev_Subject{
    public void startKWIC(){
        for (int i = 0;i<3;i++){
            super.notifyOneObserver(i);
        }
    }
}
