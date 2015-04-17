create schema SMMS; 

create table MOVIES (
	id		int 	not null,
    title 	varchar(20) not null,
    imdbID	int,
    spanishTitle	varchar(15) not null,
    imdbPictureURL	char(30) 	not null,
    year 	int		not null,
    rtID	char(30),
    rtAudienceScore 	int,
    rtPictureURL	char(50),
    PRIMARY KEY (id)
);

create table TAGS (
	id		int	not null,	
    value	varchar(15)	not null,
    PRIMARY KEY (id)
);
create table MOVIE_ACTORS (
	movieID		int	not null,	
    actorID		varchar(30)	not null,
    actorName	varchar(30)	not null,	
    ranking		int,
    PRIMARY KEY(movieID, actorID),
    FOREIGN KEY (movieID) references MOVIES (id)
);

create table MOVIE_COUNTRIES (
	movieID		int	not null,	
    country		varchar(30)	not null,
    PRIMARY KEY (movieID, country),
    FOREIGN KEY (movieID) references MOVIES (id)
);

create table MOVIE_DIRECTORS (
	movieID		int	not null,	
    directorID		varchar(30)	not null,
    directorName	varchar(30)	not null,	
    PRIMARY KEY (movieID, directorID),
    FOREIGN KEY (movieID) references MOVIES (id)
);

create table MOVIE_GENRES (
	movieID		int	not null,	
    genre		varchar(30)	not null,
    PRIMARY KEY (movieID, genre),
    FOREIGN KEY (movieID) references MOVIES (id)
);

create table MOVIE_TAGS (
	movieID		int	not null,	
    tagID		int	not null,
    tagWeight	int	not null,
	PRIMARY KEY (movieID, tagID),
    FOREIGN KEY (movieID) references MOVIES (id),
    FOREIGN KEY (tagID) references TAGS (id)
);



create table MOVIE_LOCATIONS(
	movieID		int		not null,
    location1	varchar(255),
    location2	varchar(255),
    location3	varchar(255),
    location4	varchar(255),
    PRIMARY KEY (movieID),
    FOREIGN KEY (movieID) references MOVIES (id)
    );
create table USER_RATEDMOVIES(
	userID int not null,
    movieID int not null,
    rating int,
    date_day int,
    date_month int,
    date_year int,
    date_hour int,
    date_minute int,
    date_second int,
    PRIMARY KEY(userID, movieID),
    FOREIGN KEY (movieID) references MOVIES (id)
);
create table USER_RATEDMOVIES_TIMESTAMPS(
	userID int not null,
    movieID int not null,
    rating int,
    timestamp_ varchar(20),
    PRIMARY KEY (userID, movieID),
    FOREIGN KEY (movieID) references MOVIES (id)
);
create table USER_TAGGEDMOVIES(
	userID int not null,
    movieID int not null,
    tagID int not null,
    date_day int,
    date_month int,
    date_year int,
    date_hour int,
    date_minute int,
    date_second int,
    PRIMARY KEY (userID, movieID, tagID),
    FOREIGN KEY (movieID) references MOVIES (id),
    FOREIGN KEY (tagID) references TAGS (id)
);
create table USER_TAGGEDMOVIES_TIMESTAMPS(
	userID int not null,
    movieID int not null,
    tagID int not null,
    timestamp_ varchar(20),
    PRIMARY KEY (userID, movieID, tagID),
    FOREIGN KEY (movieID) references MOVIES (id),
    FOREIGN KEY (tagID) references TAGS (id)
);