delete from message;

insert into message(id, text, tag, user_id) values
(1, 'first message', 'tag1', 1),
(2, 'second message', 'tag2', 1),
(3, 'third message', 'tag1', 1),
(4, 'fourth message', 'tag2', 1);

alter sequence hibernate_sequence restart with 10;