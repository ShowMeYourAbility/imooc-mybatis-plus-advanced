DELETE FROM sys_user;

INSERT INTO sys_user (id, name, age, email,create_time,update_time,creator,updater) VALUES
(1, 'Jone', 18, 'test1@baomidou.com',TIMESTAMP '2017-10-08 16:33:00',TIMESTAMP '2017-10-08 16:33:00','1','1'),
(2, 'Jack', 20, 'test2@baomidou.com',0,TIMESTAMP '2017-10-08 16:33:00',TIMESTAMP '2017-10-08 16:33:00','1','1'),
(3, 'Tom', 28, 'test3@baomidou.com',0,TIMESTAMP '2017-10-08 16:33:00',TIMESTAMP '2017-10-08 16:33:00','1','1'),
(4, 'Sandy', 21, 'test4@baomidou.com',0,TIMESTAMP '2017-10-08 16:33:00',TIMESTAMP '2017-10-08 16:33:00','1','1'),
(5, 'Billie', 24, 'test5@baomidou.com',0,TIMESTAMP '2017-10-08 16:33:00',TIMESTAMP '2017-10-08 16:33:00','1','1');