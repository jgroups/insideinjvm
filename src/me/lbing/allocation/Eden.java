package me.lbing.allocation;

public class Eden {
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM参数:-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio:8
	 */
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];// 出现一次Minor GC
	}
	
	public static void main(String[] args) {
		testAllocation();
	}
}
/**********运行结果jdk1.8.0_91**********/
/*
Heap
PSYoungGen      total 9216K, used 7292K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 eden space 8192K, 89% used [0x00000000ff600000,0x00000000ffd1f070,0x00000000ffe00000)
 from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
 to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
Metaspace       used 2650K, capacity 4486K, committed 4864K, reserved 1056768K
 class space    used 286K, capacity 386K, committed 512K, reserved 1048576K
 */
/**********运行结果jdk1.8.0_91**********/
/*
Heap
 PSYoungGen      total 9216K, used 7143K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 87% used [0x00000000ff600000,0x00000000ffcf9fd0,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
 ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
 PSPermGen       total 21504K, used 2570K [0x00000000f9a00000, 0x00000000faf00000, 0x00000000fec00000)
  object space 21504K, 11% used [0x00000000f9a00000,0x00000000f9c82850,0x00000000faf00000)
 */
