

    insert into doctors(address, education, speciality, name, id)
        values ('Cairo', 'Ain-Shams University', 'heart', 'Ali Omar', 1);
    insert into doctors(address, education, speciality, name, id)
        values ('Asuoot', 'Al-Qahera University', 'eyes', 'Mohammed Ahmed', 2);
    insert into doctors(address, education, speciality, name, id)
        values ('Qena', 'Qena University', 'ear', 'Ibrahim Mahmoud ', 3);
    insert into doctors(address, education, speciality, name, id)
        values ('Al-sharkiya', 'Ain-Shams University', 'ear', 'Ismael Ali ', 4);
    insert into doctors(address, education, speciality, name, id)
        values ('Al-fayoum', 'Al-Azhar University', 'eyes', 'Abd Ul-rahman Saad', 5);
    insert into doctors(address, education, speciality, name, id)
        values ('Cairo', 'Al-Azhar University', 'surgery', 'Saeed Fathy', 6);
    insert into doctors(address, education, speciality, name, id)
        values ('Al-giza', 'Al-Qahera University', 'eyes', 'Ahmed Mohammed', 7);
    insert into doctors(address, education, speciality, name, id)
        values ('Cairo', 'Al-Azhar University', 'surgery', 'Abd-Ullah', 8);

    insert into patients(birthdate, gender, name, id)
        values ('1995-09-12', 0, 'Othman Jamal', 1);
    insert into patients(birthdate, gender, name, id)
        values ('1994-05-13', 1, 'Aisha Ali', 2);
    insert into patients(birthdate, gender, name, id)
        values ('1980-11-17', 0, 'Emad Rgb', 3);
    insert into patients(birthdate, gender, name, id)
        values ('2003-03-19', 1, 'Hend Wael', 4);
    insert into patients(birthdate, gender, name, id)
        values ('2007-10-23', 1, 'Salma Mosaad', 5);

    insert into appointments (date ,brief_complain, patient_id, doctor_id, id)
                values (current_date, 'comp5462231', 2,3, 1);
    insert into appointments(date ,brief_complain, patient_id, doctor_id, id)
                values (current_date, 'comp5462231', 2,5, 2);
    insert into appointments(date ,brief_complain, patient_id, doctor_id, id)
                values (current_date, 'comp5462231', 4,5, 3);
    insert into appointments(date ,brief_complain, patient_id, doctor_id, id)
                values (current_date, 'comp5462231', 4,3, 4);
    insert into appointments(date ,brief_complain, patient_id, doctor_id, id)
                values (current_date, 'comp5462231', 4,4, 5);
    insert into appointments(date ,brief_complain, patient_id, doctor_id, id)
                values (current_date, 'comp5462231', 5,3, 6);
    insert into appointments(date ,brief_complain, patient_id, doctor_id, id)
                values (current_date, 'comp5462231', 2,6, 7);
    insert into appointments(date ,brief_complain, patient_id, doctor_id, id)
                values (current_date, 'comp5462231', 5,7, 8);