package book5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

// 데이터 저장소(배열 -> 리스트 -> 파일 -> DB)를 직접 참조하거나, 연결할 수 있음
// 프로그램의 주요 기능(목록/추가/삭제 등)을 모아둔 클래스



public class Handler {

	// 배열에서 리스트로 전환
	private ArrayList<Book> list = new ArrayList<>();
	
	// 파일 저장 및 불러오기 함수
	private File f = new File("bookList.csv");
	
	public Handler() {
		if(f.exists() == false) {
			try {
				f.createNewFile();
			}
			catch (IOException e) {
				System.out.println("\t파일을 생성하는데에 문제가 발생했습니다 : " + e);
				e.printStackTrace();
			}
		}
	}
	
	// 저장
	public void save() {
		try {
			// 프로그램의 데이터를 파일로 내보내는 스트림(데이터의 이동 통로)
			FileOutputStream fos = new FileOutputStream(f);
			
			// 스트림으로 문자열 형식 데이터를 전달하는 기능이 추가된 클래스
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			osw.write("/ufeff");
			
			for(Book ob : list) {
				String name = ob.getName();
				String author = ob.getAuthor();
				String publisher = ob.getPublisher();
				String price = String.valueOf(ob.getPrice());
				
				// 아래 서식은 띄어쓰기 없이 
				String data = String.format("%s,%s,%s,%s", name, author, publisher, price);
				osw.write(data);
				osw.write("\n");
			}
			osw.flush();
			osw.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}// end of save()
	public void load() {
		try {
			Scanner sc = new Scanner(f);
			String data = "";
			while(sc.hasNextLine()) {
				data = sc.nextLine();
				if(data.length() != 0) {
					String[] arr = data.split(",");
					Book b = new Book();
					b.setName(arr[0]);
					b.setAuthor(arr[1]);
					b.setPublisher(arr[2]);
					b.setPrice(Integer.parseInt(arr[3]));
					list.add(b);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}// end of load()
	
	// 배열을 전달받아서, 배열 내부의 각 객체를 서식에 맞게 출력하는 함수 (case 1)
	public void showList() {
		list.forEach(ob -> System.out.println(ob));
	}

	// 도서 추가
	public int insertBook(Book ob) {
		int row = 0;
//		for(int i = 0; i < arr.length; i++) {	// 배열의 처음부터 끝까지 순회하면서
//			if(arr[i] == null) {				// 빈칸을 찾았다면
//				arr[i] = ob;					// 값이 준비된 객체를 넣으면 끝
//				row = 1;						// ★ 반환값을 1로 해줘야하는데 안적으면 0이라서 추가실패라 뜸
//				break;	// 다음칸에 또 값을 넣으면 안되니까 break (반복 중단)
//			}
//		}
		boolean flag = list.add(ob);			// 추가 성공하면 true가 반환된다
		row = flag ? 1 : 0;						// true이면 row가 1, 아니면 row가 0
		return row;
	}
	
	// 도서 이름을 전달받아서, 배열 안에서 일치하는 객체를 찾아서 삭제하는 함수
	public int deleteBook(String name) {
			int row = 0;
//			for(int i = 0; i < arr.length; i++) {
//				if(arr[i] != null && arr[i].getName().equals(name)) {	
//									// arr[i] != null은 nullPointerException 생김 방지
//					arr[i] = null;	// 참조변수가 객체를 참조하지 않도록 한다
//									// 모두에게서 잊혀진 참조변수는 소멸한다
//					row = 1;		// 삭제했다는 결과를 반환하기 위해 row값을 1로 설정한다
//					break;			// 하나 지웠으면 중단한다
//				}
//			}
			boolean flag = list.removeIf(ob -> ob.getName().equals(name));
			// removeIf를 name값으로 지우는데 이름이 같은 경우 같은 이름값이 다 지워질 수 있음
			// 따라서 객체에 고유성을 부여할 수 있는 기본키(식별고유번호)가 필요함
			
			row = flag ? 1 : 0;
			return row;
			
		}
		
		
		
}
