import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import QuizList from "./components/QuizList";
import QuizDetails from "./components/QuizDetails";
import GenerateQuiz from "./components/GenerateQuiz";
import AddQuestion from "./components/AddQuestion";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<QuizList />} />
                <Route path="/quiz/:id" element={<QuizDetails />} />
                <Route path="/generate-quiz" element={<GenerateQuiz />} />
                <Route path="/quiz/:id/add-question" element={<AddQuestion />} />
            </Routes>
        </Router>
    );
};

export default App;
