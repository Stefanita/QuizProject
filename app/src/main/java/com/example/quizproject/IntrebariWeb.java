package com.example.quizproject;

public class IntrebariWeb {

    public static String question[] ={
            "Ce inseamna www?",
            "La ce este folosit CSS?",
            "Cum declaram un tabel?",
            "Ce tag creaza o lista ordonata numeric?",
            "Care selector reprezinta ID-ul unui element in CSS"
    };

    public static String choices[][] = {
            {"World wide web","World war web","World of Warship","Nu stiu imi e foame"},
            {"Pentru a scrie cod","Pentru a modifica valorile","Pentru editarea aspectului unei pagini","E un program"},
            {"<table>...</table>","<li></li>","Desenez unu","<span></span>"},
            {"<ol>","<ul>","<tr>","<tg>"},
            {".nume","#nume","nume","$nume"}
    };

    public static String correctAnswers[] = {
            "World wide web",
            "Pentru editarea aspectului unei pagini",
            "<table>...</table>",
            "<ol>",
            "#nume"
    };
}
