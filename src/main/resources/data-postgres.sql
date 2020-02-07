
insert into clinic (name, adress, description, grade_sum, grade_number, longitude, latitude) values ('Urologija','blabla', 'opis', 0.0, 0, 19.821, 45.014);
insert into clinic (name, adress, description, grade_sum, grade_number, longitude, latitude) values ('Infektivna klinika','JNA', 'klinika za infektivne i tropske bolesti', 0.0, 0, 19.823, 45.25);

insert into doctor(name, surname, email, password, adress, city, state, phone, work_hour_start, work_hour_finish, clinic_id) values ('DrMr', 'MrDr','drmd.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333, 7, 15, 1);
insert into doctor(name, surname, email, password, adress, city, state, phone, work_hour_start, work_hour_finish, clinic_id) values ('Doctor', 'House','house.com', '123', 'plainsborough', 'make', 'USA', 988, 7, 15, 2);

insert into diagnosis(name) values ('Sifilis');

insert into clinical_center_administrator (name, surname, email, password, adress, city, state, phone, validated) values ('12313131', '32131313', 'dusan.com', '123', '1232131321', '3213123123', '1231231231', 111222333, true);

insert into medical_room (operational, reserved, room_codename, room_number, date, clinic_id) values (true, false, 'Soba333', 15, '1999-05-05', 1);
insert into medical_room (operational, reserved, room_codename, room_number, date, clinic_id) values (true, true, 'Soba mala', 18, '2000-05-05', 1);
insert into medical_room (operational, reserved, room_codename, room_number, date, clinic_id) values (false, false, 'Laboratorija', 21, '2010-05-05', 1);

insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('1', '32131313', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);
insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('Prihvaceni', '32131313', 'prihvaceni.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, true, true);
insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('2', '32131313', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);
insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('Pera', 'Peric', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, false, false);
insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('Mika', 'Mikic', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 112, false, false);
insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('Zika', 'Haralampijevic', 'novi.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 123, false, false);

insert into nurse(name, surname, email, password, adress, city, state, phone) values ('nurse', 'nursic','nurse.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333);
insert into nurse(name, surname, email, password, adress, city, state, phone) values ('druga', 'drugic','druga.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333);

insert into prescription (name, validated) values ('Bromazepam',false);
insert into prescription (name, validated) values ('Fervex',true);
insert into prescription (name, validated) values ('Loperamid',false);

insert into examination_type(typename) values ('Ocni pregled');
insert into examination_type(typename) values ('Ginekoloski pregled');

insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted, patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true, 1);

insert into absence_request(startingdate, endingdate, doctor_id) values ('2019-05-05', '2019-09-09', 1);
insert into absence_request(startingdate, endingdate, doctor_id) values ('2000-05-05', '2010-09-09', 2);

insert into clinical_administrator (name, surname, email, password, adress, city, state, phone, validated, clinic_id) values ('12313131', '32131313', 'blanusa.com', '123', '1232131321', '3213123123', '1231231231', 111222333, true, 1);

insert into examination_report(text_report, diagnosis_id, prescription_id, patient_id) values ('IzvestajLekara', 1,  1, 1);
