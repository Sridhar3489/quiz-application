import React, { useState } from "react";
import { generateQuizQuestions } from "../api";

const GenerateQuiz = () => {
    const [topic, setTopic] = useState("");
    const [questions, setQuestions] = useState([]);

    const handleGenerate = async () => {
        try {
            const data = await generateQuizQuestions(topic);
            // Assuming 'data' contains an array of questions inside 'candidates'
            if (data && data.candidates) {
                // Extracting text from the API response and setting it in the state
                const questionTexts = data.candidates.map(
                    (candidate) => candidate.content.parts[0].text
                );
                setQuestions(questionTexts);
            } else {
                setQuestions([]);
            }
        } catch (error) {
            console.error("Error generating quiz questions:", error);
        }
    };

    return (
        <div>
            <h1>Generate Quiz Questions</h1>
            <input
                type="text"
                placeholder="Enter a topic"
                value={topic}
                onChange={(e) => setTopic(e.target.value)}
            />
            <button onClick={handleGenerate}>Generate</button>
            <div>
                <h3>Generated Questions</h3>
                {questions.length === 0 ? (
                    <p>No questions available</p>
                ) : (
                    <ul>
                        {questions.map((question, index) => (
                            <li key={index}>{question}</li>
                        ))}
                    </ul>
                )}
            </div>
        </div>
    );
};

export default GenerateQuiz;
