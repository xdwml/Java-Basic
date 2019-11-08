package ComputeTime;
/*
 * 分别计算双线性对运算，幂运算，乘法运算的单次运行时间
 */
import it.unisa.dia.gas.jpbc.*;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
public class computeOperation2 implements ComputeTime2 {
    public Element alpha,beta,g,g_alpha,h,g_hat_alpha,mul;
    public Pairing pairing;
    public computeOperation2() {
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
    public void computePowZ() {
        // System.out.println("-------------------幂运算----------------------");
        h  = g.duplicate().powZn(beta);//h=g^β
        // System.out.println("h=" + h);
    }

    @Override
    public void computeMult() {
        // System.out.println("-------------------乘法运算----------------------");
        mul=h.mul(g_alpha);
        // System.out.println("h=" + h); //mul=g^αβ
    }

    public static void main(String[] args) {
        computeOperation2 com=new computeOperation2();

        long startTime=System.currentTimeMillis();//获得当前时间
        com.computePair();
        long endTime=System.currentTimeMillis();//获得当前时间
        System.out.println("双线性运算时间为："+(endTime-startTime)+"ms");

        long startTime2=System.currentTimeMillis();//获得当前时间
        com.computePowZ();
        long endTime2=System.currentTimeMillis();//获得当前时间
        System.out.println("幂运算操作时间为："+(endTime2-startTime2)+"ms");

        long startTime3=System.currentTimeMillis();//获得当前时间
        com.computeMult();
        long endTime3=System.currentTimeMillis();//获得当前时间
        System.out.println("乘法的运算时间为："+(endTime3-startTime3)+"ms");
    }
}  