create table players (id bigint NOT NULL auto_increment primary key,
                           name VARCHAR(255) NOT NULL,
                           birth_date DATE,
                           position_type VARCHAR(255),
                           team_id VARCHAR(255));