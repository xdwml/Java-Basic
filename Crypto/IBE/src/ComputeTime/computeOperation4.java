package ComputeTime;
/*
 * 分别计算双线性对运算，G中幂运算，G中乘法运算，Z中幂运算，Z中乘法运算的单次运行时间
 */
import it.unisa.dia.gas.jpbc.*;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
public class computeOperation4 implements ComputeTime3 {
    public Element alpha,beta,g,g_alpha,h,g_hat_alpha,mul,alpha_beta,alphabeta;
    public Pairing pairing;
    public computeOperation4() {
        pairing = PairingFactory.getPairing("a.properties");//
        alpha = pairing.getZr().newElement().setToRandom();//随机选取的指数α
        beta = pairing.getZr().newElement().setToRandom();//随机选取的β
        g = pairing.getG1().newElement().setToRandom();//G1的生成元g
        g_alpha = g.duplicate().powZn(alpha);//g^α
        /*System.out.println("alpha  =" + alpha);
        System.out.println("beta   =" + beta);
        System.out.println("g      =" + g);
        System.out.println("g_alpha=" + g_alpha );    */
        System.out.println("-------------------单次运算时间对比----------------------");
    }
    @Override
    public void computePair() {
        //System.out.println("-------------------双线性对操作----------------------");
        g_hat_alpha = pairing.pairing(g, g_alpha);//e(g,g)^α
        // System.out.println("g_hat_alpha=" + g_hat_alpha);
    }
    @Override
    public void computePowG() {
        // System.out.println("-------------------G幂运算----------------------");
        h  = g.duplicate().powZn(beta);//h=g^β
        // System.out.println("h=" + h);
    }

    @Override
    public void computeMulG() {
        // System.out.println("-------------------G乘法运算----------------------");
        mul=h.mul(g_alpha);
        // System.out.println("h=" + h); //mul=g^αβ
    }
    @Override
    public void computePowZ() {
        // System.out.println("-------------------Z幂运算----------------------");
        alpha_beta  = alpha.duplicate().powZn(beta);//alpha_beta=α^β
        // System.out.println("alpha^beta=" + alpha_beta);
    }

    @Override
    public void computeMulZ() {
        // System.out.println("-------------------Z乘法运算----------------------");
        alphabeta=alpha.mul(beta);//alphabeta=αβ
        // System.out.println("alpha*beta=" + alphabeta);
    }

    public static void main(String[] args) {
        computeOperation4 com=new computeOperation4();

        long startTime=System.currentTimeMillis();//获得当前时间
        com.computePair();
        long endTime=System.currentTimeMillis();//获得当前时间
        System.out.println("双线性运算时间为："+(endTime-startTime)+"ms");

        long startTime2=System.currentTimeMillis();//获得当前时间
        com.computePowG();
        long endTime2=System.currentTimeMillis();//获得当前时间
        System.out.println("G中幂运算时间为："+(endTime2-startTime2)+"ms");


        long startTime3=System.currentTimeMillis();//获得当前时间
        com.computeMulG();;
        long endTime3=System.currentTimeMillis();//获得当前时间
        System.out.println("G乘法运算时间为："+(endTime3-startTime3)+"ms");


        long startTime4=System.currentTimeMillis();//获得当前时间
        com.computePowG();
        long endTime4=System.currentTimeMillis();//获得当前时间
        System.out.println("Z中幂运算时间为："+(endTime4-startTime4)+"ms");

        long startTime5=System.currentTimeMillis();//获得当前时间
        com.computeMulG();;
        long endTime5=System.currentTimeMillis();//获得当前时间
        System.out.println("Z乘法运算时间为："+(endTime5-startTime5)+"ms");
    }
}  