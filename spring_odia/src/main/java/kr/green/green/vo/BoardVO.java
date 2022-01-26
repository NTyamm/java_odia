package kr.green.green.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
 
@Data
public class BoardVO {
	private int bd_num;
	private String bd_title;
	private String bd_contents;
	private Date bd_reg_date;
	private Date bd_up_date;
	private String bd_type;
	private String bd_me_id;
	private int bd_ori_num;
	private String bd_del;
	private Date bd_del_date;
	private int bd_views;
	
	//Date를 String으로 형변환
	public String getBd_reg_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd- HH:mm:ss");
		return format.format(bd_reg_date);
	}
	//criteria에서 메소드를 가져와서 type을 bd_type으로 바꿔줌(글 작성시 typeTitle 부여를 위해)
	public String getTypeTitle() {
		if(bd_type!=null && bd_type.equals("공지"))
			return "공지사항";
		if(bd_type!=null && bd_type.equals("qna"))
			return "qna";
		return "게시판";
	}
	public boolean isAccessAuthority(String authority) {
		if(bd_type.equals("일반") || bd_type.equals("qna"))
			return true;
		if(bd_type.equals("공지") && (authority.equals("관리자") ||authority.equals("슈퍼관리자")))
			return true;
		return false;
	}
}
