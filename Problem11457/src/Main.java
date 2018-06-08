import java.util.LinkedList;
import java.util.Scanner;


class State{
    int count,sT,nT,mT;

    public State(int count, int sT, int nT, int mT) {
        this.count = count;
        this.sT = sT;
        this.nT = nT;
        this.mT = mT;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int s=sc.nextInt();
            int n=sc.nextInt();
            int m=sc.nextInt();
            int nT=0,mT=0,ls=0,ln=0,lm=0;
            byte[][][] x=new byte[101][n+1][m+1];
            x[s][0][0]++;
            if(s==0&&n==0&&m==0) break;
            int count=0;
            LinkedList<State> q=new LinkedList();
            while(true){
                if(nT!=n&&s!=0){
                    if(x[ls=s<(n-nT)?0:s-(n-nT)][ln=n<=(s+nT)?n:nT+s][lm=mT]==0){
                        q.add(new State(count+1,ls,ln,lm));                   //s倒n
//                     System.out.print(ls+" "+ln+" "+lm+"\t");
                    }
                }
                if(mT!=m&&s!=0){
                    if(x[ls=s<(m-mT)?0:s-(m-mT)][ln=nT][lm=(m-mT)<s?m:mT+s]==0){
                        q.add(new State(count+1,ls,ln,lm));                   //s倒m
//                     System.out.print(ls+" "+ln+" "+lm+"\t");
                    }
                }
                if(nT!=0&&s<100){
                    if(x[ls=(nT+s)>100?100:nT+s][ln=nT<(100-s)?0:nT-(100-s)][lm=mT]==0){
                        q.add(new State(count+1,ls,ln,lm));      //n倒s
//                     System.out.print(ls+" "+ln+" "+lm+"\t");
                    }
                }
                if(nT!=0&&mT!=m){
                    if(x[ls=s][ln=nT<(m-mT)?0:nT-(m-mT)][lm=nT<(m-mT)?mT+nT:m]==0){
                        q.add(new State(count+1,ls,ln,lm));           //n倒m
//                     System.out.print(ls+" "+ln+" "+lm+"\t");
                    }
                }
                if(mT!=0&&s<100){
                    if(x[ls=(mT+s)>100?100:mT+s][ln=nT][lm=mT<(100-s)?0:mT-(100-s)]==0){
                        q.add(new State(count+1,ls,ln,lm));      //m倒s
//                     System.out.print(ls+" "+ln+" "+lm+"\t");
                    }
                }
                if(mT!=0&&nT!=n){
                    if(x[ls=s][ln=mT<(n-nT)?mT+nT:n][lm=mT<(n-nT)?0:mT-(n-nT)]==0){
                        q.add(new State(count+1,ls,ln,lm));           //m倒n
//                     System.out.print(ls+" "+ln+" "+lm+"\t");
                    }
                }
                if(q.size()>0){
                    State k =(State) q.poll();
//                     System.out.println(count);
                    s=k.sT;
                    nT=k.nT;
                    mT=k.mT;
//                     System.out.println(s+" "+nT+" "+mT);
                    x[s][nT][mT]++;
                    count=k.count;
                    if(s==(nT+mT)){
                        System.out.println(count);
                        break;
                    }
                }else{
                    System.out.println("NO");
                    break;
                }
            }
        }
    }
}