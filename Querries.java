package smms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Querries extends SMMS{
	public ArrayList<String> query_1() throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL" +" FROM MOVIES M " + "ORDER BY M.rtAudienceScore desc " + "limit 20;";
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String title = rs.getString("title");
			int year = rs.getInt("year");
			int rtAudienceScore = rs.getInt("rtAudienceScore");
			String rtPictureURL = rs.getString("rtPictureURL");
			String imdbPictureURL = rs.getString("rtPictureURL");
			
		/*	//display values
			System.out.println("Title: " + title);
			System.out.println("Year: " + year);
			System.out.println("Audience Score: " + rtAudienceScore);
			System.out.println("PictureURL: " + rtPictureURL);
			System.out.println("IMDBPictureURL: " + imdbPictureURL);
			
			result += title+", " + year+", " +rtAudienceScore+", " +rtPictureURL+", " +imdbPictureURL+"\n";*/
			arr.add(title);
			arr.add(""+year);
			arr.add(""+rtAudienceScore);
			arr.add(rtPictureURL);
			arr.add(imdbPictureURL);
			
		}
		con.close();
		return arr;
		
	}
	//this one needs fixing not getting all tags associated with movie
	public ArrayList<String> query_2(String Movie_Title_Input) throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL, T.value " +"FROM MOVIES M, MOVIE_TAGS MT, TAGS T ";
		query += "WHERE T.id=MT.tagID and MT.movieID=M.id and M.title=" + Movie_Title_Input + " GROUP BY M.title;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String title = rs.getString("title");
			int year = rs.getInt("year");
			int rtAudienceScore = rs.getInt("rtAudienceScore");
			String rtPictureURL = rs.getString("rtPictureURL");
			String imdbPictureURL = rs.getString("rtPictureURL");
			String tags = rs.getString("values");
			
		/*	//display values
			System.out.println("Title: " + title);
			System.out.println("Year: " + year);
			System.out.println("Audience Score: " + rtAudienceScore);
			System.out.println("PictureURL: " + rtPictureURL);
			System.out.println("IMDBPictureURL: " + imdbPictureURL);
			System.out.println("Tags: " + tags);
			
			result += title+", " + year+", " +rtAudienceScore+", " +rtPictureURL+", " +imdbPictureURL+", " +tags+"\n";*/
			arr.add(title);
			arr.add(""+year);
			arr.add(""+rtAudienceScore);
			arr.add(rtPictureURL);
			arr.add(imdbPictureURL);
			arr.add(tags);
		}
		con.close();
		return arr;
	}
	public ArrayList<String> query_3(String Genre_Type_Input) throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL " +"FROM MOVIES M, MOVIE_GENRES MG ";
		query += "WHERE MG.genre="+ Genre_Type_Input+" and M.id=MG.movieID " + "ORDER BY M.rtAudienceScore desc " +"limit 20;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String title = rs.getString("title");
			int year = rs.getInt("year");
			int rtAudienceScore = rs.getInt("rtAudienceScore");
			String rtPictureURL = rs.getString("rtPictureURL");
			String imdbPictureURL = rs.getString("rtPictureURL");
			
		/*	//display values
			System.out.println("Title: " + title);
			System.out.println("Year: " + year);
			System.out.println("Audience Score: " + rtAudienceScore);
			System.out.println("PictureURL: " + rtPictureURL);
			System.out.println("IMDBPictureURL: " + imdbPictureURL);
			
			result += title+", " + year+", " +rtAudienceScore+", " +rtPictureURL+", " +imdbPictureURL+"\n";*/
			arr.add(title);
			arr.add(""+year);
			arr.add(""+rtAudienceScore);
			arr.add(rtPictureURL);
			arr.add(imdbPictureURL);
		}
		con.close();
		return arr;
	}
	public ArrayList<String> query_4(String Director_Name_Input) throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL " + "FROM MOVIES M, MOVIE_DIRECTORS MD ";
		query += "WHERE MD.directorName=" + Director_Name_Input + " and M.id=MD.movieID;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String title = rs.getString("title");
			int year = rs.getInt("year");
			int rtAudienceScore = rs.getInt("rtAudienceScore");
			String rtPictureURL = rs.getString("rtPictureURL");
			String imdbPictureURL = rs.getString("rtPictureURL");
			
		/*	//display values
			System.out.println("Title: " + title);
			System.out.println("Year: " + year);
			System.out.println("Audience Score: " + rtAudienceScore);
			System.out.println("PictureURL: " + rtPictureURL);
			System.out.println("IMDBPictureURL: " + imdbPictureURL);
			
			result += title+", " + year+", " +rtAudienceScore+", " +rtPictureURL+", " +imdbPictureURL+"\n";*/
			arr.add(title);
			arr.add(""+year);
			arr.add(""+rtAudienceScore);
			arr.add(rtPictureURL);
			arr.add(imdbPictureURL);
		}
		con.close();
		return arr;
	}
	public ArrayList<String> query_5(String Actor_Name_Input) throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL " + "FROM MOVIES M, MOVIE_DIRECTORS MD ";
		query += "WHERE MD.directorName=" + Actor_Name_Input + " and M.id=MD.movieID;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String title = rs.getString("title");
			int year = rs.getInt("year");
			int rtAudienceScore = rs.getInt("rtAudienceScore");
			String rtPictureURL = rs.getString("rtPictureURL");
			String imdbPictureURL = rs.getString("rtPictureURL");
			
		/*	//display values
			System.out.println("Title: " + title);
			System.out.println("Year: " + year);
			System.out.println("Audience Score: " + rtAudienceScore);
			System.out.println("PictureURL: " + rtPictureURL);
			System.out.println("IMDBPictureURL: " + imdbPictureURL);
			
			result += title+", " + year+", " +rtAudienceScore+", " +rtPictureURL+", " +imdbPictureURL+"\n";*/
			arr.add(title);
			arr.add(""+year);
			arr.add(""+rtAudienceScore);
			arr.add(rtPictureURL);
			arr.add(imdbPictureURL);
		}
		con.close();
		return arr;
	}
	public ArrayList<String> query_6(String Tag_Value_Input) throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL " + "FROM MOVIES M, TAGS T, MOVIE_TAGS MT ";
		query += "WHERE T.value=" + Tag_Value_Input + " and T.id=MT.tagID and MT.movieID=M.id;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String title = rs.getString("title");
			int year = rs.getInt("year");
			int rtAudienceScore = rs.getInt("rtAudienceScore");
			String rtPictureURL = rs.getString("rtPictureURL");
			String imdbPictureURL = rs.getString("rtPictureURL");
			
		/*	//display values
			System.out.println("Title: " + title);
			System.out.println("Year: " + year);
			System.out.println("Audience Score: " + rtAudienceScore);
			System.out.println("PictureURL: " + rtPictureURL);
			System.out.println("IMDBPictureURL: " + imdbPictureURL);
			
			result += title+", " + year+", " +rtAudienceScore+", " +rtPictureURL+", " +imdbPictureURL+"\n";*/
			arr.add(title);
			arr.add(""+year);
			arr.add(""+rtAudienceScore);
			arr.add(rtPictureURL);
			arr.add(imdbPictureURL);
		}
		con.close();
		return arr;
	}
	public ArrayList<String> query_7() throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT MD.directorName FROM MOVIE_DIRECTORS MD WHERE (SELECT AVG(M.rtAudienceScore) FROM MOVIES M ";
		query += "WHERE MD.movieID=M.id ORDER BY M.rtAudienceScore desc) limit 20;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String directorName = rs.getString("directorName");
			
			//display values
		/*	System.out.println("Director's Name: " + directorName);
			
			
			result += directorName;*/
			arr.add(directorName);
		}
		con.close();
		return arr;
	}
	public ArrayList<String> query_8() throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT MA.actorName FROM MOVIE_ACTORS MA WHERE (SELECT AVG(M.rtAudienceScore) FROM MOVIES M ";
		query += "WHERE MA.movieID=M.id ORDER BY M.rtAudienceScore desc) limit 20;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result= "";
		while(rs.next()){
			//get values
			String actorName = rs.getString("actorName");
			
			//display values
			//System.out.println("Actor's Name: " + actorName);
			
			//result += actorName;
			arr.add(actorName);
		}
		con.close();
		return arr;
	}
	public ArrayList<String> query_9(String Country_Input) throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT M.title " + "FROM MOVIES M, MOVIE_COUNTRIES " + "WHERE MC.country=" + Country_Input + " and M.id=MC.movieID;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String title = rs.getString("title");
			
			//display values
			//System.out.println("Title: " + title);
			
			//result += title;
			arr.add(title);
		}
		con.close();
		return arr;
	}
	public ArrayList<String> query_10(String Location_Input) throws ClassNotFoundException, SQLException{
		ArrayList<String> arr = new ArrayList<String>();
		Connection con = openConnection();
		Statement stmt = con.createStatement();
		String query = "SELECT M.title " + "FROM MOVIES M, MOVIE_LOCATIONS ML " + "WHERE ML.location=" + Location_Input + " and M.id=ML.movieID;";
		
		ResultSet rs = stmt.executeQuery(query);
		//String result = "";
		while(rs.next()){
			//get values
			String title = rs.getString("title");
			
			//display values
			//System.out.println("Title: " + title);
			
			//result += title;
			arr.add(title);
		}
		con.close();
		return arr;
	}
	
}
