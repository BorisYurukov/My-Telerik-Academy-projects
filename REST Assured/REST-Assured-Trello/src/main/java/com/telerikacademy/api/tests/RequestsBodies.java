package com.telerikacademy.api.tests;

import static com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static java.lang.String.format;

public class RequestsBodies {

   public static final String createBoardBody = format("{\n" +
                    "    \"name\":\"%s\",\n" +
                    "    \"desc\" : \"%s\"\n" +
                    "}", boardName
                       , boardDescription);


   public static  String createNewList(String boardId) { return format("{\n" +
                    "    \"idBoard\":\"%s\",\n" +
                    "    \"name\":\"%s\"\n" +
                    "}", boardId,
                    boardName);}


    public static final String createNewCard = format("{\n" +
                    "     \"desc\":\"%s\",\n" +
                    "    \"name\" : \"%s\"\n" +
                    "}", cardDescription,
                         cardName);

   public static final String updateCard=format("{\n" +
            "     \"desc\":\"%s\",\n" +
            "    \"name\" : \"%s\"\n" +
            "}",cardNewDescription,cardNewName);

}


