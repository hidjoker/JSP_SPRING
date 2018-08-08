package two;

import dto.Member;

public interface MemberDao {
	
	// ?šŒ?›ê°??… - INSERT
	// PARAMETER : insertMember - ?šŒ?›ê°??… ? •ë³?
	// RETURN : boolean - ?šŒ?›ê°??… ?„±?Œ¨
	// 	false - ?´ë¯? ì¡´ì¬?•˜?Š” userId?´ê±°ë‚˜ INSERT êµ¬ë¬¸?´ ?‹¤?Œ¨?•  ê²½ìš°
	//	true - INSERT ?„±ê³?
	public boolean join(Member insertMember);
	
}
