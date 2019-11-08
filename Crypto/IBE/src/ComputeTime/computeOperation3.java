package ComputeTime;
/*
 * 分别计算双线性对运算，幂运算，乘法运算的平均1000次运行时间
 */
import it.unisa.dia.gas.jpbc.*;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
public class computeOperation3 implements ComputeTime2 {
	public Element alpha,beta,g,g_alpha,h,g_hat_alpha,mul;
	public Pairing pairing;
	public computeOperation3() {
		pairing = PairingFactory.getPairing("a.properties");//
		alpha = pairing.getZr().newElement().setToRandom();//随机选取的α
		beta = pairing.getZr().newElement().setToRandom();//随机选取的β
		g = pairing.getG1().newElement().setToRandom();//G1的生成元g
		g_alpha = g.duplicate().powZn(alpha);//g^α
       /* System.out.println("alpha  =" + alpha);
        System.out.println("beta   =" + beta);
        System.out.println("g      =" + g);
        System.out.println("g_alpha=" + g_alpha );  */
		System.out.println("-------------------平均1000次运算时间对比----------------------");
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
		computeOperation3 com=new computeOperation3();

		long sum1=0;
		for(int i=0;i<1000;i++){
			long startTime1=System.currentTimeMillis();//获得当前时间
			com.computePair();
			long endTime1=System.currentTimeMillis();//获得当前时间
			long time1=endTime1-startTime1;
			sum1=time1+sum1;
		}
		long atime1=sum1/1000;
		System.out.println("双线性运算平均1000次时间为："+atime1+"ms");

		long sum2=0;
		for(int i=0;i<1000;i++){
			long startTime2=System.currentTimeMillis();//获得当前时间
			com.computePowZ();
			long endTime2=System.currentTimeMillis();//获得当前时间
			long time2=endTime2-startTime2;
			sum2=time2+sum2;
		}
		long atime2=sum2/1000;
		System.out.println("幂运算操作平均1000次时间为："+atime2+"ms");

		long sum3=0;
		for(int i=0;i<1000;i++){
			long startTime3=System.currentTimeMillis();//获得当前时间
			com.computeMult();;
			long endTime3=System.currentTimeMillis();//获得当前时间
			long time3=endTime3-startTime3;
			sum3=time3+sum3;
		}
		long atime3=sum3/1000;
		System.out.println("乘法的运算平均1000次时间为："+atime3+"ms");

	}
}  