package basic;

public class DisperseAlgorithms {

	/**
	 * 欧几里得求公约数
	 * @param p
	 * @param q
	 * @return
	 */
	public static int gcd(int p, int q) {
		//关键行,所有递归的函数,关键点都在递归出口
		if(q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
}
