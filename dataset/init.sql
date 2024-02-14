CREATE TABLE blogs
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(100),
    content VARCHAR(100)
);


INSERT INTO blogs(id, name, content)
VALUES (1, '1', '1');
INSERT INTO blogs(id, name, content)
VALUES (2, '2', '2');
INSERT INTO blogs(id, name, content)
VALUES (3, '3', '3');
INSERT INTO blogs(id, name, content)
VALUES (4, '4', '4');