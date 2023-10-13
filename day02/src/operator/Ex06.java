package operator;

public class Ex06 {
		// 단항 연산자 : 1개의 항에 대하여 연산을 수행 (++)
		// 이항 연산자 : 2개의 항에 대하여 연산을 수행 (+)
		// 삼항 연산자 : 3개의 항에 대하여 연산을 수행
	
	public static void main(String[] args) {
		// 논리 연산자 (* 정처기 단골문제!)
		// and (&&) : 서로 다른 두 조건이 모두 참이면 결과가 참, 아니면 거짓
		// or (||) : 서로 다른 두 조건중 하나라도 참이면 결과가 참, 아니면 거짓
		// not (!) : 하나의 조건이 참이면 거짓, 거짓이면 참
		
		
		// 1. and(&&)
		int age = 25;
		int gender = 1;	// 홀수는 남성, 짝수는 여성
		
		boolean quest = age >= 20 && gender % 2 == 1;
		// 나이가 20이상이고, 성별이 홀수이면 quest를 수행해야한다
		
		// 각 조건을 boolean 변수에 담아서 처리해도 된다
		boolean isAdult = age >= 20;
		boolean isOdd = gender % 2 != 0;
		boolean quest2 = isAdult && isOdd;
		
		System.out.println(quest);
		System.out.println(quest2);
		
		// 게시글을 삭제하기 위한 조건 : 로그인상태여야 하고, 게시글의 작성자와 동일계정이여야 한다
		// and 연산은 첫번째 조건이 중요함
		// 첫번째 조건이 거짓이면 문장 성립이 안되기 때문
		
		String s1 = "Hello world !!";
		String s2 = null;
		// null pointer exception
		
//		System.out.println("s1의 길이 : " + s1.length());
//		System.out.println("s2의 길이 : " + s2.length());
		
		for(int i = 0; i < s1.length(); i++) {
			System.out.print(s1.charAt(i) + " ");
		}
		System.out.println();
		
		// A && B에서 첫번째 조건이 거짓이면, 두번째 조건은 연산을 수행하지 않는다		
		for(int i = 0; s2 != null && i < s2.length(); i++) {
			System.out.print(s2.charAt(i) + " ");
		}
		System.out.println();
		
		int n1 = 2, n2 = 1, n3 = 0, n4 = -1;
		
		System.out.printf("%d, %d, %d, %d\n", n1, n2, n3, n4);
		
		boolean flag1 = n1++ + ++n2 < 0 && ++n3 == --n4;
		
		System.out.println("flag1 : " + flag1);
				
		System.out.printf("%d, %d, %d, %d\n", n1, n2, n3, n4);
		System.out.println();
		
		// 2. or(||) : 두 가지 조건 중 하나라도 참이면 전체 결과가 참이다
		for(int i = 1; i < 20; i++) {			// 1에서 9까지의 정수 중에서
			if(i % 3 == 0 || i % 4 == 0) {		// 3의 배수이거나, 혹은 4의 배수이면
				System.out.println(i + " ");	// 출력한다
			}
		}
		System.out.println();
		
		// 3) not(!) : true이면 false, false이면 true로 바꾼 값을 나타낸다
		age = 15;
		isAdult = age >= 20;					// 나이가 20이상이면 성인
		if(!isAdult) {							// 성인이 아니면
			System.out.println("미성년자입니다");	// 미성년자입니다 라고 출력
		}
		if(isAdult == false) {
			System.out.println("미성년자입니다");
			
		}
		System.out.println("isAdult : " + isAdult);
		
		
	}

}
