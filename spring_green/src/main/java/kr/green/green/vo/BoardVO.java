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
	private int bd_up;
	private int bd_down;
	
	//Date를 String으로 형변환
	public String getBd_reg_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd- HH:mm:ss");
		return format.format(bd_reg_date);
	}

	
}
