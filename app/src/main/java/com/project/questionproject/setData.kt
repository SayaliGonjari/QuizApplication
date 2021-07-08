package com.project.questionproject

object setData {
    val name:String="name"
    val score:String="score"

    fun getQuestion(): ArrayList<QuestionData> {
        var que: ArrayList<QuestionData> = arrayListOf()

        var question1 = QuestionData(
            1,
            "Grand Central Terminal,Park Avenue,New York is the world's?",

            "Highest Railway Station",
            "Longest Railway Station",
            "Largest Railway Station",
            "none of the above",
            3
        )
        var question2 = QuestionData(
            2,
            "Garampani sanctuary is located  at?",

            "Gangtok,Sikkim",
            "Kohima,Nagaland",
            "Diphu,Assam",
            "Junagarh,Gujarat",
            1
        )
        var question3 = QuestionData(
            3,
            "First Afghan War took place in?",

            "1839",
            "1848",
            "1843",
            "1833",
            1
        )
        var question4 = QuestionData(
            4,
            "Who was the first President of India ?",

            "Abdul Kalam",
            "Lal Bahadur Shastri",
            "Dr. Rajendra Prasad",
            "Zakir Hussain",
            3
        )

        var question5 = QuestionData(
            5,
            "How many hours are there in a day?",

            "25",
            "12",
            "36",
            "24",
            4
        )

        var question6 = QuestionData(
            6,
            "First china war was fought between ",

            "China and Egypt",
            "China and Greek",
            "China and Britain",
            "China and France",
            3
        )

        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        que.add(question6
        )

        return que
    }

}