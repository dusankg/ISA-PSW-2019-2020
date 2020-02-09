insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('Prihvaceni', '32131313', 'prihvaceni.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, true, true);
insert into clinic (name, adress, description, grade_sum, grade_number, longitude, latitude) values ('Urologija','blabla', 'opis', 0.0, 0, 19.821, 45.014);
insert into patient (name, surname, email, password, adress, city, state, phone, lbo, validated, accepted) values ('Prihvaceni2', '32131313', 'prihvaceni.com', '123', '1232131321', '3213123123', '1231231231', 111222333, 111, true, true);
insert into clinic (name, adress, description, grade_sum, grade_number, longitude, latitude) values ('Urologija','blabla', 'opis', 0.0, 0, 19.821, 45.014);
insert into doctor(name, surname, email, password, adress, city, state, phone, work_hour_start, work_hour_finish,grade_sum, grade_number ,clinic_id) values ('DrMr', 'MrDr','drmd.com', '123', 'NTP', 'Nju Nau', 'Makedonija', 333, 7, 15,0,0, 1);
insert into examination_type(typename) values ('Ocni pregled');
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted,patient_id) values ('2020-02-01', 1500, 1, 1, 1, 420, 480, true, true,1);
insert into examination (date, price, type_id, clinic_id, doctor_id, start_time, end_time, operation, accepted) values ('2020-02-01', 1600, 1, 1, 1, 440, 490, true, true);
