import React, { useState, useEffect } from "react";
import { fetchQuizById } from "../api";

const QuizDetails = ({ quizId }) => {
    const [quiz, setQuiz] = useState(null);

    useEffect(() => {
        const getQuiz = async () => {
            const data = await fetchQuizById(quizId);
            setQuiz(data);
        };
        getQuiz();
    }, [quizId]);

    if (!quiz) return <p>Loading...</p>;

    return (
        <div>
            <h1>{quiz.name}</h1>
            <ul>
                {quiz.questions.map((question) => (
                    <li key={question.id}>{question.text}</li>
                ))}
            </ul>
        </div>
    );
};

export default QuizDetails;
