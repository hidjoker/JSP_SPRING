package two;

import dto.Member;

public interface MemberDao {
	
	// ?��?���??�� - INSERT
	// PARAMETER : insertMember - ?��?���??�� ?���?
	// RETURN : boolean - ?��?���??�� ?��?��
	// 	false - ?���? 존재?��?�� userId?��거나 INSERT 구문?�� ?��?��?�� 경우
	//	true - INSERT ?���?
	public boolean join(Member insertMember);
	
}
