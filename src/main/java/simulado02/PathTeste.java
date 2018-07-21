package simulado02;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PathTeste extends Object {
	enum TESTE {
		A, B, C, D;
	}
    enum TESTE2 {
		T1,
		T2,
		T3,
		T4,
		T5,
		T6,
		T7,
		T8,
		T9,
		T10,
		T11,
		T12,
		T13,
		T14,
		T15,
		T16,
		T17,
		T18,
		T19,
		T20,
		T21,
		T22,
		T23,
		T24,
		T25,
		T26,
		T27,
		T28,
		T29,
		T30,
		T31,
		T32,
		T33,
		T34,
		T35,
		T36,
		T37,
		T38,
		T39,
		T40,
		T41,
		T42,
		T43,
		T44,
		T45,
		T46,
		T47,
		T48,
		T49,
		T50,
		T51,
		T52,
		T53,
		T54,
		T55,
		T56,
		T57,
		T58,
		T59,
		T60,
		T61,
		T62,
		T63,
		T64,
		T65,
		T66,
		T67,
		T68,
		T69,
		T70,
		T71,
		T72,
		T73,
		T74,
		T75,
		T76,
		T77,
		T78,
		T79,
		T80,
		T81,
		T82,
		T83,
		T84,
		T85,
		T86,
		T87,
		T88,
		T89,
		T90,
		T91,
		T92,
		T93,
		T94,
		T95,
		T96,
		T97,
		T98,
		T99,
		T100,
		T101,
		T102,
		T103,
		T104,
		T105,
		T106,
		T107,
		T108,
		T109,
		T110,
		T111,
		T112,
		T113,
		T114,
		T115,
		T116,
		T117,
		T118,
		T119,
		T120,
		T121,
		T122,
		T123,
		T124,
		T125,
		T126,
		T127,
		T128,
		T129,
		T130;
	}

	public static void aaa() {
		// @formatter:off
		Path p1 = Paths.get("/x/y");
		Path p2 = Paths.get("/z");
		Path p3 = p1.relativize(p2);
		System.out.println(p3);
		System.out.println(Paths.get("/x/y").resolve(Paths.get("z")));
		// @formatter:on
	}

	public static void main(String[] args) {
		/*
		teste4();

		List<Integer> ls = Arrays.asList(3, 4, 6, 9, 2, 5, 7);
		System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b)); // 1
		System.out.println(ls.stream().reduce((a, b) -> a > b ? a : b).get()); // 1
		System.out.println(ls.stream().max(Integer::max).get()); // 2
		System.out.println(ls.stream().max(Integer::compare).get()); // 3
		System.out.println(ls.stream().max((a, b) -> a > b ? a : b)); // 4
		System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);

		System.out.println(ls.stream().sorted().max((a, b) -> a > b ? a : b)); // 4
		*/
		
		System.out.println("bora");
		System.out.println(TESTE2.T1==TESTE2.T1);
		System.out.println(TESTE2.T130==TESTE2.T130);
		System.out.println(TESTE2.T130.ordinal()==TESTE2.T130.ordinal());
		
		Long l1 = 128L;
		Long l2 = 128L;
//		l1 = new Long(1);
//		l2 = new Long(1);
		System.out.println(l1==l2);
		
		
		Float f1 = 12F;
		Float f2 = 12F;
		
		System.out.println(f1 + " - "+ f2 );
		System.out.println(f1==f2);
		
		
		Integer i1 = 128;
		Integer i2 = 128;
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		
		

		System.out.println(Boolean.getBoolean("true"));
		System.out.println(Boolean.parseBoolean("true"));
		
		
		
		String s1 = "merda";
		String s2 = "merda";
		System.out.println(s1==s2);

	}

	public static void main2(String[] args) {
		List<StringBuilder> messages = Arrays.asList(new StringBuilder(), new StringBuilder());
		messages.stream().forEach(s -> s.append("helloworld"));
		messages.forEach(s -> {
			s.insert(5, ",");
			System.out.println(s);
		});
	}

	public static void teste4() {

		Office off = new HomeOffice(); // 1
//		System.out.println(off.getAddress()); // 2
	}
}
