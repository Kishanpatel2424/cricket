CREATE TABLE IF NOT EXISTS team (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    players_count INT,
                                    name VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS match (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     team1_id BIGINT,
                                     team2_id BIGINT,
                                     overs INT,
                                     is_active BOOLEAN,
                                     FOREIGN KEY (team1_id) REFERENCES team(id),
    FOREIGN KEY (team2_id) REFERENCES team(id)
    );
