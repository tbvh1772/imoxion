package com.imoxion.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.RandomAccess;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.imoxion.controller.BoardController;
import com.imoxion.domain.BoardVo;


@Service
public class BoardServiceImpl implements BoardService  {
	
	
	@Autowired
	ServletContext servletContext;
	
	
	public int getCnt() throws IOException {
		int cnt = 0;
		try {
			File file = new File(servletContext.getRealPath("\\resources\\data\\dataFile.txt"));
			FileReader fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
		    String line;
		   
		    //마지막파일에 번호를 저장
		    while((line=bufReader.readLine()) != null) {

		    	String[] writeStr = line.split(" ");
		    	cnt = Integer.parseInt(writeStr[0]);
		    }
		    fileReader.close();
		    bufReader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return cnt+1;
	}
	

	//리스트
	public List<BoardVo> getBoardList() throws IOException {
		  List<BoardVo> infoList = new ArrayList<BoardVo>();
		  try {
			  File file = new File(servletContext.getRealPath("\\resources\\data\\dataFile.txt"));
			  FileReader fileReader = new FileReader(file);
			  BufferedReader bufReader = new BufferedReader(fileReader);
			  String line;
		   
			  // 각 라인마다 " " 나눠 배열에 저장 후 읽어 BoardVo에 저장
			  while((line=bufReader.readLine()) != null) {
		    	// " "로 split하여 배열에 저장
		    	String[] writeStr = line.split(" ");
             
		    	BoardVo boardVo = new BoardVo();
             
		    	boardVo.setNo(Integer.parseInt(writeStr[0]));
		    	boardVo.setTitle(writeStr[1]);
		    	boardVo.setContent(writeStr[2]);
		    	boardVo.setDate(writeStr[3]);
		    	infoList.add(boardVo);
         }
		    fileReader.close();
		    bufReader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return infoList;
				
	}

	@Override
	//글쓰기
	public void insertBoard(BoardVo boardVo) throws IOException {
		
		try{
			
			File file = new File(servletContext.getRealPath("\\resources\\data\\dataFile.txt"));
			FileWriter fileWriter = new FileWriter(file,true);
			
			int count = getCnt();

			// 입력한 데이터 + 날짜 저장
		    SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
		    Date time = new Date();
		    String time1 = format1.format(time);
			boardVo.setNo(count);
			boardVo.setDate(time1);
			fileWriter.write(count+" ");
			fileWriter.write(boardVo.getTitle() + " ");
			fileWriter.write(boardVo.getContent() + " ");
			fileWriter.write(time1 + "\n");
			fileWriter.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//삭제
	@Override
	public void delBoard(int no) throws IOException{
		String dummy = "";
		try {
			 File file = new File(servletContext.getRealPath("\\resources\\data\\dataFile.txt"));
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			 
			 String line;
			 // 삭제할 데이터 전까지 복사
			 while((line=br.readLine()) != null) {
				String[] writeStr = line.split(" "); 
			 
				if(Integer.parseInt(writeStr[0]) != no) {
				    dummy += (line + "\r\n" ); 
				}else {
					break;
				}
			 }

			 // 삭제할 데이터 후까지 복사
			 while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" ); 
			}

			// 복사한 데이터 쓰기
			FileWriter fw = new FileWriter(servletContext.getRealPath("\\resources\\data\\dataFile.txt"));

			fw.write(dummy);
				
			fw.close();
			br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}


	//글보기
	  @Override 
	  public BoardVo getBoardView(int no) throws IOException {
	  BoardVo boardVo = new BoardVo(); 
	  try {
		  File file = new File(servletContext.getRealPath("\\resources\\data\\dataFile.txt"));
		  FileReader fileReader = new FileReader(file);
		  BufferedReader bufReader = new BufferedReader(fileReader); 
		  String line;
	  
		  // 글보기 데이터 찾기
		  while((line=bufReader.readLine()) != null) { // " "로 split하여 배열에 저장
	  
			String[] writeStr = line.split(" "); 
			  
	  		if(Integer.parseInt(writeStr[0]) == no) {
	  
	  
	  			// 각 개인정보를 저장한다. 
	  			boardVo.setNo(Integer.parseInt(writeStr[0]));
	  			boardVo.setTitle(writeStr[1]); 
	  			boardVo.setContent(writeStr[2]);
	  			break; 
	  		}
	  	} 
		fileReader.close();
	  	bufReader.close(); 
	} catch(IOException e) { 
		e.printStackTrace(); 
	} 
	  return boardVo; 
	}


	//글수정
	@Override
	public void getUpdate(BoardVo boardVo) throws IOException {
		String dummy = "";
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
		Date time = new Date();
		String time1 = format1.format(time);
		boardVo.setDate(time1);
		
		// 수정할 데이터 이전까지 복사
		try {
			 File file = new File(servletContext.getRealPath("\\resources\\data\\dataFile.txt"));
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			 
			 String line;
			 while((line=br.readLine()) != null) {
				  String[] writeStr = line.split(" "); 
			 
				if(Integer.parseInt(writeStr[0]) != boardVo.getNo()) {
				    dummy += (line + "\r\n" ); 
				}else {
					break;
				}
				
			 }
			  
			 // 수정한 데이터 복사
			 dummy += boardVo.getNo()+ " ";
			 dummy += boardVo.getTitle()+ " ";
			 dummy += boardVo.getContent()+ " ";
			 dummy += time1+ "\n";
			 
			 // 수정한 데이터 이후 복사
			while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" ); 

			}
			// 새로쓰기
			FileWriter fw = new FileWriter(servletContext.getRealPath("\\resources\\data\\dataFile.txt"));
			fw.write(dummy);
			fw.close();
			br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}

