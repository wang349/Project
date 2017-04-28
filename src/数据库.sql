DROP TABLE member PURGE ; 
CREATE TABLE member( 
	mid VARCHAR2(50) , 
	name VARCHAR2(50) , 
	birthday DATE ,
	sal NUMBER , 
	note CLOB , 
	del NUMBER(1) , 
	CONSTRAINT pk_mid PRIMARY KEY(mid) 
	) ;