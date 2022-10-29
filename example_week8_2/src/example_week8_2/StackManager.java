package example_week8_2;

import java.util.Vector;

interface Istack<T>{
	T pop();
	Boolean push(T ob);
}

// Istack 인터페이스 구
class MyStack<T> implements Istack<T>{
	// 벡터생성 
	Vector<T> v = new Vector<E>();
	T data; 
	
	@Override
	public T pop() {
		// 마지막 요소 pop하기
		int idx = v.size()-1;
		data = v.get(idx);
		// 마지막 요소 삭제하기 
		v.remove(idx);
		// 추가처리 0이면 null 
		// why? 문제 실행화면에 9~1까지 밖에 없고 0출력안
		// 이는 마지막 출력 값은 null로 변경해서 while문 벗어나게 하기 위한 조치를 치한것.
		// remove를 통해 마지막에 있는 데이터도 삭제되어 벡터의 자료 개수가 0개라면 
		// 해당 데이터를 null로만듬 
		if(v.size() == 0)
			data = null;
		
		// data 반환 
		return data;
		
	}

	@Override
	public Boolean push(T ob) {
		// 배열 전체용량 초과한지 체크 
		if(v.capacity() > 10) {
			//꽉차면 False 반환 
			System.out.println("용량 초과"); 
			return false;
		}else {
			//요소 넣고 true반환
			v.add(ob);
			return true;
		}
	}
	
}
public class StackManager {

	public static void main(String[] args) {

		
		// S오타 
		// Interger형으로 객체 생성 
		Istack <Integer> stack = new MyStack<Integer>();
		
		for(int i=0;i<10;i++)
			stack.push(i); //i 넣기 
		
		
		// n요소 다 빼기 
		while(true) {
			// n
			Integer n = stack.pop();
			if(n==null)
				break;
			System.out.print(n + " ");
			
		}
		

	}

}
