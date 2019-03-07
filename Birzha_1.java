/**
 * Created by student4 on 28.02.19.
 */
public class Birzha_1 extends Main{
    int procent = 1;
    int bir_money = 0;
    public void add(int m){
        if (this.money > m) {
            this.money -= m/procent;
        }
        else {
            System.out.println("You don't have enough money");
        }
    }
    public void sub(int m){
        if (bir_money >= m){
            bir_money -= m;
            m *= procent;
            this.money += m;
        }
    }
}
