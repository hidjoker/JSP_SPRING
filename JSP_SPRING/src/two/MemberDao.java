package two;

import dto.Member;

public interface MemberDao {
	
	// ??๊ฐ?? - INSERT
	// PARAMETER : insertMember - ??๊ฐ?? ? ๋ณ?
	// RETURN : boolean - ??๊ฐ?? ?ฑ?จ
	// 	false - ?ด๋ฏ? ์กด์ฌ?? userId?ด๊ฑฐ๋ INSERT ๊ตฌ๋ฌธ?ด ?ค?จ?  ๊ฒฝ์ฐ
	//	true - INSERT ?ฑ๊ณ?
	public boolean join(Member insertMember);
	
}
