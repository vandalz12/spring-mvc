
drop table if exists polls;
create table polls (
	poll_id INTEGER PRIMARY KEY,
	question VARCHAR(255)
);

drop table if exists options;
create table options (
	option_id INTEGER PRIMARY KEY,
	poll_id INTEGER,
	value VARCHAR(255)
);

drop table if exists votes;
create table votes (
	vote_id INTEGER PRIMARY KEY,
	option_id INTEGER
);

drop table if exists users;
create table users (
	user_id INTEGER PRIMARY KEY,
	username VARCHAR(255),
	password VARCHAR(255),
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	admin VARCHAR(3)
);

drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);
 
drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(255),
  token LONGVARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);
 
drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(255),
  token LONGVARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(255)
);
 
drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(255),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);
 
drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(255), authentication LONGVARBINARY
);
 
drop table if exists oauth_approvals;
create table oauth_approvals (
	userId VARCHAR(255),
	clientId VARCHAR(255),
	scope VARCHAR(255),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);