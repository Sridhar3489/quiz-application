import React, { useState } from "react";
import { addQuestionToQuiz } from "../api";

const AddQuestion = ({ quizId }) => {
    const [questionText, setQuestionText] = useState("");

    const handleAddQuestion = async () => {
        const question = { text: questionText };
        await addQuestionToQuiz(quizId, question);
        alert("Question added!");
    };

    return (
        <div>
            <h1>Add Question</h1>
            <textarea
                placeholder="Enter your question"
                value={questionText}
                onChange={(e) => setQuestionText(e.target.value)}
            ></textarea>
            <button onClick={handleAddQuestion}>Add Question</button>
        </div>
    );
};

export default AddQuestion;
