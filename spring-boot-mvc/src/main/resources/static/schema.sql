create table polls (
	poll_id INT NOT NULL,
	question VARCHAR(255) NOT NULL
);

create table options (
	option_id INT NOT NULL,
	option_value VARCHAR(255) NOT NULL,
	poll_id INT NOT NULL
);

create table votes (
	vote_id INT NOT NULL,
	option_id INT NOT NULL
);