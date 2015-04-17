//
//
// obviously it will make more sense to shove this into the file with the rest of the other shit
// no real reason to separate them all out
//
public class Querries(){

	public String Query_1(){
		String query = "";
		query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL" +" FROM MOVIES M " + "ORDER BY M.rtAudienceScore desc " + "limit 20;";
		return query;
	}
	public String Query_2(String Movie_Title_Input){
		String query = "";
		query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL, T.id " +"FROM MOVIES M, MOVIE_TAGS MT, TAGS T " + "WHERE T.id=MT.movieID and MT.movieID=M.id and M.title=" + Movie_Title_Input + " GROUP BY M.title;";
		return query;
		}
	public String Query_3(String Genre_Type_Input){
		String query = "";
		query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL " +"FROM MOVIES M, MOVIE_GENRES MG " + "WHERE MG.genre="+ Genre_Type_Input+" and M.id=MG.movieID " + "ORDER BY M.rtAudienceScore desc " +"limit 20;";
		return query;
	}
	public String Query_4(String Director_Name_Input){
		String query = "";
		query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL " + "FROM MOVIES M, MOVIE_DIRECTORS MD " + "WHERE MD.directorName=" + Director_Name_Input + " and M.id=MD.movieID;";
		return query;
	}
	public String Query_5(String Actor_Name_Input){
		String query ="";
		query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL " + "FROM MOVIES M, MOVIE_ACTORS MA " + "WHERE MA.actorName=" + Actor_Name_Input +" and MA.movieID=M.id;";
		return query;
	}
	public String Query_6(String Tag_Input){
		String query ="";
		query = "SELECT M.title, M.year, M.rtAudienceScore, M.rtPictureURL, M.imdbPictureURL " + "FROM MOVIES M, TAGS T, MOVIE_TAGS MT " + "WHERE T.value=" + Tag_Input + " and T.id=MT.tagID and MT.movieID=M.id;";
		return query;
	}
	//top 20 directors
	//I feel like this one and #8 are gonna freak out, probably gonna need a nested query unfortunately, but need to set up the whole database thing before we can really test it
	public String Query_7(){
		String query ="";
		query = "SELECT DISTINCT MD.directorName " + "FROM MOVIES M, MOVIE_DIRECTORS MD " + "WHERE MD.movieID = M.id " + "ORDER BY avg(M.rtAudienceScore) desc" + "limit 20;";
		return query;
	}
	//top 20 actors
	public String Query_8(){
		String query ="";
		query = "SELECT DISTINCT MA.actorName " + "FROM MOVIES M, MOVIE_ACTORS MA " + "WHERE MA.movieID = M.id " + "ORDER BY avg(M.rtAudienceScore) desc" + "limit 20;";
		return query;
	}
	//EXTRA QUERRIES
	//by country
	public String Query_9(String Country_Input){
		String query="";
		query = "SELECT M.title " + "FROM MOVIES M, MOVIE_COUNTRIES " + "WHERE MC.country=" + Country_Input + " and M.id=MC.movieID;";
		return query;
	}
	//movie locations
	public String Query_10(String Location_Input){
		String query = "";
		query = "SELECT M.title " + "FROM MOVIES M, MOVIE_LOCATIONS ML " + "WHERE ML.location=" + Location_Input + " and M.id=ML.movieID;";
		return query;
	}
}
