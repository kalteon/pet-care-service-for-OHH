package db;

import java.util.Hashtable;

import pd.systemuser.Member;

/*
 * MemberDM으로 불러온 Member Hashtable을 불러와서 보관하는 고유한 싱글톤 클래스.
 * MemberTable membertable = MemberTable.getInstance() 형태로 불러오면 어디서든 같은 내용의 MemberTable 사용가능.
 */
public class MemberTable
{
    private static MemberTable membertable;
    private static Hashtable<String, Member> memberhashtable;
    private MemberDM memberDM;
    
    private MemberTable() {
    	memberDM = new MemberDM("MemberDM");
    }
    
    public static MemberTable getInstance()
    {
        if (membertable == null)
        {
            synchronized(MemberTable.class)
            {
                membertable = new MemberTable();
            }
        }
        return membertable;
    }

    //getter
	public Hashtable<String, Member> getMemberHashTable() {
		memberhashtable = memberDM.readObjectData();
   		return memberhashtable;
	}
	
	//멤버 추가
	public void putMemberHashTable(String memberID, Member member) {
		memberhashtable = memberDM.readObjectData();
		if(memberhashtable == null)
			memberhashtable = new Hashtable<>();
		memberhashtable.put(memberID, member);
		memberDM.deletObjectData();
		memberDM.writeObjectData(memberhashtable);
	}

}
