package me.lbing.allocation;

public class TenuringThreshold {
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM参数:-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		// 什么时候进入老年代取决于XX:TenuringThreshold设置
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}

	public static void main(String[] args) {
		testTenuringThreshold();
	}
}
/********** 运行结果jdk1.7.0_79 **********/
/*
Heap
 PSYoungGen      total 9216K, used 5351K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 65% used [0x00000000ff600000,0x00000000ffb39f68,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
 ParOldGen       total 10240K, used 8192K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 80% used [0x00000000fec00000,0x00000000ff400020,0x00000000ff600000)
 PSPermGen       total 21504K, used 2570K [0x00000000f9a00000, 0x00000000faf00000, 0x00000000fec00000)
  object space 21504K, 11% used [0x00000000f9a00000,0x00000000f9c82840,0x00000000faf00000)
 */