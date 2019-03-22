package com.example.android.test_application;

import android.provider.BaseColumns;

/**
 * Created by khushal shah on 03-01-2017.
 */
public class TableData
{
    public TableData()
    {

    }
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String PARTICIPANT_NAME="Participant_name";
        public static final String PARTICIPANT_COLLEGE="Participant_college";
        public static final String PARTICIPANT_COLLEGE_ADDRESS="Participant_colg_add";
        public static final String PARTICIPANT_NUMBER="Participant_phone_number";
        public static final String PARTICIPANT_EMAIL="Participant_Email_id";
        public static final String DATABASE_NAME="List_of_IOT_participants.db";
        public static final String PARTICIPANT_COUNT="Count_of_participant";
        public static final String TABLE_NAME="Participant_info";

    }

}
