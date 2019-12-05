
insert into clinic (name, adress, description, grade_sum, grade_number) values ('Urologija','blabla', 'opis', 0.0, 0);

insert into doctor(name, surname, email, password, adress, city, state, phone) values ('DrMr', 'MrDr','drmd.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333);
insert into diagnosis(name) values ('Sifilis');


insert into clinical_center_administrator (name, surname, email, password, adress, city, state, phone, validated) values ('12313131', '32131313', 'dusan.com', '123', '1232131321', '3213123123', '1231231231', 111222333, true);

insert into medical_room (operational, reserved, room_codename, date) values (true, false, 'Soba333', '1999-05-05');


insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('12313131', '32131313', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);
insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('Prihvaceni', '32131313', 'prihvaceni.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, true, true);