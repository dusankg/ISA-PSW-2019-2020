
insert into clinic (name, adress, description, grade_sum, grade_number) values ('Urologija','blabla', 'opis', 0.0, 0);

insert into doctor(name, surname, email, password, adress, city, state, phone) values ('DrMr', 'MrDr','drmd.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333);
insert into diagnosis(name) values ('Sifilis');


insert into clinical_center_administrator (name, surname, email, password, adress, city, state, phone, validated) values ('12313131', '32131313', 'dusan.com', '123', '1232131321', '3213123123', '1231231231', 111222333, true);

insert into medical_room (operational, reserved, room_codename, date) values (true, false, 'Soba333', '1999-05-05');


insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('1', '32131313', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);
insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('Prihvaceni', '32131313', 'prihvaceni.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, true, true);

insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('2', '32131313', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);

insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('3', '32131313', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);

insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('4', '32131313', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);

insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('5', '32131313', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);

insert into examination (date, duration, price) values ('2011-03-05', 45, 1500);

insert into nurse(name, surname, email, password, adress, city, state, phone) values ('nurse', 'nursic','nurse.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333);
insert into nurse(name, surname, email, password, adress, city, state, phone) values ('druga', 'drugic','druga.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333);


insert into prescription (name, validated) values ('Bromazepam',false);
insert into prescription (name, validated) values ('Fervex',true);
insert into prescription (name, validated) values ('Loperamid',false);

insert into examination_type(typename) values ('Ocni pregled');
insert into examination_type(typename) values ('Ginekoloski pregled');


insert into absence_request(startingdate, endingdate) values ('2019-05-05', '2019-09-09');
insert into absence_request(startingdate, endingdate) values ('2000-05-05', '2010-09-09');