package kr.or.ddit.book.web;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.BookService;


/*
 *   @Controller 
 *    - 전통적인 스프링의 컨트롤러 어노테이션
 *    
 *    @RestController
 *    - JSON과 xml 형태로 객체 데이터 반환을 목적으로 할 때 사용하는 컨트롤러 어노테이션
 *    
 *    어노테이션 컨트롤러는 사용자의 요청이 진입하는 지점이고, 요청에 따라 처리를 결정하며
 *    사용자에게 View를 응답으로 보냅니다.
 */

@Controller
@RequestMapping("/book")
public class BookRetrieveController {
	/*
	  서비스를 호출하기 위해 BookService를 의존성을 주입합니다.
	 */
	@Inject
	private BookService bookService;
	
	// @RequestParam 어노테이션에 의해 쿼리 스트링 파라미터를 읽을 수 있습니다
	@RequestMapping(value ="/detail.do", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		
		// DB에서 조회한 결과를 detailMap 변수에 담습니다.
		Map<String, Object> detailMap = bookService.selectBook(map);
		
		ModelAndView mav = new ModelAndView();
		
		// ModelAndView 객체 mav에 뷰로 전달할 데이터를 담습니다.
		// book 이라는 키의 이름으로 쿼리의 결과를 담슴니다
		mav.addObject("book",detailMap);
		//Book의 pk인 book_id도 mav 객체에 담슴니다.
		// 이때 book_id의 값은 http 쿼리 스트링에서 넘겨준 파라미터에서 가지고옴 
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId", bookId);
		mav.setViewName("book/detail");
		
		return mav;
				
	}
}
