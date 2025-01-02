import React, { useState, useEffect } from "react";
import { fetchAllQuizzes } from "../api";

const QuizList = () => {
    const [quizzes, setQuizzes] = useState([]);

    useEffect(() => {
        const getQuizzes = async () => {
            const data = await fetchAllQuizzes();
            setQuizzes(data);
        };
        getQuizzes();
    }, []);

    return (
        <div>
            <h1>Quizzes</h1>
            <ul>
                {quizzes.map((quiz) => (
                    <li key={quiz.id}>{quiz.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default QuizList;
