create table players (id bigint NOT NULL auto_increment primary key,
                           name VARCHAR(255) NOT NULL,
                           birth_date DATE,
                      team_id bigint,
                           position_type varchar(30),
                           foreign key (team_id) references teams(id));