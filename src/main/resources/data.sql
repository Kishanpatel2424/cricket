-- Insert initial teams
INSERT INTO team (name, players_count) VALUES ('Team A', 8);
INSERT INTO team (name, players_count) VALUES ('Team B', 8);
INSERT INTO team (name, players_count) VALUES ('Team C', 8);

-- Insert initial matches
INSERT INTO match (team1_id, team2_id, overs, is_active) VALUES (1, 2, 20, true);
INSERT INTO match (team1_id, team2_id, overs, is_active) VALUES (2, 3, 20, true);
INSERT INTO match (team1_id, team2_id, overs, is_active) VALUES (1, 3, 20, false);
