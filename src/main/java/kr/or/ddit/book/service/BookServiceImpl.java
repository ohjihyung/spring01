package kr.or.ddit.book.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.book.dao.BookDAO;

/*
   일반적으로 서비스 레이어는 인터페이스와 클래스를 함께 사용합니다.
   스프링은 직접 클래스 생성하는 것을 지양하고 인터페이스를 통해 접근하는 것을 권장하는 프레임워크
 */
@Service
public class BookServiceImpl implements BookService {

	/*
	 *  service 클래스는 비즈니스 클래스가 위치하는 곳입니다.
	 *  스프링 MVC 구조에서 서비스 클래스는 컨트롤러와 DAO를 연결하는 역할을 합니다.
	 *  
	 *  어노테이션 Service는 스프링에 서비스 클래스임을 알려줍니다.
	 *  
	 *  데이터베이스 접근을 위해 BookDAO 인스턴스를 주입받습니다.
	 *  클리스의 이름이 Impl로 끝나는 것은 implement의 약자로 관습에 따름
	 *  Impl이 붙고 안붙고에 따라 클래스인지 인터페이스인지 구별하기 쉬움 
	 *
	 */
	
	@Inject
	BookDAO bookDAO;
	
	/**
	 * <p>책 등록 </p>
	 * @since SampleSpringYse 1.0
	 * @author ddit_ojh
	 * @param map 등록할 책 데이터
	 * @return 성공 책ID , 실패 NULL
	 */
	@Override
	public String insertBook(Map<String, Object> map) {
		// affectRowCount 변수에는 영향받은 행 수가 담김니다.
		// insert 구문은 입력이 성공하면 1, 실패하면 0 리턴
		int affectRowCount = bookDAO.insert(map);
		// book_id = 34
		if(affectRowCount == 1) {
			// 결과가 성공일 시 , map 인스턴스에 book 테이블의 pk인 book_id가 담겨져있습니다.
			return map.get("book_id").toString();
		}
		return null;
	}

	/**
	 *  <p>책 상세보기</p>
	 *  @since SampleSpringYse 1.0
	 *  @author ddit_ojh
	 *  @param map 책ID
	 *  @return ID에 해당하는 책 정보
	 */
	@Override
	public Map<String, Object> selectBook(Map<String, Object> map) {
		// 서비스 내 selectBook 함수는 dao를 호출한 결과를 바로 리턴하는 일만 한다
		return bookDAO.selectBook(map);
	}

}
