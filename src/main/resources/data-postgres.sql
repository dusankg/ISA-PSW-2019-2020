
insert into clinic (name, adress, description, grade_sum, grade_number) values ('Urologija','blabla', 'opis', 0.0, 0);

insert into doctor(name, surname, email, password, adress, city, state, phone) values ('DrMr', 'MrDr','drmd.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333);
insert into diagnosis(name) values ('Sifilis');


insert into clinical_center_administrator (name, surname, email, password, adress, city, state, phone, validated) values ('12313131', '32131313', '32131231', '123', '1232131321', '3213123123', '1231231231', 111222333, false);

insert into medical_room (operational, reserved, room_codename, date) values (true, false, 'Soba333', '1999-05-05');