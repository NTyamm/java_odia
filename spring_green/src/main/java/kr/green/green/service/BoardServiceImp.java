package kr.green.green.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.green.dao.BoardDAO;
import kr.green.green.pagination.Criteria;
import kr.green.green.utils.UploadFileUtils;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "C:\\Users\\MASTER\\Desktop\\java_odia\\upload";

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		return boardDao.selectBoardList(cri);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void registerBoard(BoardVO board, MemberVO user, List<MultipartFile> files) {
		if(board == null || user == null)
			return;
		if(board.getBd_title() == null
						 || board.getBd_title().trim().length() == 0)
			return;
		if(board.getBd_me_id() == null
						 || board.getBd_me_id().trim().length()== 0)
			return;
		board.setBd_me_id(user.getMe_id());
		boardDao.insertBoard(board);
		uploadFile(files, board.getBd_num());
	}

	@Override
	public void modifyBoard(BoardVO board, List<MultipartFile> files, Integer[] fileNums) {
				BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		if(dbBoard == null)
			return;
		
		//가져온 게시글의 수정일을 현재 시간으로 업데이트
		dbBoard.setBd_up_date(new Date());
		//다오에게 수정된 게시글 정보를 주면서 업데이트하라고 시킴
		boardDao.updateBoard(dbBoard);
		//해당 게시글번호와 일치하는 첨부파일 전체를 가져옴
		List<FileVO> fileList = boardDao.selectFileList(board.getBd_num());
		//가져온 첨부파일 전체에서 fileNums에 없는 번호들은 삭제처리
		if(fileList != null && fileList.size() != 0 && fileNums.length != 0) {
			List<FileVO> delList = new ArrayList<FileVO>();
			for(FileVO tmpFileVo : fileList) {
				for(Integer tmp: fileNums) {
					if(tmpFileVo.getFi_num() == tmp) {
						delList.add(tmpFileVo);
					}
				}
			}
			fileList.removeAll(delList); //이게 없으면 기존 파일이 삭제되고 새 파일로 대체됨
		}
		//위의 조건문을 거치고 난 뒤 fileList는 삭제할 첨부파일들
		//DB에서도 삭제
		deleteFile(fileList);
		
		//새로 추가된 첨부파일 있으면 서버에 업로드
		//새로 추가된 첨부파일을 DB에 추가
		uploadFile(files, board.getBd_num());
	}
	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || bd_num <= 0)
			return;
		BoardVO board = boardDao.selectBoard(bd_num);
		if(board == null)
			return;
		if(user != null && board.getBd_me_id().equals(user.getMe_id()))
			boardDao.deleteBoard(bd_num);
		
		List<FileVO> fileList = boardDao.selectFileList(bd_num);
		deleteFile(fileList);
	}
	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num ==null || bd_num <= 0)
			return null;
		return boardDao.selectFileList(bd_num);
	}	
	private void uploadFile(List<MultipartFile>files, Integer bd_num) {
		if(files == null)
			return;
		for(MultipartFile tmpFile : files) {
			if(tmpFile != null && tmpFile.getOriginalFilename().length() !=0) { 
				try {
					String path = UploadFileUtils.uploadFile(uploadPath, 
							tmpFile.getOriginalFilename(), tmpFile.getBytes());
					FileVO fileVo = new FileVO(
							tmpFile.getOriginalFilename(),
							path,
							bd_num);
					boardDao.insertFile(fileVo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	private void deleteFile(List<FileVO> fileList) {
		if(fileList != null && fileList.size() !=0) {
			for(FileVO tmpFileVo: fileList) {
				File f = new File(uploadPath+tmpFileVo.getFi_name().replace("/",File.separator));;
				if(f.exists()) {
					f.delete();
				}
				boardDao.deleteFile(tmpFileVo.getFi_num());
			}
		}
	
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.selectCountBoard(cri);
	}
}
