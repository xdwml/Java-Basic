package ComputeTime;
/*
 * 分别计算双线性对运算，G中幂运算，G中乘法运算，Z中幂运算，Z中乘法运算的平均1000次运行时间
 */
import it.unisa.dia.gas.jpbc.*;  
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
public class computeOperation5 implements ComputeTime3 {  
    public Element alpha,beta,g,g_alpha,h,g_hat_alpha,mul,alpha_beta,alphabeta;  
    public Pairing pairing;  
    public computeOperation5() {  
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
    	computeOperation5 com=new computeOperation5();
    	
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
    		com.computePowG();
			long endTime2=System.currentTimeMillis();//获得当前时间
			long time2=endTime2-startTime2;
			sum2=time2+sum2;
    	}
    	long atime2=sum2/1000;
		System.out.println("G中幂运算平均1000次时间为："+atime2+"ms"); 
		
		long sum3=0;
    	for(int i=0;i<1000;i++){
    		long startTime3=System.currentTimeMillis();//获得当前时间
    		com.computeMulG();;
			long endTime3=System.currentTimeMillis();//获得当前时间
			long time3=endTime3-startTime3;
			sum3=time3+sum3;
    	}
    	long atime3=sum3/1000;
		System.out.println("G乘法运算平均1000次时间为："+atime3+"ms"); 
		
		long sum4=0;
    	for(int i=0;i<1000;i++){
    		long startTime4=System.currentTimeMillis();//获得当前时间
    		com.computePowG();
			long endTime4=System.currentTimeMillis();//获得当前时间
			long time4=endTime4-startTime4;
			sum4=time4+sum4;
    	}
    	long atime4=sum4/1000;
		System.out.println("Z中幂运算平均1000次时间为："+atime4+"ms"); 
		
		long sum5=0;
    	for(int i=0;i<1000;i++){
    		long startTime5=System.currentTimeMillis();//获得当前时间
    		com.computeMulG();;
			long endTime5=System.currentTimeMillis();//获得当前时间
			long time5=endTime5-startTime5;
			sum5=time5+sum5;
    	}
    	long atime5=sum5/1000;
		System.out.println("Z乘法运算平均1000次时间为："+atime5+"ms"); 
    }
}  