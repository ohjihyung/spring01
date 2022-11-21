package kr.or.ddit.book.dao;

import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
  어노테이션 Repository 는 데이터에 접근하는 클래스임을 명시한다.
  해당 어노테이션이 있는 클래스는 스프링이 데이터를 관리하는 클래스라고 인지하여
  자바 빈(java bean)으로 등록해서 관리

  SqlSessionTemplate 객체를 맴버 변수로 선언하는 이유는 mapper.xml을 실행시키기 위해서입니다.
  해당 객체 위에 어노테이션 inject 또는 어노테이션 autowired을 붙여서 
  sqlSessionTemplate 객체를 사용할 수 있도록 합니다.
  이러한 형태를 '의존성 주입'이라고 합니다. (필드 인젝션(Field injection))
  
  SqlsessionTemplate 객체는 new 키워드를 통해 직접 생성하지 않고, 의존성 주입(Dependency Injection -DI) 를 통해
  주입받습니다. 스프링은 미리 만들어놓은 sqlSessionTemplate 타입 객체를 BookDAO 객체에 주입합니다.
  해당 과정은 스프링에서 자동 실행되며 개발자가 직접 sqlSessionTemplate 객체를 생성하는 일 없이 곧바로 사용 가능
  
  sqlSessionTemplate 객체는 root-context.xml에서 정의해둔 객체이기도 하고, 서버가 시작될 때 스프링은 미리 xml을 읽어
  객체를 인스턴스화 해둡니다
 */

@Repository
public class BookDAO {
	
	// singleton 처럼 사용하겠다 라는 것을 알려주는 inject
	/*
	 	매퍼 xml을 실행시키기 위해 SqlSessionTemplate 객체를 맴버변수로 선언 
	 	@Inject 어노테이션을 붙여서 SqlSessionTemplate 객체를 사용할 수 있게 합니다.
	 */
	@Inject
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	/*
	  sqlSessionTemplate.insert()
	  1) 첫번째 파라미터는 SQL Mapper id 입니다.
	   book_SQL.xml에서 namespace로 설정된 'Book'과 insert 쿼리를 실행하기 위해 만든 insert문의 id 값
	    'insert'입니다. mybatis는 네임스페이스 + id 조합으로 쿼리를 찾아서 실행
	    
	    2) 2번째 파라미터는 쿼리에 전달할 데이터
	     mapper내 insert 쿼리 를 실행하기 위해 전달되어지는 parameterType이 map입니다.
	     
	     외부에서 DAO까지 map에 title , category, price 가 담겨져서 넘어옵니다
	     그리고 useGeneratedKeys와 KeyProperty의 설정 덕분에 book 테이블의 pk인 book_id 항목이 생깁니다.
	  */
	public int insert(Map<String, Object> map) {
		
		/*
		 * 	  sqlSessionTemplate.insert()의 반환값은 쿼리의 영향을 받은 행 수 (row count)입니다.
		 * 	insert 쿼리의 경우 성공하면 1개의 행 (row)이 생기므로 1을 리턴하고 실패하면 0을 리턴합니다.
		 * 
		 **/
		return sqlSessionTemplate.insert("Book.insert", map);
	}
	
}
