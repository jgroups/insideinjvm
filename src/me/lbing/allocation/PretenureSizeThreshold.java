package me.lbing.allocation;

public class PretenureSizeThreshold {
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM参数:-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * -XX:PretenureSizeThreshold=3145728
	 */
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB];// 出现一次Minor GC
	}
	
	public static void main(String[] args) {
		testPretenureSizeThreshold();
	}
}
/**********运行结果jdk1.7.0_79**********/
/*
Heap
 PSYoungGen      total 9216K, used 5095K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 62% used [0x00000000ff600000,0x00000000ffaf9f88,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
 ParOldGen       total 10240K, used 0K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 0% used [0x00000000fec00000,0x00000000fec00000,0x00000000ff600000)
 PSPermGen       total 21504K, used 2569K [0x00000000f9a00000, 0x00000000faf00000, 0x00000000fec00000)
  object space 21504K, 11% used [0x00000000f9a00000,0x00000000f9c827f8,0x00000000faf00000)
 */