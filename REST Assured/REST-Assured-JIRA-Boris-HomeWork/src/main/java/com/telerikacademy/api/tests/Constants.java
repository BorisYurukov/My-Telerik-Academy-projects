package com.telerikacademy.api.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {
    //Provide your own api token:
    public static final String password = "Please, enter your personal rest API token to serve as a password, between the quotation marks.";
    //    Provide your email address:
    public static final String user_email = "Please, enter your email between the quotation marks.";
    //    Provide your  Jira URL
    public static final String baseURL= "Please, enter your base jira URL between the quotation marks.";
    public  static  final String endOfTheUrl="/rest/api/2/issue";
//    Provide your personal path to the picture.Bellow is just an example.It can be anywhere on pc:

    public static final String FILE_LOCATION_ON_PC = "C:\\Users\\boyur\\Postman\\files\\bug.jpg";

    public static final String FILE_CREATION_DATE =new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    //   Provide your own project key:
    public static  final String projectKey="Please, enter your desired project key between the quotation marks.";
    public  static  String STORY_KEY;
    public  static  String BUG_KEY;

}
