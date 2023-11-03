-- Descriptions de la table Sport issues de wikipédia

INSERT INTO Room (code,name) VALUES ('OMNIN0',  'Omnisport Niv0');
INSERT INTO Room (code,name) VALUES ('OMNIN1',  'Omnisport Niv1');
INSERT INTO Room (code,name) VALUES ('BADTEN',  'Badminton et Tennis');
INSERT INTO Room (code,name) VALUES ('BADM1N',  'Badminton');
INSERT INTO Room (code,name) VALUES ('TENN1S',  'Tennis');
INSERT INTO Room (code,name) VALUES ('POLYVA',  'Salle Polyvalente');
INSERT INTO Room (code,name) VALUES ('ARTSMA', 'Arts Martiaux');

INSERT INTO Sport (code,name,description) VALUES ('VOLB', 'volley-ball','Le volley-ball, ou volleyball, est un sport collectif opposant deux équipes de six joueurs séparées par un filet de hauteur variable selon le niveau, qui s''affrontent avec un ballon sur un terrain rectangulaire de 18 m de long sur 9 m de large.');
INSERT INTO Sport (code,name,description) VALUES ('BASB','basket-ball','Le basket-ball ou basketball4, fréquemment désigné en français par son abréviation basket, est un sport collectif de balle opposant deux équipes de cinq joueurs sur un terrain rectangulaire.');
INSERT INTO Sport (code,name,description) VALUES ('HANB','Handball','Le handball est un sport collectif joué à la main où deux équipes de sept joueurs s''affrontent avec un ballon en respectant plusieurs règles sur un terrain rectangulaire de dimensions 40 m par 20 m, séparé en deux camps.');
INSERT INTO Sport (code,name,description) VALUES ('BADM','badminton','Le badminton est un sport de raquette nommé d''après un château anglais. Il oppose soit deux joueurs, en simple, soit deux paires, en double et en mixte, placés de part et d''autre d''un filet.');
INSERT INTO Sport (code,name,description) VALUES ('TENN','tennis','Le tennis est un sport de raquette qui oppose soit deux joueurs (on parle alors de jeu en simple) soit quatre joueurs qui forment deux équipes de deux (on parle alors de jeu en double).');
INSERT INTO Sport (code,name,description) VALUES ('ESCR','escrime','L''escrime est un sport de combat. Il s''agit de l''art de toucher un adversaire avec la pointe ou le tranchant (estoc et taille) d''une arme blanche sur les parties valables sans être touché');
INSERT INTO Sport (code,name,description) VALUES ('GYMN','gymnastique','La gymnastique (ou dans le langage courant simplement gym, par apocope) est un terme générique qui regroupe aujourd''hui des formes très diverses de disciplines sportives, pratiquées pour le loisir ou la compétition ');
INSERT INTO Sport (code,name,description) VALUES ('JUDO','judo','Le judo est un art martial, créé au Japon en 1882 par Jigorō Kanō en tant que pédagogie physique, mentale et morale.');
INSERT INTO Sport (code,name,description) VALUES ('KARA','karaté','Le karaté est un art martial, dit japonais. Cependant, il est originaire du royaume de Ryūkyū. Il existe plusieurs styles de karaté dont le Shotokan-ryu, le Wado-ryu, le Shito-ryu, le Shorin-ryu ou encore le Goju-ryu.');
INSERT INTO Sport (code,name,description) VALUES ('AIKI','aikido','L''aïkido est un art martial japonais, fondé par Morihei Ueshiba ōsensei entre 1925 et 1969. L''aïkido se compose de techniques avec armes et à mains nues utilisant la force de l''adversaire, ou plutôt son agressivité et sa volonté de nuire.');

INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('OMNIN0', 'VOLB');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('OMNIN0', 'BASB');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('OMNIN0', 'HANB');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('OMNIN1', 'VOLB');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('OMNIN1', 'BASB');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('OMNIN1', 'HANB');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('BADTEN', 'BADM');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('BADTEN', 'TENN');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('BADM1N', 'BADM');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('TENN1S', 'TENN');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('POLYVA', 'ESCR');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('POLYVA', 'GYMN');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('ARTSMA', 'JUDO');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('ARTSMA', 'KARA');
INSERT INTO Room_Sports (rooms_code, sports_code) VALUES ('ARTSMA', 'AIKI');

INSERT INTO Reservation (id,room_code,email,day) VALUES (1,'OMNIN0','a@abc.be','2023-01-12');
INSERT INTO Reservation (id,room_code,email,day) VALUES (2,'OMNIN1','b@abc.be','2023-01-12');
INSERT INTO Reservation (id,room_code,email,day) VALUES (3,'TENN1S','c@abc.be','2023-01-12');
INSERT INTO Reservation (id,room_code,email,day) VALUES (4,'OMNIN0','a@abc.be','2023-01-18');
INSERT INTO Reservation (id,room_code,email,day) VALUES (5,'BADTEN','a@abc.be','2023-01-18');
INSERT INTO Reservation (id,room_code,email,day) VALUES (6,'OMNIN0','a@abc.be','2023-01-19');
INSERT INTO Reservation (id,room_code,email,day) VALUES (7,'OMNIN1','b@abc.be','2023-01-19');
INSERT INTO Reservation (id,room_code,email,day) VALUES (8,'BADTEN','c@abc.be','2023-01-19');
INSERT INTO Reservation (id,room_code,email,day) VALUES (9,'BADTEN','d@abc.be','2023-01-20');
INSERT INTO Reservation (id,room_code,email,day) VALUES (10,'BADTEN','e@abc.be','2023-01-21');
INSERT INTO Reservation (id,room_code,email,day) VALUES (11,'OMNIN0','a@abc.be','2023-01-20');

ALTER SEQUENCE reserv_seq restart with 40;